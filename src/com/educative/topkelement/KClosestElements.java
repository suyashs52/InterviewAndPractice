package com.educative.topkelement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Entry {
	int key;
	int value;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class KClosestElements {

	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
		List<Integer> list = new ArrayList<>();
		int key = binarySearch(arr, X);
		int low = Math.max(0, key - K);
		int high = Math.min(arr.length - 1, key + X);

		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((n1, n2) -> n1.value - n2.value);

		for (int i = low; i <= high; i++) {
			minHeap.add(new Entry(arr[i], Math.abs(X - arr[i])));
		}

		for (int i = 0; i < K; i++) {
			list.add(minHeap.poll().key);
		}
		Collections.sort(list);
		return list;

	}

	private static int binarySearch(int[] arr, int target) {
		int mid = -1;
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[start] < arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		 
		return start ;
	}

	public static void main(String[] args) {
		List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
		System.out.println("'K' closest numbers to 'X' are: " + result);

		result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
		System.out.println("'K' closest numbers to 'X' are: " + result);
	}
}
