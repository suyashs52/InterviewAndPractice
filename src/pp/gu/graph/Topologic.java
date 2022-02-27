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

import com.jav.ArryAnargram;

/* Name of the class has to be 'Main' only if the class is public. */
public class Topologic {
	public static void main(String[] args) throws java.lang.Exception { 
		//https://practice.geeksforgeeks.org/problems/topological-sort/1
		
		int v=4;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<Integer>());
		}
		adj.get(1).add(0);
		adj.get(2).add(0);
		adj.get(3).add(0);
		
		int[] degree= new int[v];
		
		for(int i=0;i<v;i++) {
			
			List<Integer> c=adj.get(i);
			
			for(int j:c) {
				degree[j]++;
			}
		}
		
		Queue<Integer> queue= new LinkedList<Integer>();
		for(int i=0;i<v;i++) {
			if(degree[i]==0) {
				queue.add(i);
			}
		}
		List<Integer> res=new ArrayList<Integer>();
		while(queue.isEmpty()==false) {
			Integer a=queue.poll();
			res.add(a);
			List<Integer> ch=adj.get(a);
			for(int c:ch) {
				degree[c]--;
				if(degree[c]==0) {
					queue.add(c);
				}
			}
		}
		
		System.out.println(res);
		
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