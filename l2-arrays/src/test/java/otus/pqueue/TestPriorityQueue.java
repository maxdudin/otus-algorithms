package otus.pqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPriorityQueue {
    private MyPriorityQueue<Integer> priorityQueue;

    @BeforeEach
    void init() {
        priorityQueue = new MyPriorityQueueImpl<>();
    }

    @Test
    public void test_WhenAddingElementInTheTop_ExpectItOnTheTop() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(4,0);
        assertEquals(Integer.valueOf(0), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(3), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(2), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(1), priorityQueue.dequeue());
    }


    @Test
    public void test_WhenAddingElementInTheMiddle_ExpectSameTop() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(4, 4);
        priorityQueue.enqueue(3,0);
        assertEquals(Integer.valueOf(4), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(0), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(2), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(1), priorityQueue.dequeue());
    }

    @Test
    public void test_WhenAddingElementInTheEnd_ExpectSameTop() {
        priorityQueue.enqueue(1, 1);
        priorityQueue.enqueue(2, 2);
        priorityQueue.enqueue(3, 3);
        priorityQueue.enqueue(0,0);
        assertEquals(Integer.valueOf(3), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(2), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(1), priorityQueue.dequeue());
        assertEquals(Integer.valueOf(0), priorityQueue.dequeue());
    }

}
