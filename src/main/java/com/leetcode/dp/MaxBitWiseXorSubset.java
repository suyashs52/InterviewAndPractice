package com.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class MaxBitWiseXorSubset {

    public static void main(String[] args) {
    }


    public int countMaxOrSubsets(int[] nums) {

        int maxNo = 0;

        for (int i = 0; i < nums.length; i++) {
            maxNo = maxNo | nums[i];
        }

        return 0;

    }
}
