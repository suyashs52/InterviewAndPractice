package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SingleNumber3 {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/single-number-iii/
		System.out.println(2 % 1);
		System.out.println(singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
		System.out.println(singleNumber(new int[] { -1, 0 }));
		System.out.println(singleNumber(new int[] { 0, 1 }));

		//// rightmost 1-bit diff between x and y
		// int diff = bitmask & (-bitmask);
		// 100100

		// 2's complete 011011+1=011100 & 100100=000100

	}

	public static int[] singleNumber(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}
		// xor of unique no is : any how 1 if 1 it means: any one is 0
		long mask = 1;
		while ((sum & mask) == 0) {
			mask = mask << 1;

		}

		// all element except comes 2 times so 1 bit of other ll come 2 time
		int first = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((mask & nums[i]) == mask) {
				first = first ^ nums[i];
			}
		}

		int sec = sum ^ first;

		return new int[] { Math.min(first, sec), Math.max(first, sec) };

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
