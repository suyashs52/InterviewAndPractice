package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class CustomSortString {

	public static void main(String... strings) {
//		https://leetcode.com/problems/custom-sort-string/

		FastScanner fs = new FastScanner();
		// int t = fs.nextInt();

		System.out.println(customSortString1("cba", "abcd"));

	}

	public static String customSortString(String order, String s) {
		int[] sorting = new int[26];
		int count = 1;
		for (char c : order.toCharArray()) {
			sorting[c - 'a'] = count++;
		}
		// 0 means default ordering

		Character[] ch = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
		Comparator<Character> compare = new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {

				if (sorting[o1 - 'a'] > sorting[o2 - 'a']) {
					return 1;
				} else if (sorting[o1 - 'a'] < sorting[o2 - 'a']) {
					return -1;
				}
				return 0;
			}

		};

		Arrays.sort(ch, compare);

		StringBuilder sb = new StringBuilder();
		for (char c : ch) {
			sb.append(c);
		}
		return sb.toString();

	}

	public static String customSortString1(String order, String s) {
		int[] sorting = new int[26];
		int count = 1;
		for (char c : s.toCharArray()) {
			sorting[c - 'a']++;// = count++;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			for (int j = 0; j < sorting[c - 'a']; j++) {
				sb.append(c);
			}
			sorting[c - 'a'] = 0;
		}

		// appending remaning char
		for (int i = 0; i < 26; i++) {
			if (sorting[i] > 0) {
				for (int j = 0; j < sorting[i]; j++) {
					sb.append((char) ('a' + i));
				}
				sorting[i] = 0;
			}
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
