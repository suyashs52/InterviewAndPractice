package com.educative.twopointer;

public class PairWithTargetSum {

	public static int[] search(int[] arr, int targetSum) {
		// sum is greater than targetNumber
		int first = 0;
		int last = arr.length - 1;
		while (first < last) {
			if (arr[first] + arr[last] == targetSum)
				break;
			// sorted
			if (arr[first] + arr[last] > targetSum) {
				last--;
			} else {
				first++;
			}
		}
		if (first == last) {
			return new int[] { -1, -1 };
		}
		return new int[] { arr[first], arr[last] };
	}

	public static void main(String[] arg) {
		int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 5, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 14);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 24);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	
	
	}

}
