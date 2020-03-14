package com.gfg;

public class Permute {

	public static void code() {
		System.out.println("test");
		permute("abc", 0, 2);

	}

	private static void permute(String str, int l, int r) {
		if (l == r) //if l==r all swaping done for a str,need backtrack
			System.out.println(str);
		else
			for (int i = l; i <= r; i++) {
				// swap than permutate,
				// abc> swap aa permutate, swap ab permutate, swap ac permute

				str = swap(str, l, i);
				permute(str, l + 1, r);// permutate from next with last iteration
				// a bc swap and permuteed, b ac permuted
				// back track again to go to next
				// why back track cause abc go how to to bac
				//
				//str = swap(str, l, i);
				//we do backtrack so how we go back
				// go from bac to abc to track to cab
				//here i commentd because actual value is not chaning in java
				
			}
	}

	private static String swap(String s, int i, int j) {
		char[] tempArray = s.toCharArray();
		char temp = tempArray[i];
		tempArray[i] = tempArray[j];
		tempArray[j] = temp;
		return String.valueOf(tempArray);

	}
}
