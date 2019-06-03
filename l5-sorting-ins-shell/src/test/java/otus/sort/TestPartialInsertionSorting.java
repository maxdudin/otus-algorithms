package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.insertion.PartialInsertionSort;
import otus.sort.test.TestArraySorting;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

    @Override
    @RepeatedTest(10)
    public void whenRandomArrayWasGenerated_ExpectItSorted() {
        super.whenRandomArrayWasGenerated_ExpectItSorted();
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
}
