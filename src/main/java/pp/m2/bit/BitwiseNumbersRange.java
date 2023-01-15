package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BitwiseNumbersRange {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/bitwise-and-of-numbers-range/
		System.out.println(rangeBitwiseAnd(5, 7));
		System.out.println(rangeBitwiseAnd(0, 0));
		System.out.println(rangeBitwiseAnd(1, 9));
		System.out.println(rangeBitwiseAnd(1, 2147483647));

		// in above solution we check from left matched common bit
		// how can we make 101101010 highest
		// 101000100 lower
		// remove 1010 c,0100 from right bits
		// so shift each unitil high==row calculate count
		// now shift any number by count left have the answer

		// 2nd solutoin is larger number is has more 1 bit
		// will reduce the higher value
		// as first mismatch from left-right is higher has not matching 1 , lower has 0
		// (0,1 not in this case lower ll have greater value)
		// so remove that 1 from right side, remoing 1 ll make higer value lesser 
		//if both ll be equal we have answer all common big is matching
		// if lesser then lower element i think that lesser value is answer 
		// as it contain matching right bits only 

	}

	public static int rangeBitwiseAnd(int left, int right) {

		int common = 0;
		if (right == 0)
			return 0;
		// taking out right most bit
		long count = (long) 1 << 31;
		int n = right;
		while ((count & right) == 0) {

			count = count >> 1; // right most digit each time reduce give leftmost 1
			// 111 110: 11 10: 1 : 1 0:0

		}

		long higest = (long) count;
		while (higest > 0) {
			long r = (higest & right);
			if (r == (higest & left)) { // both highest digit is matching
				if (r > 0)
					common += higest;
				higest >>= 1;
			} else
				break;

		}

		return common;

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
