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
public class QueueUsingStack {
	Stack<Integer> pushst;
	Stack<Integer> popst;
	int top;

	public static void main(String[] args) throws java.lang.Exception {
//https://leetcode.com/problems/implement-queue-using-stacks/

		QueueUsingStack sq = new QueueUsingStack();
	}

	public QueueUsingStack() {
		pushst = new Stack<>();
		popst = new Stack<>();
		top = -1;
	}

	public void push(int x) { // should add at last
		if (pushst.isEmpty() && popst.isEmpty()) {
			top = x;
			pushst.add(x);
		} // push:1 2 3
		else {
			pushst.push(x);
		}

	}

	public int pop() {

		if (popst.size() > 0) {
		
			return popst.pop();

		} else

		{
			while (pushst.isEmpty() == false) {
				popst.push(pushst.pop());
			}
			return pop();
		}
	}

	public int peek() {
		if (popst.size() > 0)
			return popst.peek();
		else {
			while (pushst.isEmpty() == false) {
				popst.push(pushst.pop());
			}
			return peek();
		}
		 
	}

	public boolean empty() {
		return pushst.size() == 0 && popst.size() == 0;
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