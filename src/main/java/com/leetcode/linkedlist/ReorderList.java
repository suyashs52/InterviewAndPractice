package com.leetcode.linkedlist;

import java.util.Stack;

public class ReorderList {
    //https://leetcode.com/problems/reorder-list/description/
    public static void main(String[] args) {


        System.out.println(new ReorderList().minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}));
    }

    public int minimumDistance(int[][] points) {
        Stack<Integer> stack=new Stack<>();
        // 3 10, 5 15, 10 2 , 4 4
        // 3 10, 4 4 , 5 15, 10 2

        long[] prefixDistance = new long[points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                prefixDistance[i]=Math.max(dis,prefixDistance[i]);
                prefixDistance[j]=Math.max(dis,prefixDistance[j]);
            }
        }

        long min=Long.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            min=Math.min(min,prefixDistance[i]);
        }

        return (int) min;
    }

    public long countAlternatingSubarrays(int[] nums) {

        long count = 0;
        int n = -1;

        for (int right = 0, left = 0; right < nums.length; right++) {


            if (right > 0 && nums[right] == nums[right - 1]) {
                left = right;
            }

            count += right - left + 1;
        }
        return count;
    }


// 110111
// 000001
    //if and is  0, so 1 comes from this number reset that bit

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int x1 = x;

        int sum = 0;

        while (x1 != 0) {
            sum += x1 % 10;
            x1 = x1 / 10;
        }

        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }
    // 1 0
    // 0 1
    // 1 1
    //xor would revert or

    public int minimumSubarrayLength(int[] nums, int k) {

        int minLen = nums.length + 1;

        if (nums[0] >= k) return 1;
        int gor = nums[0];
        if (nums.length == 1) return -1;

        for (int right = 1, left = 0; right < nums.length; right++) {
            gor = gor | nums[right];
            if (gor >= k) {
                minLen = Math.min(minLen, right - left + 1);

            }
            if (minLen == 1) return 1;

            while (gor >= k && left <= right) {
                String leftBinary = Integer.toBinaryString(left);
                String allBinary = Integer.toBinaryString(gor);


                left++;
                int fxor = 0;
                for (int j = left; j <= right; j++) {
                    fxor = fxor | nums[j];
                }
                gor = fxor;

                if (gor >= k) {
                    minLen = Math.min(minLen, right - left + 1);
                    if (minLen == 1) return 1;
                }

            }

        }

        if (minLen == nums.length + 1)
            return -1;
        return minLen;
    }

    public void reorderList(ListNode head) {

    }


}
