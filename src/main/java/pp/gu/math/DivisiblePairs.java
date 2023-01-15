package pp.gu.math;

import java.util.*;
import java.lang.*;
import java.io.*;

public class DivisiblePairs {
	public static void main(String[] args) throws java.lang.Exception {
		// leetcode.com/problems/sum-of-beauty-in-the-array/

		int[] arr = new int[] { 1, 2, 3 };
		System.out.println(sumOfBeauties(arr));
		arr = new int[] { 2, 4, 6, 4 };
		System.out.println(sumOfBeauties(arr));
		arr = new int[] { 3, 48, 33, 17, 21, 95, 24, 67, 89, 1, 50, 76, 6, 32, 20, 5, 1, 45, 79, 81, 96, 96, 15, 37, 44,
				63, 4, 40, 58, 71, 99, 78, 95, 6, 34, 97, 52, 80, 91, 20, 61, 29, 12, 85, 88, 41, 14, 4, 58, 17, 67, 75,
				100, 51, 63, 66, 42, 19, 44, 34, 34, 78, 54, 84, 3, 90, 72, 18, 86, 8, 33, 5, 17, 21, 22, 13, 59, 82,
				30, 66, 91, 5, 32, 30, 92, 57, 10, 33, 11, 76, 30, 80, 80, 91, 47, 33 };
		System.out.println(sumOfBeauties(arr));
//		arr = new int[] { 3, 2, 1 };
//		System.out.println(sumOfBeauties(arr));

	}

	public static int sumOfBeauties(int[] nums) {
		int k = 0;

		int[] suffMin = new int[nums.length];
		int min = Integer.MAX_VALUE;
		for (int j = nums.length - 1; j > -1; j--) {
			min = Math.min(nums[j], min);
			suffMin[j] = min;
		}

		int max = nums[0];
		int b = 0;
		for (int i = 1; i <= nums.length - 2; i++) {
			max = Math.max(max, nums[i - 1]);
			if (max < nums[i] && nums[i] < suffMin[i + 1]) {
				System.out.println("2->" + max + "," + nums[i] + "," + suffMin[i + 1]);
				b += 2;
			} else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
				System.out.println("1->" + nums[i - 1] + "," + nums[i] + "@@" + nums[i] + "," + nums[i + 1]);
				b += 1;

			}
		}
		return b;
	}

}
