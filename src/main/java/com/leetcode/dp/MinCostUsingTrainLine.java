package com.leetcode.dp;

import java.util.Arrays;

public class MinCostUsingTrainLine {
    //https://leetcode.com/problems/minimum-costs-using-the-train-line/description/
    public static void main(String[] args) {
        System.out.println(new MinCostUsingTrainLine().minimumCosts(new int[]{1, 6, 9, 5}, new int[]{5, 2, 3, 10}, 8));
    }

    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] cost = new long[regular.length];
        long[][] dp = new long[regular.length + 1][2];

        for (long[] d : dp) Arrays.fill(d, -1);
        //1 for regular , 0 for express
        topdown(regular, express, expressCost, cost, regular.length - 1, 1, dp);

        for (int i = 0; i < regular.length; i++) {
            cost[i]=Math.min(dp[i][0],dp[i][1]);
        }
        return cost;

//        long[] cost = new long[regular.length];
//        long[][] dp = new long[regular.length][2];
//        for (int i = 0; i < regular.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        topdown(regular,express,expressCost,cost,regular.length-1,1,dp);
//        long[] ans = new long[regular.length];
//        // Store cost for each stop.
//        for (int i = 0 ; i < regular.length; i++) {
//            ans[i] = dp[i][1];
//        }
//
//        return ans;
    }


    long topdown(int[] regular, int[] express, int expressCost, long[] cost, int index, int lane, long[][] dp) {
        //1 for regular , going to expresee will add expressCost so be in lane 1
        //same for express be in express lane
        // it can never be more expensive to be in the regular lane than to be in the express lane,
        // and thus the answer for each stop can be represented as the cost in the regular lane.
        //O(2N) , O(N)
        if (index < 0) return 0l;

        if (dp[index][lane] != -1) return dp[index][lane];

        long regularVal = regular[index] + topdown(regular, express, expressCost, cost, index - 1, 1, dp);
        long expressVal = (lane == 1 ? expressCost : 0) + express[index]
                    + topdown(regular, express, expressCost, cost, index - 1, 0, dp);
    //it will store the data when sum+ coming from either express or regular
        dp[index][lane]=Math.min(regularVal,expressVal);

        return dp[index][lane];


    }


    public long[] bottomup(int[] regular, int[] express, int expressCost) {

        long[] costs=new long[regular.length];
        long[][] dp=new long[regular.length+1][2]; //need to reach at regular.length index

        dp[0][0] =expressCost; //we currently at 0 station and choosing express lane
        dp[0][1]=0;

        for (int i = 1; i < regular.length+1; i++) {
            //at i-1 we have cost from i-1 to i
            long regVal=regular[i-1]+Math.min(dp[i-1][1],dp[i-1][0]); //no cost associate coming from express
            long expreVal=express[i-1]+Math.min(dp[i-1][1]+expressCost,dp[i-1][0]); //if coming from regular add express cost

            dp[i][1]=regVal;
            dp[i][0]=expreVal;

            costs[i-1]=Math.min(dp[i][1],dp[i][0]);
        }
        return costs;
    }



    public long[] bottomup_single(int[] regular, int[] express, int expressCost) {
        //we need only prev value
        long[] costs=new long[regular.length];
        //long[][] dp=new long[regular.length+1][2]; //need to reach at regular.length index

        long prevExpresCost =expressCost; //we currently at 0 station and choosing express lane
        long prevRegularCost=0;

        for (int i = 1; i < regular.length+1; i++) {
            //at i-1 we have cost from i-1 to i
            long regVal=regular[i-1]+Math.min(prevExpresCost,prevRegularCost); //no cost associate coming from express
            long expreVal=express[i-1]+Math.min(prevRegularCost+expressCost,prevExpresCost); //if coming from regular add express cost

            costs[i-1]=Math.min(regVal,expreVal);
            prevRegularCost=regVal;
            prevExpresCost=expreVal;


        }
        return costs;
    }

    }
