package com.dp;

public class EditDistance {

	public static void main(String... arg) {
		String str1 = "azced";
		String str2 = "abcdef";
		System.out.println(editDis(str1, str2, str1.length(), str2.length()));
		System.out.println(editdp(str1, str2, str1.length(), str2.length()));
	}

	static int editDis(String st1, String st2, int fi, int li) {

		if (fi == 0)
			return li;
		if (li == 0)
			return fi;
		// if both char string same

		if (st1.charAt(fi - 1) == st2.charAt(li - 1)) {
			return editDis(st1, st2, fi - 1, li - 1);
		}
		// insert a char in first means first increse by 1 i+1, second be same or
		// put first same, delete in second
		// 2nd is deleted a char, 1 less in first, 2nd same
		// replace means both would be 1 less char,
		// all coming from last
		// why from last because past is good than future
		return 1 + min(editDis(st1, st2, fi, li - 1), editDis(st1, st2, fi - 1, li), editDis(st1, st2, fi - 1, li - 1));

	}

	private static int editdp(String st1, String st2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <=n; j++) {
				if (i == 0)
					dp[i][j] = j; // first row;
				// if first string is empty it need char of string till length
				else if (j == 0) {
					// if 2nd string is 0 , need first char count
					// column
					dp[i][j] = i;
				} else if (st1.charAt(i - 1) == st2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					// insert , delete, replace
					dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	private static int min(int x, int y, int z) {
		// TODO Auto-generated method stub
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		return z;

	}
}
