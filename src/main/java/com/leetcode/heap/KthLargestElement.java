package com.leetcode.heap;

import java.util.Arrays;

public class KthLargestElement {

    public static void main(String[] args) {
        //https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
        // System.out.println(new KthLargestElement().findKthLargest(new int[]{3,2,1,5,6,4},2));

        System.out.println(new KthLargestElement().canMakeSubsequence("abc", "ad"));
        System.out.println(new KthLargestElement().canMakeSubsequence("zc", "ad"));
        System.out.println(new KthLargestElement().canMakeSubsequence("ab", "d"));
        System.out.println(new KthLargestElement().canMakeSubsequence("dm", "e"));
        System.out.println(new KthLargestElement().canMakeSubsequence("abc", "acd"));

    }

    int[][] dp;
    public boolean canMakeSubsequence(String str1, String str2) {

        if (str2.length() > str1.length()) return false;

        int i = 0;
        int j = 0;

          dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        dp[0][0]=2;
        for (int k = 1; k < str2.length(); k++) {
            dp[0][k]=1;

        }
        for (int k = 1; k < str1.length(); k++) {
            dp[k][0]=1;

        }
        return dfs(str1, str2, 0, 0);

        //  return dp[str1.length()][str2.length()]==2;
    }


    boolean dfs(String str1, String str2, int i1, int i2) {
        if (i1 >= str1.length() || i2 >= str2.length()) {
            if (str1.length() == str2.length() && i1 == i2) {
                dp[i1][i2] = 2;
                return true;
            } else if (i1 > str1.length() - 1 && i2 < str2.length()) {
                dp[i1][i2]=2;
                return false;
            }else if(i2>=str2.length() ){ //i1<str1.length()

                dp[i1][i2]=dp[i1-1][i2-1];
                return dp[i1][i2]==2;
            }
        }


        if (dp[i1][i2] != -1) {
            return dp[i1][i2] == 2;
        }
        if (str1.charAt(i1) == str2.charAt(i2)) {
            dp[i1][i2] = 2;
            return dfs(str1, str2, i1 + 1, i2 + 1);
        }

        int a1 = str1.charAt(i1) - 'a';
        int b1 = str2.charAt(i2) - 'a';

        if (((a1 + 1) % 26) == b1) {
            dp[i1][i2] = 2;
            return dfs(str1, str2, i1 + 1, i2 + 1);
        }

        if (dfs(str1, str2, i1 + 1, i2) || dfs(str1, str2, i1, i2 + 1)) {
            dp[i1][i2] = 2;
            return true;
        }
        dp[i1][i2] = 1;
        return false;


    }

    public int findKthLargest(int[] nums, int k) {

        return contingSort(nums, 2);


    }

    public int contingSort(int[] nums, int k) {
        //find min , max init count based on min, max value , in array store the frequency , start from last
        //if k<=0 we found kth largest :)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //ne
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] count = new int[max - min + 1];

        for (int n : nums) {
            count[n - min]++;
        }

        int remain = k;
        for (int i = count.length - 1; i >= 0; i--) {
            remain -= count[i];
            if (remain <= 0) return i + min;
        }

        return -1;


    }

}
