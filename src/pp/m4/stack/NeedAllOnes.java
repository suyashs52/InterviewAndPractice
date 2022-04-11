package pp.m4.stack;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class NeedAllOnes {

	public static void main(String[] args) throws java.lang.Exception {
//https://www.hackerrank.com/contests/gl-bajaj-self-evaluation-contest/challenges/need-all-ones
		FastScanner fs = new FastScanner();
		int n = fs.nextInt(); //808
		int m = fs.nextInt(); //250

		int[][] input = new int[n][m];
		int[] histogram = new int[m]; //column

//		3 3
//		1 0 0
//		0 1 1
//		1 1 1
		// from base we need to calculate
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				input[i][j] = fs.nextInt();
			}
		}

		for (int i = 0; i < m; i++) { //250
			int j = n - 1; //808
			while (j > -1 && input[j][i] == 1) {
				histogram[i]++;
				j--;
			}
		 
		}
		System.out.println(largestRectangleArea(histogram));

	}

	public static int largestRectangleArea(int[] heights) {
		if (heights.length < 1)
			return 0;
		if (heights.length == 1)
			return heights[0];

		// finding area we need next lowest left and right value index
		Stack<Integer> str = new Stack<>();
		// 2 1 3 is at 0 1 2 so at 1 rectangle size is 3 how
		// 1-0=1 2-1=1 or 2-0=2
		// 2 3 4 so at 0: 2-0=2 no 3-0 ok: or 3-(-1)-1=3 that is right
		// 2 1 4 now area at 0: 1-0:1 / 1-(-1)-1=1 you can do any one

		int max = 0;
		int[] arNexMin = new int[heights.length];
		int[] arPrevMin = new int[heights.length];
		str.push(0);

		for (int i = 1; i < heights.length; i++) {
			if (heights[i] > heights[str.peek()]) {
				str.push(i);
			} else {
				while (str.isEmpty() == false && heights[i] < heights[str.peek()]) {
					arNexMin[str.pop()] = i; // need index only
				}
				str.push(i);
			}
		}

		while (str.empty() == false) {
			arNexMin[str.pop()] = heights.length;
		}

		str.push(heights.length - 1);
		for (int i = heights.length - 1; i > -1; i--) {
			if (heights[i] > heights[str.peek()]) {
				str.push(i);
			} else {
				while (str.isEmpty() == false && heights[i] < heights[str.peek()]) {
					arPrevMin[str.pop()] = i; // need index only
				}
				str.push(i);
			}
		}

		while (str.empty() == false) {
			arPrevMin[str.pop()] = -1;
		}

		for (int i = 0; i < heights.length; i++) {
			max = Math.max(max, (arNexMin[i] - arPrevMin[i] - 1) * heights[i]);

		}

		return max;

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine().trim());
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