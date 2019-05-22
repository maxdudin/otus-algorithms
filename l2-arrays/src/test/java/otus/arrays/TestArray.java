package otus.arrays;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArray {
    private IArray<Integer> array;

    public TestArray(IArray<Integer> array) {
        this.array = array;
    }

    private TestArray() {}

    public void test_WhenAddingSingleElementInTheBegging_ExpectSizeIncreasingAndElementInTheBeginning() {
        IntStream.range(1, 10).forEach(array::add);
        assertEquals(array.size(), 9);
        array.add(0, 0);
        assertEquals(array.size(), 10);
        assertEquals(Integer.valueOf(0), array.get(0));
    }

    public void test_WhenAddingSingleElementInTheEnd_ExpectSizeIncreasingAndElementInTheEnd() {
        IntStream.range(0, 10).forEach(array::add);
        assertEquals(array.size(), 10);
        array.add(11, 10);
        assertEquals(array.size(), 11);
        assertEquals(Integer.valueOf(0), array.get(0));
    }


    public void test_WhenAddingSingleElementInTheMiddle_ExpectSizeIncreasingAndElementInTheMiddleAndShifting() {
        IntStream.range(0, 10).forEach(array::add);
        assertEquals(array.size(), 10);
        array.add(-5, 4);
        assertEquals(array.size(), 11);
        assertEquals(Integer.valueOf(-5), array.get(4));
        IntStream.range(5, 10).forEach(num -> assertEquals(Integer.valueOf(num - 1), array.get(num)));
    }

    public void test_WhenRemovingSingleElementInTheBegging_ExpectSizeDecreasedAndElementsShiftedLeft() {
        IntStream.range(0, 10).forEach(array::add);
        assertEquals(array.size(), 10);
        Integer removed = array.remove(0);
        assertEquals(Integer.valueOf(0), removed);
        assertEquals(array.size(), 9);
        IntStream.range(0, 9).forEach(num -> assertEquals(Integer.valueOf(num + 1), array.get(num)));
    }

    public void test_WhenRemovingSingleElementInTheEnd_ExpectSizeDecreasedAndElementsOnTheSamePositions() {
        IntStream.range(0, 10).forEach(array::add);
        assertEquals(array.size(), 10);
        Integer removed = array.remove(9);
        assertEquals(Integer.valueOf(9), removed);
        assertEquals(9, array.size());
        IntStream.range(0, 9).forEach(num -> assertEquals(Integer.valueOf(num), array.get(num)));
    }

    public void test_WhenRemovingSingleElementInTheMiddle_ExpectSizeDecreasedAndElementsFromTheEndShifted() {
        IntStream.range(0, 10).forEach(array::add);
        assertEquals(array.size(), 10);
        Integer removed = array.remove(4);
        assertEquals(Integer.valueOf(4), removed);
        assertEquals(array.size(), 9);
        IntStream.range(4, 9).forEach(num -> assertEquals(Integer.valueOf(num + 1), array.get(num)));
    }
}
