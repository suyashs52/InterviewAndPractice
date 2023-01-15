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
public class CheckCycle {
	public static void main(String[] args) throws java.lang.Exception {
		
		//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
		int v=5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>() {{add(1);}});
		adj.add(new ArrayList<Integer>() {{add(0);add(2);add(4);}});
		adj.add(new ArrayList<Integer>() {{add(1);add(3);}});
		adj.add(new ArrayList<Integer>() {{add(2);add(4);}});
		adj.add(new ArrayList<Integer>() {{add(1);add(3);}});
		
		System.out.println(isCycle(v,adj));
		
		v=4;
		adj = new ArrayList<ArrayList<Integer>>();
		adj.add(new ArrayList<Integer>());
		adj.add(new ArrayList<Integer>() {{add(2);}});
		adj.add(new ArrayList<Integer>() {{add(1);add(3);}});
		adj.add(new ArrayList<Integer>() {{add(2);}}); 
		
		System.out.println(isCycle(v,adj));
		
		 
		
	}
 

	 public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		 
		 int[] pnode=new int[V];
		 for(int i=0;i<V;i++) {
			 if(pnode[i]==0) {
				 Queue<Integer> queue = new LinkedList<>();
				 queue.add(i);
				 pnode[i] =-1;
				 
				 while(queue.isEmpty()==false) {
					 
					 int n=queue.size();
					 
					 for(int k=0;k<n;k++) {
						 Integer node= queue.poll();
						  
						 ArrayList<Integer> ch=adj.get(node);
						 
						 for(Integer c:ch) {
							 
							 if(pnode[c]==0) {
								 queue.add(c);
								 pnode[c]=node;
								  
							 }else {
								 if(pnode[node]!=c) { //node[parent] !=child
									 return true;
								 }
							 }
							  
							  
						 }
						  
					 }
					 
				 }
			 }
		 }
	        
		 return false;
	        
	        
	        
	 }
}