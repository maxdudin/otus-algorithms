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

    public void sortArrPart(T[] arr, int beginIndex, int endIndex) {
        for (int i = beginIndex; i < endIndex + 1; i++) {
            int j = i - 1;
            while (j >= beginIndex && arr[j + 1].compareTo(arr[j]) < 0) {
                swap(j, j + 1, arr);
                j--;
            }
        }
    }

    @Override
    public void sort(T[] a) {
        sort(a, 0, 1);
    }
}
