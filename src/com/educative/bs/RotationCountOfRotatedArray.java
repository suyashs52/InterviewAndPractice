package com.educative.bs;

public class RotationCountOfRotatedArray {

	public static int countRotations(int[] arr) {
		int cr = -1;
		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid < end && arr[mid] > arr[mid + 1]) //  mid+1 return null pointer at last so mid<end
				return mid + 1;
			else if (start < mid && arr[mid - 1] > arr[mid]) // mid-1 return null pointer so start <mid
				return mid;
			if (arr[start] <= arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
	}

}
