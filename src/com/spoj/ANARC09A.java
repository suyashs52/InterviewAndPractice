package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ANARC09A {

	// https://www.spoj.com/problems/MMASS/
	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();

		while (inp.charAt(0) != '-') {
			int open = 0;
			int close = 0;
			int count = 0;
			for (int i = 0; i < inp.length(); i++) {
				if (inp.charAt(i) == '}') {
					close++;
					if (close > open) {
						count++;
						close--;
						open++;
					}

				} else {
					open++;
				}
			}
			count += (open - close) / 2;
			System.out.println(count);

			inp = br.readLine();
		}

	}

	public static void code1() throws NumberFormatException, IOException {
	}

}
