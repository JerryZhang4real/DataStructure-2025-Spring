package main;

/**
* A generic doubly linked list implementation.
* This class supports insertion at the tail, deletion by key (removing the first occurrence),
* retrieval of elements by key, and querying the size of the list.
* It maintains references to the head and tail nodes to facilitate efficient operations.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class DoubleLinkedList<T> {

	Node<T> head;
	Node<T> tail;
	int size;

	public DoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public Node<T> getFirst() {
		return head;
	}
	
	
	public void insert(T element) {
		if(head == null) {
			head = new Node<T>(element);
			tail = head;
		} else {
			Node<T> newNode = new Node<T>(element);
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}

		size++;
	}
	
	public T delete(T key) {
		T data = null;
		Node<T> current = head;
		while(current != null) {
			if(current.getData().equals(key)) {
				data = current.getData();
				if(current == head) {
					head = current.getNext();
					head.setPrev(null);
					if (head == null) {
						tail = null;		//if the list only has one element, after the delete operation the list should be null
					}
				} else if(current == tail) {
					tail = current.getPrev();
					tail.setNext(null);
				} else {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
				}

				current = null;
				size--;
				break;			//only delete the first same entry
			}

			current = current.getNext();
		}
		
		return data;
	}
	
	public T get(T key) {
		T data = null;
		Node<T> current = head;
		while(current != null) {
			if (current.getData().equals(key)) {
				data = current.getData();
				break;
			}

			current = current.getNext();
		}

		return data;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		//adjust according to the PA's requirement
		String doubleLinkedList = "";
		Node<T> node = head;
		while (node != null) {
			doubleLinkedList += node.getData().toString();
			if (node.getNext() != null) {
				doubleLinkedList += " - ";
			}

			node = node.getNext();
		}

		return doubleLinkedList;
	}
}
