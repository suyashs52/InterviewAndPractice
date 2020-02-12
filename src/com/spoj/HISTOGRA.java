package com.spoj;

import java.io.IOException;
import java.util.Stack;

import com.Parser;

public class HISTOGRA {

	// https://www.spoj.com/problems/HISTOGRA/
	public static void code() throws NumberFormatException, IOException {

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String inp = br.readLine();
		Parser in = new Parser(System.in);
		long inp = in.nextLong();
		while (inp != 0) {
			Stack<Integer> digits = new Stack<>();
			Stack<Long> sums = new Stack<>();
			Long max = 0l;
			long[] hist = new long[(int) inp];
			for (int i = 0; i < inp; i++) {
				hist[i] = in.nextLong();
			}
			long max_area = 0;
			int top;
			long area_with_top;
			// 7 6 2 5 4 5 1 6 0
			int i = 0;
			while (i < inp) {
				if (digits.empty() || hist[digits.peek()] <= hist[i]) {
					System.out.println(i);
					System.out.println("value " + hist[i]);
					digits.push(i++);

				} else {
					top = digits.peek();
					digits.pop();
					System.out.println("index " + top);
					System.out.println("element " + hist[top]);
					System.out.println("multiply " + (digits.empty() ? i : (i - digits.peek() - 1)));
					area_with_top = hist[top] * (digits.empty() ? i : (i - digits.peek() - 1));

					if (max_area < area_with_top) {
						max_area = area_with_top;
					}
				}
			}

			while (digits.empty()) {
				top = digits.peek();
				digits.pop();
				area_with_top = hist[top] * (digits.empty() ? i : (i - digits.peek() - 1));
				if (max_area < area_with_top) {
					max_area = area_with_top;
				}

			}

			System.out.println(max_area);

			inp = in.nextLong();
		}

	}

	public static void code1() throws NumberFormatException, IOException {
	}

}
