package com.educative.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

public class UniqueTrees {

	public static List<TreeNode> findUniqueTrees(int n) {
		List<TreeNode> result = new ArrayList<>();
		// TODO: Write your code here
		return generate(1, n);
	}

	private static List<TreeNode> generate(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();

		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generate(start, i - 1);
			List<TreeNode> right = generate(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode t = new TreeNode(i);
					t.left = l;
					t.right = r;
					result.add(t); // counting sum+=l+r
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
		System.out.println("Total trees: " + result.size());
		result = UniqueTrees.findUniqueTrees(3);
		System.out.println("Total trees: " + result.size());
		result = UniqueTrees.findUniqueTrees(4);
		System.out.println("Total trees: " + result.size());
	}

}
