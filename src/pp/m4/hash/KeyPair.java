package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class KeyPair {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/key-pair5616/1
		System.out.println(hasArrayTwoCandidates(new int[] { 1, 4, 45, 6, 10, 8 }, 6, 16));

	}

	static boolean hasArrayTwoCandidates(int arr[], int n, int x) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// a+b=x a=x-b
		// if duplicate allow then we need to add freq too

		for (int i : arr) {
			if (map.containsKey(x - i)) {
				if (x - i == i && map.get(x - i) > 1)
					return true;

				else if (x - i != i) {
					return true;
				} else {
					map.put(i, map.get(i) + 1);
				}
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
