package com.educative.cyclicsort;

import java.util.HashSet;
import java.util.Set;

public class FindAllDuplicate {

	public static int findMissingNumber(int[] nums) {

		int missed = 0;

		// do cyclic sort,
		int start = 0;
		while (start < nums.length) {
			if (nums[start] != start && nums[start] < nums.length) { // since one number is missing , len is less by 1
				int temp = nums[nums[start]];
				nums[nums[start]] = nums[start];
				nums[start] = temp;

			} else if (nums[start] > nums.length - 1 || nums[start] == start) {
				start++;
			}
		}

		for (int i = 0; i < nums.length; i++)
			if (i != nums[i])
				return i;
		return missed;

	}

	public static void main(String[] arg) {

	     Set<Integer> tm = new HashSet<Integer>();
	    
	     tm.add(null);
	     tm.add(null);
	      
	     System.out.println(tm.iterator().next());

	     System.out.println(FindAllDuplicate.findMissingNumber(new int[] { 4, 0, 3, 1 }));
		System.out.println(FindAllDuplicate.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));

	}

}
