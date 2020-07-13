package com.dp;

public class CoinChangeMinCoin {
	public static void main(String... str) {
		//minimum coin required for a given money
		//sum given, coin , think 2d of both
		//  0	1 2 3 4 5 6 7 8 9 10 11 
		//1 1	1 2 3 4 5 6 7 8 9 10 11
		//5	0	1 2 3 4 1 2 3 4 5 2   3
		int total = 13;
		int[] coins = { 7, 3, 2, 6 };

		dpbottomup(total, coins);

		coins = new int[] { 1, 5, 6, 8 };

		dpbottomup(11, coins);

	}

	static void dpbottomup(int total, int[] coins) {
		//min

		int a[] = new int[total + 1];
		a[0] = 0;
		for (int i = 1; i <= total; i++) {
			a[i] = Integer.MAX_VALUE - 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < total + 1; j++) {
				if (j >= coins[i]) {
					if (a[j - coins[i]] + 1 < a[j])
						a[j] = 1 + a[j - coins[i]];
				}
			}
		}

		System.out.println(a[total]);
	}
}
