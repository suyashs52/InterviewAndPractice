package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StringAnagrams {
	//do it with soulution
	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> list = new ArrayList<Integer>();

		int[] p = new int[26];

		for (int i = 0; i < pattern.length(); i++) {
			p[pattern.charAt(i) - 'a'] = 1;
		}

		int start = 0;
		// abbcabc abc
		int count = 0;
		int k = 2;
		for (int end = 0; end < str.length(); end++) {
			char c = str.charAt(end);
			p[c - 'a']++;
			count++;
			if (p[c - 'a'] > k) {

				while (start < end) {
					p[str.charAt(start) - 'a']--;
					start++;
					count--;
				}

				 
			}

			if (count == pattern.length()) {
				list.add(start);
				while (end >= start) {
					p[str.charAt(end) - 'a']--;
					end--;
					count--;
					 
				}

				start++;
				end=start-1;
				 
				
			}
		}
		return list;

	}

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("test", null);

		System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
		System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
		System.out.println(StringAnagrams.findStringAnagrams("pqpqpqqpqp", "pq"));
		System.out.println(StringAnagrams.findStringAnagrams("abbaabba", "ab"));

	}

}
