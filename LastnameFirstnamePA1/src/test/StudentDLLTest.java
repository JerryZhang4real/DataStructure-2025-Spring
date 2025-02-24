package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;
import main.Node;

class StudentDLLTest {

@Test
    public void testInsertAndSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(0, list.size(), "Initial size should be 0");
        list.insert(10);
        assertEquals(1, list.size(), "Size should be 1 after one insertion");
        list.insert(20);
        list.insert(30);
        assertEquals(3, list.size(), "Size should be 3 after three insertions");
    }

    @Test
    public void testGetFirst() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        assertNull(list.getFirst(), "getFirst() should return null for an empty list");
        list.insert("A");
        list.insert("B");
        list.insert("C");
        assertNotNull(list.getFirst(), "getFirst() should not be null after insertion");
        assertEquals("A", list.getFirst().getData(), "getFirst() should return the first inserted element");
    }

    @Test
    public void testDeleteHead() {
        // Delete an element that is at the head of the list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        
        Integer deleted = list.delete(1);
        assertEquals(1, deleted, "Deleted element should be 1");

        assertNotNull(list.getFirst(), "Head should not be null after deletion");
        assertEquals(2, list.getFirst().getData(), "Head should now be 2");
        assertEquals(2, list.size(), "Size should decrease after deletion");
    }

    @Test
    public void testDeleteTail() {
        // Delete an element that is at the tail of the list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        
        Integer deleted = list.delete(3);
        assertEquals(3, deleted, "Deleted element should be 3");

        Node<Integer> current = list.getFirst();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        assertEquals(2, current.getData(), "Tail should now be 2");
        assertEquals(2, list.size(), "Size should decrease after deletion");
    }

    @Test
    public void testDeleteMiddle() {
        // Delete an element in the middle of the list.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        
        Integer deleted = list.delete(2);
        assertEquals(2, deleted, "Deleted element should be 2");

        Node<Integer> head = list.getFirst();
        assertEquals(1, head.getData(), "First element should be 1");
        assertNotNull(head.getNext(), "There should be a second element");
        assertEquals(3, head.getNext().getData(), "Second element should be 3");
        assertEquals(2, list.size(), "Size should decrease after deletion");
    }

    @Test
    public void testDeleteNonExisting() {
        // Deleting an element that is not in the list should return null and not change the size.
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("A");
        list.insert("B");
        String deleted = list.delete("C");
        assertNull(deleted, "Deleting a non-existing element should return null");
        assertEquals(2, list.size(), "Size should remain unchanged when deleting a non-existing element");
    }

    @Test
    public void testGetMethod() {
        // Test the get() method for existing and non-existing keys.
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        

        assertEquals(20, list.get(20), "get() should return the element if it exists");

        assertNull(list.get(40), "get() should return null if the element does not exist");
    }

    @Test
    public void testToStringEmpty() {
        // For an empty list, toString() should return an empty string.
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        assertEquals("", list.toString(), "toString() should return an empty string for an empty list");
    }


    @Test
    public void testToStringNonEmpty() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");

        assertEquals("A - B - C", list.toString(), "toString() should return the correct string representation");
    }

}
