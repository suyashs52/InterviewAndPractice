package com.jav;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AvgHgstMrks {
	public static void code() {
		String s[][] = { { "jerry", "65" }, { "bob", "91" }, { "jerry", "23" }, { "Eric", "83" }, { "bob", "10" } };
		Map<String, Float> m = new HashMap<>();
		Map<String, Integer> mcount = new TreeMap<>();

		for (String[] s1 : s) {
			if (m.containsKey(s1[0])) {
				m.put(s1[0], Float.parseFloat(s1[1]) + m.get(s1[0]));
				mcount.put(s1[0], (mcount.get(s1[0]) + 1));
			} else {
				m.put(s1[0], Float.parseFloat(s1[1]));
				mcount.put(s1[0], 1);
			}
		}
		for (Map.Entry<String, Float> map : m.entrySet()) {
			m.put(map.getKey(), map.getValue() / mcount.get(map.getKey()));
		}
		Float max = -1f;
		String name = "";

		for (Map.Entry<String, Float> map : m.entrySet()) {
			if (max < map.getValue()) {
				max = map.getValue();
				name = map.getKey();
			}
		}
		System.out.println(m);
		System.out.println(name);

	}
}
