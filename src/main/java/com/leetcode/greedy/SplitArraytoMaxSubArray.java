package com.leetcode.greedy;

public class SplitArraytoMaxSubArray {

    public static void main(String[] args) {
        System.out.println(new SplitArraytoMaxSubArray().maxSubarrays(new int[]{5,7,1,3}));
    }

    public int maxSubarrays(int[] nums) {
        //0 1 10 11 100 101 110 111
        //100  & 111

        //brute force
        int k=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int b=nums[i];
            int temp=k;
            for(int j=k;j<nums.length;j++){
                if((nums[j]&b)<b){
                    k=j+1;
                    b=nums[j]&b;

                }
                if(b==0){
                    break;
                }
            }
            if(temp!=k){
                count++;
            }
        }
        return count;
    }
}
