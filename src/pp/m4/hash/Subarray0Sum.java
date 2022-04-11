package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Subarray0Sum {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
		System.out.println(findsum(new int[] { 4, 2, -3, 1, 6 }, 5));
		System.out.println(findsum(new int[] { 4, 2, 0, 1, 6 }, 5));

	}

	static boolean findsum(int arr[], int n) {
		// Your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// a+b=0 if a=0 and b=0 or a=-b
		// here we need to find subarray so need to use prefix sum

		int[] prefix = new int[n];
		prefix[0] = arr[0];

		for (int i = 1; i < n; i++) {
			prefix[i] = arr[i] + prefix[i - 1];
		}
		// subarray sum is 0 means prefix at i and j matching or prefix[i]=0 a[i]=a[j]
		// s2-s1=0

		for (int i : prefix) {
			if (i == 0)
				return true;

			if (map.containsKey(i)) {
				return true;
			} else {
				map.put(i, 1);
			}
		}

		return false;
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
