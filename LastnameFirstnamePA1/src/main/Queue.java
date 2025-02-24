package main;

import java.util.NoSuchElementException;

/**
* A generic queue implementation using a circular array.
* This class supports basic queue operations: enqueue, dequeue, retrieving the front element,
* and obtaining the queue size. The queue uses modular arithmetic to efficiently wrap-around 
* the underlying array.
* Known Bugs:  None 
*
* @ Jiarui Zhang 
* jiaruiz@brandeis.edu 
* <02 23, 2025> 
* COSI 21A PA1
*/
public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
	}
	
	public void enqueue(T element) {
		// if (numEntries >= q.length) {
		// 	throw new IllegalStateException("Queue is full");
		// }
		q[tail] = element;
		tail = (tail + 1) % q.length;
		numEntries++;
	}
	
	public void dequeue() { 
		if (numEntries == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		q[head] = null; // Clear reference for garbage collection
		head = (head + 1) % q.length;
		numEntries--;
	}
	
	public T front() {
		if (numEntries == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		return q[head];
	}
	
	
	public int size() {
		return numEntries;
	}
	
	@Override
	public String toString() {
		String queue2String = "";
		for (int i = 0; i < numEntries; i++) {
			queue2String += q[(head + i) % q.length] + " ";
		}
		return queue2String;
	}
}
