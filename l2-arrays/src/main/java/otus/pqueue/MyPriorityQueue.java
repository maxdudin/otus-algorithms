package otus.pqueue;

public interface MyPriorityQueue<T> {
    void enqueue(int priority, T item);
    T dequeue();
}
