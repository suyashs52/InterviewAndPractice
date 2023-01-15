package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class XorQuerySubarray {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/xor-queries-of-a-subarray/
		System.out
				.println(xorQueries(new int[] { 1, 3, 4, 8 }, new int[][] { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } }));

	}

	public static int[] xorQueries(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];

		int[] prefixXor = new int[arr.length];
		prefixXor[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixXor[i] = prefixXor[i - 1] ^ arr[i];
		}
		// ----s1
		// ----------s2
		// s2^(s1-1) ll remove all xor element before s1 as duplicate
		for (int i = 0; i < queries.length; i++) {

			if (queries[i][0] == 0) {
				result[i] = prefixXor[queries[i][1]];
			} else {
				result[i] = prefixXor[queries[i][1]] ^ prefixXor[queries[i][0] - 1];
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
