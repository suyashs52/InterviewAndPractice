package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinSwap {
//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
	public static void code() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input ="4 3 2 1";// br.readLine();
		input ="1 3 4 2";
		input ="1 2 4 3";
		Integer[] arr = new Integer[(input.length() + 1) / 2];
		Integer[] arrsort = new Integer[(input.length() + 1) / 2];

		int count = 0;
		int max = -1;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				arr[count++] = (int) input.charAt(i)-'0';
				if (max < arr[count - 1])
					max = arr[count - 1];
				arrsort[count - 1] = arr[count-1];
			}
		}

		Integer[] index = new Integer[max+1];
		boolean[] flag = new boolean[arrsort.length];
		for (int i = 0; i < arr.length; i++) {
			index[arr[i]] = i;
		}

		Arrays.sort(arrsort);
		count = 0;
		int swap = 0;
		//		4 3 2 1
		//		1 2 3 4
		//index=3 2 1 0
		// 1-(3)-4-(0)-1 = 1
		for (int i = 0; i < arrsort.length; i++) {
			int first = arrsort[i];
			
			int in = index[first];
			while (arrsort[in] != first && !flag[in]) {
				swap++;
				flag[in] = true;
				in = index[arrsort[in]];

			}
			flag[i] = true;

		}
		
		System.out.println(swap);

	}
}
