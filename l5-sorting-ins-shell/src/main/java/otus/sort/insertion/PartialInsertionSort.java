package otus.sort.insertion;

import otus.sort.Sort;

public class PartialInsertionSort<T extends Comparable> implements Sort<T> {
    public void sort(T[] arr, int beginIndex, int gap) {
        for (int i = beginIndex; i < arr.length; i += gap) {
            int j = i - gap;
            while (j >= 0 && arr[j + gap].compareTo(arr[j]) < 0) {
                swap(j, j + gap, arr);
                j--;
            }
        }
    }

    @Override
    public void sort(T[] a) {
        sort(a, 0, 1);
    }
}
