package otus.sort.shell;

import otus.sort.Sort;
import otus.sort.insertion.PartialInsertionSort;

public class ShellSort<T extends Comparable> implements Sort<T> {

    private PartialInsertionSort<T> partialInsertionSort;
    private int[] deltas;

    private ShellSort() {

    }

    public ShellSort(PartialInsertionSort partialInsertionSort, int[] deltas) {
        this.partialInsertionSort = partialInsertionSort;
        this.deltas = deltas;

    }

    @Override
    public void sort(T[] a) {
        int deltasIter = 0;
        while (deltasIter < deltas.length) {
            int delta = deltas[deltasIter];
            for (int beginIndex = 0; beginIndex < delta; beginIndex++) {
                partialInsertionSort.sort(a, beginIndex, delta);
            }
            deltasIter++;
        }
    }
}
