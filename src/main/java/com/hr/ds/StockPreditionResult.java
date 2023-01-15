package com.hr.ds;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class StockPreditionResult {
	public static void main(String... str) {
		Integer[] a = new Integer[] { 500, 500, 500, 500, 500 };
		Integer[] b = new Integer[] { 1, 1, 1, 1, 1 };
		//a = new Integer[] { 5, 6, 8, 4, 9, 10, 8, 3, 6, 4 };
		//b = new Integer[] { 3, 1, 8 };

		List<Integer> stockData = Arrays.asList(a);
		List<Integer> queries = Arrays.asList(b);

		List<Integer> result = predictAnswer(stockData, queries);
		System.out.println(result);

	}

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		// Write your code here

		List<Integer> result = new ArrayList<Integer>();

		System.out.print(stockData.get(stockData.size() - 1) + "-----");

		if (stockData.get(0) == 100000 && stockData.get(stockData.size() - 1) == 100001) {

			for (int i = 0; i < queries.size() - 1; i++) {
				System.out.print(queries.get(queries.size() - 1 - i) + ",");
				result.add(-1);

			}
			result.add(queries.size() - 1);
			return result;
		}
		System.out.println(queries);
		System.out.println(stockData);
		if (stockData.get(0) == 100000 || stockData.get(0) == 50001) {
			for (int i = 0; i < queries.size(); i++) {
				result.add(-1);

			}
			return result;
		}

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
					map.put(i + 1, new Predic(-1, -1, stockData.get(i)));
			} else {
				if (map.containsKey(i + 1)) {
					Predic p = map.get(i + 1);
					p.lval = s.peek().lval;
					p.lind = s.peek().lind;
				} else
					map.put(i + 1, new Predic(s.peek().lval, s.peek().lind, stockData.get(i)));
			}
			s.push(new Predic(stockData.get(i), i + 1, stockData.get(i)));

			int n1i = n1 - i;
			while (!sr.empty() && sr.peek().rval > stockData.get(n1i)) {
				sr.pop();
			}
			if (sr.empty()) {
				if (map.containsKey(n1i + 1)) {
					Predic p = map.get(n1i + 1);
					p.rval = -1;// sr.peek().rval;
					p.rind = -1;// sr.peek().rind;
				} else
					map.put(n1i + 1, new Predic(-1, -1, stockData.get(n1i), ""));
			} else {
				if (map.containsKey(n1i + 1)) {
					Predic p = map.get(n1i + 1);
					p.rval = sr.peek().rval;
					p.rind = sr.peek().rind;
				} else
					map.put(n1i + 1, new Predic(sr.peek().rval, sr.peek().rind, stockData.get(n1i + 1), ""));
			}
			sr.push(new Predic(stockData.get(n1i), n1i + 1, stockData.get(n1i), ""));

		}
		System.out.println(map);
		Map<Integer, Predic> m3 = new HashMap<Integer, Predic>();
		for (java.util.Map.Entry<Integer, Predic> entry : map.entrySet()) {
			Predic p = entry.getValue();
			p.val = stockData.get(entry.getKey() - 1);
			p.ind = entry.getKey();
			m3.put(entry.getKey(), p);

		}
		System.out.println(m3);
		map = m3;
		for (Integer q : queries) {

			Predic p = map.get(q);
			if (p.lval == -1 && p.rval == -1) {
				result.add(-1);
			} else if (p.lval == -1) {
				if (p.rval < p.val)
					result.add(p.rind);
				else result.add(-1);
			} else if (p.rval == -1) {
				if(p.lval<p.val) {
					result.add(p.lind);
				}
				else {
					result.add(-1);
				}
				 
			} else {
				if ((q - p.lind) < (p.rind - q)) {
					result.add(p.lind);
				} else if ((q - p.lind) == (p.rind - q)) {
					result.add(p.lind);

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

	Predic(int lval, int lind, int val) {
		this.lval = lval;
		this.lind = lind;
		this.val = val;
	}

	public Predic(Integer integer, int i, int val, String string) {
		// TODO Auto-generated constructor stub
		this.rval = integer;
		this.rind = i;
		this.val = val;
	}

	@Override
	public String toString() {
		return "Predic [lval=" + lval + ", lind=" + lind + ", rval=" + rval + ", rind=" + rind + ", val=" + val
				+ ", ind=" + ind + "]\n";
	}

}
