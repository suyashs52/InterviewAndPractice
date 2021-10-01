package com.educative.bs;

public class SearchRotatedArray {

	public static int search(int[] arr, int key) {
		int l = -1;

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (key == arr[mid]) {
				return mid;
			}
			// rotated array
			// 10 is always greater than 1,3,8 and less than 15
			if (arr[start] <= arr[mid]) {
				if (key >= arr[start] && key < arr[mid]) {
					end = mid - 1; // key lie in between start and mid
				} else {
					start = mid + 1; // lie between mid+1 to end
				}

			} else {
				// arr[start]>arr[mid] mid is 1
				if (key > arr[mid] && key <= arr[end]) {
					start = mid + 1; // key is 15 so shift end
				} else {
					end = mid - 1;// key is 15
				}
			}

		}

		return start;
	}

	public static void main(String[] args) {
		System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
		System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	}

}
