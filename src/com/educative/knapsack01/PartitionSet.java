package com.educative.knapsack01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class PartitionSet {

	static boolean canPartition(int[] num) {
		boolean i = false;

		int sum = 0;
		for (int j : num) {
			sum += j;
		}
		if (sum % 2 != 0)
			return false;

		sum = sum / 2;
		i = icanPartitionRec(num, sum, 0);
		i = canPartitiondp(num);
		return i;

	}

	private static boolean icanPartitionRec(int[] num, int sum, int index) {
		if (index > num.length - 1)
			return false;
		if (sum == 0)
			return true;
		if (sum >= num[index])
			if (icanPartitionRec(num, sum - num[index], index + 1))
				return true;

		return icanPartitionRec(num, sum, index + 1);

	}

	private static boolean canPartitiondp(int[] num) {
		int sum = 0;
		for (int j : num) {
			sum += j;
		}
		if (sum % 2 != 0)
			return false;

		sum = sum / 2;
		boolean[][] result = new boolean[num.length][sum + 1];

		for (int i = 0; i < result.length; i++) {
			result[i][0] = true;// for 0 sum always true
		}
		for (int i = 0; i < result.length; i++) {
			if (num[0] == sum) // set first index has equal to 0,1,2,3,4 sum is num[0]=2, so num[0][2]=true
				result[0][i] = true; // next is let {2,4}, so num[i-1][4-2] if true
		}

		for (int i = 1; i < num.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= num[i]) {
					result[i][j] = result[i - 1][j - num[i]];
				} else {
					result[i][j] = result[i - 1][j];
				}
			}
		}

		return result[num.length - 1][sum - 1];

	}

	public static void main(String[] args) {
		PartitionSet ks = new PartitionSet();
		int[] profits = { 1, 2, 3, 4 };

		boolean maxProfit = canPartition(profits);
		System.out.println("Total   profit ---> " + maxProfit);
		profits = new int[] { 1, 1, 3, 4, 7 };
		System.out.println("Total   profit ---> " + canPartition(profits));
		profits = new int[] { 2, 3, 4, 6 };
		System.out.println("Total   profit ---> " + canPartition(profits));

	}

}
