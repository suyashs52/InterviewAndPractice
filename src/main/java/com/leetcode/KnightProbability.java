package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {

    int[][] direction = new int[][]{
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}

    };

    //https://leetcode.com/problems/knight-probability-in-chessboard/submissions/

    public static void main(String[] args) {

        System.out.println(new KnightProbability().knightProbability(3, 2, 0, 0));

    }





    public   double knightProbability(int n, int k, int row, int column) {
        //if it is given knight is at given row,column so probability of finding knight at given row,colm is 1
        // a knight can move to all 8 position so probabiltity as given row col will be 1/8
        //if all 8 positions in between 0,row-1/0,col-1 then sum will be 1
        //if we again go from that poistion to 8 position then finding knight at next position will be 1/8*8
        //because total we ll have 64 position and chance of finding at given position is 1/64

        Map<String, Double> map = new HashMap<>();
        // map.put("" + k + row + column, 1d);//for given row
        return dfs(n,k,row,column,map);
        //return 0;
    }

    double dfs(int n, int k, int row, int colm, Map<String, Double> map) {
        if (row < 0 || colm < 0 || row > n - 1 || colm > n - 1) return 0; //dont count probability if outside so no way

        if (k == 0) return 1; //no of ways
        double totalProbabilty = 0d;

        if(map.containsKey("s"+k+"k"+row+"t"+colm)){
            return map.get("s"+k+"k"+row+"t"+colm);
        }
        for (int r = 0; r < direction.length; r++) {

            totalProbabilty += (dfs(n, k - 1, row + direction[r][0], colm + direction[r][1], map)) ;


        }

        map.put("s"+k+"k"+row+"t"+colm,totalProbabilty/ 8.0);

        return  totalProbabilty/ 8.0;
    }

    public double knightProbabilityBottomUp(int n, int k, int row, int column) {
        int[][] moves=direction;
        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        for(int move = 1; move<=k; move++) {
            double[][] ndp = new double[n][n];
            for(int r = 0; r<n; r++) {
                for(int c = 0; c<n; c++) {
                    for(int[] m: moves) {
                        int nr = r+m[0];
                        int nc = c+m[1];
                        if (isValid(nr, nc, n)) ndp[r][c] += dp[nr][nc]/8.0;
                    }
                }
            }
            dp = ndp;
        }

        double prob = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                prob += dp[r][c];
            }
        }

        return prob;
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }


}