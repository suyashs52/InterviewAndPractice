package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique3LenPalindrom {
    //https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    public static void main(String[] args) {
        System.out.println(new Unique3LenPalindrom().countPalindromicSubsequence("bbcbaba"));
    }

    public int countPalindromicSubsequence(String s) {
        //we need 3 chars string so first and last will be same;

        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) { //calculate the first and last occurence of same character
            int in = s.charAt(i) - 'a';
            if (first[in] == -1) {
                first[in] = i;
            }

            last[in] = i;
        }
        int count=0;

        for (int i = 0; i < 26; i++) {

            if(first[i]!=-1 && last[i]!=-1){ //if both having same character
                Set<Character> set=new HashSet<>();
                for (int j = first[i]+1; j < last[i]; j++) { //count single unique character
                    set.add(s.charAt(j));
                }
                count+=set.size();
            }

        }

        return count;

    }


}
