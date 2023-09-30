package com.leetcode.string;

public class SubstringLargestVariance {
    //https://leetcode.com/problems/substring-with-largest-variance/description/
    public static void main(String[] args) {
        System.out.println(new SubstringLargestVariance().largestVariance("aababbb"));
        System.out.println(new SubstringLargestVariance().largestVariance("abcde"));
        System.out.println(new SubstringLargestVariance().largestVariance("ababab"));
        System.out.println(new SubstringLargestVariance().largestVariance("lripaa"));

    }

    public int largestVariance(String s) {

        //we need to find largest difference b/w 2 count of 2 chars in a substring
        char[] str_char = s.toCharArray();
        int gmax = 0;

        int[] counter = new int[26]; //for minimazing the iteration

        for (char c : str_char) {
            counter[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (counter[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (i == j) continue;
                if (counter[j] == 0) continue;
                //if both are same then difference =0;
                char[] ch = str_char;
                char first = (char) ('a' + i);
                char sec = (char) ('a' + j);
                int major = 0;
                int minor = 0;
                boolean minor_found = false;
                for (int k = 0; k < str_char.length; k++) {

                    if (ch[k] == first) {
                        major++;
                    }

                    if (ch[k] == sec) {
                        minor++;
                    }


                    if (minor > 0) {
                        //if we have at least 1 minor
                        gmax = Math.max(gmax, major - minor);

                    } else if (minor_found) {
                        gmax = Math.max(gmax, major - 1);
                    }
                    if (minor > major) { //kadans algoright if we have negative difference make sum=0;
                        minor = 0;
                        major = 0; //so we can start from next substring
                        minor_found = true;
                    }
                }
            }
        }


        return gmax;

    }
}
