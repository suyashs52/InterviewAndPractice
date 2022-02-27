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
public class CheckDirectedCycle {
	public static void main(String[] args) throws java.lang.Exception {

		// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
		
		//dfs traverse a path if we meet a cycle visited node traverse twice
		//if set in path each node has value 1 so 1 we got again
		//if not found set each node as value 2 so we can't traver that path again
		int v = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>() {
			{
				add(1);
			}
		});
		adj.add(new ArrayList<Integer>() {
			{
				add(2);
			}
		});
		adj.add(new ArrayList<Integer>() {
			{
				add(3);
			}
		});
		adj.add(new ArrayList<Integer>() {
			{
			//	add(3);
			}
		});

		System.out.println(isCycle(v, adj));

		v = 4;
		adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>());
		adj.add(new ArrayList<Integer>() {
			{
				add(2);
			}
		});
		adj.add(new ArrayList<Integer>() {
			{
				add(1);
				add(3);
			}
		});
		adj.add(new ArrayList<Integer>() {
			{
				add(2);
			}
		});

		System.out.println(isCycle(v, adj));

	}

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] visited = new int[V];
		boolean iscyc = false;
		for (int i = 0; i < adj.size(); i++) {
			if (visited[i] == 0)
				iscyc = dfs(adj, i, visited);

			if (iscyc == true)
				return true;

		}

		return false;

	}

	static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, int[] visited) {
		if (visited[i] == 2)
			return false;
		if (visited[i] == 1)
			return true;
		visited[i] = 1;
		
		ArrayList<Integer> ch=adj.get(i);
		boolean iscycle=false;
		for(Integer c:ch) {
			if(dfs(adj,c,visited)) {
				iscycle=true;
				break;
			}
		}
		
		visited[i]=2;
		
		return iscycle;
	

	}

}