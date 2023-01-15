package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TrappingRainWater {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/trapping-rain-water/

		FastScanner fs = new FastScanner();

		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr));
	}

	public static int trap(int[] height) {
		int count = 0;
		int n = height.length;
		int[] premax = new int[n];
		int[] postmax = new int[n];
		premax[0] = height[0];
		postmax[n - 1] = height[n - 1];
		for (int i = 1; i < n; i++) {

			premax[i] = Math.max(premax[i - 1], height[i]);
			postmax[n - 1 - i] = Math.max(postmax[n - i], height[n - 1 - i]);

		}

		// |
		// |----|
		// |----|
		// | || |
		// only trapping possible
		for (int i = 1; i < n - 1; i++) {
			int minhght = Math.min(premax[i - 1], postmax[i + 1]);
			if (minhght > height[i]) {
				count += minhght - height[i];
			}
		}

		return count;

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
