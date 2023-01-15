package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SumOfSubArray {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/trapping-rain-water/

		FastScanner fs = new FastScanner();

		long[] arr = new long[] { 1, 2, 3 };
		System.out.println(subarraySum(arr, 3));
	}

	public static long subarraySum(long a[], long n) {
		// code here

		// order of n2
		// return subarr(a, n);

		// order of n
		return subar(a, n);
	}

	private static long subar(long[] a, long n) {
		// 1 2 3
		// 1,12,123,2,23,3
		// so 2 comes in a set whose ending point is at 2 / starting point at 2
		// [1,2] is the only set has ending at 2 it comes with [2,3]
		// total is [12][2]--[2][23] there is 4 path
		// [12]--12 with 2,[12] with[23]==[12][23]
		// [2]--2 with 2 , 2 with 23==[2][23]

		int mod = (int) Math.pow(10, 9) + 7;
		long sum = 0;

		for (int i = 0; i < n; i++) { // 1 2 at 0 1 index so at 2 total
			/// element is 1-0+1
			sum = (sum + (a[i] * ((i + 1) * (n - i)) % mod) % mod) % mod;
		}
		return sum;
	}

	private static long subarr(long[] arr, long n) {

		// all possible subset
		// 1 2 3
		// 1,12,123,2,23,3
		long a = 0;

		for (int i = 0; i < n; i++) {

			int sum = 0;

			for (int j = i; j < n; j++) {
				sum += arr[j];
				a += sum;
			}

		}
		return a;

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
