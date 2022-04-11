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
public class Parentheses {

	public static void main(String[] args) throws java.lang.Exception {

		String s = "()";
		System.out.println(isValid(s));
		s = "()[]{}";
		System.out.println(isValid(s));
		s = "(]";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {
		boolean flag = false;

		char[] ch = s.toCharArray();

		Stack<Character> st = new Stack<Character>();

		for (Character c : ch) {

			if (c == '}' || c == ']' || c == ')') {
				if (st.empty())
					return false;
				char c1 = st.pop();
				if (c == '}' && c1 != '{') {
					return false;
				} else if (c == ']' && c1 != '[') {
					return false;
				} else if (c == ')' && c1 != '(') {
					return false;
				}
			} else {
				st.add(c);
			}
		}

		return st.empty() == true;
 

	}
	//where is edge conditino
	// when n is odd /even when n is 0
	
	

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