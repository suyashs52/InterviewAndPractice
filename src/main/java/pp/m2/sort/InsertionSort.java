package pp.m2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class InsertionSort {

	public static void main(String... strings) {
//		https://practice.geeksforgeeks.org/problems/bubble-sort/1

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();

		System.out.println(insertionSort(new int[] { 24, 18, 38, 43, 14, 40, 1, 54 }, 8));

	}

	static void insert(int arr[], int i) {
		// sort till i
		// as it is starting from index 1
		// shifting till current value is put at right place

		int temp = arr[i];
		int j = i;
		while (j > 0 && arr[j - 1] > temp) {
			arr[j] = arr[j - 1];
			j--;

		}
		arr[j] = temp;
	}

	public static int[] insertionSort(int arr[], int n) {
		// code here
		// in each iteration ll get sorted set till i
		for (int i = 1; i < n; i++) {
			insert(arr, i);
		}

		return arr;
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
