package pp.m2.sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class TroubleSort {

	public static void main(String... strings) {
//		https://codingcompetitions.withgoogle.com/codejam/round/00000000000000cb/00000000000079cb

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		for (int i = 0; i < t; i++) {
			int n = fs.nextInt();
			int[] arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = fs.nextInt();
			}
//			2
//			5
//			5 6 8 4 3
//			3
//			8 9 7
			// trouble sort
			// order of n^2
//			boolean done = false;
//			while (!done) {
//				done = true;
//				for (int k = 0; k < n - 2; k++) {
//					if (arr[k] > arr[k + 2]) { // lesser index is larger
//						done = false;
//						int s = arr[k];
//						arr[k] = arr[k + 2];
//						arr[k + 2] = s;
//					}
//				}
//			}

			int[] even = new int[n / 2];
			int[] odd = new int[n - even.length];
			int index = 0;
			for (int k = 0; k < n; k += 2) {
				odd[index++] = arr[k];
			}
			index = 0;
			for (int k = 1; k < n; k += 2) {
				even[index++] = arr[k];
			}

			Arrays.sort(even);
			Arrays.sort(odd);
			int evenind = 0;
			int oddind = 0;
			index = -1;
			for (int k = 0; k < n - 1; k++) {
				if ((k & 1) == 0) { // index is even but 0 is 1 take odd value
					if (odd[oddind++] > even[evenind]) { // arr[0]>arr[1] for index 0
						index = k;
						break;
					}
				} else { // even check 1,3,5 arr[1] check with arr[2]
					if (even[evenind++] > odd[oddind]) {
						index = k;
						break;
					}
				}
			}

			if (index == -1) {
				System.out.println("Case #" + (i + 1) + ": OK");
			} else {
				System.out.println("Case #" + (i + 1) + ": " + index);
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
	}

}
