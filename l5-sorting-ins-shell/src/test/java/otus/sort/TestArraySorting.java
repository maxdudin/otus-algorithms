package otus.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public abstract class TestArraySorting {
    protected Sort<Integer> sortingAlgo;

    protected TestArraySorting() {

    }

    public void sort_WhenGivenSimpleUnsortedArray_ExpectItSorted() {
        Integer[] arr = new Integer[]{3, 2, 6, 5, 4, 7, 8, 1};
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        sortingAlgo.sort(arr);

        assertEquals(arrCopy.length, arr.length);
        for (int i = 0; i < arrCopy.length; i++) {
            assertEquals(arrCopy[i], arr[i]);
        }
    }
}
