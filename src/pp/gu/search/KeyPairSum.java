package pp.gu.search;

import java.util.Arrays;

public class KeyPairSum {
	public static void main(String... strings) {
		// https://practice.geeksforgeeks.org/problems/key-pair5616/1
		int[] arr = new int[] { 1, 4, 45, 6, 10, 8 };
		int N = 6;
		int X = 16;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		arr =new int[] {1, 2, 5, 6, 7};
		N=5;
		X=4;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		
		
	}

	static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
		boolean has = false;

		// brute force --for loop 1: i-n 2nd:i+1-n a[i]+a[j] =x n^2
		// binarry search: a[i] element , next element would be x-a[i], search it from
		// i+1-n nlogn
		// two pointer
		// since array is not sorted 2pointer or binary search ll apply only on sorted
		// so sort it first
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum == x)
				return true;
			else if (sum < x) {
				i++;
			} else {
				j--;
			}
		}

		return false;

	}

}
