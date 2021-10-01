package com.educative.topkelement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {

	public static String reorganizeString(String str, int k) {
		String result = "";

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(n1, n2) -> n2.getValue() - n1.getValue());

		maxHeap.addAll(map.entrySet());
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

		while (maxHeap.isEmpty() == false) {
			Map.Entry<Character, Integer> n = maxHeap.poll();
			result += n.getKey();
			n.setValue(n.getValue() - 1);
			queue.offer(n);

			if (queue.size() == k) {
				Map.Entry<Character, Integer> q = queue.poll();
				if (q.getValue() > 0) {
					maxHeap.add(q);
				}
			}
		}

		if (result.length() == str.length())
			return result;
		return "";
	}

	public static void main(String[] args) {
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aab", 2));
		System.out.println("Reorganized string: " + RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
	}
}
