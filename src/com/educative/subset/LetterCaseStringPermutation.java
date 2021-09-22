package com.educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCaseStringPermutation {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		permutations.add(str);

		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i))) {
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] st = permutations.get(j).toCharArray();
					st[i] = Character.toUpperCase(st[i]);
					
					permutations.add(String.valueOf(st));
				}
			}

		}

		return permutations;
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}

}
