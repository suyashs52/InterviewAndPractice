package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class LengthUnsortedSubarray {

	public static void main(String... strings) {
//		https://leetcode.com/problems/custom-sort-string/

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();
		int[] arr = new int[] { 49, 130, 124, 85, 455, 257 };
		System.out.println(printUnsorted(arr, 6));

	}

	public static int[] printUnsorted(int[] arr, int n) {

		int k = -1;
		int l = -1;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				k = i;
				break; // first lesser element then current element means not sorted
			}
		}
		if (k == -1) {
			return new int[] { 0, 0 };
		}

		for (int i = n - 1; i > k; i--) {
			if (arr[i] < arr[i - 1]) {
				l = i;
				break;
			}
		}

		// now we have first and last index of unordered array
		// it can be possible the smallest value in unordered array can be lesser then
		// from 0-k
		// so need to traverse it too.
		int min = arr[n - 1];
		int max = -1;
		for (int i = k; i <= l; i++) {
			min = Math.min(arr[i], min);
			max = Math.max(max, arr[i]);
		}

		for (int i = 0; i <= k; i++) {
			if (arr[i] > min) {
				k = i;
				break;
			}
		}

		for (int j = n - 1; j >= l; j--) {
			if (arr[j] < max) {
				l = j;
				break;
			}
		}

		return new int[] { k, l };

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
