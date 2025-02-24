package main;

/**
* Represents a node in a doubly linked list.
* This class encapsulates the data stored in the node and maintains references to the next and previous nodes.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Node<T> {
	
	private T data;
	private Node<T> next;
	private Node<T> prev;
	

	public Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		String node2String = "";
		node2String += data;		//might need to change this to data.toString()
		return node2String;
	}
}
