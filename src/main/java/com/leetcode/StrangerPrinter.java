package com.leetcode;

import java.util.Arrays;

public class StrangerPrinter {

    public static void main(String[] args) {
        System.out.println(new StrangerPrinter().strangePrinter("aaaabbb"));
        System.out.println(new StrangerPrinter().strangePrinter("aba"));
        System.out.println(new StrangerPrinter().strangePrinter("abac"));
        System.out.println(new StrangerPrinter().strangePrinterBottomUp("abac"));
    }


    public int strangePrinter(String s) {
//https://leetcode.com/problems/strange-printer/description/
        //printing of same char in a single iteration
        // ab|a , abc|bcd , so divide the problem in subproblem

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int[] d : dp) Arrays.fill(d, -1);

        return devide(s,0,s.length()-1,dp);

    }





    int devide(String s, int i, int j, int[][] dp) {
        //O(n^3) 1 for loop, 2 condition each for n times
        if (i >= s.length() || j >= s.length()) return 0;
        if (i == j) { //if both index are equal then need 1 turn only
            dp[i][j] = 1;
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];
        int sum = s.length()+1; //min turn will be when all are of distince char
        for (int k = i; k < j; k++) { //divide into 2 parts i,k ,,,k+1,j
            //totoal turns will be sum of both part , calculate the   of min of turns,
        //doing k+1 so <j
            sum = Math.min(devide(s, i, k, dp) + devide(s, k + 1, j, dp), sum);
        }

        //
        if (s.charAt(i) == s.charAt(j)) {
            sum--; //if both end charcter same from both sub string so -1 form it ,
            //a | a , both turn needed 1 and 1 if we merged again we need 1 turn only as both are same
        }

        return dp[i][j] = sum;


    }


    public int strangePrinterBottomUp(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for(int i=0;i<s.length();i++){ //row i index


            for (int j = 0; j < s.length(); j++) { //column j index
                if(i==j){
                    dp[i][j]=1;
                    continue;
                }

                int sum=s.length()+1;
                for (int k=i;j<j;k++){ //divide the len into partition
                    sum=Math.min(sum, dp[i][k]+dp[k+1][j]);
                }
                if(s.charAt(i)==s.charAt(j)){ //if both index char are equal
                  sum--;

                }
                dp[i][j]=sum;

            }
        }


        return dp[s.length()][s.length()];


    }
}
