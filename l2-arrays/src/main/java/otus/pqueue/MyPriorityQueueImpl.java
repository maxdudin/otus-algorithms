package otus.pqueue;

public class MyPriorityQueueImpl<T> implements MyPriorityQueue<T> {

    private Node<T> head;

    @Override
    public void enqueue(int priority, T item) {
        Node<T> newElem = new Node<>(item, priority);
        Node<T> temp = head;

        if (head == null) {
            head = newElem;
            return;
        }

        if (newElem.getPriority() > temp.getPriority()) {
            head.setNext(newElem);
            newElem.setPrev(head);
            head = newElem;
            return;
        }

        while (newElem.getPriority() <= temp.getPriority()) {
            if (temp.getPrev() == null) {
                temp.setPrev(newElem);
                return;
            }
            temp = temp.getPrev();
        }

        newElem.setPrev(temp);
        newElem.setNext(temp.getNext());
        if (newElem.getNext() != null) {
            newElem.getNext().setPrev(newElem);
        }
        temp.setNext(newElem);
    }

    @Override
    public T dequeue() {
        Node<T> result = head;
        if (head.getPrev() != null) {
            head.getPrev().setNext(null);
            head = head.getPrev();
        } else {
            head = null;
        }

        return result.getData();
    }
}
