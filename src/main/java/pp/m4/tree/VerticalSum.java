package pp.m4.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/vertical-sum/1
		TreeNode t10 = new TreeNode(8, null, null);
		TreeNode t9 = new TreeNode(3, null, null);
		TreeNode t8 = new TreeNode(5, null, t9);
		TreeNode t7 = new TreeNode(10, t10, null);
		TreeNode t6 = new TreeNode(7, null, null);
		TreeNode t5 = new TreeNode(2, null, null);
		TreeNode t4 = new TreeNode(4, t8, t7);
		TreeNode t3 = new TreeNode(10, t6, t5);
		TreeNode t2 = new TreeNode(4, t4, t3);
		// TreeNode t1 = new TreeNode(4, t2, t3);

		//
		// System.out.println(bToDLL(t2));
		System.out.println(verticalSum(t2));

	}

	public static ArrayList<Integer> verticalSum(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		levelc(root, 0, map);

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			list.add(m.getValue());
		}
		System.out.println(list);
		return list;
	}

	static int min = 0;
	static int max = 10001;

	static void levelc(TreeNode root, int level, Map<Integer, Integer> map) {
		if (root == null)
			return;
		map.put(level, map.getOrDefault(level, 0) + root.val);

		levelc(root.left, level - 1, map);
		levelc(root.right, level + 1, map);

	}

}
