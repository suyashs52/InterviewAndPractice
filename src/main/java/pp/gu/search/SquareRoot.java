package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class SquareRoot {
	public static void main(String[] args) throws java.lang.Exception {
//		Given a non-negative integer 
//		N		, compute and print the 
//		square 	root of N 	. Print only the integer part. You must write an algorithm with O(log(n))
//		 runtime complexity.
//		6
//		4
//		8
//		16
//		0
//		9
//		2
//		
//		2
//		2
//		4
//		0
//		3
//		1
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();

		}
		for (int i = 0; i < arr.length; i++) {

		//	System.out.println((int) Math.floor(Math.sqrt(arr[i])));
			System.out.println(bsfr(arr[i]));
			//System.out.println();
		}
		// since square root of a function that is lesser than sqrt can be found
		// using binary search between 0 to n , get element just greater than

	}

	static int bsfr(int n) {
		if (n < 1)
			return 0;
		if (n < 3)
			return 1;

		int f = 0;
		int l = n;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;
			if (mid * mid > n) {
				l = mid - 1;
			} else {
				int k = mid + 1;
				if (k * k > n) {
					return mid;
				} else {
					f = mid + 1;
				}
			}
		}

		return n;

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