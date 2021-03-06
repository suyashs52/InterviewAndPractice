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

	public static int ncr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	public static int fact(int n) {
		int res = 1;
		for (int i = 2; i < n + 1; i++) {
			res *= i;
		}
		return res;
	}
}
