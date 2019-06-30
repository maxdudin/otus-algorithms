package otus.hash;

public interface MyHashTable<K, V> {
    void put(K key, V value);
    V get(K key);
    boolean delete(K key);
    int size();
}
