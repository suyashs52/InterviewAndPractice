package com.educative.knapsack01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class SubsetSum {

	static int countSubset(int[] num, int sum) {
		int t = -1;
		t = countSetRec(num, sum, 0);
		int[][] n = new int[num.length][sum + 1];
		t = countSettd(n, num, sum, 0);

		// bottom up
		int n1 = num.length;
		n = new int[num.length][sum + 1];
		for (int i = 0; i < num.length; i++) {
			n[i][0] = 1;// 0 sum always possible
		}
		n[0][num[0]] = 1;

		for (int i = 1; i < num.length; i++) {
			for (int j = 1; j < sum + 1; j++) {
				n[i][j] = n[i - 1][j];

				if (j >= num[i]) {
					n[i][j] += n[i - 1][j - num[i]];
				}

			}
		}

		t = n[num.length - 1][sum];
		return t;
	}

	private static int countSettd(int[][] n, int[] num, int sum, int index) {

		if (sum == 0)
			return 1;
		if (index > num.length - 1)
			return 0;

		if (n[index][sum] == 0) {
			int sum1 = 0;

			sum1 = countSetRec(num, sum - num[index], index + 1);
			int sum2 = countSetRec(num, sum, index + 1);
			n[index][sum] = sum1 + sum2;
		}

		return n[index][sum];

	}

	static int countSetRec(int[] num, int sum, int index) {
		if (sum == 0)
			return 1;
		if (index > num.length - 1)
			return 0;

		int sum1 = 0;

		sum1 = countSetRec(num, sum - num[index], index + 1);
		int sum2 = countSetRec(num, sum, index + 1);
		return sum1 + sum2;
	}

	public static void main(String[] args) {
		SubsetSum ks = new SubsetSum();
		int[] profits = { 1, 1, 2, 3 };

		int maxProfit = countSubset(profits, 4);
		System.out.println("Total   profit ---> " + maxProfit);
		profits = new int[] { 1, 2, 7, 1, 5 };
		maxProfit = countSubset(profits, 9);
		System.out.println("Total   profit ---> " + maxProfit);

	}

}
