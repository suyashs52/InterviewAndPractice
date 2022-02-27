package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class FirstandLastPos {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}

		int test = fs.nextInt();
		int[] sample = new int[test];

		for (int i = 0; i < sample.length; i++) {
			sample[i] = fs.nextInt();
		}

		int[] result = new int[test];

		for (int i = 0; i < sample.length; i++) {
			int f = bsf(sample[i], arr);
			if (f == -1)
				System.out.println(-1);
			else {
				System.out.print((f+1) + " ");
				System.out.println(bsl(sample[i], arr,f)+1); //return index+1
			}

		}

	}

	static int bsf(int val, int[] arr) {
		int t = 0;
		 
		int f = 0;
		int l = arr.length-1;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (arr[mid] < val) {
				f = mid + 1;
			} else if (arr[mid] > val) {
				l = mid - 1;
			} else {
				if (mid - 1 == -1)
					return mid;
				else if (arr[mid - 1] == val) {
					l = mid - 1;
				} else
					return mid;
			}
		}

		return -1;
 

	}

	static int bsl(int val, int[] arr,int f) {
		int t = 0;
		 
		int l = arr.length;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (arr[mid] < val) {
				f = mid + 1;
			} else if (arr[mid] > val) {
				l = mid - 1;
			} else {
				if (mid + 1 == arr.length)
					return mid;
				else if (arr[mid + 1] == val) {
					f = mid + 1;
				} else
					return mid;
			}
		}

		return l;

//		5
//		1 3 3 4 5
//		2
//		3
//		2

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