package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABCDEF {

	public static void main(String... strings) {
//		https://www.spoj.com/problems/ABCDEF/

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = fs.nextInt();
		}

		// a*b+c=d*(f+e)

		// all inclusive /for 12 we have 111,112,122,121,211,221,222,212=8
		// for 123 and space is 3 we have 3^3 27 _ _ _ each space can be filled with 3
		// value 3*3*3
		int num = (int) Math.pow(t, 3);
		int[] f = new int[num];
		int[] s = new int[num];

		for (int i = 0; i < num; i++) {
			f[i] = Integer.MIN_VALUE;
			s[i] = Integer.MIN_VALUE;
		}
		int fi = 0;
		int si = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					f[fi++] = (arr[i] * arr[j] + arr[k]);
					if (arr[i] != 0) {
						s[si++] = arr[i] * (arr[j] + arr[k]);
					}

				}
			}
		}

		Arrays.sort(f);
		Arrays.sort(s);
		int startf = 0;
		for (int i = 0; i < f.length; i++) {
			if (f[i] == Integer.MIN_VALUE) {
				startf++;
			}
		}
		int count = 0;
		for (int i = 0; i < num; i++) {

			if (s[i] != Integer.MIN_VALUE) {
				int found = s[i];
				int start = startf;
				int end = num - 1;

				while (start <= end) {
					int mid = start + (end - start) / 2;

					if (found == f[mid]) {
						int midv = mid;
						while (mid < num && f[mid] == found) {
							mid++;
							count++;
						}
						mid = midv - 1;
						while (mid > -1 && f[mid] == found) {
							mid--;
							count++;
						}
						break;
					} else if (found < f[mid]) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}

			}

		}

		System.out.println(count);

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
