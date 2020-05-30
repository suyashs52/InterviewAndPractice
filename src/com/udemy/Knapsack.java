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

	}

	private static int knapsack01(int[] profits, int[] weights, int capacity) {

		return knapsack01(profits, weights, capacity, 0);
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
