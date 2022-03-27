package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ManhatanDistance {

	public static void main(String... strings) {
//		https://www.geeksforgeeks.org/sum-manhattan-distances-pairs-points/

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();
		int x[] = { -1, 1, 3, 2 };
		int y[] = { 5, 6, 5, 3 };
		int n = 4;
		System.out.println(totaldistancesum(x, y, n));

	}

	static int totaldistancesum(int x[], int y[], int n) {
		int tsum = 0;
		int tsum2 = 0;
		Arrays.sort(x);
		Arrays.sort(y);
		// for -1,1,3,2
		//sort it -1 1 2 3
		// 1--1+3--1+3--1 (1+3+2)-3(-1)
		
		int sum = 0;
		int sum2 = 0;
		for (int i = n - 1; i > -1; i--) {
			
			if (i == n - 1) {
				sum = sum + x[i];
				sum2 = sum2 + y[i];
			} else {
				tsum += sum - (x[i] * (n - 1 - i));
				tsum2 += sum2 - (y[i] * (n - 1 - i));
				sum = sum + x[i];
				sum2 = sum2 + y[i];
			}

		}

		return tsum + tsum2;
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
