package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinSwapKTogether {
	public static void main(String[] args) throws java.lang.Exception {
		// https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

		FastScanner fs = new FastScanner();

		long[] arr = new long[] { 2, 1, 5, 6, 3 };
		System.out.println(minSwap(arr, 5, 3));
		arr = new long[] { 2, 7, 9, 5, 8, 7, 4 };
		System.out.println(minSwap(arr, 7, 6));
		arr = new long[] { 10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1 };
		System.out.println(minSwap(arr, 11, 1));
	}

	public static int minSwap(long arr[], int n, int k) {

		int count = 0;

		for (long i : arr) {
			if (i <= k)
				count++;
		}

		if (count == 0)
			return 0;// no element is lesseq to k so no swap possible
		if (count == n)
			return 0; // no swap needed

		int j = 0;
		int swap = n;
		int invalid = 0; // invalid num
		int i = 0;
		while (j < n) {
			if (arr[j] > k)
				invalid++;
//			if (j - i + 1 == count) {
//				swap = Math.min(invalid, swap);
//			}
			if (j - i + 1 < count) {
				j++; // if size is less then window size

			} else {
				// it ll at least execute 1 time if count<=n
				// count>n means no window size
				// not possible as we have till n element
				swap = Math.min(invalid, swap);
				if (invalid > 0 && arr[i] > k == true) {
					invalid--;
				}
				j++;
				i++;
			}

		}

		return swap;

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
