package com.udemy;

import java.io.IOException;
import java.util.Arrays;

class PaintCeiling {

	public static void code() {
		int n = 3;
		int s0 = 1;
		int k = 1;
		int b = 1;
		int m = 2;
		int a = 4;

		System.out.println(selectPaint(n, s0, k, b, m, a));

		n = 3;
		s0 = 2;
		k = 3;
		b = 3;
		m = 2;
		a = 15;

		System.out.println(selectPaint(n, s0, k, b, m, a));

	}

	private static int selectPaint(int n, int s0, int k, int b, int m, int a) {
		// TODO Auto-generated method stub

		int[] s = new int[n];
		int count = s0 * s0 > a ? 0 : 1;
		boolean isSorted = false;
		s[0] = s0;
		for (int i = 1; i < n; i++) {
			s[i] = ((k * s[i - 1] + b) % m) + 1 + s[i - 1];
			if (s[i] * s[i] <= a)
				count++;

			if (s[i] < s[i - 1])
				isSorted = false;

		}
		if (!isSorted)
			Arrays.sort(s);

		int i = 0;
		int j = n - 1;
		int c = 0;
		while (i < j) {
			if (s[i] * s[j] <= a) {
				c += (j - i);
				i++;
			} else {
				j--;
			}
		}

		return count + (c * 2);

	}

	public static void main(String[] args) throws IOException {

		code();

		// bufferedReader.close();
	}
}
