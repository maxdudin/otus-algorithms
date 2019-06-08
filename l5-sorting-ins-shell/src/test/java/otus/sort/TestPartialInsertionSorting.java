package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.insertion.PartialInsertionSort;
import otus.sort.test.TestArraySorting;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestPartialInsertionSorting extends TestArraySorting {
    private PartialInsertionSort<Integer> partialInsertionSort;

    public TestPartialInsertionSorting() {
        this.partialInsertionSort = new PartialInsertionSort<>();
        this.sortingAlgo = partialInsertionSort;
    }

    @Override
    @Test
    public void whenGivenSimpleUnsortedArray_ExpectItSorted() {
        super.whenGivenSimpleUnsortedArray_ExpectItSorted();
    }

    @RepeatedTest(10)
    public void whenRandomArrayWasGenerated_ExpectItSorted() {
        super.whenRandomArrayWasGenerated_ExpectItSorted(100, 777);
    }

    @Test
    public void sort_WhenGivenPartialSortingTask_ExpectArrayBeingPartialSorted() {
        Integer[] arr = new Integer[]{2, 9, 3, 4, 6, 1, 5, 8, 7, 0};
        partialInsertionSort.sort(arr, 1, 3);
        assertEquals(Integer.valueOf(6), arr[1]);
        assertEquals(Integer.valueOf(8), arr[4]);
        assertEquals(Integer.valueOf(9), arr[7]);
    }

    @Test
    public void sort_WhenGivenPartialSortingTaskLenModGapIsZero_ExpectArrayBeingPartialSorted() {
        Integer[] arr = new Integer[]{4, 4, 4, 1, 1, 1, 3, 3, 3, 2};
        partialInsertionSort.sort(arr, 0, 3);
        assertEquals(Integer.valueOf(1), arr[0]);
        assertEquals(Integer.valueOf(2), arr[3]);
        assertEquals(Integer.valueOf(3), arr[6]);
        assertEquals(Integer.valueOf(4), arr[9]);
    }

    @RepeatedTest(1000)
    public void sort_WhenGivenPartialSortingTaskLenModGapIsZero_ExpectArrayBeingPartialSorted1() {
        Integer[] array = new Random()
                .ints(10, 0, 10)
                .boxed().toArray(Integer[]::new);
        partialInsertionSort.sortArrPart(array, 2, 7);
        IntStream.range(3, 7).forEach(i -> {
            for (int j = i - 1; j >= 2; j--) {
                assertTrue(array[j] <= array[i]);
            }
        });
    }
}
