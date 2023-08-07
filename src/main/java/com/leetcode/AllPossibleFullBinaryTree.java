package com.leetcode;

import java.util.*;

public class AllPossibleFullBinaryTree {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public List<TreeNode> allPossibleFBT(int n) {
        //iterative approach
        Map<Integer, List<TreeNode>> itr = new HashMap<>();
        itr.put(0,new ArrayList<>());
        itr.put(1,new ArrayList<>(){{add(new TreeNode(0));}});
        if(n%2==0){
            return  new ArrayList<>();

        }

        for(int i=0;i<=n;i++){
            itr.put(i,new ArrayList<>());
        }
        itr.put(1,new ArrayList<>(){{add(new TreeNode(0));}});

        for (int i = 3 ; i <=n ; i+=2) {
            //for node =n solution will run by below iteration if n=5 head =1, left: 1,3, right: 3,1
            for (int left = 1; left < i-1; left+=2) {
                int right=i-left-1;
                List<TreeNode> result=new ArrayList<>();

                for(TreeNode tleft: itr.get(left)){
                    for(TreeNode tright:itr.get(right)){
                        TreeNode node=new TreeNode(0,tleft,tright);
                        //   result.add(node);
                        itr.get(i).add(node);
                    }
                }

                //  itr.put(i,result);


            }

        }

        return itr.get(n);


        //map will store all possible bt for an integer

        //full binary tree always have odd number

        //return dfs(n);
    }

    private List<TreeNode> dfs(int n) {

        if (n % 2 == 0) {
            return new ArrayList<>();

        }

        if (n == 1) { //terminal condition
            return Arrays.asList(new TreeNode());
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        List<TreeNode> newNode=new ArrayList<>();


        //left and right  if node has n node ex: 5
        //left will have 1,3 nodes right will have 3,1 node

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left=dfs(i);
            List<TreeNode> right=dfs(n-i-1); //1 is parent node itself

            for(TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode node = new TreeNode(0);

                    node.left=l;
                    node.right=r;
                    newNode.add(node);
                }
            }
        }

        map.put(n,newNode);

        return newNode;


    }


}
