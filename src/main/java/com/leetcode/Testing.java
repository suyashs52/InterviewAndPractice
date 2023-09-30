package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing {

    public static void main(String[] args) {

        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        System.out.println(new Testing().maxSubarrays(new int[]{19,19,19,19,19,19,19,19,19,19,19,19,19}));


    }

    public int maxSubarrays(int[] nums) {

        int n=1;
        System.out.println("-----");
        System.out.println(5 & 7);
        System.out.println(5 & 7 & 1);
        System.out.println(5 & 7 &1 & 3);
        System.out.println("------");
        return n;

    }

}
