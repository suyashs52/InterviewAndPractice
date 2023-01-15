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
public class NextGreaterElement {

	public static void main(String[] args) throws java.lang.Exception {
//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
		System.out.println(nextLargerElement(new long[] { 1, 3, 2, 4 }, 4));
		System.out.println(nextLargerElement(new long[] { 1, }, 1));

	}

	public static long[] nextLargerElement(long[] arr, int n) {
		// Your code here
		long[] res = new long[n];
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[st.peek()]) {
				st.push(i);
			} else {
				while (st.isEmpty() == false && arr[i] > arr[st.peek()]) {
					Integer in = st.pop();
					res[in] = arr[i];
				}

				st.push(i);
			}
		}

		while (st.isEmpty() == false) {
			Integer in = st.pop();
			res[in] = -1;
		}

		return res;
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