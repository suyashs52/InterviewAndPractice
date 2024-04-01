package com.leetcode.dp;

import java.math.BigInteger;
import java.util.Arrays;

public class PowerfulIntegers {
    //https://leetcode.com/problems/count-the-number-of-powerful-integers

    long[][] dp;

    public static void main(String[] args) {

      //  System.out.println(new PowerfulIntegers().numberOfPowerfulInt(1, 6000, 4, "124"));
        System.out.println(new PowerfulIntegers().numberOfPowerfulInt(697662853, 11109609599885l, 6, "5"));

    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        return numberOfPowerfulInt(finish, limit, s) - numberOfPowerfulInt(start - 1, limit, s);

    }

    private long numberOfPowerfulInt(long finish, int limit, String suffix) {

        int size = (finish + "").length();
        dp = new long[17][2]; //17 is total digits , 2 is 0, 1: tight bound(if finish is 78980 index is 4(7) if digit is 7
        //we must put digit from 0to7 for index 3 otherwise all digits
        for (int i = 0; i < 17; i++) {
            Arrays.fill(dp[i], -1);
        }

        int needToFill = size - suffix.length(); //this digit we need to check

        if (needToFill < 0) return 0; // if suffix > finish

        return dp_rec(0, 1, limit, size, needToFill, suffix, finish + ""); //as we limit at left most index by limit


    }


    long dp_rec(int index, int tight, int limit, int size, int needToFill, String suffix, String finish) {
        if (index == size) return 1;
        if (dp[index][tight] != -1) return dp[index][tight];

        long ans = 0;

        if (index >= needToFill) { //reached at suffix level and beyond
            int current_digit = suffix.charAt(index - needToFill) - '0'; //take digit from suffix
            if (current_digit <= limit) { //if digit is less then limit
                if (tight > 0 && current_digit <= finish.charAt(index) - '0') { //if tight and digit is less
                    ans += dp_rec(index + 1, current_digit == finish.charAt(index) - '0' ? 1 : 0, limit, size, needToFill, suffix, finish);
                } else if (tight == 0) { //no limit any value we can choose 0-9 for next index
                    ans += dp_rec(index + 1, 0, limit, size, needToFill, suffix, finish);

                }
            }

        } else if (tight > 0) {
            int digit=finish.charAt(index)-'0';
            for(int current_digit=0;current_digit<= Math.min(digit,limit);current_digit++){
                ans+=dp_rec(index+1,current_digit==digit?1:0,limit,size,needToFill,suffix,finish);
            }

        } else { //if no bound previouly we can choose any digit , here we had limit digit constraint
            for (int current_digit = 0; current_digit <= limit; current_digit++) {
                ans += dp_rec(index + 1, 0, limit, size, needToFill, suffix, finish);
            }
        }

        dp[index][tight]=ans;
        return ans;

    }

}
