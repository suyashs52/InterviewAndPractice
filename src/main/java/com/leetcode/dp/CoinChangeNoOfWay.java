package com.leetcode.dp;

import java.util.Arrays;

public class CoinChangeNoOfWay {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));

        int[][] dp = new int[coins.length][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(changeTopDown(amount, coins, coins.length - 1, dp));
    }



    public static int changeTopDown(int amount, int[] coins, int index, int[][] dp) {

        if (amount == 0) return 1;
        if (index == 0) {
            //coin 0 is used
            if (amount >= coins[index] && amount % coins[index] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int notTake = changeTopDown(amount, coins, index - 1, dp);

        int take = 0;

        if (amount >= coins[index]) {
            take = changeTopDown(amount - coins[index], coins, index, dp);
        }

        dp[index][amount] = take + notTake;

        return dp[index][amount];

    }

    int dfs_start_end(int amount , int[] coins,int coin,int amt, int[][] dp){

        if(amt==0) return 1; //we can able to take all coins
        if(coin==coins.length-1) {
            if(coins[coin]<=amt && amt%coins[coin]==0) return 1;
            return 0;
        }
        if(dp[coin][amt]!=-1) return dp[coin][amt];

        // if(coins[coin]>amt) return dfs(amount,coins,coin+1,amt,dp);
        int take=0;
        if(coins[coin]<=amt){
            take=dfs_start_end(amount,coins,coin,amt-coins[coin],dp);
        }

        int notTake=dfs_start_end(amount,coins,coin+1,amt,dp);

        return dp[coin][amt]=take+notTake;



    }
    int dfs_terminateCondition(int amount , int[] coins,int coin,int amt, int[][] dp){

        if(amt==0) return 1; //we can able to take all coins
        if(coin==coins.length) {

            return 0;
        }
        if(dp[coin][amt]!=-1) return dp[coin][amt];

        if(coins[coin]>amt) return dfs_terminateCondition(amount,coins,coin+1,amt,dp); //if amount is less then coin
        int take=0;
       // if(coins[coin]<=amt){
            take=dfs_terminateCondition(amount,coins,coin,amt-coins[coin],dp);
      //  }

        int notTake=dfs_terminateCondition(amount,coins,coin+1,amt,dp);

        return dp[coin][amt]=take+notTake;



    }

    public static int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];//no of way for given coin and amount

        //for amount=0 , no of ways is also 0
        //no of ways means sum of takeCoin+notTakeCoin
        dp[0][0] = 1; //to take 0 amount always there is a way
        for (int coin = 0; coin < coins.length; coin++) {
            dp[coin][0] = 1;
        }

        //populate coin[0][any amount] no of ways
        for (int amt = 1; amt < amount + 1; amt++) {

            if (amt >= coins[0] && amt % coins[0] == 0) { //way is always 1 if we can have n coins[0] for given amount
                dp[0][amt] = 1;
            }

        }

        for (int coin = 1; coin < coins.length; coin++) {

            for (int amt = 1; amt < amount + 1; amt++) {
                int notTake = dp[coin - 1][amt]; //no of way if current coin not to take for given amount
                int take = 0;
//                 if(amt==coins[coin]){
//                     take=1;
//                 }
                //amount is 3, coins are 1,2  only 1 has 1 way(3coins), at 2 2-1=1 when used 2 we have amount 1 and total way
                // for amount 1 using 1,2 coins are 1 so at 2 we have 2 ways, 111, 12,
                if (amt >= coins[coin]) {
                    take = dp[coin][amt - coins[coin]]; //if take current coin and if we are able to take the coin for given amount
                    //and their is a way for amt-coins[coin] amount so thie is prev total way
                    //total way is that way only
                    //so last amount total way must have a value
                }
                //total no of way for the given amount by taking using this coin
                dp[coin][amt] = take + notTake;
            }

        }

        return dp[coins.length - 1][amount];

    }
    //here no of way we can get given amount using all coins
    public int changeOptimize(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) { //coins
            for (int j = coins[i]; j <= amount; j++) {//amount
                dp[j] += dp[j - coins[i]]; //no of way (dp[j])  when not take current coin, when take current coin (dp[j - coins[i]])
            }
        }

        // return dp[amount];-------------1 optimized way


//        int[] dp = new int[amount + 1];
//        dp[0] = 1; // when amount is 0, there is one way to make it up for every coin.
//
//
        for (int i = 0; i < coins.length; i++) { // list of types of coins
            // looping j from 1 works too, as long as you check j bigger than coins[i]
          //  for (int j = 1; j <= amount; j++) { // amount
              //  if (j >= coins[i]) dp[j] += dp[j - coins[i]];
                for (int k= coins[i]; k <= amount; k++) { // amount
                    dp[k] += dp[k - coins[i]];
                }
         //   }

        }
        return dp[amount];
    }
}
