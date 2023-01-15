package com.educative.kwaymerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestPairs {

	public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		// list of int[] hold each array contain 2 digit only pairs

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] + n1[1]) - (n2[0] + n2[1]));

		for (int i : nums1) {
			for (int j : nums2) {
				if (minHeap.size() < k) {
					minHeap.add(new int[] { i, j });
				} else {
					int[] a = minHeap.peek();
					if (i + j > a[0] + a[1]) {
						minHeap.poll();
						minHeap.add(new int[] { i, j });
					} else {
						break;
					}

				}

			}
		}
		result.addAll(minHeap);
		return result;
	}

	public static void main(String[] args) {
		int[] l1 = new int[] { 9, 8, 2 };
		int[] l2 = new int[] { 6, 3, 1 };
		List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
		System.out.print("Pairs with largest sum are: ");
		for (int[] pair : result)
			System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
	}

}
