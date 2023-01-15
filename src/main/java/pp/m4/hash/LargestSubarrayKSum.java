package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LargestSubarrayKSum {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
		System.out.println(maxLen(new int[] { 10, 5, 2, 7, 1, 9 }, 6, 15));
		System.out.println(maxLen(new int[] { -1, 2, 3 }, 3, 6));
		System.out
				.println(maxLen(new int[] { 13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 }, 17, 15));

	}

	static int maxLen(int A[], int N, int K) {

		// if subarray sum is k contiguous element so last index value of sum-k in
		// prefix sum be
		// duplicated
		// 10, 5, 2, 7, 1, 9
		// 10 15 17 25 26 35
		// 25-5 15 exist
		int[] prefix = new int[N];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		prefix[0] = A[0];

		int max = 0;
		map.put(prefix[0], 0);
		if (prefix[0] == K)
			max = 1;
		for (int i = 1; i < N; i++) {
			prefix[i] = A[i] + prefix[i - 1];

			if (map.containsKey(prefix[i] - K)) {

				max = Math.max(max, i - map.get(prefix[i] - K)); // need to remove last index sum so i-j ll give
																	// count

			}
			if (map.containsKey(prefix[i]) == false) { // if not contain to maintain highest len
				map.put(prefix[i], i);
				if (prefix[i] == K) { // ll be from index 0
					max = Math.max(max, i + 1);
				}
			}

		}

		return max;
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
