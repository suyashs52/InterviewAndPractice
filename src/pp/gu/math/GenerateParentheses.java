package pp.gu.math;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import pp.gu.math.CountValidParanthesis.FastScanner;

public class GenerateParentheses {
	public static void main(String[] args) throws java.lang.Exception {

		// https://www.hackerrank.com/contests/gl-bajaj-self-evaluation-evening-batch/challenges/bracket-challenge-1/problem
		FastScanner fs = new FastScanner();
//		int t = fs.nextInt();
//		int s = fs.nextInt();
//		System.out.println(generateParenthesis(t, s));
		System.out.println(generateParenthesis(1, 2));

	}

	public static List<String> generateParenthesis(int p, int b) {
		List<String> list = new ArrayList<>();
		String sb = new String();
		int t = p + b;
		char[] ch = new char[t * 2];
		generate(ch, p, b, 0, 0, 0, 0, 0);

		return list;
	}

	private static void generate(char[] sb, int p, int b, int po, int pc, int bo, int bc, int curr) {

		if (curr == (p + b) * 2) {
			for (char c : sb)
				System.out.print(c);
			System.out.println();
			return;
		}

		if (po < p) {
			sb[curr] = '(';
			generate(sb, p, b, po + 1, pc, bo, bc, curr + 1);
		}
		if (bo < b) {
			sb[curr] = '{';
			generate(sb, p, b, po, pc, bo + 1, bc, curr + 1);
		}
		if (pc < po) {
			sb[curr] = ')';
			generate(sb, p, b, po, pc + 1, bo, bc, curr + 1);
		}
		if (bc < bo) {
			sb[curr] = '}';
			generate(sb, p, b, po, pc, bo, bc + 1, curr + 1);
		}

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