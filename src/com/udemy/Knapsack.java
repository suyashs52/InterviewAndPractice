package com.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Knapsack {
	public static void main(String[] args) {
		ArrayList<KnapsackEntity> item = new ArrayList<KnapsackEntity>();
		int[] value = { 6, 2, 1, 8, 3, 5 };
		int[] weight = { 6, 10, 3, 5, 1, 3 };
		int capacity = 10;
		for (int i = 0; i < value.length; i++) {
			item.add(new KnapsackEntity(i + 1, value[i], weight[i]));
		}
		knapsackFrac(item, capacity);

		// 0/1 kanpsack
		// profit can be taking first value+ profit of(remaining element)/ 0+profit
		// from remaining element max value from both
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = knapsack01(profits, weights, 7);
		System.out.println("max profit " + maxProfit);
		maxProfit = knapsack01TopDown(profits, weights, 7);
		System.out.println("max profit " + maxProfit);
		maxProfit = knapsack01BottomUpNoRecur(profits, weights, 7);
		System.out.println("max profit " + maxProfit);

	}

	private static int knapsack01(int[] profits, int[] weights, int capacity) {
//take value give max profit , 
		// take next value make max profit
		return knapsack01(profits, weights, capacity, 0);
	}

	private static int knapsack01TopDown(int[] profits, int[] weights, int capacity) {
		// dp store value in 2d array if found then return it
		Integer[][] dp = new Integer[profits.length][capacity + 1];
		return knapsack01(dp, profits, weights, capacity, 0);
	}

	private static int knapsack01BottomUpNoRecur(int[] profits, int[] weights, int capacity) {
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) // Base case
			return 0;

		int numberOfRows = profits.length + 1;// adding a dummy row to avoid array index issues
		Integer[][] dp = new Integer[numberOfRows][capacity + 1];// Create a 2D Array to store all the results

		for (int i = 0; i < numberOfRows; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index
													// issues
			dp[i][0] = 0;
		}

		for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
			dp[numberOfRows - 1][i] = 0;
		}

		for (int row = numberOfRows - 2; row >= 0; row--) {
			for (int column = 1; column <= capacity; column++) {
				int profit1 = 0, profit2 = 0;
				if (weights[row] <= column) { // column represents current capacity
					profit1 = profits[row] + dp[row + 1][column - weights[row]]; // Taking current element
				}
				profit2 = dp[row + 1][column]; // Not taking current element
				dp[row][column] = Math.max(profit1, profit2);
			}
		} // end of loop
		System.out.println(dp);
		return dp[0][capacity];
	}

	private static int knapsack01(Integer[][] dp, int[] profits, int[] weights, int capacity, int curr_ind) {
		if (capacity <= 0 || curr_ind < 0 || curr_ind >= profits.length)
			return 0;
		if (dp[curr_ind][capacity] != null) {
			return dp[curr_ind][capacity];
		}
		int profit1 = 0;
		if (weights[curr_ind] <= capacity) { // taking profit
			profit1 = profits[curr_ind] + knapsack01(dp, profits, weights, capacity - weights[curr_ind], curr_ind + 1);
		}
		int profit2 = knapsack01(dp, profits, weights, capacity - weights[curr_ind], curr_ind + 1);
		dp[curr_ind][capacity] = Math.max(profit1, profit2);
		return dp[curr_ind][capacity];
	}

	private static int knapsack01(int[] profits, int[] weights, int capacity, int cind) {
		if (capacity <= 0 || cind < 0 || cind >= profits.length) // terminate condition
			return 0;
		int profit1 = 0;
		if (weights[cind] <= capacity) {
			profit1 = profits[cind] + knapsack01(profits, weights, capacity - weights[cind], cind + 1);
		}
		int profit2 = knapsack01(profits, weights, capacity - weights[cind], cind + 1);
		return Math.max(profit1, profit2);
	}

	private static void knapsackFrac(ArrayList<KnapsackEntity> item, int capacity) {
		// theaf take item bases on high value
		// high value means higher per value ratio so sort decending of value/weight
		Comparator<KnapsackEntity> comparator = new Comparator<KnapsackEntity>() {

			@Override
			public int compare(KnapsackEntity o1, KnapsackEntity o2) {
				// TODO Auto-generated method stub
				return o2.getRatio() - o1.getRatio() > 0 ? 1 : -1;
			}
		};
		Collections.sort(item, comparator);
		// use greedy algo
		int usedCap = 0;
		double totalValue = 0;
		for (KnapsackEntity i : item) {
			if (capacity >= usedCap + i.getWeight()) {
				usedCap += i.getWeight();
				System.out.println("takken " + i);
				totalValue += i.getValue();
			} else if (capacity >= usedCap) {
				// total weight is greater then remaining capacity
				// so use fraction
				int usedWeight = capacity - usedCap;
				double value = i.getRatio() * usedWeight;
				usedCap += usedWeight;
				totalValue += value;
				System.out.println("Taken: " + "item index = " + i.getIndex() + ",obtained value = " + value
						+ ",used weight = " + usedWeight + ", ratio = " + i.getRatio() + "]");

			}
			if (usedCap == capacity)
				break;
		}
		System.out.println("\nTotal value obtained: " + totalValue);

	}
}
