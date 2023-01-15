package pp.gu.math;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class LetterCombination {
	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
		System.out.println(letterCombinations("234"));

	}

	public static List<String> letterCombinations(String digits) {
		Map<Character, String> letters = new HashMap<Character, String>() {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");

			}
		};

		if (digits == "")
			return new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		lcr(digits, letters, 0, result,"");
		return result;

	}

	private static void lcr(String digits, Map<Character, String> letters, int i, List<String> result, String t) {
		if (i == digits.length() ) {
			result.add(t);
			return;
		}
		for (char c : letters.get(digits.charAt(i)).toCharArray()) {
			t += c;
			lcr(digits, letters, i + 1, result, t);
			t = t.substring(0, t.length() - 1);

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