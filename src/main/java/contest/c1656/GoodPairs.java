package contest.c1656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class GoodPairs {
	public static void main(String[] args) throws java.lang.Exception {

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t > 0) {

			int n = fs.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = fs.nextInt();
			}

			if (n == 1) {
				System.out.println("1 1");
			} else if (n == 2) {
				System.out.println("1 2");
			} else {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxind = 0;
				int minind = 0;

				for (int i = 0; i < n; i++) {
					if (arr[i] < min) {
						min = arr[i];
						minind = i;
					}
					if (arr[i] > max) {
						max = arr[i];
						maxind = i;
					}
				}
				minind++;
				maxind++;

				System.out.println(minind + " " + maxind);

			}
			t--;
		}
		long[] arr = new long[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextLong();
		}
		for (int i = 0; i < arr.length; i++) {
			long anser = 1L << arr[i];
			System.out.println(anser - 1);
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