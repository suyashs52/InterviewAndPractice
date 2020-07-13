package com.dp;

public class CoinChangeMinCoin {
	public static void main(String... str) {
		// minimum coin required for a given money
		// sum given, coin , think 2d of both
		// 0 1 2 3 4 5 6 7 8 9 10 11
		// 1 1 1 2 3 4 5 6 7 8 9 10 11
		// 5 0 1 2 3 4 1 2 3 4 5 2 3
		// for 5 we check that at 5,10 coin would be 1 ,2 multiple of 5
		// before 5 we have as it is
		// between 5 to 10 we have value 1to5 incremented order
		// ie +1 from 0 to 4 again at 10 coin is 2 +1 of 5 so on
		// it means when we need 1d array and after coin value is equal to index
		// if current value is greater than +1+val at index-coinValue replace it
		int total = 13;
		int[] coins = { 7, 3, 2, 6 };

		dpbottomup(total, coins);

		coins = new int[] { 1, 5, 6, 8 };

		dpbottomup(11, coins);

	}

	static void dpbottomup(int total, int[] coins) {
		// min

		int a[] = new int[total + 1];
		a[0] = 0;
		for (int i = 1; i <= total; i++) {
			a[i] = Integer.MAX_VALUE - 1; // adding max value
											// if coin is not multiple of index leave as it is
											// -1 is due to +1 check if(index-conin) value +1
			// is less than current value replace it
			// if max=max do nothing as last if we get max value-1 no solution
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
