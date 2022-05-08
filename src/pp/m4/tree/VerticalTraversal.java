package pp.m4.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {

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
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		levelc(root, 0, map);

		for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
			for (Integer l : m.getValue()) {
				list.add(l);
			}
		}
		System.out.println(list);
		return list;
	}

	static class pair {
		TreeNode node;
		int level;

		pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	static void levelc(TreeNode root, int level, Map<Integer, ArrayList<Integer>> map) {

		if (root == null)
			return;

		Queue<pair> queue = new LinkedList<>();
		queue.add(new pair(root, level));
//5, 4, 3, 8, 4, 10, 7, 10, 2
		while (queue.isEmpty() == false) {
			pair p = queue.poll();

			if (map.containsKey(p.level)) {
				map.get(p.level).add(p.node.val);
			} else {
				map.put(p.level, new ArrayList<Integer>() {
					{
						add(p.node.val);
					}
				});
			}

			if (p.node.left != null) {
				queue.add(new pair(p.node.left, p.level - 1));
			}
			if (p.node.right != null) {
				queue.add(new pair(p.node.right, p.level + 1));
			}
		}
//
//		// pre order traversal
//		if (map.containsKey(level)) {
//			map.get(level).add(root.val);
//		} else {
//			ArrayList<Integer> l = new ArrayList<>();
//			l.add(root.val);
//			map.put(level, l);
//		}
//
//		levelc(root.left, level - 1, map);
//		levelc(root.right, level + 1, map);

	}

}
