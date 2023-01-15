package com.educative.subset;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

		subsets.add(new ArrayList<Integer>());
		findset(subsets, nums, 0);

		subsets = new ArrayList<>();
		subset(subsets, nums, 0, new ArrayList<>());
		return subsets;
	}

	private static void findset(List<List<Integer>> subsets, int[] nums, int k) {

		for (int j : nums) {
			int n = subsets.size();
			for (int i = 0; i < n; i++) {
				List<Integer> l = new ArrayList<>(subsets.get(i));
				l.add(j);
				subsets.add(l);
			}

		}

	}

	static void subset(List<List<Integer>> subsets, int[] nums, int k, List<Integer> set) {
		subsets.add(new ArrayList<>(set));

		for (int i = k; i < nums.length; i++) {
			//add number 
			set.add(nums[i]);
			subset(subsets, nums, i + 1, set);
			//back track
			set.remove(set.size() - 1);
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = Subsets.findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

}
