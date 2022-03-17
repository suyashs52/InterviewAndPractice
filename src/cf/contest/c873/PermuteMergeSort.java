package cf.contest.c873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class PermuteMergeSort {
	public static void main(String[] args) throws java.lang.Exception {
		// https://codeforces.com/contest/873/problem/D
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int k = fs.nextInt();

		int[] a = desiredNum(n, k);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static int[] desiredNum(int n, int k) {
		if (k % 2 == 0) { // even

			return new int[] { -1 };
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		merge1(arr, 0, n, k);

		return arr;

	}

	static int k;

	private static void merge1(int[] arr, int start, int end, int k) {
		if (k == 1) {//
			return;
		}

		if (end - 1 == 1) {
			return;
		}
		if (start == end-1)
			return;
		k = k - 2;

		int mid = start + (end - start) / 2;

		// swap
		int temp = arr[mid];
		arr[mid] = arr[mid - 1];
		arr[mid - 1] = temp;
		// mid
		merge1(arr, start, mid, k);
		merge1(arr, mid, end, k);

	}

	private static void merge(int[] arr, int left, int right, int k) {
		if (k == 1)
			return; // k=1 already sorted
		if (right - 1 == 1)
			return;
		k -= 2;
		int mid = left + (right - left) / 2;

		// swap
		int temp = arr[mid];
		arr[mid] = arr[mid - 1];
		arr[mid - 1] = temp;

		merge(arr, left, mid, k);
		merge(arr, mid, right, k);

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

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}