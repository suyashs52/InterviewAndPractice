package com.leetcode;

public class Way2ExpressIntegerSumOfPower {

    //https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
    //prerequisite coin change problem min coin needed, no of ways
    public static void main(String[] args) {

    }


    public int numberOfWays(int n, int x) {
        //n x is the power ,
        //here coin will be 1 to n
        //amount will be n
        int mod=(int)1e9+7;
        //so initialize amount / number in dp
        int[] dp=new int[n+1];
        dp[0]=1; //number=0 can be achieve only 1 way, coin=0 only then so 1 way
        //for each number(amount) check if no of way to take all number to achieve the target
        for (int i = 1; i < n+1 ; i++) {
            int power=(int) Math.pow(i,x); //number or coin value

            for (int p = n; p >=power; p--) {
            //no of way to get number p: total way when include p (dp[p-power])+total way when not include p
                dp[p]= (dp[p]+dp[p-power])%mod; //dont take number(coin) p, dp[p] ,total way is dp[p] reference coin problem
                //

            }
            
        }

        return dp[n];

    }
}
