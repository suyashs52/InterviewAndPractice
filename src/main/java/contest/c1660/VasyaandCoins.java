package contest.c1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class VasyaandCoins {
	public static void main(String[] args) throws java.lang.Exception {

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		 
		for(int i=0;i<t;i++) {
			 int o=fs.nextInt();
			 int s=fs.nextInt();
			 
			 if(o==0) {
				 System.out.println(1);
				 continue;
			 }else {
				System.out.println((o+s*2)+1);
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

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}