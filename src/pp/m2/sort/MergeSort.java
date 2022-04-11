package pp.m2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class MergeSort {

	public static void main(String... strings) {
//		https://practice.geeksforgeeks.org/problems/merge-sort/1

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();

		mergeSort(new int[] { 4, 1, 3, 9, 7 }, 0, 4);
		mergeSort(new int[] { 6, 5, 4, 3, 2, 1 }, 0, 5);

	}

	static void merge(int arr[], int l, int m, int r) {
		// Your code here
		int[] temp = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;
		while (i <= m && j <= r) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= m) {
			temp[k++] = arr[i++];

		}
		while (j <= r) {
			temp[k++] = arr[j++];
		}

		for (i = 0; i < temp.length; i++) {
			arr[i + l] = temp[i];
		}

	}

	static void mergeSort(int arr[], int l, int r) {
		// code here

		if (l >= r)
			return;

		int m = l + (r - l) / 2;

		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);

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
