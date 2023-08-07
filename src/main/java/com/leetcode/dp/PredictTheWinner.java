package com.leetcode.dp;

import java.util.Arrays;

public class PredictTheWinner {
    //https://leetcode.com/problems/predict-the-winner/

    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new PredictTheWinner().PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

    public boolean PredictTheWinner(int[] nums) {

        int playerAfinalScoreRec = recur(nums, 0, nums.length - 1);

        //top - down
        int[][] dp = new int[nums.length][nums.length];
        for (int[] d : dp) Arrays.fill(d, -1);
        int topdown = topdown(nums, dp, 0, nums.length - 1);

        // bottom up


        return playerAfinalScoreRec > 0;
    }

    public int recur(int[] nums, int left, int right) {
        //take left/right so 1 option
        // O(2^n) time
        if (left == right) { //players point to 1 number so return the number for any player
            return nums[right];
        }
        //player a take first left so next player b will negate the positive sum gain by player a in next turn
        //check the difference for player a if >0 means positive difference player a win
        int leftPick = nums[left] - recur(nums, left + 1, right);
        int righPick = nums[right] - recur(nums, left, right - 1);

        return Math.max(leftPick, righPick);

    }

    public int topdown(int[] nums, int[][] dp, int left, int right) {
        //O(n2)
        //0,n-1 ==> 0,n-2, 1,n-1 / 1,n-1-> 1,n-2 , 2,n-1

        if (dp[left][right] != -1) return dp[left][right];
        if (left == right) {
            return nums[left];
        }

        int leftPick = nums[left] - topdown(nums, dp, left + 1, right);
        int righPick = nums[right] - topdown(nums, dp, left, right - 1);

        return dp[left][right] = Math.max(leftPick, righPick);


    }

    public int bottomup(int[] nums) { //O(n^2)
        //for single value we ll have dp[i][i]

        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        //now solve for 2 value it will be if a take 0 , b take 1, if a 1, b=0
        //a[0][1] a[1][0] from a[0][0]
        //we are moving diagonal up so for dp[left] we ll solve next problem dp[left][left+1] then for dp[left][left + 2] ..
        //final will be dp[0][n-1]

        for (int diff = 1; diff < nums.length; diff++) {
            for (int i = 0; i < nums.length - diff; i++) { // if solve for 00, next solve for 01
                int j=i+diff;       //to solve 01 get max(num[0]-dp[1][1],num[1]-dp[0][0]), next solve for 1,2
                //for diff=n-1 i will be till n-n+1=1 1 time run only
                dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);


            }
        }

        return dp[0][nums.length-1];

    }

    public boolean bottomup_spaceoptimized(int[] nums){
        //we only need prev lower diagonal
        //first we need n-1 length ,then n-2 length...1
        //each next value caluclate from left and bottom side
        //for left we -ve next data , for right we ll take prev means left data
        //image ----,--- first - , from first -- 2 only

        int n=nums.length;
        int[] dp=Arrays.copyOf(nums,n); //starting 4

        for(int diff=1;diff<n;diff++){
            for(int cell=0;cell<n-diff;cell++){
                int right=cell+diff;
                dp[cell]=Math.max(nums[cell]-dp[cell+1],nums[right]-dp[cell]);
            }
        }

        return dp[0]>=0; //if equal then a win


    }

    //min max from both side
    public int solve(int[][] dp,int []v,int i,int j,int k){
        if(i==j) return  v[j];
        if(i>j)return 0;
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int first=0,last=0,ans=0;
        if(k%2==0){// it's player 1's turn
            first=v[i]+solve(dp,v,i+1,j,k+1);// pick the first element and add it to the score of player 1
            last=v[j]+solve(dp,v,i,j-1,k+1);// pick the last element and add it to the score player 1
            ans=Math.max(first,last);//store the ans which will return the max score for player 1
        }
        else{// it's player 2's turn
            first=-v[i]+solve(dp,v,i+1,j,k+1);// pick the first element and subtract it from the score of player 1
            last=-v[j]+solve(dp,v,i,j-1,k+1);// pick the lastelement and subtract it from the score of player 1
            ans=Math.min(first,last); //store the ans which will return the min score for player 1
        }
        return dp[i][j]=ans;
    }

}
