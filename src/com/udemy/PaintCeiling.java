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
		long a = 4;
		System.out.println(selectPaint(n, s0, k, b, m, a));

		n = 60000000;
		s0 = 9;
		k = 60306849;
		b = 729789559;
		m = 10;
		a = 2500001627076924l;

		System.out.println(selectPaint(n, s0, k, b, m, a));
		System.out.println(selectPaint1(n, s0, k, b, m, a));

		n = 53144100;
		s0 = 30854518;
		k = 932125114;
		b = 616256181;
		m = 18;
		a = 5690240867915603l;

		System.out.println(selectPaint(n, s0, k, b, m, a));
		System.out.println(selectPaint1(n, s0, k, b, m, a));

	}

	private static long selectPaint(int n, int s0, int k, int b, int m, long a) {
		// TODO Auto-generated method stub

		Long[] s = new Long[n];
		long count = s0 * s0 > a ? 0 : 1;
		boolean isSorted = false;

		s[0] = (long) s0;
		for (int i = 1; i < n; i++) {
			s[i] = ((k * s[i - 1] + b) % m) + 1 + s[i - 1];
			if (s[i] * s[i] <= a)
				count++;

			if (s[i] < s[i - 1])
				isSorted = false;

		}
		if (!isSorted)
			Arrays.sort(s);
		System.out.println("teststt");
		System.out.println("count>" + count);

		print(s);

		int i = 0;
		int j = n - 1;
		long c = 0;
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

	static void print(Long[] arr) {
		for (int i = 0; i < 100; i++) {
			if (i > arr.length - 1)
				break;
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		for (int i = 1; i < 100; i++) {
			if (i > arr.length - 1)
				break;
			System.out.print((arr[i] - arr[i - 1]) + ",");
		}
	}

	private static long selectPaint1(int n, int s0, int k, int b, int m, long a) {
		// TODO Auto-generated method stub

		boolean isSorted = false;
		long count1 = 0;
		long s1 = Long.valueOf(s0);
		long s2 = ((k * s1 + b) % m) + 1 + s1;
		long s3 = ((k * s2 + b) % m) + 1 + s2;
		if (s1 * s1 <= a)
			count1++;
		if (s2 * s2 <= a)
			count1++;
		long seq = s3 - s2;
		for (int i = 2; i < n; i++) {
			s3 = s2 + seq;
			if (s3 * s3 <= a) {
				count1++;
				s2 = s3;
			} else
				break;
		}
		System.out.println("count1>" + count1);
		int i = 0;
		int j = n - 1;
		long c = 0;
		s3 = s0;

		while (i < j) {
			s1 = s3 + seq * j;
			if (s3 * s1 <= a) {
				c += (j - i);
				i++;
				s3 = s3 + seq;
			} else {
				j--;
			}
		}
		/*
		 * 6 2809828005141984 63755947405852
		 */
		return count1 + (c * 2);

	}

	public static void main(String[] args) throws IOException {

		code();

		// bufferedReader.close();
	}
}
