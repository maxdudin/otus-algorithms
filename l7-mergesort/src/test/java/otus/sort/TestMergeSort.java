package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.merge.MergeSort;
import otus.sort.test.TestArraySorting;

public class TestMergeSort extends TestArraySorting {
    public TestMergeSort() {
        this.sortingAlgo = new MergeSort<>(5);
    }

    @Override
    @Test
    public void whenGivenSimpleUnsortedArray_ExpectItSorted() {
        super.whenGivenSimpleUnsortedArray_ExpectItSorted();
    }

    @RepeatedTest(100)
    public void whenRandomArrayWasGenerated_ExpectItSorted() {
        super.whenRandomArrayWasGenerated_ExpectItSorted(121, 121);
    }
}
