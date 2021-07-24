package com.educative.heap;

public class MinHeap {

	public int[] heap;
	public int size;
	public int maxSize;

	MinHeap(int size) {
		this.maxSize = size;
		this.size = 0;
		heap = new int[maxSize];
	}

	MinHeap() {
		this.size = 0;
		this.maxSize = 10;
		heap = new int[maxSize];
	}

	public void insert(int val) {
		if (size >= maxSize) {
			int[] temp = new int[maxSize * 2];
			int count = 0;
			for (int i : heap) {
				temp[count++] = i;
			}
		}

		heap[++size] = val;

		int curr = size;

		while (heap[curr] < heap[curr / 2]) {
			int temp = heap[curr];
			heap[curr] = heap[curr / 2];
			heap[curr / 2] = temp;
			curr = curr / 2;
		}

	}

	public int first() {
		return heap[1];
	}

	public int pop() {
		if (size == 0)
			return -1;
		int popped = heap[1];
		heap[1] = heap[size--];
		 
		heap[size+1] = 0;
		 
		minHeapify(1);
		return popped;
	}

	void minHeapify(int pos) {
		if (pos >= size / 2)
			return;

		if (heap[pos] > heap[pos / 2 + 1] || heap[pos] > heap[pos / 2 + 2]) {
			if (heap[pos / 2 + 1] < heap[pos / 2 + 2]) {
				swap(pos, pos / 2 + 1);
				minHeapify(heap[pos / 2 + 1]);
			} else {
				swap(pos, pos / 2 + 2);
				minHeapify(heap[pos / 2 + 2]);
			}
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
	public void removeElem(int val) {

		int index = findElement(val, 1, -1);
		 
		heap[index] = heap[size--];
		heap[size + 1] = 0;

		if (heap[index / 2]  > heap[index]) {
			while (heap[index / 2] > heap[index]) {
				swap(index / 2, index);
				index = index / 2;
			}
		} else {
			minHeapify(index);
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

	public static void main(String[] arg) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);

		minHeap.print();
		System.out.println("The Min val is " + minHeap.pop());
	}

}
