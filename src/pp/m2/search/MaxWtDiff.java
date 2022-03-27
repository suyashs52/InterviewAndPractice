package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaxWtDiff {

	public static void main(String... strings) {
//		https://www.codechef.com/problems/MAXDIFF
//sorting cause nlogn 
		// can be reduce to o(n+logk) if we change it to heap
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t > 0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = fs.nextInt();
			}

			Arrays.sort(arr);

			int sum = 0;
			for (int i = 0; i < k; i++) {
				sum -= arr[i];

			}

			for (int i = k; i < n; i++) {
				sum += arr[i];
			}
			System.out.println(sum);

			t--;
		}

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
