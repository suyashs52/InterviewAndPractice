package com.udemy;

public class LCS {
	// longest common subsequence
	public static void main(String... str) {
		String s1 = "abcdhqrs";
		String s2 = "aedqrs";

		int result = lcsrecur(s1.toCharArray(), s2.toCharArray(), 0, 0);
		int result1 = lcsrecurdp(s1.toCharArray(), s2.toCharArray());
		System.out.println(result);
		System.out.println(result1);

	}

	private static int lcsrecurdp(char[] ca, char[] ch) {

		// https://www.youtube.com/watch?v=NnD96abizww

		int temp[][] = new int[ca.length + 1][ch.length + 1];
		int max = 0;
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (ca[i - 1] == ch[j - 1]) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				} else {
					temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
				}
				if (temp[i][j] > max) {
					max = temp[i][j];
				}
			}
		}
		return max;
	}

	private static int lcsrecur(char[] ca, char[] ca2, int l1, int l2) {
		int len1 = ca.length;
		int len2 = ca2.length;
		if (l1 == len1 || l2 == len2) {
			return 0;
		}
		int c3 = 0;
		if (ca[l1] == ca2[l2]) {

			c3 = 1 + lcsrecur(ca, ca2, l1 + 1, l2 + 1);
			return c3;
		} else

			return Math.max(lcsrecur(ca, ca2, l1 + 1, l2), lcsrecur(ca, ca2, l1, l2 + 1));

	}
}
