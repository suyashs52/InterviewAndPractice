package com.leetcode.tree;

import com.array.TreeNode;

public class AmountBinarytreeInfected {
    private int maxDistance = 0;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2};
        TreeNode root = buildTreeTest(arr);


        System.out.println(new AmountBinarytreeInfected().amountOfTime(root, 10));

    }


    static TreeNode buildTreeTest(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);

        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        root.left.right = new TreeNode<>(arr[4]);
        root.right.left = new TreeNode(arr[5]);
        root.right.right = new TreeNode(arr[6]);
        root.left.right.left = new TreeNode(arr[7]);
        root.left.right.right = new TreeNode(arr[8]);

        return root;
    }

    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxDistance;
    }

    public int traverse(TreeNode<Integer> root, int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int leftDepth = traverse(root.left, start);
        int rightDepth = traverse(root.right, start);

        if (root.val == start) { //to calculate depth of start node, if child depth higher then maxDistance
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
    }
}
