package pp.gu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadriplet4Sum {
	public static void main(String... strings) {
		// https://leetcode.com/problems/4sum/
		int[] arr = new int[] { 1, 0, -1, 0, -2, 2 };

		int x = 0;
		System.out.println(fourSum(arr, x));

		arr = new int[] { 2, 2, 2, 2, 2 };
		x = 8;
		System.out.println(fourSum(arr, x));

		arr = new int[] { 0, 0, 0, 0 };
		x = 0;
		System.out.println(fourSum(arr, x));

		arr = new int[] { -3, -2, -1, 0, 0, 1, 2, 3 };
		x = 0;
		System.out.println(fourSum(arr, x));

	}

	public static List<List<Integer>> fourSum(int[] nums, int x) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		// a+b+c+d=x-->a+b=x-(c+d)
		// must not have duplicate set
		if (nums.length < 4)
			return new ArrayList<List<Integer>>();

		int temp = nums[0];
		int temp2 = nums[1];

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && temp == nums[i]) {
				continue;
			} // distinct means not repeated 2nd time
			temp = nums[i];
			temp2 = nums[i + 1];
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && temp2 == nums[j])
					continue;
				temp2 = nums[j];
				int f = x - (nums[i] + nums[j]);
				int low = j + 1;
				int high = nums.length - 1;
				while (low < high) {
					if (nums[low] + nums[high] < f) {
						low++;
					} else if (nums[low] + nums[high] > f) {
						high--;
					} else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[low]);
						list.add(nums[high]);
						l.add(list);
						// needed distinct pairs
						if (nums[low] == nums[high]) {
							break;
						} else {
							int t1 = nums[low];
							while (low < nums.length && nums[low] == t1) {
								low++;
							}
							t1 = nums[high];
							while (high > 0 && nums[high] == t1) {
								high--;
							}

						}

					}
				}

			}

		}
		return l;
	}

}
