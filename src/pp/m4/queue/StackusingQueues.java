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
public class StackusingQueues {
	Queue<Integer> queue;
	int top;

	public static void main(String[] args) throws java.lang.Exception {
//https://leetcode.com/problems/implement-stack-using-queues/

		StackusingQueues sq = new StackusingQueues();
	}

	public StackusingQueues() {
		queue = new LinkedList<>();
		top = -1;
	}

	public void push(int x) {
			queue.add(x);
			top = x;
	}

	public int pop() {
		Queue<Integer> t = new LinkedList<Integer>();
		int x;
		while (queue.size() > 1) { // 2 3 4 5
			x = queue.poll();

			t.add(x);
			top=x;
		}

		x = queue.poll();
		queue = t;
		return x;

	}

	public int top() {
		return top;
	}

	public boolean empty() {
		return queue.size() == 0;
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