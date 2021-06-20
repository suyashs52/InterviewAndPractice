package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		int len = 0;
		// araac
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;

		for (int end = 0; end < str.length(); end++) {
			Character c = str.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			while (map.size() > k) {
				Character c1 = str.charAt(start);
				Integer i1 = map.get(c1);
				i1--;
				if (i1 == 0) {
					map.remove(c1);
				}
				len = Math.max(len, end - start);
				start++;

			}

		}

		return len;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
		System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
	}

}
