package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SearchIn2DMatrix {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/search-a-2d-matrix-ii/

		FastScanner fs = new FastScanner();

		int[][] arr = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

		System.out.println(searchMatrix(arr, 5));
		System.out.println(searchMatrix(arr, 20));
		System.out.println(searchMatrix(arr, 10));
		System.out.println(searchMatrix(arr, 9));
		System.out.println(searchMatrix(arr, 17));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		boolean f = false;

		// matrix is sorted row wise ascending and column wise ascending
		//for more soln
		//https://leetcode.com/problems/search-a-2d-matrix-ii/solution/
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j > -1) {
			if(matrix[i][j]==target) {
				return true;
			}
			//1 4 7
			//2 5 8
			//3 6 9
			
			if(matrix[i][j]>target) {
				j--;
			} else { // matrix[i][j]<target search in column so fix j i++
				i++;
			}
			
		}
		return f;

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
