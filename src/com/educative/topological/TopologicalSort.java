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

public class TopologicalSort {
	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();

		HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		Queue<Integer> source = new LinkedList<>();

		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				source.add(entry.getKey());
			}
		}

		while (source.isEmpty() == false) {
			int vertex = source.poll();
			sortedOrder.add(vertex);
			List<Integer> children = graph.get(vertex);
			for (Integer c : children) {
				inDegree.put(c, inDegree.get(c) - 1);
				if (inDegree.get(c) == 0) {
					source.add(c);
				}
			}

		}

		if (sortedOrder.size() != vertices) {
			return new ArrayList<Integer>();
		}

		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = TopologicalSort.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);

		try {
			asyncOper();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void asyncOper() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10); // it's just an arbitrary number
		final List<Future<?>> futures = new ArrayList<>();
		final List<String> list = Collections.synchronizedList(new ArrayList<String>());
		List<String> l = new ArrayList<>();
		for (int i = 0; i < 100; i++) {

			Future<?> future = executor.submit(() -> {
				populateList(list);
			});
			futures.add(future);
		}

		for (Future<?> future : futures) {
			System.out.println("----------------------");
			future.get(); // do anything you need, e.g. isDone(), ...
		}
		System.out.println("123----------------------");
		l = list;
		for (int i = 0; i < list.size(); i++) {
			if (!l.get(i).equals(list.get(i))) {
				System.out.println(l.get(i));
			}

		}
		System.out.println(list.size());
		System.out.println("098----------------------");

		CountDownLatch cdl = new CountDownLatch(10);
		final  List<String>  list1 = Collections.synchronizedList(new ArrayList<String>());
		for (int i = 0; i < 10; i++) {
			executor.execute(() -> {
				populateList(list1);
				cdl.countDown();
			});
		}

		cdl.await();

		System.out.println(list1.size());
		System.out.println("097----------------------");
		 
		executor.shutdown();

		 

	}

	private static void populateList(List<String> list) {

		for (int i = 0; i < 100; i++) {
			list.add(i + Thread.currentThread().getName());

		}

	}

}
