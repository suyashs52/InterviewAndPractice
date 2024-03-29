package com.educative.topkelement;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {

	public static List<Integer> findKLargestNumbers(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (heap.peek() < nums[i]) {
				heap.poll();
				heap.add(nums[i]);
			}
		}

		return new ArrayList<>(heap);

	}

	public static void main(String[] args) {
		List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println("Here are the top K numbers: " + result);

		result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Here are the top K numbers: " + result);
	}

}
