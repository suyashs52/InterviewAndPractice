package pp.gu.dp;

/* package codechef; // don't place package name! */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class MaxAdjacentSum {

	static List<Integer> prime = new ArrayList<>();
	static int pkey = 0;

	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
		int mod = 1000000007;
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {

			int[] a = new int[] { 5, 5, 10, 100, 10, 5 };
			int n = a.length;
			TopBottom(a, n);
			BottomTop(a, n);

		}
	}

	static void TopBottom(int arr[], int n) {
		// no adjacent together
		// so max sum is include that value or not and make sum max
		int[] auxarr = new int[n];
		topbottomsum(arr, 0, auxarr);
		System.out.println(auxarr[0]);

	}

	static int topbottomsum(int arr[], int index, int[] auxarr) {
		if (index > arr.length - 1)
			return 0;
		if (auxarr[index] != 0)
			return auxarr[index];
		int s = arr[index] + topbottomsum(arr, index + 2, auxarr);
		int s2 = topbottomsum(arr, index + 1, auxarr);
		auxarr[index] = Math.max(s, s2);
		return auxarr[index];

	}

	static void BottomTop(int arr[], int n) {
		// all value is greater than 0
		int f = arr[0];
		int s = Math.max(f, arr[1]);
		int l = 0;
		for (int i = 2; i < n; i++) {
			l = Math.max(arr[i] + f, s);
			f=s;
			s=l;

		}
		
		System.out.println(s);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine().trim());
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