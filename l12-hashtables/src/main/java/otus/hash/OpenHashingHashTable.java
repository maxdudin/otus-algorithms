package otus.hash;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class OpenHashingHashTable<K, V> implements MyHashTable<K, V> {
    public static final int INITIAL_CAPACITY = 17;
    public static final double LOAD_FACTOR_BOUNDARY = 0.25d;
    private int occupied;
    private int size;
    private double loadFactor;
    private List<MyEntry> entries;

    @SuppressWarnings("unchecked")
    public OpenHashingHashTable() {
        entries = new ArrayList<>(INITIAL_CAPACITY);
        IntStream.range(0, INITIAL_CAPACITY).forEach(n -> entries.add(n, null));
        size = INITIAL_CAPACITY;
        loadFactor = 0;
    }

    public class MyEntry {
        private final K key;
        private final V value;

        @Setter
        private boolean toDelete;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode());
        int pos = hash % size;
        int probingBase = pos;
        int step = 0;
        while (entries.get(probingBase) != null) {
            probingBase = (pos + step * step) % size;
            step++;
            if (step == size) {
                throw new RuntimeException("Not enough space!");
            }
        }

        entries.set(probingBase, new MyEntry(key, value));
        occupied++;
        loadFactor = (double) occupied / (double) size;
        if (loadFactor > LOAD_FACTOR_BOUNDARY) {
            resize();
        }
    }

    private void resize() {
        int newSize = getPrime((int) (size * 1.5), size * 2);
        List<MyEntry> newEntries = new ArrayList<>(newSize);
        IntStream.range(0, newSize).forEach(n -> newEntries.add(n, null));
        List<MyEntry> oldEntries = this.entries;
        this.size = newSize;
        this.occupied = 0;
        this.loadFactor = 0;
        this.entries = newEntries;
        oldEntries.stream()
                .filter(Objects::nonNull)
                .filter(e -> !e.toDelete)
                .forEach(e -> put(e.key, e.value));
    }

    public static Integer getPrime(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(OpenHashingHashTable::isPrime).boxed()
                .findAny().get();
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(n -> (n & 0X1) != 0)
                .allMatch(n -> number % n != 0);
    }

    @Override
    public V get(K key) {
        int hash = Math.abs(key.hashCode());
        int pos = hash % size;
        int probingBase = pos;
        int step = 0;
        while (entries.get(probingBase) != null) {
            probingBase = (pos + step * step) % size;
            step++;
            if (step == size) {
                return null;
            }

            if (entries.get(probingBase).key.equals(key)) {
                return entries.get(probingBase).value;
            }
        }

        return null;
    }

    @Override
    public boolean delete(K key) {
        int hash = Math.abs(key.hashCode());
        int pos = hash % size;
        int probingBase = pos;
        int step = 0;
        while (entries.get(probingBase) != null) {
            probingBase = (pos + step * step) % size;
            step++;
            if (step == size) {
                return false;
            }

            if (entries.get(probingBase).key.equals(key)) {
                entries.get(probingBase).setToDelete(true);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return occupied;
    }
}
