package com.udemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Region {

	public static void main(String[] args) throws Exception {
		System.out.println("test");

		 reader();
		//test();
	}

	private static void reader() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t1 = Integer.parseInt(br.readLine());
		char[][] m1 = new char[t1][t1];

		for (int i = 0; i < t1; i++) {
			m1[i] = br.readLine().toCharArray();
		}

		int t2 = Integer.parseInt(br.readLine());

		char[][] m2 = new char[t2][t2];

		for (int i = 0; i < t2; i++) {
			m2[i] = br.readLine().toCharArray();
		}

		code(m1, m2);
	}

	private static void test() {
		char[][] m1 = { { '0', '1', '0', '0' }, { '1', '0', '0', '1' }, { '0', '0', '1', '1' },
				{ '0', '0', '1', '1' } };
		char[][] m2 = { { '0', '1', '0', '1' }, { '1', '0', '0', '1' }, { '0', '0', '1', '1' },
				{ '0', '0', '1', '1' } };
		code(m1, m2);
	}

	private static void code(char[][] m1, char[][] m2) {
		Map<Coordinate, Integer> mxy2 = countRegion(m2);
		Map<Coordinate, Integer> mxy1 = countRegion(m1);

		System.out.println(mxy1);
		System.out.println(mxy2);
		int count = 0;

		for (Map.Entry<Coordinate, Integer> entry : mxy1.entrySet()) {
			Integer val = mxy2.get(entry.getKey());
			if (val != null && val == entry.getValue())
				count++;
		}
		System.out.println(count);
	}

	static Map<Coordinate, Integer> countRegion(char[][] m) {
		int n = m.length;
		boolean[][] isVisit = new boolean[n][n];
		Map<Coordinate, Integer> mxy = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (m[i][j] == '1' && !isVisit[i][j]) {

					mxy.put(new Coordinate(i, j), navRegion(m, i, j, isVisit));
				}
			}
		}

		return mxy;

	}

	private static int navRegion(char[][] m, int i, int j, boolean[][] isVisit) {
		isVisit[i][j] = true;
		int[] x = new int[] { -1, 0, 0, 1 };
		int[] y = new int[] { 0, -1, 1, 0 };
		int n = m.length;
		int count = 1;
		for (int k = 0; k < 4; k++) {
			if ((i + x[k]) < n && (j + y[k]) < n && (i + x[k]) > -1 && (j + y[k]) > -1 && m[i + x[k]][j + y[k]] == '1'
					&& !isVisit[i + x[k]][j + y[k]]) {
				count = count + navRegion(m, i + x[k], j + y[k], isVisit);
			}
		}
		return count;

	}

}

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o == this) {
			return true;
		}

		if (!(o instanceof Coordinate)) {
			return false;
		}

		Coordinate c = (Coordinate) o;

		// Compare the data members and return accordingly
		return Integer.compare(x, c.x) == 0 && Double.compare(y, c.y) == 0;
	}
	
	

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

}
