package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class KthSmallestMatrix {
	public static void main(String[] args) throws java.lang.Exception {
//		Given an n*n
//		 matrix where each of the rows and columns are sorted in ascending order, print the  kth
//		 smallest element in the matrix.Note that it is the kth
//		 
//		 smallest element in the sorted order, not the kth 		 distinct element.
//
//		Try to solve this question using Binary Search

//		3
//		1 5 9
//		10 11 13
//		12 13 15
//		8
//		
//		13

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[][] arr = new int[t][t];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = fs.nextInt();
			}
		}

		int needed = fs.nextInt();
		System.out.println(bsfr(arr, needed));

	}

	static int bsfr(int[][] arr, int index) {

		// find min
		int min = arr[0][0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] < min) {
				min = arr[0][i];
			}
		}
		// find max
		int max = arr[0][arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][arr.length - 1] > max) {
				max = arr[i][arr.length - 1];
			}
		}

		int f = min;
		int l = max;

		while (f <= l) { // run till last index is lesser than first
			int mid = f + (l - f) / 2;

			int count = findCountLessThen(mid, arr);
			if (count < index ) { // if less means we can found from mid+1 to last
				f = mid + 1;
			} else {
				if (count == index ) { 
					int cc = findCountLessThen(mid - 1, arr); // in above output let mid be (7),8,9,(10),11,12,(15)
					if (cc <index) {  
						return mid;
					} else {
						l=mid-1;
					}
				} else {
					l = mid - 1;
				}

			}

		}

		return -1;

	}

	static int findCountLessThen(int n, int[][] arr) {
		int f = 0;

		for (int i = 0; i < arr.length; i++) {
			int c1 = 0;
			int st = 0;
			int lt = arr.length - 1;

			while (st <= lt) {
				int mid = st + (lt - st) / 2;
				if (arr[i][mid] < n) {
					st = mid + 1;
				} else {
					if (arr[i][mid] == n) {
						c1 = mid + 1;// index is 1 less but we need count
						st = mid + 1;// less than equal to as duplicate allow
						break;
					} else {
						lt = mid - 1;

					}
				}
			}

			f += st;
		}
		return f;
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