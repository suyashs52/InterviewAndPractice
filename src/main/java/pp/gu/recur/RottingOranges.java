package pp.gu.recur;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class RottingOranges {
	public static void main(String[] args) throws java.lang.Exception {

		int N = 6;
		int[][] mat = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int m = orangesRotting(mat);
		System.out.println(m);
		mat = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		System.out.println(orangesRotting(mat));
		mat = new int[][] { { 0, 2 } };
		System.out.println(orangesRotting(mat));
		mat = new int[][] { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		System.out.println(orangesRotting(mat));

	}

	private static int orangesRotting(int[][] mat) {
		// https://leetcode.com/problems/rotting-oranges/
		int result = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 2) {
					queue.add(new int[] { i, j });

				}
			}

		}
		int[][] path = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

		while (queue.isEmpty() == false) {
			boolean found = false;
			int n = queue.size();
			for (int k = 0; k < n; k++) {

				int[] node = queue.poll();

				for (int i = 0; i < path.length; i++) {
					int x = node[0] + path[i][0];
					int y = node[1] + path[i][1];

					if (x < 0 || x > mat.length - 1 || y < 0 || y > mat[0].length - 1 || mat[x][y] == 0) {
						continue;
					}

					if (mat[x][y] == 1) {
						found = true;
						queue.add(new int[] { x, y });
						mat[x][y] = 2;

					}

				}
			}

			if (found)
				result++;

		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					return -1;

				}
			}

		}

		return result;
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

				if (x < 0 || x > result[0].length - 1 || y < 0 || y > result[0].length - 1) {
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