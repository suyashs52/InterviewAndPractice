package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RangeSumQuery {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/range-sum-query-2d-immutable/

		FastScanner fs = new FastScanner();

		int[][] arr = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix(arr);
		System.out.println(sumRegion(2, 1, 4, 3));
		System.out.println(sumRegion(1, 1, 2, 2));
		System.out.println(sumRegion(1, 2, 2, 4));

	}

	static int[][] prefixSum;

	public static void NumMatrix(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		prefixSum = new int[n][m];
		for (int i = 0; i < n; i++) { // row wise sum
			prefixSum[i][0] = matrix[i][0];
			for (int j = 1; j < m; j++) {
				prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
			}
		}
		for (int i = 0; i < m; i++) { // column wise sum
			// prefixSum[0][i] = prefixSum[0][i];
			for (int j = 1; j < n; j++) {
				prefixSum[j][i] = prefixSum[j][i] + prefixSum[j - 1][i];
			}
		}
	}

	public static int sumRegion(int row1, int col1, int row2, int col2) {

		// 1 2 3
		// 5 6 7
		// 9 1 2
		// prefex sum at (2,0)=1+5+9, sum at (0,2)=1+2+3
		// sum at (2,2) = 6+7+1+2+ 1+2+3+5+9
		// sum from 1,1 to 22 is 6+7+1+2+ 1+2+3+5+9 -(1+5+9)-(1+2+3)+1

		// sum from (1,1)-(2,2)

		int sum = prefixSum[row2][col2];
		if (row1 > 0) {
			sum -= prefixSum[row1 - 1][col2];
		}
		if (col1 > 0) {
			sum -= prefixSum[row2][col1 - 1];
		}
		if (row1 > 0 && col1 > 0) {
			sum += prefixSum[row1 - 1][col1 - 1];
		}

		return sum;

	}

	static int matrixSum(int arr[][]) {
		int sum = 0;
		// we need to understand each element is part of how many elements
		// that end at index, and start of index
		// so total element part of it is multiplication of both if want sum
		// multiply iwth value at index--it ll contribute the same same in total sum
		// for (0,0)=> element start: is 1,1 element is 1 ending for 3*3 is 3-0*3-0=9
		// elment
		// for(0,1) => 1*2=2 end at this index,3*2=6 start from this index draw diagram
		// you ll understand

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += (i + 1) * (j + 1) * (arr.length - i) * (arr[0].length - j) * arr[i][j];
			}
		}
		// https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
		// check for opti version
		return sum;
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
