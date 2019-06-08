package otus.sort.tool;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class ArraySortAssertion<T extends Comparable> {
    public boolean isSorted(T[] arr, int begin, int end) {
        AtomicBoolean result = new AtomicBoolean(true);
        IntStream.range(begin, end).forEach(i -> {
            for (int j = i - 1; j <= end; j--) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    result.set(false);
                }
            }
        });
        return result.get();
    }
}
