package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import main.Queue;

class StudentQueueTest {

	@Test
    public void testEnqueueAndFront() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(10);
        assertEquals(10, queue.front(), "front() should return the first enqueued element");
        assertEquals(1, queue.size(), "Size should be 1 after one enqueue");
    }
    
    @Test
    public void testEnqueueDequeue() {
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        
        assertEquals("A", queue.front(), "front() should return the first enqueued element");
        assertEquals(3, queue.size(), "Size should be 3 after enqueuing three elements");
        
        queue.dequeue();
        assertEquals("B", queue.front(), "After one dequeue, front() should return the second element");
        assertEquals(2, queue.size(), "Size should be 2 after one dequeue");
    }
    
    @Test
    public void testDequeueEmptyQueueThrowsException() {
        Queue<Integer> queue = new Queue<>(5);
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        }, "dequeue() should throw NoSuchElementException if the queue is empty");
    }
    
    @Test
    public void testFrontEmptyQueueThrowsException() {
        Queue<Integer> queue = new Queue<>(5);
        assertThrows(NoSuchElementException.class, () -> {
            queue.front();
        }, "front() should throw NoSuchElementException if the queue is empty");
    }
    
    @Test
    public void testToString() {
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("X");
        queue.enqueue("Y");
        queue.enqueue("Z");
        String expected = "X Y Z ";
        assertEquals(expected, queue.toString(), "toString() should list all elements separated by spaces");
    }
    
    @Test
    public void testCircularEnqueue() {
        // Create a small queue to force a wrap-around
        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(1); 
        queue.enqueue(2); 
        queue.enqueue(3); 
        
        assertEquals(3, queue.size(), "Queue should be full with three elements");
        
        // Dequeue two elements so that head wraps around later
        queue.dequeue(); 
        queue.dequeue(); 
        
        assertEquals(1, queue.size(), "Queue size should be 1 after two dequeues");
        assertEquals(3, queue.front(), "front() should now be the element 3");
        
        // Now enqueue two more elements; these should be placed at the beginning of the array (wrap-around)
        queue.enqueue(4); 
        queue.enqueue(5); 
        
        // The queue now logically holds 3, 4, 5 in order.
        String expected = "3 4 5 ";
        assertEquals(expected, queue.toString(), "toString() should reflect the correct order after wrap-around");
	}
}
