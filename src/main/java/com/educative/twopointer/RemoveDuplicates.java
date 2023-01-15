package com.educative.twopointer;

public class RemoveDuplicates {

	public static int remove(int[] arr) {
		int next = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == next) {

			} else {
				arr[index] = arr[i - 1];
				index++;
				next = arr[i];
			}
		}
		

		//inserting last value
		++index;
		arr[index-1] = arr[arr.length - 1];

		return index;

	}

	public static void main(String[] arg) {

		System.out.println(RemoveDuplicates.remove(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
		System.out.println(RemoveDuplicates.remove(new int[] { 2, 2, 2, 11 }));
		System.out.println(RemoveDuplicates.remove(new int[] { 1, 2, 3, 11 }));
		System.out.println(RemoveDuplicates.remove(new int[] { 2, 2, 2, 2 }));

	}

}
