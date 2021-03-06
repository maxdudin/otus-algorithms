package otus.sort.merge;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMergeOperation {

    @Test
    public void testSimpleArr() {
        int len = 4;
        int begin = 0;
        int middle = 1;
        Integer[] array = new Integer[]{0, 7, 6, 9};
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    @RepeatedTest(100)
    public void whenLargeRandomArrayIsGiven_expectMergeProcedureWorks() {
        int len = ThreadLocalRandom.current().nextInt(1, 41);
        int max = ThreadLocalRandom.current().nextInt(1, 41);
        int begin = 0;
        int middle = (len - 1) / 2;
        Integer[] array = new Random()
                .ints(len, 0, max)
                .boxed().toArray(Integer[]::new);
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    @RepeatedTest(1000)
    public void whenSmallRandomArrayIsGiven_expectMergeProcedureWork() {
        int len = ThreadLocalRandom.current().nextInt(1, 5);
        int max = ThreadLocalRandom.current().nextInt(1, 5);
        int begin = 0;
        int middle = (len - 1) / 2;
        Integer[] array = new Random()
                .ints(len, 0, max)
                .boxed().toArray(Integer[]::new);
        testGenericMerge(array, len, begin, middle, len - 1);
    }

    private void testGenericMerge(Integer[] array, int len, int begin, int middle, int end) {
        Integer[] arrayCopyAux = Arrays.copyOf(array, len);

        Arrays.sort(array, begin, middle + 1);
        Arrays.sort(array, middle + 1, end + 1);
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.merge(array, begin, middle, end, arrayCopyAux);

        IntStream.range(begin, end).forEach(i -> {
            for (int j = i - 1; j > begin; j--) {
                assertTrue(array[j] <= array[i]);
            }
        });
    }
}
