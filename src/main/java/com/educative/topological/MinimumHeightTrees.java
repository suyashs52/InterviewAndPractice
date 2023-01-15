package com.educative.topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class MinimumHeightTrees {
	public static List<Integer> findTrees(int nodes, int[][] edges) {

		Map<Integer, Integer> degree = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nodes; i++) {
			degree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int f = edges[i][0];
			int s = edges[i][1];
			degree.put(f, degree.get(f) + 1);
			degree.put(s, degree.get(s) + 1);
			graph.get(f).add(s);
			graph.get(s).add(f);

		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
			if (entry.getValue() == 1) {
				queue.add(entry.getKey());
			}
		}

		int totalNodes = nodes;
		while (totalNodes > 2) {
			int quesize=queue.size();
			totalNodes -= queue.size();
			for (int q=0;q<quesize;q++) {
				Integer i =queue.poll();
				List<Integer> c=graph.get(i);
				for(int ch:c) {
					degree.put(ch,degree.get(ch)-1);
					if(degree.get(ch)==1) {
						queue.add(ch);
						
					}
				}
				
			}
		}
		
		result.addAll(queue);

		return result;
	}

	public static void main(String[] args) {

		List<Integer> result = MinimumHeightTrees.findTrees(5,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 }, new int[] { 2, 4 } });
		System.out.println("Roots of MHTs: " + result);

		result = MinimumHeightTrees.findTrees(4,
				new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 2, 3 } });
		System.out.println("Roots of MHTs: " + result);

		result = MinimumHeightTrees.findTrees(4,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 } });
		System.out.println("Roots of MHTs: " + result);
	}

}
