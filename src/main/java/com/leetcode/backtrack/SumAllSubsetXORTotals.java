package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SumAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
       List<List<Integer>> set=new ArrayList<>();

       dfs(nums,0,new ArrayList<>(),set);

       int sum=0;

       for(int i=0;i<set.size();i++){
           int xor=0;

           for(int j:set.get(i)){
               xor=xor^j;
           }
           sum+=xor;
       }

       return sum;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> currentList, List<List<Integer>> set) {
        if(index==nums.length){
            set.add(new ArrayList<>(currentList));
            return;
        }

        currentList.add(nums[index]);
        dfs(nums,index+1,currentList,set);
        currentList.remove(currentList.size()-1);
        dfs(nums,index+1,currentList,set);
    }
}
