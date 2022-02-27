package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class RotatedSortedArray {
	public static void main(String[] args) throws java.lang.Exception {
//		7
//		4 5 6 7 0 1 2
//		2
//		0
//		3
		
//		4
//		-1
		// your code goes here
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		
		int test = fs.nextInt();
		int[] sample = new int[test];

		for (int i = 0; i < sample.length; i++) {
			sample[i] = fs.nextInt();
		}

		int[] result = new int[test];

		for (int i = 0; i < sample.length; i++) {
			int f = bsfr(sample[i], arr);
			if (f == -1) {
				// all are sorted
				System.out.println(bsf(sample[i], arr, 0, arr.length - 1));
			}

			else {
				if (sample[i] >= arr[0]) {
					System.out.println(bsf(sample[i], arr, 0, f));
				} else {
					System.out.println(bsf(sample[i], arr, f + 1, arr.length - 1));
				}

			}

		}

	}

	static int bsfr(int val, int[] arr) {
		int t = 0;

		int f = 0;
		int l = arr.length - 1;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (arr[mid] < arr[arr.length - 1]) { // if mid is less then last element so max element found in index <
													// mid-1
				l = mid - 1;
			} else if (arr[mid] > arr[arr.length - 1]) {
				if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
					return mid;
				} else {
					f = mid + 1;
				}

			}
		}

		return -1;

	}

	static int bsf(int val, int[] arr, int f, int l) {
		int t = 0;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (arr[mid] < val) {
				f = mid + 1;
			} else if (arr[mid] > val) {
				l = mid - 1;
			} else {
				 
					return mid;
			}
		}

		return -1;

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