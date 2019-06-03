package otus.sort;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import otus.sort.insertion.InsertionSort;
import otus.sort.test.TestArraySorting;

public class TestInsertionSorting extends TestArraySorting {
    public TestInsertionSorting() {
        this.sortingAlgo = new InsertionSort<>();
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
