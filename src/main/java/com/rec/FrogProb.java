package com.rec;

import java.util.ArrayList;
import java.util.List;

public class FrogProb {
	public static void main(String... str) {
		//how many path genereated by frog jump
		// frog can travel n cell: i+1,i+2
		// for 5 cell 12345,1235,1245,135,1345
		List<Integer> p = new ArrayList<Integer>();
		p.add(1);
		generate(5, p, new ArrayList<List<Integer>>());

		System.out.println(count(5, 1));
		System.out.println(countdp(5, 1));

	}

	static void generate(int n, List<Integer> path, List<List<Integer>> ans) {

		int i = path.get(path.size() - 1);

		if (n == i) {
			for (Integer k : path) {
				System.out.print(k);
			}
			System.out.println();
			return;
		}
		if (n < i) {

			return;
		}

		path.add(i + 1);
		generate(n, path, ans);
		path.remove(path.size() - 1);

		path.add(i + 2);
		generate(n, path, ans);
		path.remove(path.size() - 1);

	}

	public static int count(int n, int cur) {
		// above function adding recur call 2 time
		// making new path so total is sum of both
		// summing it so return 1 on complete 1+1, not possible than 0
		if (n == cur) {
			return 1;
		}
		if (n < cur)
			return 0;

		return count(n, cur + 1) + count(n, cur + 2);
	}

	public static int countdp(int n, int cur) {
		int[] arr = new int[n];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];

		}
		System.out.println("test");
		System.out.println(arr[n - 1]);
		arr = new int[n];
		arr[n - 1] =1; arr[n - 2] = 2;
		for (int i = n - 3; i > 0; i--) {
			arr[i] = arr[i + 1] + arr[i + 2];
		}

		System.out.println(arr[1]);
		return arr[n - 1];
	}

	public static void travelFrog(int j, int n) {
		int i = 0;
		if (j > n) {
			System.out.println();
			return;
		}
		System.out.print(j);
		while (i <= n) {
			travelFrog(i + 1, n);
			travelFrog(i + 2, n);
			i++;
		}
	}
}
