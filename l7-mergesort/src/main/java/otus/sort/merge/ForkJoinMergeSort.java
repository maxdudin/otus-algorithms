package otus.sort.merge;

import otus.sort.tool.ArraySortAssertion;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMergeSort<T extends Comparable> extends MergeSort<T> {
    private final int processors = Runtime.getRuntime().availableProcessors();
    private ArraySortAssertion<T> arraySortAssertion = new ArraySortAssertion();

    public ForkJoinMergeSort() {
        super();
    }

    public ForkJoinMergeSort(int insertionSortBoundary) {
        super(insertionSortBoundary);
    }

    @Override
    public void sort(T[] a) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(processors);
        forkJoinPool.invoke(new SortTask(a, 0, a.length - 1, (T[]) new Comparable[a.length]));
    }

    private class SortTask extends RecursiveAction {
        private T[] array;
        private T[] copy;
        private int subBegin;
        private int subEnd;

        SortTask(T[] array, int subBegin, int subEnd, T[] copy) {
            this.array = array;
            this.subBegin = subBegin;
            this.subEnd = subEnd;
            this.copy = copy;
        }

        protected void compute() {
            if ((subEnd - subBegin) < INSERTION_SORT_BOUNDARY) {
//                insertionSort.sortArrPart(array, subBegin, subEnd);
                Arrays.sort(array, subBegin, subEnd + 1);
                return;
            }

            int mid = subBegin + (subEnd - subBegin) / 2;

            invokeAll(new SortTask(array, subBegin, mid, copy),
                      new SortTask(array, mid + 1, subEnd, copy));

            merge(array, subBegin, mid, subEnd, copy);
        }
    }
}
