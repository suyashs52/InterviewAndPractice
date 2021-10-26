package com.educative.knapsack01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Knapsack {

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		int i = -1;
		i = solveKnapsackRec(profits, weights, capacity, 0);
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		i = solveKnapsackTopDown(dp, profits, weights, capacity, 0);
		i=solveKnapscakBottomUp(profits,weights,capacity);
		return i;

	}

	int solveKnapscakBottomUp(int[] profits, int[] weights, int capacity) {
		int s = -1;

		int n = profits.length;
		Integer[][] dp = new Integer[n][capacity + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < capacity + 1; i++) {
			if (weights[0] < capacity)
				dp[0][i] = profits[0];
		}

		for (int i = 1; i < weights.length; i++) {
			for (int j = 1; j < capacity + 1; j++) {
				int profit1 = 0;
				int profit2 = 0;
				if (weights[i] <= j) {
					profit1 = profits[i] + dp[i - 1][j - weights[i]];
				}
				profit2 = dp[i - 1][j];

				dp[i][j] = Math.max(profit1, profit2);
			}
		}

		return dp[n - 1][capacity];

	}

	int solveKnapsackTopDown(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
		if (capacity <= 0)
			return 0;
		if (index > profits.length - 1)
			return 0;

		if (dp[index][capacity] != null) {
			return dp[index][capacity];
		}

		int p = 0;
		if (capacity >= weights[index]) {
			p = profits[index] + solveKnapsackTopDown(dp, profits, weights, capacity - weights[index], index + 1);
		}
		int p1 = solveKnapsackTopDown(dp, profits, weights, capacity, index + 1);
		dp[index][capacity] = Math.max(p, p1);

		return dp[index][capacity];
	}

	int solveKnapsackRec(int[] profits, int[] weights, int capacity, int index) {
		if (index > profits.length - 1) {
			return 0;
		}
		if (capacity <= 0) {
			return 0;
		}

		int p1 = 0;
		if (capacity >= weights[index])
			p1 = profits[index] + solveKnapsackRec(profits, weights, capacity - weights[index], index + 1);
		int p2 = solveKnapsackRec(profits, weights, capacity, index + 1);

		return Math.max(p1, p2);

	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		int maxProfit = ks.solveKnapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);
		maxProfit = ks.solveKnapsack(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);
	}

}
