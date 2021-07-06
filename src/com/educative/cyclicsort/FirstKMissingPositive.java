package com.educative.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

	public static List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> duplicateNumbers = new ArrayList<>();

		int start = 0;
		Set<Integer> set = new HashSet<Integer>();
		while (start < nums.length) {
			//2, 3, 4 
			if (nums[start] > 0 && nums[start] - 1 < nums.length && nums[nums[start] - 1] != nums[start]) {
				int temp = nums[nums[start] - 1];
				nums[nums[start] - 1] = nums[start];
				nums[start] = temp;
			} else {
				start++;
			}
		}

		int i = 0;
		for (i = 0; i < nums.length && k > 0; i++) {
			if (nums[i] != i + 1) {
				if (nums[i] > 0)
					set.add(nums[i]);
				duplicateNumbers.add(i + 1);
				k--;

			}
		}
		i++;
		while (k > 0) {
			if (!set.contains(i)) {
				duplicateNumbers.add(i);

				k--;
			}
			i++;
		}

		return duplicateNumbers;

	}

	public static void main(String[] arg) {
		System.out.println(FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3));
		System.out.println(FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 4));
		System.out.println(FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3));
		System.out.println(FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 10));
		System.out.println(FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2));

	}

}
