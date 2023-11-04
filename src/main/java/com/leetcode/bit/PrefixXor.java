package com.leetcode.bit;

public class PrefixXor {
//https://leetcode.com/problems/find-the-original-array-of-prefix-xor/editorial/
    public static void main(String[] args) {

        int[] res = new PrefixXor().findArray(new int[]{5, 2, 0, 3, 1});
        for (int i : res)
            System.out.println(i);

        //5 ^ 7=2 101 ^ x=010 so x should be 111 101^111=010 also
        // 101^010==111
    }

    public int[] findArray(int[] pref) {

        int[] res = new int[pref.length];
        res[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            res[i] = pref[i - 1] ^ pref[i];
        }


        return res;
    }
}
