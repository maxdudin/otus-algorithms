package otus.sort.merge;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeOperationSort {

    @Test
    public void testSimpleArr() {
        int len = 4;
        int begin = 0;
        int middle = 2;
        Integer[] array = new Integer[]{0, 7, 6, 9};
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    @RepeatedTest(100)
    public void testRandomizedMerge() {
        int len = ThreadLocalRandom.current().nextInt(1, 41);
        int max = ThreadLocalRandom.current().nextInt(1, 41);
        int begin = 0;
        int middle = len / 2;
        Integer[] array = new Random()
                .ints(len, 0, max)
                .boxed().toArray(Integer[]::new);
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    @RepeatedTest(100)
    public void testRandomizedMergeSmallNumbers() {
        int len = ThreadLocalRandom.current().nextInt(1, 5);
        int max = ThreadLocalRandom.current().nextInt(1, 5);
        int begin = 0;
        int middle = len / 2;
        Integer[] array = new Random()
                .ints(len, 0, max)
                .boxed().toArray(Integer[]::new);
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    private void testGenericMerge(Integer[] array, int len, int begin, int middle, int end) {
        Integer[] arrayCopy = Arrays.copyOf(array, len);
        Integer[] arrayCopyAux = Arrays.copyOf(array, len);
        Arrays.sort(arrayCopy);

        Arrays.sort(array, begin, middle);
        Arrays.sort(array, middle, end + 1);
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.merge(array, begin, middle, end, arrayCopyAux);

        IntStream.range(begin, end).forEach(i -> {
            for (int j = i - 1; j >= 0; j--) {
                assertTrue(array[j] <= array[i]);
            }
        });
    }
}
