package pp.gu.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class ConnectedComponent {
	public static void main(String[] args) throws java.lang.Exception {
		//https://www.hackerearth.com/problem/algorithm/connected-components-in-a-graph/
		
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String name = br.readLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		// Scanner
		Scanner s = new Scanner(System.in);
		// String name = s.nextLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		// Write your code here

		int n = s.nextInt();
		int e = s.nextInt();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			int f = s.nextInt();
			int se = s.nextInt();

			graph.get(f).add(se);
			graph.get(se).add(f);
		}

		boolean[] visited = new boolean[n + 1];
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (visited[i] == false) {
				dfs(visited, graph, i);
				count++;
			}
		}

		System.out.println(count);

	}

	private static boolean dfs(boolean[] visited, List<List<Integer>> graph, int i) {
		// TODO Auto-generated method stub
		if (visited[i])
			return true;

		visited[i] = true;

		List<Integer> g = graph.get(i);

		for (int c : g) {
			dfs(visited, graph, c);
		}
		
		return visited[i];
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}