package com.dp;

public class EditDistance {

	public static void main(String... arg) {
		String str1 = "azced";
		String str2 = "abcdef";
		System.out.println(editDis(str1, str2, str1.length(), str2.length()));
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

		return 1 + min(editDis(st1, st2, fi, li - 1), editDis(st1, st2, fi - 1, li), editDis(st1, st2, fi - 1, li - 1));

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
