package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

	private List<String> combination = new ArrayList<>();
	private Map<Character, String> map;
	private String phoneDigits;

	public static void main(String... comb) {

		LetterCombination lc = new LetterCombination();
		lc.map = new HashMap<>();
		lc.map.put('2', "abc");
		lc.map.put('3', "def");
		lc.map.put('4', "ghi");

		System.out.println(lc.letterCombination("234"));
	}

	List<String> letterCombination(String digits) {
		if (digits.length() == 0) {
			return combination;
		}
		phoneDigits = digits;
		backtrack(0, new StringBuilder());
		return combination;
	}

	private void backtrack(int index, StringBuilder path) {
		if (path.length() == phoneDigits.length()) {
			combination.add(path.toString());
			return;
		}

		String s = map.get(phoneDigits.charAt(index));

		for (char c : s.toCharArray()) {
			path.append(c); // add char
			backtrack(index + 1, path); // add next element
			path.deleteCharAt(path.length() - 1); //return back to old
		}

	}

}
