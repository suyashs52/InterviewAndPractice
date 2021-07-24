package com.educative.heap;

public class MaxHeap {

	public int[] heap;
	public int size;
	public int maxSize;

	MaxHeap(int size) {
		this.maxSize = size;
		this.size = 0;
		heap = new int[maxSize];
		heap[0] = Integer.MAX_VALUE;
	}

	MaxHeap() {
		this.size = 0;
		this.maxSize = 10;
		heap = new int[maxSize];
		heap[0] = Integer.MAX_VALUE;
	}

	public void insert(int val) {
		if (size >= maxSize) {
			int[] temp = new int[maxSize * 2];
			for (int i = 1; i < temp.length; i++) {
				temp[i] = heap[i];
			}

			heap = temp;

		}

		// first element
		heap[++size] = val;

		int current = size;
		// max heap
		while (heap[current / 2] < heap[current]) {
			swap(current / 2, current);
			current = current / 2;
		}

	}

	public int first() {
		return heap[1];
	}

	public int pop() {
		int popped = heap[1];
		heap[1] = heap[size--];
		heap[size + 1] = 0;
		maxHeapify(1);
		return popped;
	}

	void maxHeapify(int pos) {
		if (pos >= size / 2)
			return;
		if (heap[pos] < heap[pos * 2] || heap[pos] < heap[pos * 2 + 1]) {

			if (heap[pos * 2] > heap[pos * 2 + 1]) {
				swap(pos, pos * 2);
				maxHeapify(pos * 2);
			} else {
				swap(pos * 2 + 1, pos);
				maxHeapify(pos * 2 + 1);
			}

		}

	}

	private void swap(int fpos, int spos) {
		int tmp;
		tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
			System.out.println();
		}
	}

	public void removeElem(int val) {

		int index = findElement(val, 1, -1);
		heap[index] = heap[size--];
		heap[size + 1] = 0;

		if (heap[index / 2] < heap[index]) {
			while (heap[index / 2] < heap[index]) {
				swap(index / 2, index);
				index = index / 2;
			}
		} else {
			maxHeapify(index);
		}

	}

	int findElement(int val, int index, int ind) {
		if (ind > 0)
			return ind;
		if (index > size)
			return ind;
		 
		if (heap[index] == val)
			return index;
		ind = Math.max(findElement(val, 2 * index, ind), findElement(val, 2 * index + 1, ind));

		return ind;

	}

	public static void main(String[] arg) {
		System.out.println("The Max Heap is ");
		MaxHeap maxHeap = new MaxHeap(15);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);

		maxHeap.removeElem(9);

		maxHeap.print();
		System.out.println("The Max val is " + maxHeap.pop());
		maxHeap.print();
	}

}
