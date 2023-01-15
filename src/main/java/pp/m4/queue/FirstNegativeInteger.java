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
public class FirstNegativeInteger {
	Stack<Integer> pushst;
	Stack<Integer> popst;
	int top;

	public static void main(String[] args) throws java.lang.Exception {
		// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
		System.out.println(printFirstNegativeInteger(new long[] { -8, 2, 3, -6, 10 }, 5, 2));

	}

	public static long[] printFirstNegativeInteger(long A[], int N, int K) {
		long[] result = new long[N - K + 1]; // always has n-k+1 set
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (A[i] < 0)
				que.add(i);
		}

		int total = N - K + 1;
		int st = K;

		while (st < N) {

			if (que.isEmpty())
				result[st - K] = 0;
			else {
				result[st - K] = A[que.peek()];
			}

			if (que.size() > 0 && que.peek() <= st - K) // 2 -1 3, k=2, i=2 que:1(index) so we wont remove as 2-2=0
			// so -1 can be part of 01,12,23 not so at st-k=2 we ll remove it
			{
				que.poll();
			}

			if (A[st] < 0) {
				que.add(st);
			}
			st++;
		}
		// -8, 2, 3, -6, 10 , -6 10 value can be calculated next as in while loop st=N
		// if you add st<=N then at line 55 ll give overflow error

		if (que.isEmpty()) {
			result[st - K] = 0;
		} else {
			result[st - K] = A[que.poll()];
		}

		return result;
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