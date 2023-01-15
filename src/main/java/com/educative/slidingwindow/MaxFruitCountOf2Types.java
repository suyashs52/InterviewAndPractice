package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxFruitCountOf2Types {
	public static int findLength(char[] arr) {
		int start = 0;
		int len = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int end = 0; end < arr.length; end++) {
			Character c = arr[end];
			// a b c b b c c d d d d c b
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (map.size() > 2) {
				map.put(arr[start], map.get(arr[start]) - 1);
				// if d comes remove until b completly removed
				// increase start index so bcbb ll remove
				if (map.get(arr[start]) == 0) {
					map.remove(arr[start]);
				}
				start++;

			}

			len = Math.max(len, end - start + 1);

		}

		return len;
	}

	public static void main(String[] args) {
		System.out.println("Length of the longest substring: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Length of the longest substring: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

	}

}
