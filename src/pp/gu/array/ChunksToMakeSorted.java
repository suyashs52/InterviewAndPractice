package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ChunksToMakeSorted {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/max-chunks-to-make-sorted/

		FastScanner fs = new FastScanner();

		int[] arr = new int[] { 4, 3, 2, 1, 0 };
		System.out.println(maxChunksToSorted(arr));
		arr = new int[] {1,0,2,3,4};
		System.out.println(maxChunksToSorted(arr));
	}

	public static int maxChunksToSorted(int[] arr) {
		int chunks = 0;
		// element is from 0 to n-1 contiguous
		// if element is sorted the element is present at elementh index
		// if need sorted chunks from starting means max element of that chunks
		// should be at its index
		int max = -100;

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
			if (max == i) {
				chunks++;
			}
		}
		return chunks;
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
