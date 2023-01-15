package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class SingleElement {
	public static void main(String[] args) throws java.lang.Exception {
		// You are given a sorted array consisting of only integers where every element
		// appears exactly twice, except for one element which appears exactly once.
		// Find this single element that appears only once.
//		7
//		3 3 7 7 10 11 11
		// 10

		// check index and even odd value
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		System.out.println(bsfr(arr));

	}

	static int bsfr(int[] arr) {
		if (arr.length == 1)
			return arr[0];

		int f = 0;
		int l = arr.length - 1;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (mid == 0) {
				if (arr[mid] != arr[mid + 1]) {
					return arr[mid];
				} else {
					f = mid + 1;
				}
			} else if (mid == arr.length - 1) {
				if (arr[mid] != arr[mid - 1]) {
					return arr[mid];
				} else {
					l = mid - 1;
				}

			} else {
				if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
					return arr[mid];
				else if (arr[mid] == arr[mid - 1]) { // 0 1 > 3 3 4 5 5> m=1 so
					if (mid % 2 == 0) { // even
						l = mid - 1;

					} else {
						f = mid + 1;
					}
				} else {
					if (mid % 2 == 0) { // even
						f = mid + 1;

					} else {
						l = mid - 1;
					}
				}
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