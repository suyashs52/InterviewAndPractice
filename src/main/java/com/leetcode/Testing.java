package com.leetcode;

public class Testing {

    public static void main(String[] args) {

        long same = 0l;
        long opposite = 0l;

        int[] nums = new int[]{2, 3, 6, 1, 9, 2};
        int x = 5;

        boolean current = (nums[0] & 1) == 0 ? true : false;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) { //even
                if(current){
                    same += nums[i];

                }else {
                    same += nums[i];
                }
            }
        }


    }
}
