package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NOKIA {
	public static int t2;

	public static void code() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			String[] inp1 = br.readLine().split(" ");
			int t1 = Integer.parseInt(inp1[0]);
			t2 = Integer.parseInt(inp1[1]);
			isFound = false;
			 max = -1;
			int[] a = new int[t1 + 1];
			for (int j = 1; j < a.length; j++) {
				a[j] = j;
			}
			try {
				permute(a, 1, a.length - 1);
			}catch(NumberFormatException ex) {
				System.out.println(0);
				isFound=true;
			}
			
			if (isFound)
				isFound=true;
			else if (max < t2) {
				System.out.println( t2-max);
			} else {
				System.out.println(-1);
			}
		}

	}

	static boolean isFound = false;
	static int max = -1;

	public static int permute(int[] a, int l, int r) throws NumberFormatException {
		int found = 0;
		if (isFound)
			return 0;
		if (l == r) {
			/*
			 * for (int j = 1; j < a.length; j++) { System.out.print(a[j]); }
			 * System.out.println();
			 */
			int left = 0, right = a[a.length - 2] + 1;
			int rope = 0;
			boolean[] c = new boolean[a.length + 1];
			c[0] = true;
			c[c.length - 1] = true;
			for (int j = 1; j < a.length; j++) {
				c[a[j]] = true;
				for (int i = a[j] - 1; i > 0; i--) {
					if (c[i]) {
						left = i;
						c[i] = true;

						break;
					}
				}
				for (int i = a[j] + 1; i < c.length; i++) {
					if (c[i]) {
						right = i;
						c[i] = true;
						break;
					}
				}
				rope += (a[j] - left) + (right - a[j]);
			}
			if (rope == t2) {
				isFound = true;
				max = rope;
				throw new NumberFormatException();
			} else if (max < rope)
				max = rope;

		} else
			for (int i = l; i <= r; i++) {
				if (isFound)
					break;
				a = swap(a, l, i);
				permute(a, l + 1, r);
				a = swap(a, l, i);
			}
		return found;

	}

	private static int[] swap(int[] a, int l, int i) {
		// TODO Auto-generated method stub
		if(isFound) return a;
		int temp = a[l];
		a[l] = a[i];
		a[i] = temp;

		return a;

	}
}
