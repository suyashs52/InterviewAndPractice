package com.leetcode.str;

public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        String t = s2;

        if (s1.length() < s2.length()) {
            s2 = s1;
            s1 = t;
        }

        if (s1.length() + s2.length() != s3.length()) return false;
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < s3.length()) {
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                i++;

            } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                j++;

            }
            k++;
        }

        return (k == i + j);
    }
}
