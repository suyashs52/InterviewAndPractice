package com.leetcode.array;

public class MonotonicArray {

    public static void main(String[] args) {

    }

    public boolean isMonotonic_onePass(int[] nums) {
        boolean increase = true;
        boolean decrease = true;

        for (int n = 1; n < nums.length; n++) {
            if (nums[n] > nums[n - 1]) {
                decrease = false;
            }
            if (nums[n] < nums[n - 1]) {
                increase = false;
            }
        }
        return decrease || increase; //if both are false means it is nothing
    }

    public boolean isMonotonic_IntegerCompare(int[] nums) {

        int prev = 0;

        for (int n = 1; n < nums.length; n++) {
            int s = Integer.compare(nums[n - 1], nums[n]); //return 1 if nums[0]> nums[1], -1 otherwise

            if ( s!=0) {
                if (prev!=0 && s != prev)
                    return false;
                prev=s;
            }
        }
        return true;
    }
}
