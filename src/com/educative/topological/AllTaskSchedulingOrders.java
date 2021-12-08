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

public class AllTaskSchedulingOrders {
	public static void printOrders(int tasks, int[][] prerequisites) {

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

		List<Integer> sortedOrder = new ArrayList<Integer>();

		printAllSorts(indegree, graph, queue, sortedOrder);

	}

	static void printAllSorts(Map<Integer, Integer> indegree, Map<Integer, List<Integer>> graph, Queue<Integer> queue,
			List<Integer> sortedOrder) {

		if (indegree.size() == sortedOrder.size()) {
			System.out.println(sortedOrder);

		}
		if (queue.isEmpty())
			return;
//		System.out.println("q" + queue);
//		System.out.println("s" + sortedOrder);
//		System.out.println();
		for (Integer s : queue) {
			sortedOrder.add(s);
			Queue<Integer> copyqueue = copyQueue(queue);
			copyqueue.remove(s); // remove the element and add children, current added to sorted list

			List<Integer> child = graph.get(s);

			for (Integer c : child) {
				indegree.put(c, indegree.get(c) - 1);

				if (indegree.get(c) == 0) {
					copyqueue.add(c);
				}
			}

			// recursive call to add next element in sorted order
			printAllSorts(indegree, graph, copyqueue, sortedOrder);

			// backtrack -revert the changes
			sortedOrder.remove(s);
			for (Integer c : child) {
				indegree.put(c, indegree.get(c) + 1);

			}

		}

	}

	static Queue<Integer> copyQueue(Queue<Integer> queue) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (Integer q1 : queue)
			q.add(q1);

		return q;
	}

	public static void main(String[] args) {
//
//		AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
//		System.out.println();
//
//		AllTaskSchedulingOrders.printOrders(4,
//				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
//		System.out.println();

		AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
				new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println();
	}

}
