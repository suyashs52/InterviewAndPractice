package pp.gu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class CountValidParanthesis {
	public static void main(String[] args) throws java.lang.Exception {

		// You are given a non-negative number N, find the number of valid parentheses
		// expressions of that length. If the answer exists, print the answer modulo
		// 10^9 + 7, otherwise print -1.

//		2
//		4
//		5
//		
//		2
//		-1

		long[] catalan = new long[501];
		catalan[0] = 1;
		catalan[1] = 1; // ()
		catalan[2] = 2;// ()(), (())
		// 3 we divide (_)|_ _
		// inside/outside == 0 inside2outside,1in1out,2in0out
		// we already know 0,2 index value so can calculate3 also
		// doing same for others too
		// for 3 we need till 2
		int mod = (int) Math.pow(10, 9) + 7;
		for (int i = 3; i < 501; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i] = (catalan[i] % mod + (catalan[j] % mod * catalan[i - 1 - j] % mod) % mod) % mod;
			}
		}
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		for (int i = 0; i < t; i++) {
			int n = fs.nextInt();

			if (n % 2 == 0) {
				n = n / 2;
				System.out.println(catalan[n]);

			} else {
				System.out.println(-1);
			}

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