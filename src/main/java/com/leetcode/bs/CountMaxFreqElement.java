package com.leetcode.bs;

import java.util.ArrayList;
import java.util.List;

public class CountMaxFreqElement {
//https://leetcode.com/problems/find-mode-in-binary-search-tree/editorial/


    int currNum = 0;
    int st = 0;
    int mst = 0;
    int maxStreak = 0;
    List<Integer> answer;

    public static void main(String[] args) {

    }

    public int[] findMode(TreeNode root) {
        //count the max freq node,

        //as it is bst so inorder traversal will always give sorted value, if adjacent 2 are equal we got an streak
        //inorder traversal node.left , node, node.right will always gives sorted array
        maxStreak = 0;
        int currVal = 0;
        int currStreak = 0;
        List<Integer> answer = new ArrayList<>();
        dfs(root, currVal, currStreak);

        int[] ans = new int[answer.size()];
        int i = 0;
        for (Integer a : answer) {
            ans[i++] = a;
        }

        return ans;
    }

    void dfs(TreeNode node, int val, int streak) {
        if (node == null) return;
        dfs(node.left, node.val, streak);
        if (node.val == currNum) {
            st++;
        } else {
            st = 1;
            currNum = node.val;
        }

        if (st > mst) {
            answer = new ArrayList<>();
            mst = st;
            //  answer.add(node.val);
        }

        if (mst == st) {
            answer.add(node.val);
        }

        dfs(node.right, node.val, streak);

    }

    //Morris Traversal
    //nodes left right most assign to node and break the node pointer to left , if then traverse always get
    //sorted list in bst


    public void add(int num) {
        if (num == currNum) {
            num++;
        } else {
            num = 1;
            currNum = num;
        }

        if (num > maxStreak) {
            answer = new ArrayList();
            maxStreak = num;
        }

        if (num == maxStreak) {
            answer.add(num);
        }
    }

    public int[] findMode_morris(TreeNode root) {
        TreeNode curr = root;
        TreeNode friend;
        while (curr != null) {
            if (curr.left != null) {
                friend = curr.left;
                while (friend.right != null && friend.right != curr) {
                    friend = friend.right;
                }

                if (friend.right == null) {
                    friend.right = curr;
                    curr = curr.left;
                } else {
                    friend.right = null;
                    add(curr.val);
                    curr = curr.right;
                }

            } else {
                add(curr.val);
                curr = curr.right;
            }
        }


        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


