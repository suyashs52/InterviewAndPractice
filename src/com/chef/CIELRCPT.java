package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CIELRCPT {

	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		int[] inp = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048 };
		for (int i = 0; i < test; i++) {
			int cas = Integer.parseInt(br.readLine());
			int count = 0;
			int remain = 0;
			for (int j = inp.length - 1; j > 0; j--) {
				if (inp[j] <= cas) {
					remain = cas / inp[j];
					count += remain;
					cas -= (remain * inp[j]);
				}
			}
			count += cas;
			System.out.println(count);

		}

	}

}
