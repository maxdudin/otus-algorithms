package otus.sort;

import org.junit.jupiter.api.Test;
import otus.sort.insertion.InsertionSort;

public class TestInsertionSorting extends TestArraySorting {
    public TestInsertionSorting() {
        this.sortingAlgo = new InsertionSort<>();
    }

    @Override
    @Test
    public void sort_WhenGivenSimpleUnsortedArray_ExpectItSorted() {
        super.sort_WhenGivenSimpleUnsortedArray_ExpectItSorted();
    }
}
