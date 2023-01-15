package pp.m2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BubbleSort {

	public static void main(String... strings) {
//		https://practice.geeksforgeeks.org/problems/bubble-sort/1

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();

		System.out.println(bubbleSort(new int[] { 24, 18, 38, 43, 14, 40, 1, 54 }, 8));

	}

	public static int[] bubbleSort(int arr[], int n) {
		// sort higher to lower for each n
		boolean flag = false;
		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 0; j < n - 1 - i; j++) { // at last largest element is at right position
				if (arr[j] > arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
					flag = true;
				}
			}
			if (flag == false) // no sorting required now
				return arr;
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
