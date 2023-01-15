package pp.gu.math;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PowXN {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/powx-n/
		System.out.println(myPow(2.00000, 8));
		System.out.println(Math.pow(2, 8));
		System.out.println(myPow(2.00000, 10));
		System.out.println(myPow(2.10000, 3));
		System.out.println(myPow(2.00000, -2));

	}

	public static double myPow(double x, int n) {
		boolean isneg = n < 0;
		if (isneg)
			n = -n;
		double value = mPow(x, n);

		if (isneg)
			return 1 / value;
		return value;
	}

	public static double mPow(double x, int n) {
		if (n == 1)
			return x;
		else if (n == 0)
			return 1;

		if ((n & 1) == 1) {
			// odd
			double k = mPow(x, n / 2);
			return x * k * k;
		} else {

			double k = mPow(x, n / 2);
			return k * k;
		}

	}

}