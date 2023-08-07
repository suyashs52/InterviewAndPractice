package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesKDistance {

    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public static void main(String[] args) {

        TreeNode node7=new TreeNode(7);
        TreeNode node4=new TreeNode(4);
        TreeNode node2=new TreeNode(2,node7,node4);
        TreeNode node6=new TreeNode(6);
        TreeNode node5=new TreeNode(5,node6,node2);
        TreeNode node0=new TreeNode(0);
        TreeNode node8=new TreeNode(8);
        TreeNode node1=new TreeNode(1,node0,node8);
        TreeNode node=new TreeNode(3,node5,node1);

        AllNodesKDistance allNodesKDistance=new AllNodesKDistance();
        System.out.println( allNodesKDistance.distanceK(node,node5,2));

    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //need to build a graph , assuming all node have unique value
        Map<Integer, List<TreeNode>> graph = new HashMap<>();

        buildGraph(root, null, graph);

        if (k == 0) return new ArrayList<>();
        List<Integer> kDistanceNode = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        findK(kDistanceNode, k, graph, visited, target);
        return kDistanceNode;
    }

    private void findK(List<Integer> kDistanceNode, int k, Map<Integer,
            List<TreeNode>> graph, List<Integer> visited, TreeNode target) {

        if(target==null) return;
        if(visited.contains(target.val)) return;
        visited.add(target.val);
        if(k==0) {
            kDistanceNode.add(target.val);
            return;
        }
        List<TreeNode> node=graph.get(target.val);

        for (int i = 0; i < node.size(); i++) {

            findK(kDistanceNode,k-1,graph,visited,node.get(i));
        }


    }


    private void buildGraph(TreeNode root, TreeNode parent, Map<Integer, List<TreeNode>> graph) {
        if (root == null) return;

        if(graph.containsKey(root.val)) return;

             graph.put(root.val, new ArrayList<>());

        List<TreeNode> nodes = graph.get(root.val);
        if (parent != null)
            nodes.add(parent);
        if (root.left != null)
            nodes.add(root.left);
        if (root.right != null) {
            nodes.add(root.right);
        }

        if (root.left != null) {
            buildGraph(root.left, root, graph);
        }
        if (root.right != null) {
            buildGraph(root.right, root, graph);
        }
    }
}
