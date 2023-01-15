package com;

public class Testing {

	public static void main(String... args) {

		int[] arr = { 2, 9, 2, 7, 11, 15, 9 };
		int st = 0;
		int end = 0;
		int sum = 9;
		int s = 0;
		while (end < arr.length) {
			s = arr[end];
			while (s > sum && st <= end) {

				s = s - arr[st];
				st++;
			}
			end++;

			System.out.println(st + "," + end);

		}

		// Starting index of
		// sliding window.
		st = 0;

		// Ending index of
		// sliding window.
		end = 0;

		// Sum of elements currently
		// present in sliding window.
		sum = 0;
		int x = 9;
		// To store required
		// number of subarrays.
		int cnt = 0;

		// Increment ending index
		// of sliding window one
		// step at a time.
		int n = arr.length;
		while (end < n) {

			// Update sum of sliding
			// window on adding a
			// new element.
			sum += arr[end];

			// Increment starting index
			// of sliding window until
			// sum is greater than x.
			while (st <= end && sum > x) {
				sum -= arr[st];
				st++;
			}

			// Update count of
			// number of subarrays.
			cnt += (end - st + 1);
			System.out.println("st" + arr[st] + "," + arr[end]);
			end++;
		}

		System.out.println(cnt);

	}

}
