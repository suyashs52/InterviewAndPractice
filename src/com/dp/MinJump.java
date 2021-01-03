package com.dp;

public class MinJump {
	public static void main(String... str) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		int n;

		// 1->3>6->->9->5 is final answer

		System.out.println(recrSol(arr, 0, arr.length - 1));
		System.out.println(dynSol(arr,arr.length));

	}

	public static int recrSol(int[] arr, int f, int l) {
		// get min to reach last from first

		if (f == l)
			return 0; // if first and last equal than reached to last so no where to reach
		if (arr[f] == 0)
			return Integer.MAX_VALUE; // nothing is reachable from first (source)

		int min = Integer.MAX_VALUE;
		// 2 1 3 2 , if i=1,h=3, 1+1=2 arr[2]=3, so a[h] can't reach 2nd condition is
		// the same
		for (int i = f + 1; i <= l && i <= f + arr[f]; i++) {
			int p = recrSol(arr, i, l); // calculate path first i last to l so return 0 if not max, increment path
			if (p != Integer.MAX_VALUE && min > p + 1) {
				min = p + 1;
			}
		}

		return min;

	}

	public static int dynSol(int[] arr, int n) {
		// 1, 3, 6, 3, 2, 3, 6, 8, 9, 5
		// for each index calculate min distance from starting
		// 3 can be 1, for 6 , from 1 0, from 3 it is 1
		// for 2, from 1 -0, 3-0,6-3, 3-4 so min is 3

		// 2 for loop needed

		int[] jumps = new int[n];

		jumps[0] = 0;

		for (int i = 1; i < n; i++) {
				jumps[i] =Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if(jumps[j]!=Integer.MAX_VALUE && j+arr[j]>=i) {
					jumps[i] =Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}

		}

		return jumps[n - 1];
	}

}
