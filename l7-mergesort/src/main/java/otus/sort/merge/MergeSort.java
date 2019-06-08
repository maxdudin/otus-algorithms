package otus.sort.merge;

import otus.sort.Sort;
import otus.sort.insertion.InsertionSort;

public class MergeSort<T extends Comparable> implements Sort<T> {
    protected static final int INSERTION_SORT_BOUNDARY = 33;
    protected final Sort<T> insertionSort = new InsertionSort<>();

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] a) {
        splitMerge(a, 0, a.length - 1, (T[]) new Comparable[a.length]);
    }

    public void splitMerge(T[] arr, int begin, int end, T[] copy) {
        if ((end - begin) < INSERTION_SORT_BOUNDARY) {
            insertionSort.sort(arr);
            return;
        }

        int mid = begin + (end - begin) / 2;
        splitMerge(arr, begin, mid, copy);
        splitMerge(arr, mid + 1, end, copy);
        merge(arr, begin, mid, end, copy);
    }

    public void merge(T[] arr, int begin, int middle, int end, T[] copy) {
        for (int i = begin; i <= end; i++) {
            copy[i] = arr[i];
        }

        int fst = begin;
        int scd = middle;
        for (int i = begin; i <= end; i++) {
            if (fst > middle) arr[i] = arr[scd++];
            else if (scd > end) arr[i] = arr[fst++];
            else if (arr[fst].compareTo(arr[scd]) < 0) arr[i] = arr[fst++];
            else arr[i] = arr[scd++];
        }
    }
}
