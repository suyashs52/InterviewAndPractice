package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class OnlyRepeatingElement {
	public static void main(String[] args) throws java.lang.Exception {
//		Given a sorted array of n elements containing elements in range from 
//		1
//		 to 
//		n
//		−
//		1
//		 i.e. one element occurs twice, the task is to find the repeating element in an array.
//		7
//		1 2 3 4 4 5 6
		// 4
		// your code goes here

		// as it says contain index from 1 to n-1 think index
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		System.out.println(bsfr(arr));

	}

	static int bsfr(int[] arr) {
		int t = 0;

		int f = 0;
		int l = arr.length - 1;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			if (arr[mid] == mid) {

				l = mid - 1;
			} else {
				if (mid == arr.length - 1) {
					if (arr[mid] == arr[mid - 1])
						return arr[mid];
					else {
						return -1;
					}
				}
				if (arr[mid] == mid + 1 && arr[mid + 1] == mid + 1) {
					return arr[mid];
				} else {
					f = mid + 1;
				}

			}
		}

		return -1;

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