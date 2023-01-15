package com.educative.topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskScheduling {
	public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

		List<Integer> list = new ArrayList<Integer>();
		boolean isTask = false;

		Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < tasks; i++) {
			indegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int p = prerequisites[i][0];
			int c = prerequisites[i][1];
			List l = graph.get(p);
			l.add(c);
			indegree.put(c, indegree.get(c) + 1);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		System.out.println(queue.size());
		while (queue.isEmpty() == false) {
			int a = queue.poll();
			list.add(a);
			List<Integer> c = graph.get(a);
			for (Integer i : c) {
				indegree.put(i, indegree.get(i) - 1);
				if (indegree.get(i) == 0) {
					queue.add(i);
				}
			}

		}
		
		return list.size()==tasks;

		//sreturn isTask;
	}

	public static void main(String[] args) {

		boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println("Tasks execution possible: " + result);

		result = TaskScheduling.isSchedulingPossible(3,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		System.out.println("Tasks execution possible: " + result);

		result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
				new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println("Tasks execution possible: " + result);
	}

}
