package com.leetcode.bs;

import com.array.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearch2 {

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearch2().generateTrees_topdown(3));
    }

    public List<TreeNode> generateTrees_bottomup(int n) {
        Map<String, List<TreeNode>> map = new HashMap<>(); //this will store all bst in between i, j
        //we can also use List<List<List<TreeNode>>> i,j,node
        //result is total binary tree betwenn 1.n map.get("1,"+n)
        for (int i = 1; i <= n; i++) {
            final int j = i;
            map.put(i + "," + i, new ArrayList<>() {{
                add(new TreeNode(j));
            }}); // single node
        }

        //solve for n node
        // n=6 lets noOfNodes=2 , we can start from 1 to 5 , end till if start =5 then till 6 so start+noOfNode-1
        //n=6, nfn=3 ,start:1..4 , start=4, end=6 4+3-1=6
        //so start always from 1 to n-nfn+1, and end=start+noOfNode-1;
        for (int noOfNodes = 2; noOfNodes <= n; noOfNodes++) {

            for (int left = 1; left <= n - noOfNodes + 1; left++) { //if n=6, noOfNodes=4 , left=6-4+1=3, nfn=2,6-2+1=5

                int right = left + noOfNodes - 1;
                List<TreeNode> node = new ArrayList<>(); //total binary tree we can from in left ..right
                for (int i = left; i <= right; i++) {
                    //i is the parent node
                    //so left will be left to i-1, right will be i+1, right
                    List<TreeNode> leftNode = i == left ? new ArrayList<>() : map.get((left) + "," + (i - 1));

                    if (leftNode.isEmpty()) leftNode.add(null);

                    List<TreeNode> rightNode = i == right ? new ArrayList<>() : map.get((i + 1) + "," + right);

                    if (rightNode.isEmpty()) rightNode.add(null);

                    for (TreeNode lnode : leftNode) {
                        for (TreeNode rnode : rightNode) {
                            TreeNode root = new TreeNode(i);
                            root.left = lnode;
                            root.right = rnode;
                            node.add(root);
                        }
                    }

                }
                map.put(left + "," + right, node);
            }

        }

        return map.get("1," + n);

    }


    public List<TreeNode> generateTrees_topdown(int n) {
        Map<String, List<TreeNode>> map = new HashMap<>(); //this will store all bst in between i, j
        return topdown(1, n, map);

    }

    List<TreeNode> topdown(int left, int right, Map<String, List<TreeNode>> map) {

        //The number of nodes in a range start, end is (end - start + 1). Let k=end−start+1
        //There are n states start, end with one node, that is k=1,n-1 state with n=2, n-3 state with k=3 nodes
        //for given k , there would be g(n)= 4^k/k^1.5  no of bst and have k node so k*g(n), so 4^k/sqrt(k)
        //space complexity is sum of al bst node, sum:1..n:=>(n-k+1)*4^k/k^1/2
        String key = left + "," + right;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (left == right) {
            map.put(left + "," + right, new ArrayList<>() {{
                add(new TreeNode(left));
            }});
            return map.get(left + "," + right);
        }
        if (left > right) {
            return new ArrayList<>() {{
                add(null);
            }};
        }
        ArrayList<TreeNode> node = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = topdown(left, i - 1, map);
            List<TreeNode> rightTree = topdown(i + 1, right, map);

            for (TreeNode ltn : leftTree) {
                for (TreeNode rtn : rightTree) {

                    TreeNode root = new TreeNode(i);
                    root.left = ltn;
                    root.right = rtn;
                    node.add(root);

                }
            }
        }

        map.put(key, node);

        return node;

    }


    public List<TreeNode> generateTrees_SpaceOptimized(int n) {
        //all the BSTs that can be created from a set of consecutive values from start to end
        //from 1 to end-start+1 ,  we will find that the structure of all the BSTs created with the above two ranges
        // would be identical. bst with range [1,3] structure is similar to bst with range [4,6]
        //So, we can just store the BSTs for all the ranges starting from 1 and add the offset to convert them to required ranges.
        //dp[i]  will store a list of all BSTs with i nodes having values from 1 to i
        //As we are executing in bottom-up manner and figuring out the answer for numberOfNodes nodes,
        // we will already have the list of root nodes for all BSTs with i - 1 and numberOfNodes - i nodes (for all values of i = 1 to numberOfNodes).
        //We want the right subtree to have numberOfNodes - i nodes but the range of nodes should be from i + 1
        // to numberOfNodes. If we add the offset (i + 1) - 1 = i to all the nodes,
        // it would solve this as we would now have trees with numberOfNodes - i nodes from values i + 1 to numberOfNodes
        //1->r3->l2 same as 4->r6->l5 offset is 3,
        List<List<TreeNode>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(null); //0 nodes means empty tree so null

        for (int numberOfNodes = 1; numberOfNodes <= n; numberOfNodes++) {
            for (int i = 1; i <= numberOfNodes; i++) {
                int j = numberOfNodes - i;
                for (TreeNode left : dp.get(i - 1)) {
                    for (TreeNode right : dp.get(j)) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = clone(right, i);
                        dp.get(numberOfNodes).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode clonedNode = new TreeNode((int) node.val + offset);
        clonedNode.left = clone(node.left, offset);
        clonedNode.right = clone(node.right, offset);
        return clonedNode;
    }

}
