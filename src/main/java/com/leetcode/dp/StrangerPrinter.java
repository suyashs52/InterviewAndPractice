package com.leetcode.dp;

import java.util.Arrays;

public class StrangerPrinter {

    public static void main(String[] args) {
        System.out.println(new StrangerPrinter().strangePrinter("aaaabbb"));
        System.out.println(new StrangerPrinter().strangePrinter("aba"));
        System.out.println(new StrangerPrinter().strangePrinter("abac"));
        System.out.println(new StrangerPrinter().strangePrinterBottomUp_wrong("abac"));
        System.out.println(new StrangerPrinter().strangePrinterBottomUp2("abac"));
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


    public int strangePrinterBottomUp_wrong(String s) {

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for(int i=0;i<s.length();i++){ //row i index


            for (int j = i; j < s.length(); j++) { //column j index
                if(i==j){
                    dp[i][j]=1;
                    continue;
                }

                int sum=s.length()+1;
                for (int k=i;k<j;k++){ //divide the len into partition
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

    private int[][] dp;
    public int strangePrinter1(String s) {
        int len = s.length();
        dp = new int[len + 1][len + 1];
        return turn(s, 1, len);
    }
    private int turn(String s, int i, int j){
        if(i > j) return 0; //empty string.
        else if(dp[i][j] > 0) return dp[i][j]; //Cached
        else{
            //Give the fall back.
            dp[i][j] = turn(s, i, j - 1) + 1;
            for(int k = i; k < j; k++){
                if(s.charAt(j - 1) == s.charAt(k - 1))
                    dp[i][j] = Math.min(turn(s, i, k) + turn(s, k + 1, j - 1), dp[i][j]);
            }
            return dp[i][j];
        }
    }
    public int strangePrinterBottomUp2(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-1; i >= 0; --i) { //start from last char in string
            dp[i][i] = 1; //if single character , so min turn =1
            for (int j = i+1; j < n; ++j) { //from next char till n
                dp[i][j] = dp[i][j-1] + 1; //max turn will increase by 1 if use next character
                for (int k = i; k < j; ++k) { // check the division between i and j
                    if (s.charAt(k) == s.charAt(j)) { //if in between we find char is same as last character
                        //partition the group i,k k+1,j-1 dp[i][k]+dp[k+1][j-1] s[j] wont increse the turn
                        // as this is same as k, assumeing k +1 < j-1 to form valid sub string
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + (k+1<=j-1 ? dp[k+1][j-1] : 0));
                    }
                }
            }
        }
        return dp[0][n-1]; //return the turn for sub string 0,n-1

    }
}
