package com.dp;

public class TrappingWater {
	public static void code() {
		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}
		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i > 0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Math.min(right[i], left[i]) - arr[i];
		}
		System.out.println(sum);

	}
}
