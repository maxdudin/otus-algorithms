package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.merge.ForkJoinMergeSort;
import otus.sort.test.TestArraySorting;

public class TestForkJoinMergeSort extends TestArraySorting {
    protected TestForkJoinMergeSort() {
        this.sortingAlgo = new ForkJoinMergeSort<>(5);
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
