package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestAirthmeticsSubseq {

    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

        LongestAirthmeticsSubseq cs=new LongestAirthmeticsSubseq();
        System.out.println(cs.longestSubsequence( new int[] {1,5,7,8,5,3,4,2,1},-2));
        System.out.println(cs.longestSubsequence( new int[] {1,2,3,4},1));
        System.out.println(cs.longestSubsequence( new int[] {1,5,7,8,5,3,4,2,1},-2));

    }
    public int longestSubsequence(int[] arr, int difference) {

        int count=0;
        int maxCount=0;
        int ccount=1;
        for(int i=0;i<arr.length;i++){
                count=0;
                ccount=0;
                int k=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]-k==difference){
                    ccount=1;
                    count++;
                    k=arr[j];
                }
            }
            maxCount=Math.max(count+ccount,maxCount);
        }
        return maxCount;
    }
}
