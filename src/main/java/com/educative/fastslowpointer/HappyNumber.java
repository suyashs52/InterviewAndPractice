package com.educative.fastslowpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HappyNumber {

	public static boolean find(int num) {
		boolean flag = false;

		if (num == 1)
			return true;
		int f = num;
		int s = num;
		do {
			f = findnum(f);
			s = findnum(findnum(s));

			if (f == s && f == 1) {
				return true;
			}

		} while (f != s);

		return false;
	}

	static int findnum(int num) {
		int ans = 0;
		while (num > 0) {
			int l = num % 10;
			ans += l * l;
			num = num / 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(HappyNumber.find(23));
		System.out.println(HappyNumber.find(12));
	}

}
