package com.leetcode.array;

public class CountSubarraysBounds {
    //https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/

    public static void main(String[] args) {
        System.out.println(new CountSubarraysBounds().countSubarrays(new int[]{1,3,5,2,7,5,1,2},1,5));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {

        int minIndex=-1;
        int maxIndex=-1;
        int invalidIndex=-1;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK){
                minIndex=i;
            }
            if(nums[i]==maxK){
                maxIndex=i;
            }

            int minOfBoth=Math.min(minIndex,maxIndex);
            //we are moving right
            if(nums[i]<minK || nums[i]>maxK){
                invalidIndex=i;
            }

            if(invalidIndex==-1 && minOfBoth>-1){
                ans+=minOfBoth+1; //index start from 0, 1,3,5
            }else if(invalidIndex>-1 && minOfBoth>-1){
                //all are moving in right direction so
                //invlaidIndex should fall behind minOfBoth
                if(invalidIndex<minOfBoth){ //sub array form from next index

                    ans+=(minOfBoth-(invalidIndex+1))+1;
                }
            }


        }

        return ans;
    }
}
