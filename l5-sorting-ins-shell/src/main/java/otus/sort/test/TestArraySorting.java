package otus.sort.test;

import otus.sort.Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public abstract class TestArraySorting {
    protected Sort<Integer> sortingAlgo;

    protected TestArraySorting() {

    }

    public void whenGivenSimpleUnsortedArray_ExpectItSorted() {
        Integer[] arr = new Integer[]{3, 2, 6, 5, 4, 7, 8, 1};
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        sortingAlgo.sort(arr);

        assertArrayEquals(arrCopy, arr);
    }

    public void whenRandomArrayWasGenerated_ExpectItSorted(int len, int max) {
        Integer[] array = new Random()
                .ints(len, 0, max)
                .boxed().toArray(Integer[]::new);
        sortingAlgo.sort(array);

        IntStream.range(0, len - 1).forEach(i -> {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    System.out.println("asd");
                }
                assertTrue(array[j] <= array[i]);
            }
        });
    }
}
