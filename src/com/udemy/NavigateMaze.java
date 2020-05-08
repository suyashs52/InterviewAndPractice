package com.udemy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NavigateMaze {

	public static void code() {
		int n = 3;
		int m = 3;
		int[][] maze = { { 0, 2, 0 }, { 0, 0, 1 }, { 1, 1, 1 } }; // 2
		int x = 1;
		int y = 1;
		System.out.println(navmaz(n, m, maze, x, y));
		n = 3;
		m = 3;
		int[][] maze1 = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 2, 2 } }; // -1
		maze = maze1;
		x = 1;
		y = 1;

		System.out.println(navmaz(n, m, maze, x, y));

		n = 3;
		m = 3;
		int[][] maze2 = { { 0, 2, 1 }, { 1, 2, 0 }, { 1, 0, 0 } };// 4
		maze = maze2;
		x = 2;
		y = 2;
		System.out.println(navmaz(n, m, maze, x, y));

		n = 3;
		m = 3;
		Arrays.asList(new Integer[] { 0, 2, 0 });
		// 5
		List<List<Integer>> mazel = new ArrayList<>();
		mazel.add(Arrays.asList(new Integer[] { 0, 2, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 1, 2 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0 }));

		x = 2;
		y = 1;
		System.out.println(minMoves(mazel, x, y));

		mazel = new ArrayList<>();

		mazel.add(Arrays.asList(new Integer[] { 0, 1, 2, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 2, 0, 0, 1, 0, 2, 2, 0, 0, 2, 0, 2, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 2, 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }));
		x = 3;
		y = 1;
		System.out.println(minMoves(mazel, x, y));

		mazel = new ArrayList<>();

		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 2, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2,
				2, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0,
				0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,
				0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0,
				0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0,
				0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0,
				1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
				1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
				0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
				0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
				1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
				0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,
				0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0 }));
		mazel.add(Arrays.asList(new Integer[] { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));

		x = 37;
		y = 40;
		System.out.println(minMoves(mazel, x, y));

	}

	public static int minMoves(List<List<Integer>> maze, int x, int y) {

		// TODO Auto-generated method stub
		ROW = maze.size();
		COL = maze.get(0).size();
		boolean[][] visited = new boolean[ROW][COL];
		System.out.println("x,y >>>" + x + "," + y);
		visited[0][0] = true;
		Point src = new Point(0, 0);
		Queue<QueueNode> queue = new LinkedList<>();
		QueueNode s = new QueueNode(src, 0);
		queue.add(s);
		int dist = -1;
		while (!queue.isEmpty()) {
			QueueNode cur = queue.peek();
			if (cur.p.x == x && cur.p.y == y) {
				dist = cur.dist;
				break;
			}

			queue.remove();
			boolean is2 = false;
			for (int i = 0; i < 4; i++) {
				int row = cur.p.x + rowNum[i];
				int col = cur.p.y + colNum[i];
				if (isValid(row, col) && !visited[row][col] && maze.get(row).get(col) == 2) {
					visited[row][col] = true;
					QueueNode qn = new QueueNode(new Point(row, col), cur.dist + 1);
					queue.add(qn);
					is2 = true;
				}

			}
			if (is2)
				for (int i = 0; i < 4; i++) {
					int row = cur.p.x + rowNum[i];
					int col = cur.p.y + colNum[i];
					if (isValid(row, col) && !visited[row][col] && maze.get(row).get(col) == 0) {
						maze.get(row).set(col, 1);// = 1;

					}

				}
			else {
				for (int i = 0; i < 4; i++) {
					int row = cur.p.x + rowNum[i];
					int col = cur.p.y + colNum[i];
					if (isValid(row, col) && !visited[row][col] && maze.get(row).get(col) == 0) {
						visited[row][col] = true;
						QueueNode qn = new QueueNode(new Point(row, col), cur.dist + 1);
						queue.add(qn);

					}

				}

			}
		}

//		if (dist > -1) {
//			boolean isbreak = false;
//			for (int i = 0; i < ROW; i++) {
//				for (int j = 0; j < COL; j++) {
//					if (!visited[i][j] && maze.get(i).get(j) == 2) {
//						isbreak = true;
//						dist = -1;
//						break;
//					}
//				}
//				if (isbreak)
//					break;
//			}
//		}
		print(maze);
		print(visited);
		//return dist;
		return -1;

	}

	private static void print(List<List<Integer>> maze) {
		// TODO Auto-generated method stub
		for (List<Integer> li : maze) {
			for (Integer i : li) {
				System.out.print(i);
			}
			System.out.println();

		}

	}

	private static void print(boolean[][] maze) {
		// TODO Auto-generated method stub
		for (boolean[] li : maze) {
			for (boolean i : li) {
				System.out.print(i?"x":"-");
			}
			System.out.println();

		}

	}

	private static int navmaz(int n, int m, int[][] maze, int x, int y) {
		// TODO Auto-generated method stub
		ROW = maze.length;
		COL = maze[0].length;
		boolean[][] visited = new boolean[ROW][COL];
		visited[0][0] = true;
		Point src = new Point(0, 0);
		Queue<QueueNode> queue = new LinkedList<>();
		QueueNode s = new QueueNode(src, 0);
		queue.add(s);
		int dist = -1;
		while (!queue.isEmpty()) {
			QueueNode cur = queue.peek();
			if (cur.p.x == x && cur.p.y == y) {
				dist = cur.dist;
				break;
			}

			queue.remove();
			boolean is2 = false;
			for (int i = 0; i < 4; i++) {
				int row = cur.p.x + rowNum[i];
				int col = cur.p.y + colNum[i];
				if (isValid(row, col) && !visited[row][col] && maze[row][col] == 2) {
					visited[row][col] = true;
					QueueNode qn = new QueueNode(new Point(row, col), cur.dist + 1);
					queue.add(qn);
					is2 = true;
				}

			}
			if (is2)
				for (int i = 0; i < 4; i++) {
					int row = cur.p.x + rowNum[i];
					int col = cur.p.y + colNum[i];
					if (isValid(row, col) && !visited[row][col] && maze[row][col] == 0) {
						maze[row][col] = 1;

					}

				}
			else {
				for (int i = 0; i < 4; i++) {
					int row = cur.p.x + rowNum[i];
					int col = cur.p.y + colNum[i];
					if (isValid(row, col) && !visited[row][col] && maze[row][col] == 0) {
						visited[row][col] = true;
						QueueNode qn = new QueueNode(new Point(row, col), cur.dist + 1);
						queue.add(qn);

					}

				}

			}
		}

		if (dist > -1) {
			boolean isbreak = false;
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					if (!visited[i][j] && maze[i][j] == 2) {
						isbreak = true;
						dist = -1;
						break;
					}
				}
				if (isbreak)
					break;
			}
		}

		return dist;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class QueueNode {
		Point p;
		int dist;

		public QueueNode(Point p, int dist) {
			this.p = p;
			this.dist = dist;
		}
	}

	static int ROW;
	static int COL;
	static int rowNum[] = { -1, 0, 0, 1 };
	static int colNum[] = { 0, -1, 1, 0 };
	int[][] matrix;

	static boolean isValid(int row, int col) {
		return (row > -1 && row < ROW && col > -1 && col < COL);
	}

	public static void main(String[] args) throws IOException {

		code();

		// bufferedReader.close();
	}
}
