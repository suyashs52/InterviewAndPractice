package com.educative.knapsack01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class PartitionSet2 {

	static int canPartition(int[] num) {
		int t = -1;
		t = icanPartitionRec(num, 0, 0, 0);
		int sum = 0;
		for (int i : num) {
			sum += i;
		}
		int[][] dptb = new int[num.length][sum + 1];
		t = icanPartitionTopDownRec(dptb, num, 0, 0, 0);

		boolean[][] dpb = new boolean[num.length][sum / 2 + 1];
		for (int i = 0; i < dpb.length; i++) {
			dpb[i][0] = true;
		}
		dpb[0][num[0]] = true;

		for (int i = 1; i < num.length; i++) {
			for (int s = 1; s <= sum / 2; s++) {
				if (dpb[i - 1][s]) {
					dpb[i][s] = true;
				} else if (s >= num[i]) {
					dpb[i][s] = dpb[i - 1][s - num[i]];
				}
			}
		}

		int sum1 = 0;
		for (int i = sum / 2; i >= 0; i--) {
			if (dpb[num.length - 1][i]) {
				sum1 = i;
				break;
			}
		}

		int sum2 = sum - sum1;
		t = Math.abs(sum1 - sum2);
		return t;
	}

	private static int icanPartitionRec(int[] num, int sum1, int sum2, int index) {
		if (num.length == index) {
			return Math.abs(sum1 - sum2);
		}

		// devid in 2 subset
		// {1,2} --> 1_,_1 -> 12_,12,21,_12
		int diff = icanPartitionRec(num, sum1 + num[index], sum2, index + 1);
		int diff2 = icanPartitionRec(num, sum1, sum2 + num[index], index + 1);

		return Math.min(diff, diff2);

	}

	private static int icanPartitionTopDownRec(int[][] dptb, int[] num, int sum1, int sum2, int index) {
		if (num.length == index) {
			return Math.abs(sum1 - sum2);
		}

		if (dptb[index][sum1] == 0) {
			int diff = icanPartitionRec(num, sum1 + num[index], sum2, index + 1);
			int diff2 = icanPartitionRec(num, sum1, sum2 + num[index], index + 1);
			dptb[index][sum1] = Math.min(diff, diff2);

		}

		return dptb[index][sum1];

	}

	public static void main(String[] args) {
		PartitionSet2 ks = new PartitionSet2();
		int[] profits = { 1, 2, 3, 9 };

		int maxProfit = canPartition(profits);
		System.out.println("Total   profit ---> " + maxProfit);
		profits = new int[] { 1, 2, 7, 1, 5 };
		System.out.println("Total   profit ---> " + canPartition(profits));
		profits = new int[] { 1, 3, 100, 4 };
		System.out.println("Total   profit ---> " + canPartition(profits));

	}

}
