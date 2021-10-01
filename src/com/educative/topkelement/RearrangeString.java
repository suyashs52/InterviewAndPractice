package com.educative.topkelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeString {

	public static String rearrangeString(String str) {
		String result = "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(n1, n2) -> n2.getValue() - n1.getValue());
		maxHeap.addAll(map.entrySet());
		Map.Entry<Character, Integer> prev = null;
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> curr = maxHeap.poll();
			
			result += curr.getKey();
			curr.setValue(curr.getValue() - 1);
			if (prev != null && prev.getValue() > 0) {
				 maxHeap.add(prev);
			}
			prev = curr;
		}
		if(str.length()==result.length()) {
			return result;
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
		System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
	}
}
