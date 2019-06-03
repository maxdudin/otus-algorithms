package otus.sort.heap;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHeapConstruction {
    @Test
    public void whenArrayHasGiven_ExpectHeapConstructed() {
        Integer[] arr = new Integer[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.buildHeap(arr, arr.length);
        Integer[] arrExpected = new Integer[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        assertArrayEquals(arrExpected, arr);
    }

    @RepeatedTest(100)
    public void whenArrayWasGenerated_ExpectHeapPropertiesAreValid() {
        Integer[] array = new Random()
                .ints(100, 0, 777)
                .boxed().toArray(Integer[]::new);
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.buildHeap(array, array.length);
        Stream.of(array).forEach(i -> {
            if (i * 2 + 1 < array.length) {
                assertTrue(array[i] >= array[i * 2 + 1]);
            }

            if (i * 2 + 2 < array.length) {
                assertTrue(array[i] >= array[i * 2 + 2]);
            }
        });
    }
}
