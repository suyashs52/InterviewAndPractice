package com.leetcode;

import java.util.Arrays;

public class MinAsciiDelete {
    public static void main(String[] args) {
        System.out.println(new MinAsciiDelete().minimumDeleteSum("sea", "eat"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return matchCase(s1, s2, 0, 0, dp);
    }


    public int minimumDeleteSum1D(String s1, String s2) {

        // Make sure s2 is smaller string
        if (s1.length() < s2.length()) {
            return minimumDeleteSum(s2, s1);
        }

        // Case for empty s1
        int m = s1.length(), n = s2.length();
        int[] currRow = new int[n + 1];
        for (int j = 1; j <= n; j++) { //column is for s2
            currRow[j] = currRow[j - 1] + s2.charAt(j - 1);
        }

        // Compute answer row-by-row
        for (int i = 1; i <= m; i++) {
        //i for s1
            int diag = currRow[0];//if both char same use diagonal (prev) sum
            currRow[0] += s1.charAt(i - 1); //colm 0 means when s2="", s1 sum will be answer

            for (int j = 1; j <= n; j++) {

                int answer;

                // If characters are the same, the answer is top-left-diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    answer = diag;
                }

                // Otherwise, the answer is minimum of top and left values with
                // deleted character's ASCII value
                else {
                    answer = Math.min(
                            s1.charAt(i - 1) + currRow[j],
                            s2.charAt(j - 1) + currRow[j - 1]
                    );
                }

                // Before overwriting currRow[j] with answer, save it in diag
                // for the next column
                diag = currRow[j];
                currRow[j] = answer;
            }
        }

        // Return the answer
        return currRow[n];
    }

    public int minimumDeleteSumBottomUp(String s1, String s2) {
        //If there are TTT state variables, then we need an array of at most TTT dimensions to store the result of each sub-problem.

        // Prepare the two-dimensional array
        int m = s1.length(), n = s2.length();
        int[][] computeCost = new int[m + 1][n + 1];

        // Fill in the base case values
        for (int i = 1; i <= m; i++) { //first compare "", to s1 string need to delete all the charcter
            computeCost[i][0] = computeCost[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) { //"" to s2
            computeCost[0][j] = computeCost[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill the remaining cells using the Bellman Equation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    computeCost[i][j] = computeCost[i - 1][j - 1];
                } else {
                    computeCost[i][j] = Math.min(
                            s1.charAt(i - 1) + computeCost[i - 1][j], //s1 delete a char and go ahead
                            s2.charAt(j - 1) + computeCost[i][j - 1] //s2 delete a char and go ahead
                    );
                }
            }
        }

        // Return the answer for entire input strings
        return computeCost[m][n];
    }


    int matchCase(String s1, String s2, int i1, int i2, int[][] dp) {
        //O(m*n) so only 2 operation access each s index by 1 only
        if (i1 > s1.length() && i2 > s2.length()) return 0;
        if (dp[i1][i2] != -1) return dp[i1][i2];

        if (i1 == s1.length()) {
            if (i2 == s2.length()) return 0;
            int remaining = 0;

            remaining = (int) s2.charAt(i2)
                    + matchCase(s1, s2, i1, i2 + 1, dp); //save the prev record result
            dp[i1][i2] = remaining;

            return remaining;
        }

        if (i2 == s2.length()) {
            if (i1 == s1.length()) return 0;
            int remaining = 0;

            remaining = (int) s1.charAt(i1)
                    + matchCase(s1, s2, i1 + 1, i2, dp); //save the prev record result

            dp[i1][i2] = remaining;

            return remaining;
        }


        int sum = (int) 1e8;

        if (s1.charAt(i1) != s2.charAt(i2)) {
            //dont need 3rd case ex min(i+1,j),(i,j+1)
            //(i+1,j) call again check (i+2,j),(i+1,j+1)
            //so (i+1,j+1) already computed using this only
            sum = Math.min((int) s1.charAt(i1) + matchCase(s1, s2, i1 + 1, i2, dp),
                    (int) s2.charAt(i2) + matchCase(s1, s2, i1, i2 + 1, dp));
            // sum=Math.min(sum,((int)s1.charAt(i1)+ (int)s2.charAt(i2))
            //     + matchCase(s1,s2,i1,i2+1,dp));
        } else {
            sum = matchCase(s1, s2, i1 + 1, i2 + 1, dp);
        }

        dp[i1][i2] = sum;

        return sum;
    }
}
