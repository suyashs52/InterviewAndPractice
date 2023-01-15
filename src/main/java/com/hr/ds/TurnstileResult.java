package com.hr.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TurnstileResult {
	public static void main(String... str) {
		Integer[] a = new Integer[] { 0, 0, 1, 5 };
		Integer[] b = new Integer[] { 0, 1, 1, 0 };

		a = new Integer[] { 0, 1, 1, 3, 3 };
		b = new Integer[] { 0, 1, 0, 0, 1 };

		a = new Integer[] { 3, 3, 3, 4, 4, 5, 6, 6, 7, 8 };
		b = new Integer[] { 1, 1, 0, 1, 0, 0, 0, 1, 0, 0 };

		List<Integer> stockData = Arrays.asList(a);
		List<Integer> queries = Arrays.asList(b);
		List<Integer> result = getTimes(stockData, queries);
		System.out.println(result);

	}

	public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {

		Integer left = 0;
		Integer right = 0;
		int exit = 1;
		Integer timer = time.get(left);
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();// <Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		while (left < time.size() && map.size() < time.size()) {
			timer = time.get(right);// get next timer value// Math.max(time.get(left), timer);
			while (right < time.size() && time.get(right) == timer) { // push untill same value
				temp.put(right, direction.get(right));
				right++;
			}

			int i = left;
			Integer[] arr = new Integer[temp.size()];
			Iterator<Integer> itr = temp.keySet().iterator();
			int c = 0;
			if (itr.hasNext()) {
				i = itr.next();
				left = i;
				arr[c++] = i;
				while (itr.hasNext()) {
					arr[c++] = itr.next();
				}

			}
			boolean istimeadd = false;
			for (int j = 0; j < arr.length; j++) {
				if (direction.get(arr[j]) == exit) {
					map.put(arr[j], timer);
					istimeadd = true;
					temp.remove(arr[j]);
					break;

				}
				i++;
			}
			right = arr[arr.length - 1] + 1;
			if (right > time.size() - 1) {
				right = time.size() - 1;
			}

			if (i >= right) { // no same exit value found
				exit = exit == 1 ? 0 : 1;
				i = left;
				while (i < right) {
					if (direction.get(i) == exit) {
						if (istimeadd)
							timer++;
						map.put(i, timer);
						temp.remove(i);
						break;

					}
					i++;

				}

			}
			Integer maxTimer = time.get(right); // next max value
			if (i < right) {
				if (timer == maxTimer - 1) { // right increase
					if (temp.size() == 0)
						left = right;
					continue;

				} else if (timer < maxTimer) {
					if (temp.size() > (maxTimer - timer)) {
						arr = new Integer[temp.size()];
						itr = temp.keySet().iterator();
						c = 0;
						if (itr.hasNext()) {
							i = itr.next();
							left = i;
							arr[c++] = i;
							while (itr.hasNext()) {
								arr[c++] = itr.next();
							}

						}
						int t = maxTimer - timer;
						while (t > 0 && temp.size() > 0) {

							boolean found = false;
							for (int j = 0; j < arr.length; j++) {
								if (direction.get(arr[j]) == exit) {
									timer++;
									map.put(arr[j], timer);
									temp.remove(arr[j]);
									found = true;
									break;

								}
								i++;
							}
							if (!found) {
								exit = exit == 1 ? 0 : 1;
							}
							t--;

						}
						if (temp.size() == 0) {
							right = arr[arr.length - 1] + 1;
							left = right;
						} else if (t == 0) {

						}

					} else {
						if (temp.size() > 0) {

							arr = new Integer[temp.size()];
							itr = temp.keySet().iterator();
							c = 0;
							if (itr.hasNext()) {
								i = itr.next();
								left = i;
								arr[c++] = i;
								while (itr.hasNext()) {
									arr[c++] = itr.next();
								}

							}

							while (!temp.isEmpty()) {
								boolean found = false;
								for (int j = 0; j < arr.length; j++) {
									if (direction.get(arr[j]) == exit) {
										timer++;
										map.put(arr[j], timer);
										temp.remove(arr[j]);
										found = true;
										break;

									}
									i++;
								}
								if (!found) {
									exit = exit == 1 ? 0 : 1;
								}
							}
							if (right > time.size() - 1) {
								right = time.size() - 1;
							}

							left = right;

						}
					}
				} else if (timer == maxTimer && right == time.size() - 1 && temp.size() > 0) {
					int mt = -1;
					for (Integer in : map.values()) {
						if (in > mt)
							mt = in;

					}
					timer = mt;

					while (!temp.isEmpty()) {
						boolean found = false;
						for (int j = 0; j < arr.length; j++) {
							if (direction.get(arr[j]) == exit) {
								timer++;
								map.put(arr[j], timer);
								temp.remove(arr[j]);
								found = true;
								// break;

							}
							i++;
						}
						if (!found) {
							exit = exit == 1 ? 0 : 1;
						}
					}
					if (right > time.size() - 1) {
						right = time.size() - 1;
					}

					left = right;

				}

			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}
}

class li {

}
