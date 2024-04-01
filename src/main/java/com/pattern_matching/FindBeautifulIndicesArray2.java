package com.pattern_matching;

import java.util.ArrayList;
import java.util.List;

public class FindBeautifulIndicesArray2 {

    public static void main(String[] args) {

        FindBeautifulIndicesArray2 kmp = new FindBeautifulIndicesArray2();

        System.out.println(kmp.beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my"
                , "squirrel"
                , 15));
        System.out.println(kmp.beautifulIndices("onwawarwa", "wa"
                , "r"
                , 2));

    }

    private static int[] largestPrefixSuffix(String pattern) {

        int[] pi = new int[pattern.length()];

        pi[0] = 0; //prefix of oth index is 0
        int len = 0;
        int i = 0;
        for (i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(len)) { //if path add how much prefix matched
                pi[i] = ++len;
                i++;
            } else { //aab index at 2 ,,aaacaaa(a) so 0,1,2,0,1,2,3,(3) below will take len=len[2] and in next in ++len
                if (len != 0)
                    len = pi[len - 1];  //abcab(d) so last 2 are matching
                    //don't increse i;
                else {
                    //len =0

                    pi[i] = 0;
                    i++; //increase i

                }

            }
        }
        return pi;

    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> l1 = search(s, a);
        List<Integer> l2 = search(s, b);
        List<Integer> l3=new ArrayList<>();
        for(int i=0,j=0;i<l1.size();i++){
            while(j<l2.size() && l1.get(i)>l2.get(j)  && Math.abs(l1.get(i)-l2.get(j))>k) j++;
            if(j<l2.size() && Math.abs(l1.get(i)-l2.get(j))<=k) l3.add(l1.get(i));
            //if l1.get(i)<l2.get(j) take difference if not under k , for move j it will again not under k
            //wawawawarrrrrwawawawawawa // wa r, so 0st nd first r index index
            //so try next i,
            //if l1(i)>l1(j), increment j to match i, until the difference is >k
            //we can do binary search
            //https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii/solutions/4561712/exactly-same-code-for-both-i-and-ii-c-java-kmp-codestorywithmik/


        }
        return l3;
    }

    List<Integer> search(String text, String pattern) {
        List<Integer> l = new ArrayList<>();
        int[] lps = largestPrefixSuffix(pattern);
        int i = 0;
        int j = 0; //will contain pattern length
        while (i < text.length()) { //i- j+ pattern.length() <= //if we want to avoid last len calculation from i
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) { //during iteration if j reached to end
                l.add(i - j);
                // System.out.println("Pattern Found at index : "+(i-j));
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return l;
        // System.out.println(lps);

    }
}
