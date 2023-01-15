package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class CollectingNumbers {
	public static void main(String[] args) throws java.lang.Exception {
//https://cses.fi/problemset/task/2216

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		Integer[] arr = new Integer[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();

		}

		System.out.println(collect(arr));

	}

	static int collect(Integer[] arr) {
		// given 1 to n only
		// collect number in increasing order
		// 1 2 3 4 5 so count=1
		// 3 1 2 4 5 count=2 , 1 2 4 5 , then 3
		// why 3 comes before 2 , when ever we get decreasing seq count ++
		// o^2 for each element check if lesser value is ahead then count++
		// as it is from 1 to n only 3 comes before 1 it must comes before 2
		// 3 2 1 4 5 count=3, for 1 4 5, 2 , 3 so start ranking 3 assign 1 st rank

		Integer[] rank = new Integer[arr.length + 1];

		for (Integer i = 0; i < rank.length - 1; i++) {
			rank[arr[i]] = i;
		}

		int c = 1; // starting 1 seq found rest ll collect if higher value comes first

		for (int i = 2; i < rank.length; i++) { // 1 2 3 4 5 2 comes before means 2 rank lesser then 1
			if (rank[i - 1] > rank[i]) {
				c++;
			}
		}

		return c;
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