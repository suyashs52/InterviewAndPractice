package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TACHSTCK {

	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp1 = br.readLine().split(" ");
		int test = Integer.parseInt(inp1[0]);
		int t2 = Integer.parseInt(inp1[1]);
		int[] inp = new int[test];
		for (int i = 0; i < test; i++) {
			inp[i] = Integer.parseInt(br.readLine());

		}

		Arrays.sort(inp);
		int count = 0;
		for (int i = 0; i < test - 1; i++) {
			if (inp[i + 1] <= inp[i] - t2) {
				count++;
				i++;
			}
		}

		System.out.println(count);

	}

}
