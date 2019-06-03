package otus.sort.heap;

import otus.sort.Sort;

import java.util.Stack;

public class HeapSort<T extends Comparable> implements Sort<T> {
    @Override
    public void sort(T[] a) {
        int heapSize = a.length;
        buildHeap(a, heapSize);
        for (int i = heapSize - 1; i > 0; i--) {
            swap(0, i, a);
            heapSize--;
            buildHeap(a, heapSize);
        }
    }

    void buildHeap(T[] arr, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            Stack<Integer> heapifyStack = new Stack<>();
            heapifyStack.push(i);
            while (!heapifyStack.empty()) {
                maxHeapify(arr, heapifyStack, heapSize);
            }
        }
    }

    void maxHeapify(T[] arr, Stack<Integer> heapifyStack, int heapSize) {
        if (heapifyStack.empty()) {
            return;
        }

        int i = heapifyStack.pop();
        int l = left(i);
        int r = right(i);
        int max = i;
        if (l < heapSize && arr[l].compareTo(arr[i]) > 0) {
            max = l;
        }

        if (r < heapSize && arr[r].compareTo(arr[max]) > 0) {
            max = r;
        }

        if (max != i) {
            swap(max, i, arr);
            heapifyStack.push(max);
        }
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
