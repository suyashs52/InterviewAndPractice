package pp.m4.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class MaxStack {
	//https://www.hackerrank.com/challenges/maximum-element/problem
	Stack<Long> st;
	long min;

	public MaxStack() {
		st = new Stack<>();
		min = ((long) Integer.MAX_VALUE + 1);
	}

	public void push(int val) {
		// -4 is min, -5 come new min is -5 value pushed if -5+4=-1 oops got greater
		// value
		// -5*2+4= let -10 comes
		///
		// 5 new min is 4 4-5=-1 min then 4//-1+4=3 so adding min in (min-prev min) is
		// always less then min
		// cause curr min is less than prev min and less-greater is negative if adding
		// same ll always give
		// lesser value now -4 next min is -5=> -5--4=-1 so this is greater now add -5
		// now -5-1=-6 why cause adding
		// in negative number always give more negative number so problem solved :)
		// cmin+(cmin-prevmin)=2cmin-prevmin=ans
		if (val < min) {

			st.push(2 * (long) val - min);
			min = (long) val;

		} else
			st.push((long) val);

	}

	public void pop() {
		if (st.isEmpty() == false) {
			long lng = st.pop();

			if (lng < min) {
				min = 2 * min - lng; // as 2cmin-prevmin=ans
			}
		}
	}

	public int top() {

		if (st.peek() > min) {
			return st.peek().intValue();
		} else {
			return (int) min;
		}

	}

	public int getMin() {

		return (int) min;

	}

	public static void main(String[] args) throws java.lang.Exception {
//https://leetcode.com/problems/min-stack/
		String[] task = new String[] { "MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin" };
		MaxStack ms = null;

		task = new String[] { "MinStack", "push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop",
				"push", "top", "getMin", "push", "top", "getMin", "pop", "getMin" };
		int[] input = new int[] { 2147483646, 2147483646, 2147483647, 2147483647, -2147483648 };
		int i = 0;
		for (String s : task) {
			switch (s) {
			case "MinStack":
				ms = new MaxStack();
				break;
			case "push":
				ms.push(input[i++]);
				break;
			case "getMin":
				System.out.println(ms.getMin());
				break;
			case "pop":
				ms.pop();
				break;
			case "top":
				System.out.println(ms.top());
			}
		}
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
