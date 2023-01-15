package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class MaxPointOnLine {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {
//https://leetcode.com/problems/max-points-on-a-line/
		int[][] points = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };

		System.out.println(maxPoints(points));
		points = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } };

		System.out.println(maxPoints(points));
		points = new int[][] { { 0, 0 }, { 4, 5 }, { 7, 8 }, { 8, 9 }, { 5, 6 }, { 3, 4 }, { 1, 1 } };

		System.out.println(maxPoints(points));

		points = new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 1 } };

		System.out.println(maxPoints(points));

	}

	public static int maxPoints(int[][] points) {

		if (points.length < 3)
			return points.length;
		int max = 0;
		// duplicate value
		// slope
		// -ve slope , parallel x line, y line
		// same point

		// from each point select how many point crossing through that line
		Map<pair, Integer> map = new HashMap();

		int maxpoint = 0;
		for (int i = 0; i < points.length; i++) {
			int common = 1;
			for (int j = i + 1; j < points.length; j++) {

				if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
					common++;

					continue;
				}

				int x = 0;
				int y = 0;

				if (points[j][1] > points[i][1]) {
					x = points[j][0] - points[i][0];
					y = points[j][1] - points[i][1];
				} else {
					x = points[i][0] - points[j][0];
					y = points[i][1] - points[j][1];
				}

				if (y < 0) { // x always negative to match same slope
					y = -y;
					x = -x;

				}

				else if (y == 0) { // parallel to x axis as dy=0
					if (points[j][1] > 0) {
						x = 0;
						y = points[j][1];
					} else { // x -corodinate
						x = 0;
						y = Integer.MAX_VALUE;
					}
				} else if (x == 0) { // parallel to y axis
					if (points[j][0] > 0) {// x value is greater so +ve coordinate
						x = points[j][0]; // |------------
						y = 0; //// ////////|------------
					} else { // points[j][0]=0 y-coordinate
						x = Integer.MAX_VALUE;
						y = 0;
					}
				} else {
					// we have dy/dx case take out GCD of both

					int m1 = Math.abs(x);
					int m2 = Math.abs(y);
					int maxg = Math.max(m1, m2);
					int ming = Math.min(m1, m2);

					m1 = GCD(maxg, ming);
					y = y / m1;
					x = x / m1;

				}

				pair p = new pair(x, y);

				map.put(p, map.getOrDefault(p, 0) + 1);
				maxpoint = Math.max(maxpoint, map.get(p));
			}

			max = Math.max(max, maxpoint + common);
			map.clear();

		}

		return max;
	}

	private static int GCD(int maxg, int ming) {
		if (maxg % ming == 0)
			return ming;

		return GCD(ming, maxg % ming);
	}

	static class pair {
		int x;
		int y;

		private int hashCode;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;

			this.hashCode = Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			pair that = (pair) o;
			return x == that.x && y == that.y;

		}

		@Override
		public int hashCode() {
			return this.hashCode;
		}

		@Override
		public String toString() {
			return " (" + x + "," + y + ") ";

		}
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
