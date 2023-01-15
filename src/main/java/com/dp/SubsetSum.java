package com.dp;

public class SubsetSum {
	public static void main(String... str) {
		// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
		int[] arr = new int[] { 2, 3, 5, 7, 8, 10 };
		int given = 11;
		// similar to knapsack problem
		System.out.println(isExists(arr, 0, 0, given));
		checksum(arr, given);
	}

	static boolean isExists(int[] ar, int index, int sum, int given) {
		// check given sum is obtain by current index and value included
		// or next index check
		boolean ischeck = false;
		if (sum == given)
			return true;
		if (index == ar.length)
			return false;
		if (ar[index] > given)
			return isExists(ar, index + 1, sum, given);
		ischeck = isExists(ar, index + 1, sum, given) || isExists(ar, index + 1, sum + ar[index], given);
		return ischeck;

	}

	static void checksum(int[] arr, int sum) {
		// isexist method we checking sum and index value
		// everytime we sum the array value in sum and check
		// dp would be sum, and given array value/
		// check value exist or not
		boolean[][] set = new boolean[arr.length + 1][sum + 1];
		// index start from 0 and take sum index value

		for (int i = 0; i <= arr.length; i++) {
			set[i][0] = true; // 0 given sum is always achievable
		}

		for (int i = 1; i <= sum; i++) { // 0 given value no sum is possible starting from 1
			set[0][i] = false;
		}
		// for a given sum and given value
		// if array value exist before it
		// we are taking sum so reduced it to index by given value and check
		// if sum exist if yes then current true
		// we take 0 sum as true so value self and given array value =true
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				set[i][j] = set[i - 1][j];
				if (j >= arr[i - 1]) {
					set[i][j] = set[i - 1][j] || set[i - 1][j - arr[i - 1]];
				}
			}
		}

		System.out.println(set[arr.length][sum]);
	}
}
