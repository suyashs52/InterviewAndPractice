package com.educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {
	class Parenthesis {
		String str;
		int open;
		int close;

		public Parenthesis(String str, int open, int close) {
			this.str = str;
			this.open = open;
			this.close = close;
		}
	}

	static GenerateParentheses gp = new GenerateParentheses();

	public static List<String> generateValidParentheses(int num) {
		List<String> result = new ArrayList<String>();
		// since each string has differennt open and close braces
		// so need to check validation on each string so create class
		Queue<Parenthesis> queue = new LinkedList<GenerateParentheses.Parenthesis>();
		queue.add(gp.new Parenthesis("", 0, 0));

		while (queue.isEmpty() == false) {
			Parenthesis p = queue.poll();

			if (p.open < num) {
				queue.add(gp.new Parenthesis(p.str + "(", p.open + 1, p.close));

			}
			if (p.close < p.open) {
				queue.add(gp.new Parenthesis(p.str + ")", p.open, p.close + 1));

			}
			if (p.close == num) {
				result.add(p.str);
			}
		}

		return result;
	}

	static void generateRecur(int open, int close, char[] parens, List<String> result, int i) {

		if (close == parens.length/2) {
			result.add(parens.toString());
			return;
		}

		if (open < parens.length/2) {
			parens[i] = '(';
			generateRecur(open + 1, close, parens, result, i + 1);
		}
		if (close < open) {
			parens[i] = ')';
			generateRecur(open, close + 1, parens, result, i + 1);

		}

	}

	public static void main(String[] args) {
		List<String> result = GenerateParentheses.generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = GenerateParentheses.generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);

		System.out.println(" Recursive");
		result = new ArrayList<String>();
		generateRecur(0,0,new char[6],result,0);
		result = GenerateParentheses.generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

}
