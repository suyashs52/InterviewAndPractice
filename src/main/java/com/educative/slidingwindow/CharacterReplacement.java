package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterReplacement {
	public static int findLength(String str, int k) {

		int maxlen = 0;

		// aabccbb , acabd
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int count = 0;
		for (int end = 0; end < str.length(); end++) {
			map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
			if (str.charAt(start) != str.charAt(end)) {
				count++;
			}
			while (count > k) {
				map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
				if (map.get(str.charAt(start)) == 0) {
					map.remove(str.charAt(start));
					count = Math.min(map.size() - 1, count--);

				}
				start++;
			}
			maxlen = Math.max(maxlen, end - start + 1);

		}

		//maxchar --is lie in start end so we can replace remaining k value if not
		// slide window
		// 1 more technique is aaaabcde so end-start+1-maxCharLenCount if >k
		// k-2 cur at d , start=0 ,end at 7 maxChar=4 , 7-0-4(3) 3 is bcd so
		// we can most replace 2 char continue loop remove from start
		// aabbb
		map = new HashMap<>();
		start = 0;
		int maxchar = 0;
		maxlen=0;
		for (int end = 0; end < str.length(); end++) {
			char c = str.charAt(end);
			map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
			maxchar = Math.max(maxchar, map.get(c));

			if (end - start + 1 - maxchar > k) {  ///aaabcdefccccc 
				//k=2 at d max=3, start at 3rd a ,4-3 aaabcd,,it will shift one pointer next unitl c is max till d
				map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
				start++;
			}
			maxlen = Math.max(maxlen, end - start + 1);

		}

		return maxlen;

	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: " + CharacterReplacement.findLength("aaabcdefccccc", 3));

		System.out.println("Length of the longest substring: " + CharacterReplacement.findLength("aabccbb", 2));
		System.out.println("Length of the longest substring: " + CharacterReplacement.findLength("abbcb", 1));
		System.out.println("Length of the longest substring: " + CharacterReplacement.findLength("abccde", 1));

	}
	 
}
