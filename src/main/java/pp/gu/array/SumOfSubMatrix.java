package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SumOfSubMatrix {
	public static void main(String[] args) throws java.lang.Exception {
		// geeksforgeeks.org/sum-of-all-submatrices-of-a-given-matrix/

		FastScanner fs = new FastScanner();

		int[][] arr = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(matrixSum(arr));
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
