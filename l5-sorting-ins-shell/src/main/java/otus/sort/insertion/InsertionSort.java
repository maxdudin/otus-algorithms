package otus.sort.insertion;

import otus.sort.Sort;

public class InsertionSort<T extends Comparable> implements Sort<T> {
    @Override
    public void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            while (j >= 0 && a[j + 1].compareTo(a[j]) < 0) {
                swap(j, j + 1, a);
                j--;
            }
        }
    }
}
