package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class MinimumWindowSubstring {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/minimum-window-substring/
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("ADOBE", "ABC"));
		System.out.println(minWindow("ADOBEC", "ABC"));
		System.out.println(minWindow("ADOBEC", "C"));
		System.out.println(minWindow("a", "b"));
		System.out.println(minWindow("ab", "b"));
		
		System.out.println(minWindow("a", "aa"));
	}

	public static String minWindow(String s, String t) {

		if (t.length() > s.length())
			return "";

		int[] source = new int[256];
		int[] target = new int[256];

		int tcount = 0;
		for (char c : t.toCharArray()) {
			if (target[c] == 0)
				tcount++;
			target[c]++;
		}

//		for (char c : s.toCharArray()) {
//			if (target[c] == 0)
//				scount++;
//			source[c]++;
//		}

		int f = 0;
		int l = 0;
		int count = 0;
		int min = s.length();
		int rf = 0;

		while (l < s.length()) {
			char c = s.charAt(l);
			char fc = s.charAt(f);
			source[c]++;
			if (source[c] == target[c]) {
				count++;
			}

			if (count == tcount &&source[fc] > target[fc]) {
				 

				while (source[fc] > target[fc]) {

					source[fc]--;
					f++;
					fc = s.charAt(f);

				}

			}
			int len = l - f + 1;
			if (count == tcount && len < min) {
				min = len;
				rf = f;

			}
			l++;
		}
		if (count < tcount)
			return "";

		return s.substring(rf, rf + min);
	}
}