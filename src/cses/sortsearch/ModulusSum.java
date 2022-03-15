package cses.sortsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModulusSum {
	public static void main(String[] args) throws java.lang.Exception {

		// https://cses.fi/problemset/task/1662/
		// 3
		// 1 1 1

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = fs.nextInt();
		}

		System.out.println(implement(arr));

		// System.out.println(implement(new int[] { 3, 1, 2, 7, 4 }));

	}

	static int implement(int[] arr) {

		int k = 0;
		int n = arr.length;
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = (arr[i] + prefix[i - 1]) % n;
			if (prefix[i] < 0) {

				prefix[i] = (n + prefix[i]) % n;
			} else {
				prefix[i] = prefix[i] % n;
			}

		}

		int[] freq = new int[n + 1];

		for (int i : prefix) {
			freq[i]++;
		}

		int count = freq[0];
		for (int i = 1; i < freq.length; i++) {
			if (i > 1) {

				count += (i * (i - 1)) / 2;
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