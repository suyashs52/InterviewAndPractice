package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleii {
    List<List<Integer>> result = new ArrayList<>();

    //https://leetcode.com/problems/pascals-triangle-ii/editorial/
    public static void main(String[] args) {

        System.out.println(new PascalTriangleii().getRow(3));
        System.out.println(new PascalTriangleii().getRow_bottomUpSpace(3));


    }

    public List<Integer> getRow(int rowIndex) {

        if (result.size() > rowIndex) return result.get(rowIndex);

        if (result.size() == 0) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            result.add(first);
            if (rowIndex == 0)
                return result.get(0);
        }

        int size = result.size() - 1;
        int count = 0;
        for (int i = size + 1; i <= rowIndex; i++) {
            List<Integer> l = new ArrayList<>();
            List<Integer> l1 = result.get(i - 1);
            l.add(1);
            count++;
            for (int j = 1; j < count; j++) {
                l.add(l1.get(j - 1) + l1.get(j));
            }
            l.add(1);
            result.add(l);
        }

        return result.get(rowIndex);
    }


    public List<Integer> getRow_topDown(int rowIndex) {
        // 1,11,121,1331,14641,... at 5th 14641 to caluclate 6(we check 1(2)1 data many time )
        //we can use map to save space or use 2d array

        int[][] dp = new int[rowIndex + 1][rowIndex + 1]; //at index 4 we ll have 5 element max
        dp[0][0] = 1;

        //it is clear at 0 col we always have 1 value, 0 row too
        //at 2nd row 20=1,21=2,22=1, / at 3rd row we 30=1, 31=3 32=3 33=1 so i==j so again 1
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) { //add value , row=rowIndex, we ll save lesser row on fly,column is what we iterate
            result.add(dp_topdown(rowIndex, i, dp));
        }

        return result;

    }

    Integer dp_topdown(int row, int col, int[][] dp) {
        if (row == 0 || col == 0 || row == col) return 1;

        if (dp[row][col] != 0) return dp[row][col];

        dp[row][col] = dp_topdown(row - 1, col - 1, dp) + dp_topdown(row - 1, col, dp);

        return dp[row][col];
    }

    public List<Integer> getRow_bottomUp(int rowIndex) {
    //O(k2)
        List<Integer> prev = new ArrayList<>(), curr=new ArrayList<>(); //starting position
        prev.add(1);
        for (int i = 1; i < rowIndex+1; i++) { //row will move 1 to =rowIndex
            curr=new ArrayList<>(){{add(1);}}; //start will have 1
            for (int j = 1; j < i; j++) { //column will move from
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1); //at last add 1
            prev=curr;
        }
        return curr;

    }


    public List<Integer> getRow_bottomUpSpace(int rowIndex) {
        //1,11,121 ..., at 0 it is 1 if we have previously 1331
        //add 1 at last, now 3+1=4, so 133(3+1)1, again 13(3+3)41,14641 store at last index
        List<Integer>  curr=new ArrayList<>(rowIndex+1); //starting position

        curr.add(1);
        if(rowIndex==0) return curr;
        curr.add(1);
        for (int i = 1; i < rowIndex; i++) { //row will move 1 to =rowIndex

            for (int j = i; j>0; j--) { //column will move from last to 1 not 0, 1 3 3 1,
                curr.set(j,curr.get(j-1)+curr.get(j));
            }
            curr.add(1); //at last add 1

        }
        return curr;

    }

    public List<Integer> getRow_bottomUpMath(int rowIndex) {
        //pascal triagnle is always ncr=ncr+ncr-1,  next row can be,if ncr/ncr-1=n-r+1/r
        // curr=prv*(n-r+1/r)

        List<Integer> row =
                new ArrayList<>() {
                    {
                        add(1);
                    }
                };

        for (int k = 1; k <= rowIndex; k++) {
            row.add((int) ((row.get(row.size() - 1) * (long) (rowIndex - k + 1)) / k));
        }

        return row;
    }

}
