package pp.gu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationSequence {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/permutation-sequence/

//		FastScanner fs = new FastScanner();
//		int t = fs.nextInt();
//		int[] arr = new int[t];
//		for (int i = 0; i < t; i++) {
//			arr[i] = fs.nextInt();
//		}

		System.out.println(getPermutation(3, 3));
		strs = "";
		System.out.println(getPermutation(2, 2));
		strs = "";
		System.out.println(getPermutation(4, 9));

	}

	public static String getPermutation(int n, int k) {
		int[] arr = new int[n];

		for (int i = 1; i < n + 1; i++) {
			arr[i - 1] = i;
		}
		permute(arr, 0, n, k);
		return strs;

	}

	static String strs = "";

	static void print(int[] arr) {
		for (int i : arr)
			System.out.print(i);
		System.out.println();
	}

	private static int permute(int[] arr, int j, int n, int k) { // j is index
		if (strs.length() > 0)
			return k;
		if (k == 1) {
			strs = str(arr);
			return k;
		}

		if (j == n) {
			k--;
			//print(arr);
			return k;

		}

		for (int i = j; i < arr.length; i++) {
			swap(arr, j, i); // making level abc--> a__,b__,c__ for j=0;in abc
			k = permute(arr, j + 1, n, k); // in abc if a select next from b
			swapr(arr, j, i);
		}

		return k;

	}

	private static void swap(int[] arr, int j, int i) {
		if (j == i)
			return;
		// abcde a_c_e =>not adcbe but adbce
		if (j > i) {
			j = i + j;
			i = j - i;
			j = j - i;
		}
		int temp = arr[j]; // temp=a
		arr[j] = arr[i]; // c__

		for (int k = i; k > j; k--) { // shift each elemnet right by 1
			arr[k] = arr[k - 1];
		}
		if (j < arr.length - 1)
			arr[j + 1] = temp; // ca_

	}

	private static void swapr(int[] arr, int j, int i) {
		if (j == i)
			return;
		// abcde a_c_e =>not adcbe but adbce
		if (j > i) {
			j = i + j;
			i = j - i;
			j = j - i;
		}
		int temp = arr[j]; // temp=a

		for (int k = j; k < i; k++) { // shift each elemnet right by 1
			arr[k] = arr[k + 1];
		}
		if (i < arr.length)
			arr[i] = temp; // ca_

	}

	private static String str(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i);
		}
		return sb.toString();
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