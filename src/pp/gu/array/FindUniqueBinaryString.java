package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class FindUniqueBinaryString {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/find-unique-binary-string/

		FastScanner fs = new FastScanner();

		System.out.println(findDifferentBinaryString(new String[] {"01","10"}));

	}

	public static String findDifferentBinaryString(String[] nums) {
		char[] ch = new char[nums[0].length()];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			  if(nums[i].charAt(count)=='1') {
				  ch[i]='0';
			  }else {
				  ch[i]='1';
			  }
			  count++;
		}
		
		return String.valueOf(ch);

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
