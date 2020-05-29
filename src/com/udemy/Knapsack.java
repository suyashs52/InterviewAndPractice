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
