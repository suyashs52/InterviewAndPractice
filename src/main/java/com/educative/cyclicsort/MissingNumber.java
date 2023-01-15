package com.educative.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumber {

	public static List<Integer> findNumbers(int[] nums) {
		List<Integer> duplicateNumbers = new ArrayList<>();

		// numbers missing are from 1 t0 n
		int start = 0;
		while (start < nums.length) {
			if (nums[nums[start] - 1] != nums[start]) {
				int temp = nums[nums[start] - 1];
				nums[nums[start] - 1] = nums[start];
				nums[start] = temp;

			} else {
				start++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i) {
				duplicateNumbers.add(nums[i]);
			}
		}

		return duplicateNumbers;

	}

	public static void main(String[] arg) {

		System.out.println(MissingNumber.findNumbers(new int[] { 3, 4, 4, 5, 5 }));
		System.out.println(MissingNumber.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 }));

	}

}
