package otus.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMatrixArray {

    private IArray<Integer> array;
    private TestArray testArray;

    @BeforeEach
    public void initArray() {
        array = new MatrixArray<>(3);
        testArray = new TestArray(array);
    }

    @Test
    public void test_WhenAddingSingleElementInTheBegging_ExpectSizeIncreasingAndElementInTheBeginning() {
        testArray.test_WhenAddingSingleElementInTheBegging_ExpectSizeIncreasingAndElementInTheBeginning();
    }

    @Test
    public void test_WhenAddingSingleElementInTheEnd_ExpectSizeIncreasingAndElementInTheEnd() {
        testArray.test_WhenAddingSingleElementInTheEnd_ExpectSizeIncreasingAndElementInTheEnd();
    }

    @Test
    public void test_WhenAddingSingleElementInTheMiddle_ExpectSizeIncreasingAndElementInTheMiddleAndShifting() {
        testArray.test_WhenAddingSingleElementInTheMiddle_ExpectSizeIncreasingAndElementInTheMiddleAndShifting();
    }

    @Test
    public void test_WhenRemovingSingleElementInTheBegging_ExpectSizeDecreasedAndElementsShiftedLeft() {
        testArray.test_WhenRemovingSingleElementInTheBegging_ExpectSizeDecreasedAndElementsShiftedLeft();
    }

    @Test
    public void test_WhenRemovingSingleElementInTheEnd_ExpectSizeDecreasedAndElementsOnTheSamePositions() {
        testArray.test_WhenRemovingSingleElementInTheEnd_ExpectSizeDecreasedAndElementsOnTheSamePositions();
    }

    @Test
    public void test_WhenRemovingSingleElementInTheMiddle_ExpectSizeDecreasedAndElementsFromTheEndShifted() {
        testArray.test_WhenRemovingSingleElementInTheMiddle_ExpectSizeDecreasedAndElementsFromTheEndShifted();
    }
}
