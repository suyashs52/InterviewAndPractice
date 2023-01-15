package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HammingDistance {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/total-hamming-distance/
		System.out.println(totalHammingDistance(new int[] { 4, 14, 2 }));
		System.out.println(totalHammingDistance(new int[] { 4, 14, 4 }));

	}

	public static int totalHammingDistance(int[] nums) {
		// for each i there are n-i-1 pair in 4 14 2 for i:0 , pair 4,14 4,2 i:1 14 2
		// so trick is for each bit if we calculate how many 1 bit n-count is 0 bit
		// so count1*count0 is total combination pair 3 1bit in different digit 2 0 bit
		// in diffrent digit total 6 combi
		// as we need to calculate pair so permutation not allowed
		// 1 1 0
		// 1 0 1
		// 0 1 1 at 3rd left bit: 1,0 1,0 2difference only

		long mask = (long) 1 << 31;
		int sum = 0;
		while (mask > 0) {
			int one = 0;

			for (int i : nums) {
				if ((i & mask) > 0) {
					one++;
				}
			}
			sum += one * (nums.length - one);

			mask >>= 1;
		}

		return sum;
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
