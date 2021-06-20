package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordConcatination {
	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> list = new ArrayList<Integer>();

		List<String> word = new ArrayList<String>();
		word = Arrays.asList(words);
		int wordlen = word.get(0).length();
		for (int i = 0; i <= str.length() - (word.size() * wordlen); i++) { // need to check all words
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int j = 0; j < word.size(); j++) {
				String s = str.substring(i + j * wordlen, i + j * wordlen + wordlen);

				if (!word.contains(s))
					break;
				map.put(s, map.getOrDefault(s, 0) + 1);
				// cat cat need to check
				// assuming all comes only 1
				if (map.get(s) > 1)
					break;
				if (j + 1 == word.size()) {
					list.add(i);
				}

			}

		}

		return list;

	}

	public static void main(String[] args) {

		System.out.println(WordConcatination.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" }));
		System.out.println(WordConcatination.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" }));
		System.out.println(WordConcatination.findWordConcatenation("catcatfoxfoxcat", new String[] { "cat", "fox" }));

	}

}
