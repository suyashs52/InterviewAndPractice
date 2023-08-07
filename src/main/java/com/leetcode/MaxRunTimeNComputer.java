package com.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaxRunTimeNComputer {

    public static void main(String[] args) {
        System.out.println(new MaxRunTimeNComputer().maxRunTime(2, new int[]{3, 3, 3}));
    }


    public long maxRunTime(int n, int[] batteries) {


        //per computer = per battery,
        //all n computer must be charge together
        //minimum time is min of battery value for all computer
        //max value for each battery can be sum of batteries/n
        //if all have same value 5,5,5 n=3 so each batty need 15/3 hours max
        // if 5 4 5, again to maintain all computer charged max time for a computer will be 14/3=6.6, not 5*3/3
        long low =Integer.MAX_VALUE;
        long answer=-1;
        long high=0;

        for(int bat:batteries){
            low=Math.min(low,bat);
            high+=bat;
        }

        high=(high/n)+1;

        while(low<high){
            long mid=low+(high-low)/2; //this is the hour should take by all computer in charge state

            long target=mid*n;
            long sum=0;
            for(int i=0;i< batteries.length;i++){
                if(batteries[i]<mid){
                    sum+=batteries[i]; //if battery charged hour is less then mid take that
                }else{
                    sum+=mid;
                }
            }

            if(sum>=target){ //if we are able to managed that hour , we can check for greater hour
                answer=mid;
                low=mid+1;
            }else{
                high=mid; //if not expected hour must be less then mid hour
            }



        }

        return  answer;




    }

}
