package otus.sort.merge;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMergeSort<T extends Comparable> extends MergeSort<T> {
    private final int processors = Runtime.getRuntime().availableProcessors();

    @Override
    public void sort(T[] a) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(processors);
        forkJoinPool.execute(new SortTask<>(a, 0, a.length - 1, (T[]) new Comparable[a.length]));
    }

    private class SortTask<T> extends RecursiveAction {
        private T[] array;
        private T[] copy;
        private int begin;
        private int end;

        SortTask(T[] array, int begin, int end, T[] copy) {
            this.array = array;
            this.begin = begin;
            this.end = end;
            this.copy = copy;
        }

        protected void compute() {
            if ((end - begin) < INSERTION_SORT_BOUNDARY) {
                insertionSort.sort(array);
                return;
            }

            int mid = begin + (end - begin) / 2;

            invokeAll(new SortTask(array, begin, mid, copy),
                      new SortTask(array, mid + 1, end, copy));
            merge(array, begin, mid, end, copy);
        }
    }
}
