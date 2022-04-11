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
public class MinStack {

	public static void main(String[] args) throws java.lang.Exception {
//https://leetcode.com/problems/remove-duplicate-letters/
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("bbcaac"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		System.out.println(removeDuplicateLetters("bcabc"));

	}

	public static String removeDuplicateLetters(String s) {
		String result = "";
		int[] freq = new int[26];
		boolean[] occur = new boolean[26];
		Stack<Integer> st = new Stack();

		char[] ch = s.toCharArray();

		for (char c : ch) {
			freq[c - 'a']++;
		}

		int ind = ch[0] - 'a';
		st.push(ind);
		occur[ind] = true;
		freq[ind]--;
		for (int i = 1; i < ch.length; i++) {
			ind = ch[i] - 'a';
			freq[ind]--; // if repeated char come freq should also be reduce
			if (occur[ind])
				continue;
			// stack:d string bad
			// lesser value come and it is not in stack and greater value is present in
			// future
			// so lexicographically smaller value comes first
			// remove greater element
			// ex 1. abd(a)bcd 2. abc(a)bdc
			// in first when pointer at c we remove d as d present in future c is smaller so
			// answer is abcd, for a and b we ignore it
			// 2 when d come we add it can't remove c as lesser value already present so
			// ignore future value
			// let if we remove it so ans would be abdc that is wrong //as freq value >1
			// means
			// future has at least a value

			while (st.isEmpty() == false && st.peek() > ind && freq[st.peek()] > 0) {
				occur[st.peek()] = false;
				st.pop();
			}
			st.push(ind);
			occur[ind] = true;
			// freq[ind]--;
		}

		char[] c = new char[st.size()];
		int j = st.size() - 1;
		while (st.empty() == false) {

			c[j--] = (char) (st.pop() + 'a');

		}

		return String.valueOf(c);
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