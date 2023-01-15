package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BooleanMatrix {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {
//https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1
		int[][] matrix = new int[][] { { 1, 0 }, { 0, 0 } };
		booleanMatrix(matrix);
	}

	static void booleanMatrix(int matrix[][]) {
		int row = matrix.length;
		int col = matrix[0].length;

		int[] rowarr = new int[row];
		int[] colarr = new int[col];
		// store row and colm value in index if it appear in a pass put value as 1
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					rowarr[i] = 1;
					colarr[j] = 1;
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rowarr[i] == 1 || colarr[j] == 1) {
					matrix[i][j] = 1;
				}
			}
		}

		System.out.println(matrix);
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
