package com.leetcode.dp;

public class JumpGame6 {
    //https://leetcode.com/problems/jump-game-vi/description/
    public static void main(String[] args) {

    }

    public int maxResult_topDown(int[] nums, int k) {
        int[] dp = new int[nums.length];


        return dp[nums.length-1];
    }

    int dp_topdown(int[] nums,int k,int i, int[] dp){
        if(i==nums.length){
            return 0;
        }
        if(k==0) return  0;
        if(dp[i]!=0) return  dp[i];
        int sum=nums[i];
        return 0;
    }
}
