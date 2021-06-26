package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArraySquares {

	public static int searchTriplet(int[] arr, int targetSum) {
		List<List<Integer>> triplets = new ArrayList<>();

		if (arr.length < 3)
			return -1;
		Arrays.sort(arr);
		int res = Integer.MAX_VALUE;
		// -3, -1, 1, 2,-- 1 give output 0
		for (int i = 0; i < arr.length - 2; i++) { // need to find triplet
			int a = arr[i];

			int start = i + 1;
			int end = arr.length - 1;

			while (start < end) {
				int diff = targetSum - (a + arr[start] + arr[end]);
				if (diff == 0) { // if found
					return targetSum; // we got sum to target value diffrence is closest=0 , so return sum
				}
				if (diff > 0) { // it means target sum is greater more negative value needed
					start++;
				} else {
					end--;
				}

				if (Math.abs(diff) < res) {
					res = Math.abs(diff);
				}

			}

		}

		return targetSum - res;

	}

	public static void main(String[] arg) throws InterruptedException {

		System.out.println(SortedArraySquares.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(SortedArraySquares.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(SortedArraySquares.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));

	}

}
