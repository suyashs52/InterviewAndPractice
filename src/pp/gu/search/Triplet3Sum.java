package pp.gu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet3Sum {
	public static void main(String... strings) {
		// https://leetcode.com/problems/3sum/
		int[] arr = new int[] { -1, 0, 1, 2, -1, -4 };
		int N = 6;
		int X = 12;
		System.out.println(threeSum(arr));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		// a+b+c=0-->a+b=-c
		// must not have duplicate set
		if (nums.length < 3)
			return new ArrayList<List<Integer>>();

		int temp = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && temp == nums[i]) {
				continue;
			}
			temp = nums[i];
			int f = -1 * nums[i];

			int low = i + 1;
			int high = nums.length - 1;
			while (low < high) {
				if (nums[low] + nums[high] < f) {
					low++;
				} else if (nums[low] + nums[high] > f) {
					high--;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(-f);
					list.add(nums[low]);
					list.add(nums[high]);
					l.add(list);
					//needed distinct pairs
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
		return l;
	}

}
