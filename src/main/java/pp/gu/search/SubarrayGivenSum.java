package pp.gu.search;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayGivenSum {
	public static void main(String... strings) {
		// https://practice.geeksforgeeks.org/problems/key-pair5616/1
		int[] arr = new int[] { 1, 2, 3, 7, 5 };
		int N = 6;
		int X = 12;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		N = 5;
		X = 1;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		arr = new int[] { 1, 3, 7, 9, 2 };
		N = 5;
		X = 2;
		System.out.println(hasArrayTwoCandidates(arr, N, X));

	}

	static ArrayList<Integer> hasArrayTwoCandidates(int arr[], int n, int x) {
		ArrayList<Integer> l = new ArrayList<Integer>();

		if (arr.length == 1) {
			if (x == arr[0]) {
				l.add(1);
				l.add(1);
				return l;
			} else {
				l.add(-1);
				return l;
			}
		}

		int i = 0;
		int j = 0;
		int sum = 0;
		while (j < arr.length) {

			if (sum + arr[j] == x) {
				l.add(i + 1);
				l.add(j + 1);

				return l;
			} else if (sum + arr[j] < x) {

				sum += arr[j];
				j++;

			} else { // sum is greater than x
				// sum is 2, x=1
				// we start from 0 and given sum always >0
				// we must have added some arr value so remove it
				sum -= arr[i];
				i++;
				// if i and j is equal and sum is not found means sum is 0
				// if we don't increment j
 
//				if (sum + arr[j] == x) {
//					l.add(i + 1);
//					l.add(j + 1);
//					return l;
//
//				}
//
//				sum += arr[j];
//
//				j++;

			}
		}

		l.add(-1);

		return l;

	}

}
