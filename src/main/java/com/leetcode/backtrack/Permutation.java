package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[]{1,2,3}));

        //using swappnig
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        allnum(new int[]{1,2,3}, list, 0);
    }

    public List<List<Integer>> permute(int[] nums) {
        //time complexity is n*n! n! is n*(n-1)*(n-2) becuase we are reducing the size by 1 for each recursive call
        // first n is if size==n then copy the element in array
        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        int index = 0;
        dfs(list, nums, index, n, new ArrayList<>());

        return list;

    }

    void dfs(List<List<Integer>> list, int[] nums, int index, int n, List<Integer> sublist) {
//We have a for loop over nums, and each iteration of the loop checks if an element is in curr.
// As such, the work done at each node is approximately O(n2)  // ). Because the number of nodes grows
// faster than n! , the work done for the traversal grows faster than n2⋅n!  and it becomes the dominating term.
        //but not at final level
        if (sublist.size() == nums.length) {
            list.add(new ArrayList<>(sublist));
            return;
        }


        for (int i = 0; i < n; i++) {
            if (sublist.contains(nums[i])) continue;
            // if(i==index) continue;

            sublist.add(nums[i]);
            dfs(list, nums, i + 1, n, sublist);

            sublist.remove(sublist.size() - 1);
        }


    }

    private static void allnum(int[] nums, List<List<Integer>> list, int i) {

        if (i == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int j : nums)
                l.add(j);
            list.add(l);
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            allnum(nums, list, i + 1);
            swap(nums, j, i);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        // TODO Auto-generated method stub
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;

    }
}
