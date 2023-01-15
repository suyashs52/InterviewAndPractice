package pp.gu.recur;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class Matrix01 {
	public static void main(String[] args) throws java.lang.Exception {

		int N = 6;
		int[][] mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		mat = updateMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		mat = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		mat = updateMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		mat = new int[][] { { 0 }, { 0 }, { 0 } ,{0}};
		mat = updateMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		mat = new int[][] { { 0 }, { 1}};
		mat = updateMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] mat) {

		// https://leetcode.com/problems/01-matrix/
		Queue<int[]> queue = new LinkedList<int[]>();

		// bfs always give shortest path , starting point is 0 take out all 0 and start

		boolean[][] visited = new boolean[mat.length][mat[0].length];
		int[][] result = new int[mat.length][mat[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (mat[i][j] == 0) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					result[i][j] = 0;
				}
			}

		}
		int[][] path = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
		while (queue.isEmpty() == false) {
			int[] node = queue.poll();

			for (int i = 0; i < path.length; i++) {
				int x = node[0] + path[i][0];
				int y = node[1] + path[i][1];

				if (x < 0 || x > result.length - 1 || y < 0 || y > result[0].length - 1) {
					continue;
				}

				if (visited[x][y] == false) {
					queue.add(new int[] { x, y });
					visited[x][y] = true;
					if (mat[x][y] == 0)
						result[x][y] = 0;
					else {
						result[x][y] = 1 + result[node[0]][node[1]];
					}
				}
			}

		}

		return result;

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