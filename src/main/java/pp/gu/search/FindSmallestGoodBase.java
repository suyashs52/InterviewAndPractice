package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class FindSmallestGoodBase {
	public static void main(String[] args) throws java.lang.Exception {

		// Given an integer n represented as a string, return the smallest good base of
		// n
		// We call k≥ 2 a good base of n, if all digits of nbase kare 1s.
//		2
//		13
//		4681
//		
//		3
//		8
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		Integer[] arr = new Integer[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			int min = 2;
			for (int j = 63; j > 0; j--) {

				int low = 2;
				int high = arr[i] - 1;
				boolean found = false;
				while (low <= high) {
					int mid = low + (high - low) / 2;

					int res = checkPowSum(mid, j, arr[i]);

					if (res == arr[i]) {
						System.out.println(mid);
						found = true;
						break;
					} else if (res < arr[i]) { // all power sum exhausted still sum is less than target
						low = mid + 1; // we can found in higher value
					} else {
						high = mid - 1;
					}
				}
				if (found)
					break;

			}
		}

	}

	static int checkPowSum(int val, int exp, int target) {

		int sum = 1;
		int pow = 1;
		int v = 1;
		while (sum <= target && pow <= exp) {
			v *= val;
			pow++;
			sum += v;

		}
		return sum;

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