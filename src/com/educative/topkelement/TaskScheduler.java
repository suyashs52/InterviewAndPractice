package com.educative.topkelement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static int scheduleTasks(char[] tasks, int k) {
		int s = 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// aaabcc has acbacida --so k=2 acb
		PriorityQueue<Map.Entry<Character, Integer>> maxheap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(n1, n2) -> n2.getValue() - n1.getValue());

		maxheap.addAll(map.entrySet());

		while (maxheap.isEmpty() == false) {
			List<Map.Entry<Character, Integer>> list = new ArrayList<>();
			// abc
			int n = k + 1;
			for (; n > 0 && maxheap.isEmpty() == false; n--) {
				Map.Entry<Character, Integer> m = maxheap.poll();
				s++;
				m.setValue(m.getValue() - 1);
				if (m.getValue() > 1) //empty means==1
					
					list.add(m);

			}

			if (n > 0) { // if maxheap has done k iter, now empty but n is not completed k+1 time
				s += n+1;
			}
			 
				maxheap.addAll(list);
		}

		return s;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

		tasks = new char[] { 'a', 'b', 'a' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
	}
}
