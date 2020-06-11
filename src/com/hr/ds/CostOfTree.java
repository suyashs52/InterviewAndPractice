package com.hr.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostOfTree {
	public static int calculateCost(List<Integer> arr) {
		// Write your code here
		m1 = 0;
		m2 = 0;
		int a = cc(arr, 0);
		System.out.println(a);

		return a;// cc(arr,0);

	}

	static int m1 = 0;
	static int m2 = 0;
//https://leetcode.com/discuss/interview-question/333903/mathworks-oa-minimize-the-cost-of-building-a-tree
	public static Integer cc(List<Integer> arr, int ci) {
		
		int length = arr.size();

		int[][] maxs = new int[length][length];
		int[][] dp = new int[length][length];

		// maxs[i][j] represent the maximum number in arr[i:j]
		for (int i = 0; i < length; i++) {
			maxs[i][i] = arr.get(i);
			for (int j = i + 1; j < length; j++) {
				maxs[i][j] = Math.max(maxs[i][j - 1], arr.get(j));
			}
		}

		// dp[i][j] represent the minimum cost in arr[i:j]
		for (int len = 1; len < length; len++) {
			for (int i = 0; i + len < length; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxs[i][k] * maxs[k + 1][j]);
				}
			}
		}
		return dp[0][length - 1];
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 4, 6, 2 };
		List<Integer> arr = Arrays.asList(a);

		calculateCost(arr);

		a = new Integer[] { 5, 3, 1 };
		arr = Arrays.asList(a);

		calculateCost(arr);

		a = new Integer[] { 1, 5, 3 };
		arr = Arrays.asList(a);

		calculateCost(arr);

		a = new Integer[] { 344, 132, 640, 333, 301, 990, 788, 616, 972, 595, 682, 18, 249, 599, 140, 239, 770, 825,
				758, 107, 538, 436, 254, 750, 813, 327, 693, 200, 817, 72, 108, 160, 203, 99, 493, 504, 88, 280, 119,
				60, 226, 800, 77, 826, 751, 568, 64, 872, 392, 173 };
		arr = Arrays.asList(a);

		calculateCost(arr);
	}

	static class Node {
		int mul;
		int max;

		Node(int mul, int max) {
			this.mul = mul;
			this.max = max;
		}
	}
}
