package otus.pqueue;

public class Node<T> {
    private final T data;
    private final int priority;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public T getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}