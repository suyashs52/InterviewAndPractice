package com.educative.slidingwindow;

public class MinSizeSubArraySum {

	public static int findMinSubArray(int S, int[] arr) {
		if(arr.length==0) return -1;
		int sum = 0;
		int[] arr1 = new int[arr.length];
		int count = 0;
		int width = -1;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - i; j++) {
				arr1[j] += arr[j + i];

				if (arr1[j] >= S) {
					width = i + 1;
				}
			}
		}

		// sliding windows
		// start from index and slide till sum is not greater
		// if greater then slide left pointer

		int left = 0;
		sum = 0;
		int length = 1000;
		for (int right = 0; right < arr.length; right++) {
			sum += arr[right];

			while (sum >= S) { // if we get sum greater than given sum halt right check left
				length = Math.min(length, right - left + 1);
				// +1 due to single element index can be same
				sum -= arr[left++];

			}
		}

		return length;
		//return width;
	}

	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(15, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
	}

}
