package com.gfg.dp;

import java.util.Arrays;

public class ReachAGivenScore {

    public static void main(String[] args) {
        System.out.println(new ReachAGivenScore().count(20));
    }


    public long count(int n) {
        if(n<3) return 0;
        long[] dp = new long[(int)n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1]=0;
        dp[2]=0;
        //dp[3]=1;
        for(int i=3;i<=n;i++) { //1 way always
            if (i >= 3) dp[i] += dp[i - 3];
        }
        for (int i = 5; i <= n; i++) { //1 way always if in between dp[i-5] point to dp[3multiple] so way will increase by 1
            dp[i] += dp[i - 5];
        }

        for (int i = 10; i <= n; i++) {
            dp[i] += dp[i - 10];
        }


        // Add your code here.

        return dp[n];
    }
}
