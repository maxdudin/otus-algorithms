package otus.sort;

import org.junit.jupiter.api.Test;
import otus.sort.insertion.PartialInsertionSort;
import otus.sort.shell.ShellSort;

import java.util.Random;
import java.util.stream.IntStream;

public class TestShellSorting {
    public TestShellSorting() {

    }

    @Test
    public void sort_WhenGivenSimpleUnsortedArray_ExpectItSorted() {
        int arraySize = 1000;
        int maxNum = 1000;
        Integer[] array = new Random()
                .ints(arraySize, 0, maxNum)
                .boxed().toArray(Integer[]::new);
        int[] deltas = IntStream
                .iterate(1, x -> x < maxNum, x -> 4^x + 3*2^(x - 1) + 1)
                .sorted().toArray();
        Sort<Integer> sorter = new ShellSort<>(new PartialInsertionSort(), deltas);
        sorter.sort(array);
    }
}
