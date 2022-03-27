package cf.contest.c1658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class MarinandPhotoshoot {
	public static void main(String[] args) throws java.lang.Exception {

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t > 0) {

			int n = fs.nextInt();
			String s = fs.next();

			char[] ch = s.toCharArray();
			int zero = 0;

			for (int i = 0; i < ch.length - 1; i++) {
				if (ch[i] == '0' && ch[i + 1] == '0') {
					zero += 2;
				}
			}
			int one = 0;
			for (int i = 0; i < ch.length - 2; i++) {
				if (ch[i] == '0' && ch[i + 1] == '1' && ch[i + 2] == '0') {
					one += 1;
				}
			}
//			9
//			3
//			000
//			3
//			001
//			3
//			010
//			3
//			011
//			3
//			100
//			3
//			101
//			3
//			110
//			3
//			111
//			19
//			1010110000100000101
			

			System.out.println(zero + one);
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

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}