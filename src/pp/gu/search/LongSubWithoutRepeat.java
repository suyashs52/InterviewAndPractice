package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class LongSubWithoutRepeat {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/longest-substring-without-repeating-characters/
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("abada"));

	}

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() < 2)
			return s.length();

		int[] ch = new int[256];

		int min = 0;
		int f = 0;
		int l = 0;
		for (char c : s.toCharArray()) {
			ch[c]++;
			if (ch[c] > 1) {

				char c1 = s.charAt(f);
				while (c1 != c) {
					ch[c1]--;
					f++;
					c1 = s.charAt(f);
				}
				ch[c1]--;
				f++;

			}

			min = Math.max(min, l - f + 1);
			l++;
		}

		return min;
	}
}