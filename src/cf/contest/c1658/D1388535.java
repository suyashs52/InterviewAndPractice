package cf.contest.c1658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class D1388535 {
	public static void main(String[] args) throws java.lang.Exception {
//https://codeforces.com/contest/1658/problem/D1
		FastScanner fs = new FastScanner();
//		int t = fs.nextInt();
//		while (t > 0) { }

		System.out.println(2 ^ 3);
		int[] arr = new int[3];
		arr = new int[] { 1, 2, 3 };

		for (int i = 0; i < 100; i++) {
			System.out.println((1 ^ i) + "," + (2 ^ i) +","+ (3 ^ i));
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

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}