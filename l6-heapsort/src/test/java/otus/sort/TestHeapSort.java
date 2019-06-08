package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.heap.HeapSort;
import otus.sort.test.TestArraySorting;

public class TestHeapSort extends TestArraySorting {
    public TestHeapSort() {
        this.sortingAlgo = new HeapSort<>();
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
}
