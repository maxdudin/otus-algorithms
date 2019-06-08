package otus.sort.merge;

import otus.sort.Sort;
import otus.sort.insertion.PartialInsertionSort;

public class MergeSort<T extends Comparable> implements Sort<T> {
    protected final int INSERTION_SORT_BOUNDARY;
    protected final PartialInsertionSort<T> insertionSort = new PartialInsertionSort<>();

    public MergeSort() {
        INSERTION_SORT_BOUNDARY = 33;
    }

    public MergeSort(int insertionSortBoundary) {
        this.INSERTION_SORT_BOUNDARY = insertionSortBoundary;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(T[] a) {
        splitMerge(a, 0, a.length - 1, (T[]) new Comparable[a.length]);
    }

    public void splitMerge(T[] arr, int begin, int end, T[] copy) {
        if ((end - begin) < INSERTION_SORT_BOUNDARY) {
            insertionSort.sortArrPart(arr, begin, end);
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
        int scd = middle + 1;
        for (int i = begin; i <= end; i++) {
            if (fst > middle) arr[i] = copy[scd++];
            else if (scd > end) arr[i] = copy[fst++];
            else if (copy[fst].compareTo(copy[scd]) < 0) arr[i] = copy[fst++];
            else arr[i] = copy[scd++];
        }
    }
}
