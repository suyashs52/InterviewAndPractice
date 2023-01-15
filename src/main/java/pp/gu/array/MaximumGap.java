package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaximumGap {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/maximum-gap/

		FastScanner fs = new FastScanner();

		int[] arr = new int[] { 3, 6, 9, 1 };

		System.out.println(maximumGap(arr));
		arr = new int[] { 1, 3, 100 };

		System.out.println(maximumGap(arr));

	}

	public static int maximumGap(int[] nums) {
		int n = 0;
		// sort the array and take a[high]-a[low] diff
		// order is nlogn
		// max gap between 2 number
		// 1 3 6 9
		// min:1 max:9 diff:8 total gap in array is 3 so max diff:8/3=2 as odd it is 3

		if (nums.length < 2)
			return 0;
		if (nums.length == 2)
			return Math.abs(nums[0] - nums[1]);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		int len = nums.length;
		int gap = (max - min) % (len - 1); // total space is n-1

		if ((max - min) % (len - 1) > 0)
			gap = gap + 1; // this is min difference 8/3:min (max) dif of 4 element in 1-9 3

		if (gap == 0)
			return gap;
		// now bucketing
		int[] mina = new int[gap];
		int[] maxa = new int[gap];

		for (int i = 0; i < gap; i++) {
			mina[i] = Integer.MAX_VALUE;
			maxa[i] = Integer.MIN_VALUE;
		}

		for (int i : nums) {
			int t = ((i - 1) / gap) % gap;

			mina[t] = Math.min(mina[t], i);
			maxa[t] = Math.max(maxa[t], i);
		}
		int diff = 0;
		int j = 0;
		for (int i = 0; i < gap; i++) {

			if (maxa[i] != Integer.MIN_VALUE && i <= j) {
				max = maxa[i];

			}
			if (i > j && mina[i] != Integer.MAX_VALUE) {
				min = mina[i];
				diff = Math.max(diff, min - max);
				if (maxa[i] != Integer.MIN_VALUE) {
					max = maxa[i];

				}

			}

			j = i;
		}

		return diff;
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
