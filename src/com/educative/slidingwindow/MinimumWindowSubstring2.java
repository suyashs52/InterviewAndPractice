package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MinimumWindowSubstring2 {
	public static String findSubString(String str, String pattern) {
		String result = "";

		// aabdec , abc

		int len = 100;
		int start = 0;
		int ind = 0;
		for (int end = 0; end < str.length(); end++) {
			if (str.charAt(end) == pattern.charAt(0)) {
				start = end;
				ind = 1;
			} else if (str.charAt(end) == pattern.charAt(ind)) {
				ind++;
			}

			if (ind == pattern.length()) {
				if (len > (end - start + 1)) {
					len = end - start + 1;
					result = str.substring(start, end + 1);
				}

				start = end + 1;
				ind = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(MinimumWindowSubstring2.findSubString("aabdec", "abc"));
		System.out.println(MinimumWindowSubstring2.findSubString("abdabca", "abc"));
		System.out.println(MinimumWindowSubstring2.findSubString("adcad", "abc"));
		System.out.println(MinimumWindowSubstring2.findSubString("abdcabc", "abc"));
		System.out.println(MinimumWindowSubstring2.findSubString("abdcabc", "abc"));
		System.out.println(MinimumWindowSubstring2.findSubString("babecdc", "abc"));

		System.out.println(MinimumWindowSubstring2.findSubString("aaaacb", "a"));

	}

}
