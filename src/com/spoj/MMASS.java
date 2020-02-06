package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MMASS {
	// https://www.spoj.com/problems/MMASS/
	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		int count = 0;
		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < inp.length(); i++) {
			Character c = inp.charAt(i);

			count = 0;

			if (c >= '0' && c <= '9') {

				int it = st.peek() * (c - '0');
				st.pop();
				st.push(it);

			} else if (c == '(') {
				st.push(-1);

			} else if (c == ')') {
				int it = 0;
				while (st.peek() != -1) {
					it += st.peek();
					st.pop();
				}
				st.pop();
				st.push(it);

			} else {
				st.push(cho(c));
			}

		}
		count = 0;
		while (!st.isEmpty()) {
			count += st.pop();
		}
		System.out.println(count);

	}

	static int cho(char c) {
		switch (c) {
		case 'C':
			return 12;
		case 'H':
			return 1;
		case 'O':
			return 16;
		}
		return 0;

	}
}
