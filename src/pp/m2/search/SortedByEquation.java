package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SortedByEquation {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation0304/1
		sortArray(new long[] { -1, 0, 1, 2, 3, 4 }, 6, -1l, 2l, -1l);

	}

	public static long[] sortArray(long[] arr, int n, long A, long B, long C) {
		// Code here
		long[] result = new long[arr.length];
		// -x^2
		// -4 -3 -2 3 5
		// -16 -9 -4 -9 -25
		// ax^2+bx+c a=1 b=-1 c=2 x2-x+2=0 2x-1=0 x=1/2 so after x=1/2 it ll start
		// increasing upward
		// if a is negative means more smaller value comes first so index start from 1

		int i = 0;
		int j = arr.length - 1;
		for (; i < arr.length; i++) {
			arr[i] = A * (arr[i] * arr[i]) + B * (arr[i]) + C;
		}
		i = 0;
		if (A > 0) {
			int k = arr.length - 1;
			while (k > -1) { // largest comes first
				if (arr[i] > arr[j]) {
					result[k--] = arr[i++];
				} else {
					result[k--] = arr[j--];
				}
			}
		} else {
			int k = 0;
			while (k < arr.length) { // smallest comes first
				if (arr[i] < arr[j]) {
					result[k++] = arr[i++];
				} else {
					result[k++] = arr[j--];
				}

			}

		}

		return result;
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
