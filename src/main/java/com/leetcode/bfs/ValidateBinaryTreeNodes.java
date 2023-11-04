package com.leetcode.bfs;

import java.util.*;

public class ValidateBinaryTreeNodes {
//https://leetcode.com/problems/validate-binary-tree-nodes/submissions/

    public static void main(String[] args) {
        System.out.println(new ValidateBinaryTreeNodes().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) return true;
        //root can't always be 0 , so find root element
        //find the root
        Set<Integer> set=new HashSet<>();
        for(int i:leftChild){
            set.add(i);
        }
        for(int i:rightChild){
            set.add(i);
        }

        int count=0;
        int root=-1;
        for(int i=0;i<n;i++){
            if(set.contains(i)){
                count++;
            }else{
                root=i;
            }
        }
        if(count==n){
            return false;
        }


        boolean[] visited = new boolean[n];
        boolean vacant = false;
        vacant = dfs(root, leftChild, rightChild, visited);

        for (boolean v : visited) {
            if (v == false) return v;
        }
        return vacant;
    }


    boolean dfs(int n, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (n > leftChild.length - 1) return true;


        if (visited[n] == true) {
            return false;
        }

        visited[n] = true;

        boolean left = true;
        if (leftChild[n] != -1)
            left = dfs(leftChild[n], leftChild, rightChild, visited);
        boolean right = true;
        if (rightChild[n] != -1)
          right=  dfs(rightChild[n], leftChild, rightChild, visited);

        return left && right;


    }

    public boolean validateBinaryTreeNodes_dfsStack(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        seen.add(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }

                    stack.push(child);
                    seen.add(child);
                }
            }

        }

        return seen.size() == n;
    }

    public boolean validateBinaryTreeNodes_bfs(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        seen.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            int[] children = {leftChild[node], rightChild[node]};

            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }

                    queue.add(child);
                    seen.add(child);
                }
            }

        }

        return seen.size() == n;
    }
    public int findRoot(int n, int[] left, int[] right) {
        Set<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }

        for (int node : right) {
            children.add(node);
        }

        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
