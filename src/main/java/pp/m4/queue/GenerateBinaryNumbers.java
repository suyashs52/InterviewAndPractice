package pp.m4.queue;

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
public class GenerateBinaryNumbers {
	Stack<Integer> pushst;
	Stack<Integer> popst;
	int top;

	public static void main(String[] args) throws java.lang.Exception {
//https://leetcode.com/problems/implement-queue-using-stacks/

		// https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
		System.out.println(generate(2));
		System.out.println(generate(5));

	}

	static ArrayList<String> generate(int N) {
		ArrayList<String> num = new ArrayList<String>();
		// 1 10 11 100 101
		// from here we can see 1 chile is 10 11 append 0 and 1 next to 1

		String a = "1";

		Queue<String> sq = new LinkedList<String>();

		sq.add(a);
		int temp = 0;
		while (temp < N) {
			String s = sq.poll(); // removing 1 adding 2 so no underflow
			num.add(s);
			sq.add(s + "0");
			sq.add(s + "1");
			temp++;
		}

		return num;
		// Your code here
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