package com.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ONP {

	// https://www.spoj.com/problems/MMASS/
	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int j = 0; j < testcase; j++) {
			String inp = br.readLine();
			Stack<String> st = new Stack<String>();
			for (int i = 0; i < inp.length(); i++) {
				Character c = inp.charAt(i);
				if (c == '(') {
					st.push("(");
				} else if (c == ')') {
					Stack<String> tmp = new Stack<>();
					while (!st.peek().equals("(")) {
						tmp.push(st.pop());
					}
					st.pop();
					String str = "";
					while (!tmp.isEmpty()) {
						if ("+-/^*".indexOf(tmp.peek()) > -1) {
							String t = tmp.pop();
							str += tmp.pop() + t;
						} else {
							str += tmp.pop();
						}

					}
					st.push(str);

				} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
					st.push(c + "");
				} else if (!st.empty() && !st.peek().equals("(")) {
					String sym = st.pop();
					st.push(st.pop() + c + sym);
				} else {
					st.push(c + "");
				}

			}
			System.out.println(st.pop());
		}

	}

	public static void code1() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int j = 0; j < testcase; j++) {
			String inp = br.readLine();
			StringBuilder sb = new StringBuilder();
			Stack<Character> st = new Stack<>();
			// (c+(a+b))==> c[+] - ca[++]b - cab+[+] - cab++
			for (int i = 0; i < inp.length(); i++) {
				Character c = inp.charAt(i);
				if (c == '(') {

				} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
					st.push(c);
				} else if (c == ')') {
					sb.append(st.pop());
				} else {
					sb.append(c);
				}

			}
			System.out.println(sb);
		}

	}

}
