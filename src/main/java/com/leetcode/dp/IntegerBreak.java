package com.leetcode.dp;

public class IntegerBreak {
//https://leetcode.com/problems/integer-break/editorial/

    public static void main(String[] args) {

        System.out.println(new IntegerBreak().integerBreak_topDown(10));
        System.out.println(new IntegerBreak().integerBreak_topDown(5));
        System.out.println(new IntegerBreak().mathsproof(5));
    }

    public int mathsproof(int n){
        if(n<4) return n-1;
        ///n=2 :1, n=3:2,n=4:4(2*2), n=5:3*2, n=6: 3*3, n=7: 3*4 , n=8: 3*3*2,n=9: 3*3*3
        //clearly

        if(n%3==0) return (int) Math.pow(3,n/3);
        if(n%3==2) return (int) Math.pow(3,n/3)*2;

        return (int) Math.pow(3,(n/3-1))*4;

    }

    public int integerBreak_topDown(int n) {
        if (n < 4) return n - 1;
        int[] topDownDP = new int[n + 1];
        topdown(n, topDownDP);
        return topDownDP[n];

    }

    public int topdown(int n, int[] dp) {

        if (n < 3) { //n=3:2*1, ,2:1*1:1
            dp[n] = n - 1;
            return n - 1;
        }


        if (dp[n] != 0) return dp[n];
        int prod = n; //n=4 ans=2*2, n=5 ans=3*2=6
        for (int i = 2; i < n; i++) {
            prod = Math.max(prod, i * topdown(n - i, dp));
        }

        dp[n] = prod;

        return dp[n];


    }

    public int bottomup(int n) {

        if (n < 4) return n - 1; //n=2:1,3:2,1:0

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; //we are now calculating from 4, that is 2*2  so 2*dp[2] means dp[2] must have max value of 2
        //n=3: 2*1=2 this we are returning from 1st line
        //for n=5: 3*dp[2]=6, n=6:3*dp[3] so dp of 3 must be 3, n=7
        dp[3]=3;
        for (int i = 4; i <= n; i++) {
            //i*dp[n-i]
            int ans = i;
            for (int j = 2; j < i; j++) {
                ans = Math.max(ans, j * dp[i - j]);
            }
            dp[i] = ans;
        }

        return  dp[n];

    }


}
