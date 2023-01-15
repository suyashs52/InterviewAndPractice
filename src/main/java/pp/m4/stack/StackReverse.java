package pp.m4.stack;

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
import java.util.Stack;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class StackReverse {
	public static void main(String[] args) throws java.lang.Exception { 
		
		
		Stack<Integer> st = new Stack<>();
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		System.out.println(st);
		rev(st);
		System.out.println(st);
		
	}
// 4 3 2 1 
	private static void rev(Stack<Integer> st) {
		if(st.isEmpty()) return ;
		
		int n=st.pop();
		
		rev(st);
		
		insertAtBottom(st,n);
		 
		
		
		
		
	}

	private static void insertAtBottom(Stack<Integer> st, int n) {
	if(st.empty()) {
		st.add(n);
		
	}else {
		int k=st.pop();
		insertAtBottom(st, n);
		st.add(k);
	}
	
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