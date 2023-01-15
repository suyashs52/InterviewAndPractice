package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Numbersof1Bits {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/number-of-1-bits/
		System.out.println(hammingWeight(8));

	}

	public static int hammingWeight(int n) {
		int one = 0;

		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((mask & n) == mask) { // 10101010 & 0000010 = 0000010 means if 1 bit set always give mask value
			//>0 more efficient 
			//also n&(n-1) always make rightmost bit to 0
			//10101 
			//10110
			// 000 001 010 011 100 101 110 111 you see always last bit of n, n-1 is opposite
			//so last bit is always 0
				one++;
			}

			mask = mask << 1;
		}

		return one;
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
