package com.educative.bs;

public class NextLetter {

	public static char searchNextLetter(char[] letters, char key) {
		if (letters[0] > key || letters[letters.length - 1] <= key) {
			return letters[0];

		}
		char result = letters[0];
		int start = 0;
		int end = letters.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < letters[mid]) {
				end = mid-1;
			}else {
				start =mid+1;
			}
		}

		return letters[start];

	}

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}

}
