package com;

public class Common {
	public static int gcd(int a, int b) {
//		a 	b	a%b
//		30	42	30
//		42 30	12
//		30	12	6
//		12	6	0
//		6	0	return result
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
// a*b=gcd*lcm
		return (a * b) / gcd(a, b);
	}
}
