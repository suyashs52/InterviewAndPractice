package pp.m4.queue;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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
public class SlidingWindowMaximum {
	Stack<Integer> pushst;
	Stack<Integer> popst;
	int top;

	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/sliding-window-maximum/
		System.out.println(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
		System.out.println(maxSlidingWindow(new int[] {1}, 1));

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {

		int[] res = new int[nums.length - k + 1];// total window

		Deque<Integer> deque = new LinkedList<>();
		deque.add(0);
		int i = 1;
		while (i < k) {
			// if any value in a window greater then inserted value we should remove queue
			// value
			// as in that window greater value has the answer
			// if lesser value comes later we should keep it until greater value comes
			if (deque.isEmpty()) {
				deque.add(i);
			} else {
				while (deque.isEmpty() == false && nums[deque.peekLast()] < nums[i]) {
					deque.pollLast();
				}
				deque.add(i);
			}
			i++;
		}

		int st = k;
		while (st < nums.length) {
			res[st - k] = nums[deque.peekFirst()]; // always has a value

			if (deque.peek() <= st - k) { // if deque index doesn't fall in a windows set index
				deque.pollFirst();
			}

			if (deque.isEmpty()) {
				deque.add(st);
			} else {
				while (deque.isEmpty() == false && nums[deque.peekLast()] < nums[st]) {
					deque.pollLast();
				}
				deque.add(st);
			}

			st++;
		}

		// last index value ll remain as st==nums.length
		res[st - k] = nums[deque.pollFirst()];

		return res;

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