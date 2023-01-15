package com.dp;

public class LongestIncreasingSubs {
	static int max = 1;

	public static void main(String... str) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		lis(arr, n);
		System.out.println(max);
		System.out.println(lisdp(arr, n));
	}

	private static int lis(int[] arr, int n) {
		if (n == 1)
			return 1;
		int res = 0;
		int max_end = 1;
		// first put n=last length cause calculation done to last index
		// for each n -iterate from 1 to n recursive, at 1 return 1
		// iterating if array n value is greater than ith value
		// increase value by one and assign to max but not always
		// ensure +1 increment is greater than max as for each greater
		// value we do the assignment

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_end) {
				max_end = res + 1;
			}

		}
		if (max < max_end) {
			max = max_end;
		}
		return max_end;

	}

	static int lisdp(int[] arr, int n) {
		int lis[] = new int[n];
		int max = 0;
		// for starting single value has 1 incremented value

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		// for start next value
		// if nth value is lesser than i the value then +1 + then value at i
		// we do all value for lesser value so make sure check current value
		// should be less than +1+value of ith val

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
			if (max < lis[i]) {
				max = lis[i];
			}
		}

		return max;

	}

}
