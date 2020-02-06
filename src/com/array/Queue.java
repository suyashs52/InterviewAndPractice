package com.array;

public class Queue {
	int front, rear, size;
	int capacity;
	int array[];

	public Queue(int capacity) {
		this.capacity = capacity;
		this.front = this.size = 0;
		this.rear = this.capacity - 1;
		array = new int[this.capacity];
	}

	public void enqueue(int data) {
		if (size == capacity) {
		} else {

			this.rear = (this.rear + 1) % capacity;
			array[rear] = data;
			this.size = this.size + 1;
			System.out.println(data + " enque to queue");

		}
	}

	public int dequeue() {
		int data = -1;
		if (size == 0) {

		} else {
			int item = array[this.front];
			this.front = (this.front + 1) % this.capacity;
			this.size = this.size - 1;
			return item;
		}
		return data;
	}

	public int front() {

		if (this.size == 0)
			return -1;
		else
			return array[front];

	}

	public int rear() {
		if (this.size == 0)
			return -1;
		return this.array[rear];
	}

	public static void code() {
		Queue queue = new Queue(5);
		queue.enqueue(5);
		queue.enqueue(10);
		queue.enqueue(15);
		System.out.println(queue.front());
		System.out.println(queue.rear());

	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	
	

}
