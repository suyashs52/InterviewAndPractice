package com.udemy.tree;

public class Heap {

	int[] arr;
	int sizeOfTree;

	public Heap(int size) {
		arr = new int[size + 1];
		sizeOfTree = 0;
	}

	public static void main(String... strings) {
		Heap heap = new Heap(10);
		heap.insertInHeap(100);
		heap.insertInHeap(90);
		heap.insertInHeap(80);
		heap.insertInHeap(70);
		heap.insertInHeap(60);
		heap.insertInHeap(50);
		heap.insertInHeap(40);
		heap.insertInHeap(30);
		heap.insertInHeap(20);

		heap.head();

		heap.insertInHeap(110);
		heap.head();
	}

	private int head() {
		// take top element replace it with bottom element
		// hepify top to bottom , removing top so heapify top to bottom
		if (sizeOfTree == 0) {
			System.out.println("Heap is empty");
			return -1;
		} else {
			System.out.println("Head of heap is: " + arr[1]);
			System.out.println("Extracting it now");
			int val = arr[1];
			arr[1] = arr[sizeOfTree--];
			heapifyTopToBottom(1);
			levelOrder();
			return val;

		}

	}

	private void insertInHeap(int value) {
		// insert at bottom of heap so need to heapify from bottom to top
		System.out.println("inserting " + value + " in heap");
		arr[++sizeOfTree] = value;
		heapifyBotoomToTop(sizeOfTree);
		levelOrder();

	}

	private void levelOrder() {
		System.out.println("printing all the element of this heap");
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	private void heapifyBotoomToTop(int index) {
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (arr[index] < arr[parent]) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
		}
		heapifyBotoomToTop(parent);
	}

	private void heapifyTopToBottom(int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		int min = 0;
		if (sizeOfTree < left) { // no element
			return;
		} else if (sizeOfTree == left) { // only has left child
			if (arr[index] > arr[left]) {
				int temp = arr[index];
				arr[index] = arr[left];
				arr[left] = temp;
			}
			return;
		} else { // has both child

			if (arr[left] < arr[right]) {
				min = left;
			} else {
				min = right;
			}
			if (arr[index] > arr[min]) {
				int tmp = arr[index];
				arr[index] = arr[min];
				arr[min] = tmp;
			}
		}

		heapifyTopToBottom(min);

	}
}
