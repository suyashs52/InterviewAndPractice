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

			int testCase = (int) inp;
			Stack<Long> st = new Stack<>();
			Stack<Integer> stin = new Stack<>();
			long maxarea = 0l;
			long area = 0l;
			 
			for (int i = 0; i < testCase; i++) {
				long l = in.nextLong();
				if (st.empty() || st.peek() <= l) {
					stin.push(i);
					st.push(l);
				} else {
					// [1456]4-> [144],5*2|6*1=10
					int lastGreatIndex=-1;
					while (!st.empty() && st.peek() > l) {
						area = (i - stin.peek()) * st.peek();
						if (maxarea < area)
							maxarea = area;
						lastGreatIndex=stin.pop();
						st.pop();
					}
					st.push(l);
					//because next smallest value should start from last large value for 
					// greater area
					stin.push(lastGreatIndex);

				}

			}

			while (!st.empty()) {

				area = (testCase - stin.peek()) * st.peek();
				if (maxarea < area)
					maxarea = area;
				stin.pop();
				st.pop();

			}

			System.out.println(maxarea);
			inp = in.nextLong();
			//8 6 2 5 5 4 5 1 6 0
			//5 1 4 5 6 4 0
		}

	}

	public static void code1() throws NumberFormatException, IOException {
	}

}
