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

public class GridIllumination {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {
//https://leetcode.com/problems/grid-illumination/
		int n = 5;
		int[][] lamps = new int[][] { { 0, 0 }, { 4, 4 } };
		int[][] queries = new int[][] { { 1, 1 }, { 1, 0 } };
		gridIllumination(n, lamps, queries);

		n = 5;
		queries = new int[][] { { 1, 1 }, { 1, 1 } };
		lamps = new int[][] { { 0, 0 }, { 4, 4 } };
		gridIllumination(n, lamps, queries);

		n = 5;
		lamps = new int[][] { { 0, 0 }, { 1, 0 } };
		queries = new int[][] { { 1, 1 }, { 1, 1 } };
		gridIllumination(n, lamps, queries);
		gridIllumination1(n, lamps, queries);
	}

	public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		int[] result = new int[queries.length];
		if (queries.length == 0)
			return result;
		if (lamps.length == 0)
			return result;
		// let light is at 0,3
		// 0 1 0 1
		// 0 0 1 0
		// 0 1 0 1
		// 1 0 0 0

		// 0,1 --1,2--2,3 for light at 1,2 it means i-j =-1 for this case so i-j is
		// unique for right diagonal
		// 0,3 -- 1,2 -- 2,1 3,0 ---so i+j is :3 for 1,2 that is unique
		// i-j for right diagonal, i+j for left diagonal
		// i-j max value: n-1-0=n-1 min value: 0-(n-1) so range is from -(n-1) to (n-1)
		// i+j min is 0 max is 2n-2

		boolean[] row = new boolean[n];
		boolean[] col = new boolean[n];
		boolean[] iminusj = new boolean[2 * n];
		boolean[] iplusj = new boolean[2 * n];
		int[][] matrix = new int[n][n];
		for (int k = 0; k < lamps.length; k++) {
			row[lamps[k][0]] = true;
			col[lamps[k][1]] = true;
			iminusj[n - 1 + lamps[k][0] - lamps[k][1]] = true;
			iplusj[lamps[k][0] + lamps[k][1]] = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (row[i] || col[j] || iminusj[n - 1 + i - j] || iplusj[i + j]) {
						matrix[i][j]++;
					}
				}
			}
			// backtrack
			row[lamps[k][0]] = false;
			col[lamps[k][1]] = false;
			iminusj[n - 1 + lamps[k][0] - lamps[k][1]] = false;
			iplusj[lamps[k][0] + lamps[k][1]] = false;

		}

		int[][] valid = new int[][] { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { 1, 1 },
				{ -1, 1 }, { 1, -1 } };

		for (int i = 0; i < queries.length; i++) {
			int r = queries[i][0];
			int c = queries[i][1];
			if (matrix[r][c] > 0) {
				result[i] = 1;

				for (int j = 0; j < valid.length; j++) {
					int vr = r + valid[j][0];
					int vc = c + valid[j][1];

					if (vr < 0 || vc < 0 || vr > n - 1 || vc > n - 1)
						continue;
					matrix[vr][vc]--;

					if (row[vr] && col[vc]) { // if actual light is turned off it means it impacts also //so matrix is
												// not working check next func logic

					}

				}

			} else {
				result[i] = 0;
			}
		}

		return result;
	}

	public static int[] gridIllumination1(int n, int[][] lamps, int[][] queries) {
		// Lights that are turned on. Identified by the entry number
		// entry = n*i + j
		Set<Long> lights = new HashSet<>();
		// columns/vertical lines
		Map<Integer, Integer> cols = new HashMap<>();

		// rows/horizontal lines
		Map<Integer, Integer> rows = new HashMap<>();

		// k-diagonals: from up left to lower right
		Map<Integer, Integer> kDiagonals = new HashMap<>();

		// skew-diagonals: from up right to lower left
		Map<Integer, Integer> skewDiagonals = new HashMap<>();

		// populate the hashmaps based on the lights that are turned on
		for (int[] lamp : lamps) {
			int r = lamp[0], c = lamp[1];
			long light = (long) (n * r + c);
			if (lights.contains(light))
				continue;

			lights.add(light);
			cols.put(c, cols.getOrDefault(c, 0) + 1);
			rows.put(r, rows.getOrDefault(r, 0) + 1);
			kDiagonals.put(r - c, kDiagonals.getOrDefault(r - c, 0) + 1);
			skewDiagonals.put(r + c, skewDiagonals.getOrDefault(r + c, 0) + 1);
		}

		int[] result = new int[queries.length];
		int index = 0;
		int[][] vectors = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, -1 },
				{ -1, 1 } };

		// evaluate the queries
		for (int i = 0; i < queries.length; i++) {

			int r = queries[i][0], c = queries[i][1];
			boolean turnedOn = cols.getOrDefault(c, 0) > 0 || rows.getOrDefault(r, 0) > 0
					|| kDiagonals.getOrDefault(r - c, 0) > 0 || skewDiagonals.getOrDefault(r + c, 0) > 0;
			result[i] = turnedOn ? 1 : 0;

			// turn off the light and its neighbours if turned on
			for (int[] v : vectors) {
				int rr = r + v[0], cc = c + v[1];
				long light = (long) (n * rr + cc);

				if (rr < 0 || rr >= n || cc < 0 || cc >= n)
					continue;
				if (!lights.contains(light))
					continue;

				lights.remove(light);
				reduce(cols, cc);
				reduce(rows, rr);
				reduce(kDiagonals, rr - cc);
				reduce(skewDiagonals, rr + cc);
			}

		}

		return result;
	}

	private static void reduce(Map<Integer, Integer> map, int key) {
		map.put(key, map.getOrDefault(key, 0) - 1);
		if (map.get(key) < 1)
			map.remove(key);
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
