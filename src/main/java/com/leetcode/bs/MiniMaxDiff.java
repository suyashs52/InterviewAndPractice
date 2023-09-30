package com.leetcode.bs;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MiniMaxDiff {

    public static void main(String[] args) {
        System.out.println(new MiniMaxDiff().minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(new MiniMaxDiff().minimizeMax(new int[]{4,2,1,2}, 1));
    }

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int maxDiff=nums[nums.length-1]-nums[0];
        int min=0;

        while (min<maxDiff){
            int mid=min+(maxDiff-min)/2;

            int k=p;

            //check if p pair having mid difference possible or not
            //if yes we can take max difference till mid (from 0..mid)

            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i+1]-nums[i]<=mid){
                    k--;
                    i++; //if taken , take the next index difference
                }
                if(k==0) break;
            }

            if(k==0){
                maxDiff=mid; //if we can take this difference check for lower min difference we can take
            }else {
                min=mid+1; //we can't take mid difference for p pair, so increase the difference
            }


        }


        return maxDiff;
    }
}
