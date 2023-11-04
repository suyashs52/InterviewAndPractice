package com.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    //https://leetcode.com/problems/majority-element-ii/editorial/

    //sort the element and compare the prev with current
    //Boyer-Moore Voting Algorithm


    public static void main(String[] args) {
        System.out.println(new MajorityElement2().majorityElement(new int[]{4,2,1,1}));
    }
    public List<Integer> majorityElement(int[] nums) {

        System.out.println((Integer)2333);
        int count1=0;
        int count2=0;

        Integer cand1=null;
        Integer cand2=null;

      //  for(Integer i:nums){
        for(int i:nums){
            if(cand1!=null && cand1==i){
                count1++;
            }else if(cand2!=null && cand2==i){
                count2++;
            }else if(count1==0){
                cand1=i;
                count1++;
            }else if(count2==0){
                cand2=i;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        List result=new ArrayList<>();
        count1=0;
        count2=0;
        for(int i:nums){
            if(cand1!=null && i==cand1)
                count1++;

            if(cand2!=null && i==cand2)
                count2++;

        }

        int n=nums.length;

        if(count1 > n/3){
            result.add(cand1);
        }
        if(count2>n/3){
            result.add(cand2);
        }

        return result;
    }
}
