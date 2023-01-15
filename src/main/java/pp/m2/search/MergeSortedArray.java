package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MergeSortedArray {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/merge-sorted-array/
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
		merge(new int[] { 0 }, 0, new int[] { 1 }, 1);
		merge(new int[] { 1 }, 1, new int[] { }, 0);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = 0;
		int j = 0;
		int[] temp = new int[m + n];
		int c = 0;
		while (i < m && j < n) {
			if (nums1[i] > nums2[j]) {
				temp[c++] = nums2[j];
				j++;

			} else {
				temp[c++] = nums1[i];
				i++;
			}
		}

		while (i < m) {
			temp[c++] = nums1[i++];
		}
		while (j < n) {
			temp[c++] = nums2[j++];
		}
		nums1 = temp;
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
