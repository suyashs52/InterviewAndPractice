package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class KClosestPointsOrigin {

	public static void main(String... strings) {
//		https://leetcode.com/problems/k-closest-points-to-origin/

		FastScanner fs = new FastScanner();
		//int t = fs.nextInt();

		System.out.println(kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1));
		System.out.println(kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));
	}

	public static int[][] kClosest(int[][] points, int k) {

		int[][] res = new int[k][2];

		int[] dis = new int[points.length];
		int j = 0;
		Triplet[] triple = new Triplet[points.length];

		for (int[] i : points) {

			triple[j] = new Triplet();
			triple[j].dist = i[0] * i[0] + i[1] * i[1];
			triple[j].index = j;
			triple[j].x = i[0];
			triple[j].y = i[1];
			j++;
		}
		Comparator<Triplet> comp= new Comparator<KClosestPointsOrigin.Triplet>() {
			
			@Override
			public int compare(Triplet o1, Triplet o2) {

				if (o1.dist < o2.dist) {
					return -1;
				}
				if (o1.dist > o2.dist) {
					return 1;
				} else {
					return Integer.compare(o1.x, o1.y);
				}
			
			}
		};

		Arrays.sort(triple,comp);

		for (int i = 0; i < k; i++) {
			res[i][0] = triple[i].x;// [0];
			res[i][1] = triple[i].y;
		}
		return res;

	}

	static class Triplet   {
		int dist;
		int index;
		int x;
		int y;

		  
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
