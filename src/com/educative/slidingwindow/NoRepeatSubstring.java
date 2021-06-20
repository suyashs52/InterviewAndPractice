package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatSubstring {
	public static int findLength(String str) {

		if (str.length() <= 1)
			return str.length();
		// longest char without repetion so if in map -already exist so start fresh from
		// next index

		int start = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = 0;
		for (int end = 0; end < str.length(); end++) {
			if (map.containsKey(str.charAt(end))) {
				// acbcd at cth index
				len = Math.max(len, end - start);
				start = end;
			} else {
				map.put(str.charAt(end), end);
			}
		}
		if (str.length() == map.size())
			len = str.length();

		// one logic is to add last index of each char
		// if we got first repeatable char, move start point to next of last found same
		// char index
		// above code will fail on that case-- acbcde ouput should be :4 , but we ll get
		// 3
		map = new HashMap<Character, Integer>();
		len = 0;
		start = 0;
		for (int end = 0; end < str.length(); end++) {
			if (map.containsKey(str.charAt(end))) {
				// acbcd at cth index

				start = Math.max(start, map.get(str.charAt(end)) + 1);
			}
			map.put(str.charAt(end), end);
			len = Math.max(len, end - start + 1);

		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abcde"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("acbcde"));

		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aaaaaaa"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abcde"));

	}

}
