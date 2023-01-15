package com.educative.knapsack01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shopping {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int budget = 0;
		budget = Integer.parseInt(br.readLine().trim());
		String[] len = br.readLine().trim().split(" ");
		int flen = Integer.parseInt(len[0]);
		int slen = Integer.parseInt(len[1]);

		String[] farr = br.readLine().trim().split(" ");
		String[] sarr = br.readLine().trim().split(" ");
		Integer[] ifar = new Integer[farr.length];
		Integer[] isar = new Integer[sarr.length];
		int cout = 0;
		for (String s : farr) {
			ifar[cout++] = Integer.valueOf(s);
		}
		cout = 0;
		for (String s : sarr) {
			isar[cout++] = Integer.valueOf(s);
		}

		System.out.println(profit(ifar, isar, budget));

	}

	static int profit(Integer[] farr, Integer[] sarr, Integer budget) {
//		10
//		3 3
//		5 7 9
//		6 2 7
		
		
//		9
		
		
//		20
//		3 3
//		10 5 8
//		11 7 4
//		
//		
//		19
		
		
		Arrays.sort(farr);
		Arrays.sort(sarr);

		int l = 0;
		int r = sarr.length - 1;
		int diff = Integer.MAX_VALUE;
		int result = -1;
		while (l < farr.length && r > -1) {
			Integer sum = farr[l] + sarr[r];

			if (budget - sum > 0 && budget - sum < diff) {
				result = sum;
				diff=budget - sum ;
			}
			if (budget - sum > 0) {
				l++;
			} else {
				r--;
			}

		}

		return result;
	}

}
