package pp.gu.recur;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class KnightWalk {
	public static void main(String[] args) throws java.lang.Exception {

		int N = 6;
		int[] knightPos = new int[] { 4, 5 };
		// int[] targetPos = new int[] { 6, 6 };
		int[] targetPos = new int[] { 1, 1 };

		System.out.println(knightwalkbfs(N, knightPos, targetPos));
		knightPos = new int[] { 4, 5 };
		targetPos = new int[] { 1, 1 };
		knightwalk(N, knightPos, targetPos);
		// knight move 2,1/1,2 in each direction, so there is 8 direction
		// (1,2) is mirror image of (1,-2),(-1,2) vertically and diagonally
		// so value at this 3 location is same now for (i+-1,j+-2) (i+-2,j+-1) can have
		// same value for(i+2,j+1)
		// move init pos to 0,0 and target position to relative coordinate
		// mirror target pos to 1st coordinate
		// for termination condition we can have max value at 3*3 matrix is (1+2)
		// checking possible move in those coordinate
		// 0 1 2
		// 0 0 3 2
		// 1 3 2 1
		// 2 2 1 4
		// we see when i,j is (0,1) || (1,0) value is 3; (0,0):0, (1,1) (0,2) (1,1)
		// (2,0) is 2
		// (2,2)- 1+min((1,0),(0,1)-4,(2,1) is : 1+ f(0,0)-1
		// i+j=1-3, x+y=0-0,x+y=2:2
		// it is symmetrical to diagonal too
		knightPos = new int[] { 4, 5 };
		targetPos = new int[] { 1, 1 };
		targetPos[0] -= knightPos[0];
		targetPos[1] -= knightPos[1];
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("0,0", 0);
		int value = dfsonecoordinate(N, knightPos, targetPos, map);
		System.out.println(value);

	}

	private static int knightwalkbfs(int n, int[] knightPos, int[] targetPos) {
		int ans = -1;

		boolean[][] isvisited = new boolean[n][n];
		int[][] isvalid = new int[][] { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
				{ 2, -2 } };
		knightPos[0]--;
		knightPos[1]--;
		targetPos[0]--;
		targetPos[1]--;

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { knightPos[0], knightPos[1], 0 });
		isvisited[knightPos[0]][knightPos[1]] = true;
		boolean found = false;
		while (queue.isEmpty() == false) {
			int[] temp = queue.poll();
			if (temp[0] == targetPos[0] && temp[1] == targetPos[1]) {

				return temp[2];
			}
			for (int i = 0; i < isvalid.length; i++) {

				int l = temp[0] + isvalid[i][0];
				int k = temp[1] + isvalid[i][1];
				if (l < 0 || k < 0 || l > n - 1 || k > n - 1) {
					continue;
				}
				if (isvisited[l][k] == false) {
					queue.add(new int[] { l, k, temp[2] + 1 });
					isvisited[l][k] = true;
				}
			}

		}

		return -1;
	}

	private static int knightwalk(int n, int[] knightPos, int[] targetPos) {
		// https://practice.geeksforgeeks.org/problems/knight-walk4521/1
		knightPos[0]--;
		knightPos[1]--;
		targetPos[0]--;
		targetPos[1]--;

		int[][] isvalid = new int[][] { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { -2, -1 }, { -2, 1 }, { 2, -1 },
				{ 2, -2 } };

		int[][] trav = new int[n][n];
		for (int i = 0; i < trav.length; i++) {
			for (int j = 0; j < n; j++) {
				trav[i][j] = Integer.MAX_VALUE;
			}
		}

		dfsf(isvalid, knightPos, targetPos, trav, 0);
		System.out.println(trav[targetPos[0]][targetPos[1]]);
		return -1;

	}

	private static int dfsf(int[][] isvalid, int[] knightPos, int[] targetPos, int[][] trav, int curr) {
		if (knightPos[0] < 0 || knightPos[1] < 0 || knightPos[0] > trav.length - 1 || knightPos[1] > trav.length - 1)
			return -1;
		if (trav[knightPos[0]][knightPos[1]] <= curr) {
			return -1;
		}
		if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
			trav[knightPos[0]][knightPos[1]] = Math.min(curr, trav[knightPos[0]][knightPos[1]]);
			return -1;

		}

		trav[knightPos[0]][knightPos[1]] = Math.min(curr, trav[knightPos[0]][knightPos[1]]);

		for (int i = 0; i < isvalid.length; i++) {

			knightPos[0] = knightPos[0] + isvalid[i][0];
			knightPos[1] = knightPos[1] + isvalid[i][1];

			dfsf(isvalid, knightPos, targetPos, trav, curr + 1);

			knightPos[0] = knightPos[0] - isvalid[i][0];
			knightPos[1] = knightPos[1] - isvalid[i][1];

		}

		return -1;

	}

	static int dfsonecoordinate(int n, int[] knightPos, int[] targetPos, Map<String, Integer> map) {
		// reaching to 0 is better so manipulate targetpos
		int x = 0;
		targetPos[0] = Math.abs(targetPos[0]);
		targetPos[1] = Math.abs(targetPos[1]);

		if (targetPos[0] + targetPos[1] == 0) // reached destination
			return 0;
		if (targetPos[0] + targetPos[1] == 2)
			return 2;
		if (targetPos[0] + targetPos[1] == 1)
			return 3;

		String key = targetPos[0] + "," + targetPos[1];
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int m = 1 + Math.min(dfsonecoordinate(n, knightPos, new int[] { targetPos[0] - 1, targetPos[1] - 2 }, map),
				dfsonecoordinate(n, knightPos, new int[] { targetPos[0] - 2, targetPos[1] - 1 }, map));
		map.put(key, m);
		return m;

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