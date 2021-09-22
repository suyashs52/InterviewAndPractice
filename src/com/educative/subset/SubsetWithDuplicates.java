package com.educative.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDuplicates {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

		subsets.add(new ArrayList<Integer>());
		int start = 0;
		int end = 0;
		for (int i = 0; i < nums.length; i++) {

			start = 0;

			if (i> 0 && nums[i] == nums[i - 1]) { //1 3 3 
				//[] , [] 1,  3 13 , next 3 ll insert by taking start from 3 13 not from [] 
				start = end;
			}
			end = subsets.size();
			for (int j = start; j < end; j++) {
				List<Integer> s = new ArrayList<>(subsets.get(j));
				s.add(nums[i]);
				subsets.add(s);
			}

		}

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
			// add number
			set.add(nums[i]);
			subset(subsets, nums, i + 1, set);
			// back track
			set.remove(set.size() - 1);
		}

	}

	public static void main(String[] args) {
		
		System.out.println("123".matches(".*[a-zA-Z]+.*"));
		
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}
