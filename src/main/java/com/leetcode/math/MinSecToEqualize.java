package com.leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSecToEqualize {
    //https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/description/
    public static void main(String[] args) {
        System.out.println(new MinSecToEqualize().minimumSeconds(new ArrayList<>() {{
            add(1);
            add(2);
            add(1);
            add(2);
        }})); //answer will be 1


        System.out.println(new MinSecToEqualize().minimumSeconds(new ArrayList<>() {{
            add(2);
            add(1);
            add(3);
            add(3);
            add(2);
        }}));


        System.out.println(new MinSecToEqualize().minimumSeconds(new ArrayList<>() {{
            add(17);
            add(10);
            add(10);
            add(12);
            add(16);
            add(12);
        }}));
    }

    public int minimumSeconds(List<Integer> nums) {

        //if unique character present like 1,2,3,4 and it is circular array so difference between two char will be n
        //1+n -1 //same character will be n distance away
        //if duplication chars then find max distance b/w 2 chars , also add circullar max difference
        //now each character at a 1 sec replace -1,+1 character so total time taken to replace each character will be
        // maxdiff/2, as we are calculating ciruclar distance to so find minimum of max difference it will be our answer


        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> lastSeen = new HashMap<>();

        int n=nums.size();
        for (int i = 0; i < n; i++) {
            nums.add(nums.get(i)); ////to calculate circular distance for i , distance will be i+n
        }

            for (int i = 0; i < nums.size(); i++) {
            int num=nums.get(i);
            if (lastSeen.containsKey(num)) {

                distance.put(num, Math.max(distance.get(num), i - lastSeen.get(num)));
                lastSeen.put(num, i);
            } else {
              //  nums.add(num); //to calculate circular distance for i , distance will be i+n
                lastSeen.put(num, i);
                distance.put(num,0);
            }
        }

        int minDis = nums.size() + 2;

        for (Integer m : distance.values()) {
            minDis = Math.min(minDis, m);
        }

        return minDis / 2; //both size -1+1 replacing so

    }
}
