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

/* Name of the class has to be 'Main' only if the class is public. */
public class NumIslands {
	public static void main(String[] args) throws java.lang.Exception {
System.out.print("test");
        // your code goes here
		FastScanner fs= new FastScanner();
	int size=	fs.nextInt();
		int [] arr=new int[size];
		for(int i=0;i<size;i++){
			arr[i]=fs.nextInt();
		}
		int count=fs.nextInt();
		
		int [] found= new  int[count];
		
		for(int i=0;i<count;i++){
			found[i] =fs.nextInt();
		}
		for(int i=0;i<count;i++){
			System.out.println(findIndex(arr,found[i]));
		}
	
	
	}
	
	static int findIndex(int [] arr,int value){
		int index=-1;
		
		int start=0;
		int end= arr.length;
		
		while(start<=end){
			int mid=start+(end-start)/2;
			
			if(arr[mid]==value){
				return mid;
			}else if(arr[mid]<value){
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
		
		return index;
	}

	private static boolean dfs(char[][] g, int m, int n) {

		if (m < 0 || m > g.length - 1 || n < 0 || n > g[0].length - 1)
			return false;
		if (g[m][n] == '0') {
			return false;
		}

		g[m][n] = '0';

		dfs(g, m + 1, n);
		dfs(g, m, n + 1);
		dfs(g, m - 1, n);
		dfs(g, m, n - 1);
		return false;
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