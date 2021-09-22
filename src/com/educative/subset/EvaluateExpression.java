package com.educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvaluateExpression {

	public static List<Integer> diffWaysToEvaluateExpression(String input) {
		List<Integer> result = new ArrayList<>();
		if (!(input.contains("+") || input.contains("*") || input.contains("-"))) {
			// it is integer
			result.add(Integer.parseInt(input));

		} else {
			for (int i = 0; i < input.length(); i++) {
				// divide each into left and right
				char c = input.charAt(i);
				if (c == '+' || c == '*' || c == '-') {
					List<Integer> l = new ArrayList<>(diffWaysToEvaluateExpression(input.substring(0, i)));
					List<Integer> r = new ArrayList<>(diffWaysToEvaluateExpression(input.substring(i + 1)));

					for (int l1 : l) {
						for (int j1 : r) {
							switch (c) {
							case '+':
								result.add(l1 + j1);
								break;
							case '*':
								result.add(l1 * j1);
								break;
							case '-':
								result.add(l1 - j1);
								break;

							}
						}
					}
				}

			}

		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
		System.out.println("Expression evaluations: " + result);

		result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
		System.out.println("Expression evaluations: " + result);
	}

}
