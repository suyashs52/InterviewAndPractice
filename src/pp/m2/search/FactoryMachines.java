package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FactoryMachines {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/power-of-two/
		FastScanner fs = new FastScanner();
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(3));

	}

	public static boolean isPowerOfTwo(int n) {

		// 4 has 100 3 has 011 take & ll result in 0
		if (n == 0)
			return false;
		//n = Math.abs(n);
		long x=(long) n; // when -2^31 then -2^31-1 ll go overflow so
		return (x & x - 1) == 0;
		//-ve is not a power
		//x&(-x)==x is power of 2
		//8 0001000
		//-8 is 2's complement
		// 1110111+1=1111000 & 0001000=0001000
		//2's complement always set rightous bit to 1
		
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
