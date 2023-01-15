package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class KthSmallest {
	public static void main(String[] args) throws java.lang.Exception {
		// Given an array arr[] of size N having no duplicates and an integer K, the
		// task is to find the Kth smallest element from the array in constant extra
		// space and the array can’t be modified.
//		6
//		7 10 4 3 20 15
//		4
//		10
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		int needed = fs.nextInt();
		System.out.println(bsfr(arr, needed));

	}

	static int bsfr(int[] arr, int index) {
		if (arr.length == 1)
			return arr[0];

		// find min
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		// find max
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int f = min;
		int l = max;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			int count = findCountLessThen(mid, arr);
			if (count < index - 1) { // if less means we can found from mid+1 to last
				f = mid + 1;
			} else {
				if (count == index - 1) {
					int cc = findCountLessThen(mid + 1, arr);  //in above output let mid be (7),8,9,(10),11,12,(15)
					if (cc == index) {				// at 8 cnt be 3
						return mid;
					} else {
						f = mid + 1;
					}
				} else {
					l = mid - 1;
				}

			}
			 
		}

		return -1;

	}

	static int findCountLessThen(int n, int[] arr) {
		int f = 0;

		for (int i : arr) {
			if (i < n) {
				f++;
			}
		}

		return f;
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