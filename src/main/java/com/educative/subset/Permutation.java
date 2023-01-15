package com.educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> subset = new ArrayList<List<Integer>>();
		// take out the array list and insert into it new element
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		queue.add(new ArrayList<Integer>());

		for (int n : nums) {
			int k = queue.size(); // why k --. we insert element in queue when size not equal
			for (int j = 0; j < k; j++) { // iterate on all list in queue
				List<Integer> old = queue.poll(); // take out the element from queue to insert
				for (int i = 0; i <= old.size(); i++) { // insert at all place in list
					List<Integer> perm = new ArrayList<Integer>(old); // take the old element list
					perm.add(i, n);
					if (perm.size() == nums.length) {
						subset.add(perm); // got each permution while inserting
					} else {
						queue.add(perm);
					}

				}
			}

		}

		return subset;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Permutation.findPermutations(new int[] { 1, 3, 5 });
		System.out.println("Here are all the permutation: " + result);

	}

}
