package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class COMPILER {
	public static void code() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		 
		for (int i = 0; i < testcase; i++) {
			String inp = br.readLine();

			int max = 0;

			// https://www.codechef.com/problems/COMPILER
			// <<><<<>>
			// question says longest prefix so if there is error then max is till than
			int less = 0;

			for (int j = 0; j < inp.length(); j++) {
				if (inp.charAt(j) == '<') {
					less++;

				} else {
					less--;

				}
				if (less < 0) {
					break;
				}
				if (less == 0) {
					max = j + 1;
				}
			}

			System.out.println(max);
		}

	}
}
