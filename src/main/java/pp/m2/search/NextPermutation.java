package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class NextPermutation {

	public static void main(String... strings) {
//		https://leetcode.com/problems/next-permutation/

		FastScanner fs = new FastScanner();
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 1, 1, 5 });
		nextPermutation(new int[] { 5, 6, 4, 3, 6, 1 });
	}

	public static void nextPermutation(int[] nums) {
		int index = -1;
		for (int i = nums.length - 1; i > 0; i--) { // valid till nums[1]>nums[0]
			if (nums[i - 1] < nums[i]) {
				index = i - 1;
				break;
			}
		}

		if (index > -1) {
			for (int i = nums.length - 1; i > index; i--) {
				if (nums[i] > nums[index]) {
					int t = nums[i];
					nums[i] = nums[index];
					nums[index] = t;
					break;
				}
			}

			index++;
			int end = nums.length - 1;

			while (index < end) {
				int t = nums[index];
				nums[index] = nums[end];
				nums[end] = t;
				index++;
				end--;
			}
		}

		for (int i : nums)
			System.out.print(i);
		System.out.println();

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
