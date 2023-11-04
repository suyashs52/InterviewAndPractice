package com.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
        System.out.println(new Pattern132().find132pattern_byInterval(new int[]{5, 6, 7, 4, 3, 2, 7, 3, 8, 2, 9}));
    }

    public boolean find132pattern_byInterval(int[] nums) {
        //add all increasing interval for 5,6,7,8 store 5,8
        //again in future if value comes that lies in between 5,8 we ll have our answer
        ///5 6 7 8 6 5 4
        List<int[]> intervals = new ArrayList<>();
        int i = 1, s = 0;

        while (i < nums.length) {
            if (nums[i] < nums[i - 1]) {
                if (s < i - 1)
                    intervals.add(new int[]{nums[s], nums[i - 1]});
                s = i; //6 5 4 3 so dont store any of it
            }
            for (int[] a : intervals)
                if (nums[i] > a[0] && nums[i] < a[1])
                    return true;
            i++;
        }
        return false;

    }


    public boolean find132pattern_byStack(int[] nums) {
        if (nums.length < 3) return false;
        //we need to find the 132 pattern so 13 means min before j , and k>min ,k<j

        //store prefix min for nums
        int[] min = new int[nums.length];

        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }

        //we need to find k that start from last length
        Stack<Integer> stack = new Stack<>();

        for (int k = nums.length - 1; k > -1; k--) {
            if (nums[k] > min[k]) {

                while (stack.isEmpty() && stack.peek() <= min[k]) { //if at num[k] min[k] > last all element of stack so dont need those element
                    stack.pop();
                }

                if (stack.isEmpty() == false && nums[k] > stack.peek()) { // 1..13..10..11 so at 13 we got our answer
                    return true;
                }
                //1...10..11 we at 10 push 10
                //1..12..10..11 we get our answer from above steps
                //1..8..10 11....push again so each time from last either we get sorted element or our answer
                stack.push(nums[k]);

            }

        }

        return false;
    }

}
