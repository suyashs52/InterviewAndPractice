package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LargestSubarray0Sum {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
		System.out.println(maxLen(new int[] { 15, -2, 2, -8, 1, 7, 10, 23 }, 8));
		System.out.println(maxLen(new int[] { 1, 2, 3 }, 3));

	}

	static int maxLen(int arr[], int n) {

		// if subarray sum is 0 contiguous element so last index value in prefix sum be
		// duplicated
		// 15, -2, 2, -8, 1, 7, 10, 23
		// 15 13 15 7 8 15 25 47
		int[] prefix = new int[n];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		prefix[0] = arr[0];

		int max = 0;
		map.put(prefix[0], 0);
		for (int i = 1; i < n; i++) {
			prefix[i] = arr[i] + prefix[i - 1];

			if (map.containsKey(prefix[i])) {
				if (prefix[i] == 0) { // sum is 0 means it is either 0 at index 0 or from index 0
					max = Math.max(max, i + 1); // 2 3 -5 --prefix 2 5 0
				} else {
					max = Math.max(max, i - map.get(prefix[i])); // need to remove last index sum so i-j ll give count
				}
			} else {
				map.put(prefix[i], i);
			}

		}

		if (max == 0 && arr[0] == 0)
			return 1;

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
