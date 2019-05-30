package otus.sort;

public interface Sort<T extends Comparable> {
    void sort(T[] a);
    default void swap(int a, int b, T[] arr) {
        T swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }
}
