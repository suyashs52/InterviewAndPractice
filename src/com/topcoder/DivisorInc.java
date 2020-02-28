package com.topcoder;

public class DivisorInc {
	// https://community.topcoder.com/stat?c=problem_solution&cr=7452866&rd=9823&pm=6186
	// https://community.topcoder.com/stat?c=problem_statement&pm=6186&rd=9823
	public static void code() {
		System.out.println(countOperation(4, 24));
		System.out.println(countOperation(4, 576));
		System.out.println(countOperation(8748, 83462));
	}

	public static int countOperation(int n, int m) {
		int count = 0;
		int[] dyn = new int[m + 1];

		// index contain visit of max
		// 4-2-6
		// 6-2-8,
		for (int j = n; j < m + 1; j++) {
			dyn[j] = m + 1;
		}
		dyn[n] = 1;
		for (int j = n; j < m + 1; j++) {
			for (int i = 2; i * i <= j; i++) {
				if (j % i == 0) {
					if (j + i < (m + 1))
						dyn[j + (i)] = Math.min(dyn[j] + 1, dyn[j + (i)]);
					if ((j + (j / i)) < (m + 1))
						dyn[j + (j / i)] = Math.min(dyn[j] + 1, dyn[j + (j / i)]);
				}
			}
		}
		return dyn[m]-1;

	}
}
