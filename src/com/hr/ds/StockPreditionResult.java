package com.hr.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class StockPreditionResult {
	public static void main(String... str) {
		Integer[] a = new Integer[] { 5, 6, 8, 4, 9, 10, 8, 3, 6, 4 };
		Integer[] b = new Integer[] { 6, 5, 4 };
		List<Integer> stockData = Arrays.asList(a);
		List<Integer> queries = Arrays.asList(b);
		List<Integer> result = predictAnswer(stockData, queries);
		System.out.println(result);

	}

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		// Write your code here
		List<Integer> result = new ArrayList<Integer>();

		Stack<Predic> s = new Stack<>();
		Stack<Predic> sr = new Stack<Predic>();
		Map<Integer, Predic> map = new HashMap<Integer, Predic>();
		int n = stockData.size();
		int n1 = stockData.size() - 1;
		for (int i = 0; i < n; i++) {
			while (!s.empty() && s.peek().lval > stockData.get(i)) {
				s.pop();
			}
			if (s.empty()) {
				if (map.containsKey(i + 1)) {
					Predic p = map.get(i + 1);
					p.lval = -1;// s.peek().lval;
					p.lind = -1;// s.peek().lind;
				} else
					map.put(i + 1, new Predic(-1, -1));
			} else {
				if (map.containsKey(i + 1)) {
					Predic p = map.get(i + 1);
					p.lval = s.peek().lval;
					p.lind = s.peek().lind;
				} else
					map.put(i + 1, new Predic(s.peek().lval, s.peek().lind));
			}
			s.push(new Predic(stockData.get(i), i + 1));

			int n1i = n1 - i;
			while (!sr.empty() && sr.peek().rval > stockData.get(n1i)) {
				sr.pop();
			}
			if (sr.empty()) {
				if (map.containsKey(n1i + 1)) {
					Predic p = map.get(n1i + 1);
					p.rval = sr.peek().rval;
					p.rind = sr.peek().rind;
				} else
					map.put(n1i + 1, new Predic(-1, -1,""));
			} else {
				if (map.containsKey(n1i + 1)) {
					Predic p = map.get(n1i + 1);
					p.rval = sr.peek().rval;
					p.rind = sr.peek().rind;
				} else
					map.put(n1i + 1, new Predic(sr.peek().rval, sr.peek().rind,""));
			}
			sr.push(new Predic(stockData.get(n1i), n1i + 1, ""));

		}
		System.out.println(map);
		for (Integer q : queries) {
			Predic p = map.get(q);
			if (p.lval == -1 && p.rval == -1) {
				result.add(-1);
			} else if (p.lval == -1) {
				result.add(p.rind);
			} else if (p.rval == -1) {
				result.add(p.lind);
			} else {
				if ((q - p.lind) < (q - p.rind)) {
					result.add(p.lind);
				} else if ((q - p.lind) == (q - p.rind)) {
					if (p.lval >= p.rval) {
						result.add(p.lind);
					} else {
						result.add(p.rind);
					}
				} else {
					result.add(p.rind);
				}
			}
		}
		return result;

	}

}

class Predic {
	int lval;
	int lind;
	int rval;
	int rind;
	int val;
	int ind;

	Predic(int lval, int lind) {
		this.lval = lval;
		this.lind = lind;
	}

	public Predic(Integer integer, int i, String string) {
		// TODO Auto-generated constructor stub
		this.rval = integer;
		this.rind = i;
	}

	@Override
	public String toString() {
		return "Predic [lval=" + lval + ", lind=" + lind + ", rval=" + rval + ", rind=" + rind + "]\n";
	}

}
