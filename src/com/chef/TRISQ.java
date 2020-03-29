package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRISQ {
	public static void code() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			int it = Integer.parseInt(br.readLine());
			 
			it = (it - 2) / 2;
			int sum = (it * (it + 1)) / 2;

			System.out.println(sum);
		}
	}

	private static int square(int t, int b) {
		// TODO Auto-generated method stub

		if (t < 2 || b < 2)
			return 0;
		return 1 + square(t - 2, b - 2);

	}
}
