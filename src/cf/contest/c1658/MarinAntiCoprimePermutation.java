package cf.contest.c1658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class MarinAntiCoprimePermutation {
	public static void main(String[] args) throws java.lang.Exception {
//https://codeforces.com/contest/1658/problem/B
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t > 0) {

			long n = fs.nextInt();

			if ((n & 1) == 1) {
				// odd
				System.out.println(0);
			} else {
				long even = n / 2;
				long odd = even;
				long fact = factor(even);
				fact = (fact * fact) % 998244353;
				System.out.println(fact);
			}
			t--;
		}

	}

	static long factor(long n) {
		int res = 1, i;
		for (i = 2; i <= n; i++)
			res = (res * i) % 998244353;
		return res;

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