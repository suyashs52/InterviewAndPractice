package com.dp;

import com.Common;

public class AddTwoFraction {
//	Input:  1/2 + 3/2
//	Output: 2/1
//	Input:  1/3 + 3/9
//	Output: 2/3
	static public void code() {
		int[] a = { 1, 2 };
		int[] b = { 3, 2 };
		int[] c = addFraction(a, b);
		System.out.println(c[0] + "/" + c[1]);
		c = addFraction(new int[] { 1, 3 }, new int[] { 3, 9 });
		System.out.println(c[0] + "/" + c[1]);
	}

	static int[] addFraction(int[] a, int[] b) {
		int[] c = { 0, 0 };
		int lcm = Common.lcm(a[1], b[1]);
		c[0] = lcm / a[1] * a[0] + lcm / b[1] * b[0];
		c[1] = lcm;
		int gcd = Common.gcd(c[0], c[1]);
		c[0] /= gcd;
		c[1] /= gcd;
		return c;
	}
}
