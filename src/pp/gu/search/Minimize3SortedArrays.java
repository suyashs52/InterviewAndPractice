package pp.gu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimize3SortedArrays {
	public static void main(String... strings) {
		// https://www.geeksforgeeks.org/minimize-maxai-bj-ck-minai-bj-ck-three-different-sorted-arrays/
		int[] D = { 5, 8, 10, 15 };
		int[] E = { 6, 9, 15, 78, 89 };
		int[] F = { 2, 3, 6, 6, 8, 8, 10 };
		System.out.println(solve(D, E, F));

	}

	static int solve(int[] a, int[] b, int[] c) {
		int diff = Integer.MAX_VALUE;

		int i = 0, j = 0, k = 0;
		// min the max(a,b,c)-min(a,b,c)
		// can use 3 loop or 3 pointer
		while (i < a.length && j < b.length && k < c.length) {
			int min=Math.min(a[i], Math.min(b[j],c[k]));
			int max=Math.max(a[i], Math.max(b[j], c[k]));
			
			diff=Math.min(diff, max-min);
			
			if(min==a[i]) { //min 
				i++;
			}
			if(min==b[j]) {
				j++;
			}
			if(min==c[k]) {
				k++;
			}
		}
		return diff;
	}

}
