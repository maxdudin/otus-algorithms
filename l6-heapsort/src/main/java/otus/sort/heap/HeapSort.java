package otus.sort.heap;

import otus.sort.Sort;

import java.util.Stack;

public class HeapSort<T extends Comparable> implements Sort<T> {
    @Override
    public void sort(T[] a) {

    }

    void buildHeap(T[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            Stack<Integer> heapifyStack = new Stack<>();
            heapifyStack.push(i);
            while (!heapifyStack.empty()) {
                maxHeapify(arr, heapifyStack);
            }
        }
    }

    void maxHeapify(T[] arr, Stack<Integer> heapifyStack) {
        if (heapifyStack.empty()) {
            return;
        }

        int i = heapifyStack.pop();
        int l = left(i);
        int r = right(i);
        int max = i;
        if (l < arr.length && arr[l].compareTo(arr[i]) > 0) {
            max = l;
        }

        if (r < arr.length && arr[r].compareTo(arr[max]) > 0) {
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
