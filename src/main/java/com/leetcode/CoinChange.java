package com.leetcode;

import java.util.Arrays;

public class CoinChange {

    //https://www.youtube.com/watch?v=hh-uFQ-MGfw

    public static void main(String[] args) {
        System.out.println(coinChangedp(new int[]{1, 2, 5}, 11));

        //top down...start from full problem and solve for sub problem of lower index
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(coinChangeTopDown(coins,11,coins.length-1,dp));

    }

    public static int coinChangedp(int[] coins, int amount) {
        //can't use greedy as the highest denomination coin can't always give optimal answer
        // 1,6,5,9 amount is 11 if we use 9 then need 2 1s coin 3 coin , but 6,5 will have 2 coins

        int[][] dp = new int[coins.length][amount + 1]; //coins needed for j amount , find the minimum coins needed for given amount

        //for 0 amount needs 0 coins
//        for (int i = 0; i < coins.length; i++) {
//            dp[i][0] =0; // for 0 amount min coin needed is 0
//        }

        for (int i = 1; i < amount + 1; i++) {

            if (i >= coins[0] && i % coins[0] == 0) { //no of min coin of coin[0] needed for given amount
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }

        }

        for (int co = 1; co < coins.length; co++) {

            for (int amt = 1; amt < amount + 1; amt++) {
                if (amt < coins[co]) {
                    dp[co][amt] = dp[co - 1][amt]; //take the count from prev no of coins if amount < coin value
                } else {
                    int prevValue = dp[co - 1][amt]; // count when not taking current coin
                    if (dp[co][amt - coins[co]] != -1) { // if we can take current value of coin so add 1+ min coin need to get amt-coins[col] value
                        int curr = 1 + dp[co][amt - coins[co]];

                        if (prevValue != -1) { //if we can also get count after not taking current value
                            dp[co][amt] = Math.min(prevValue, curr);
                        } else { //if we only can take current value
                            dp[co][amt] = curr;
                        }
                    } else {
                        dp[co][amt] = prevValue;
                    }
                }


            }

        }


        return dp[coins.length - 1][amount];
    }

    public static int coinChangeTopDown(int[] coins, int amount, int index, int[][] dp) {

        if (index == 0) {
            //we are calculating no of min coin needed for amount by coins[0]
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else return Integer.MAX_VALUE - 1; //no value possible

        }

        if(dp[index][amount]!=-1) return dp[index][amount];

        int takeValue = Integer.MAX_VALUE - 1;
        //min coin needed if we take current coin
        //take the value, and check after taking , count is possible or not,
        //not doing index-1, because we are taking current value , and needed no of coins needed for amount amount-coint[index]
        //that we already had calculated in last recursive call
        if (amount >= coins[index])
            takeValue = 1 + coinChangeTopDown(coins, amount - coins[index], index, dp);

        //not take means not taking current coins, so total minimum coins needed till the prev coin considered for given amount
        int notTakeValue = coinChangeTopDown(coins, amount, index - 1, dp);


        dp[index][amount] = Math.min(takeValue, notTakeValue);

        return dp[index][amount];
    }



// return coinChange(coins, amount, new int[amount]);
    //Dynamic programming - Top down
    private int coinChange(int[] coins, int remAmount, int[] count) {
        //use all coins to found min coin needed for given amount
        //here we are passing amount index so remAmount-1 returned
        if (remAmount < 0) return -1;
        if (remAmount == 0) return 0;
        if (count[remAmount - 1] != 0) return count[remAmount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, remAmount - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[remAmount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[remAmount - 1];
    }

    //Dynamic programming - Bottom up
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; //max coin needed +1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; //0 coin needed for amount 0
        for (int i = 1; i <= amount; i++) { //amount from 1 to amount
            for (int j = 0; j < coins.length; j++) { //for each amount check min count needed if use all coins
                if (coins[j] <= i) { //if amount is greater then coins base value
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //take mini of if take the coin dp[i - coins[j]] + 1, or not take use prev/existing value
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
