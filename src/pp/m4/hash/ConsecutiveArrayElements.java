package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ConsecutiveArrayElements {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/consecutive-array-elements2711/1

		System.out.println(areConsecutives(new long[] { 5, 4, 2, 1, 3 }, 5));
		System.out.println(areConsecutives(new long[] { 59, 60, 59 }, 3));
		System.out.println(areConsecutives(new long[] { 5, 4, 2, 2, 2 }, 5));
		System.out.println(areConsecutives(new long[] { 2, 1, 0, -3, -1, -2 }, 6));

		// xor can also solve this
		// xor with n to n+N  number with arr[i]
//		int min=getmin(arr,N);
//	    int num=0;
//	    for(int i=0;i<N;i++){
//	         num^=min^arr[i];
//	         min+=1;
//	          }
//	      return num==0? true:false;

	}

	static boolean areConsecutives(long arr[], int N) {
		boolean is = false;

		Set<Long> set = new HashSet<>();
		int count = 0;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;

		// set contain unique element so duplicate if present
		// no issue set ll have unique element
		for (long i : arr) {
			min = Math.min(min, i);
			max = Math.max(max, i);
			count++; // as duplicate not allowed
			set.add(Long.valueOf(i));
		}

		return max - min + 1 == set.size() && count == set.size();

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
