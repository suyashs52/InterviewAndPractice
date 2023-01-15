package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SquareSortedArray {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/squares-of-a-sorted-array/
		sortedSquares(new int[] { -4, -1, 0, 3, 10 });

	}

	public static int[] sortedSquares(int[] nums) {
		int[] sort = new int[nums.length];
		int j = nums.length - 1;
		int k = j;
		int i = 0;
		for (; k > -1;) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				sort[k--] = nums[i] * nums[i];
				i++;
			} else {
				sort[k--] = nums[j] * nums[j];
				j--;

			}
		}

		return sort;
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
