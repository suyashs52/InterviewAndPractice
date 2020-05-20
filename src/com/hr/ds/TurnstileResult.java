package com.hr.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TurnstileResult {
	public static void main(String... str) {
		Integer[] a = new Integer[] { 0, 0, 1, 5 };
		Integer[] b = new Integer[] { 0, 1, 1, 0 };
		List<Integer> stockData = Arrays.asList(a);
		List<Integer> queries = Arrays.asList(b);
		List<Integer> result = getTimes(stockData, queries);
		System.out.println(result);

	}

	public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
		// Write your code here
		Integer left = 0;
		Integer right = 0;
		int exit = 1;
		Integer timer = time.get(left);
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> temp = new LinkedHashMap();// <Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (left < time.size()) {

			while (time.get(right) == timer) {
				temp.put(right, time.get(right));
				right++;
			}
			Integer maxTimer = time.get(right);
			int i = left;
			while (i < right) {
				if (direction.get(i) == exit) {
					map.put(i, timer);
					temp.remove(i);
					break;

				}
				i++;

			}
			if (i < right) {
				if (timer == maxTimer - 1) { // right increase
					continue;

				} else if (timer < maxTimer) {
					if (temp.size() > (maxTimer - timer)) {
						int t = maxTimer - timer;
						while (t > 0 && temp.size() > 0) {
							boolean found = false;
							for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
								if (entry.getValue() == exit) {
									timer++;
									map.put(entry.getKey(), timer);
									found = true;
									temp.remove(entry.getKey());

									break;
								}
							}
							if (!found) {
								exit = exit == 1 ? 0 : 1;

							}
							t--;
							
							
						}
						if(temp.size()==0) {
							left=right;
						}else if(t==0) {
							
						}

					}
				}

			}
		}

		return null;
	}
}

class li {

}
