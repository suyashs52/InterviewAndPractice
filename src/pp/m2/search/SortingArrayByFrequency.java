package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class SortingArrayByFrequency {

	public static void main(String... strings) {
//		https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0

//		2
//		5
//		5 5 4 6 4
//		5
//		9 9 9 2 5
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();

		for (int i = 0; i < t; i++) {
			int size = fs.nextInt();
			Integer[] arr = new Integer[size];
			int[] freq = new int[61];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = fs.nextInt();
				freq[arr[j]]++;
			}

			Comparator<Integer> comp = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					if (freq[o1] > freq[o2]) {
						return -1;
					} else if (freq[o1] < freq[o2]) {
						return 1;
					} else {
						return o1.compareTo(o2);
					}

				}
			};

			Arrays.sort(arr, comp);
			for (int j : arr)
				System.out.print(j+" ");
			System.out.println();

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
