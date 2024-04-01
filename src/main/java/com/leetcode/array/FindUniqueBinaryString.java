package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
//https://leetcode.com/problems/find-unique-binary-string/description/
    public static void main(String[] args) {

        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryString_rec(new String[]{"00","01"}));

    }



    public String findDifferentBinaryString(String[] nums) {
//Cantor's diagonal argument
        // n unique binary strings each of length n, , so 2 len will always has 2 char string, 3 len will have 3
        //16char len only contain 16 length
        //so 3len will have max 0-7 8 nums here in array we will get 3 nums only, so last we can have 4 possibilty
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }

        return ans.toString();
    }


    int n;
    Set<String> numsSet = new HashSet();

    private String generate(String curr) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public String findDifferentBinaryString_rec(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            numsSet.add(s);
        }

        return generate("");
    }
}
