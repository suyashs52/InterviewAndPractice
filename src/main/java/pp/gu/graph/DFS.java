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
public class DFS {
	public static void main(String[] args) throws java.lang.Exception { 
		
	}

	 public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
	        // Code here
		 ArrayList<Integer> node= new ArrayList<Integer>();
		 boolean [] visited =new boolean[V];
		 dfs(visited,adj,node,0);
		 
		 System.out.println(node);
		 
		 return node;
	    }
	private void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> node, int i) {
		// TODO Auto-generated method stub
		if(visited[i]) return; //o(1)
		
		visited[i] =true; //o(n)
		node.add(i);
		ArrayList<Integer> n=adj.get(i);
		
		for(Integer nn:n) { //child node: max can be n so rec code will run n time only
			dfs(visited,adj,node,nn); //rec ll be of edge
		}
		
		//total is o(n+e)
		//this function call n time for loop run O(1) time when no edge if edge then
		// run edge time for each edge it is of constant value if node is visited
		//no multiplication O(N+E)
		
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