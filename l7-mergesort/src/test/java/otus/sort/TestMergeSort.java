package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.merge.MergeSort;
import otus.sort.test.TestArraySorting;

public class TestMergeSort extends TestArraySorting {
    public TestMergeSort() {
        this.sortingAlgo = new MergeSort<>();
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
}
