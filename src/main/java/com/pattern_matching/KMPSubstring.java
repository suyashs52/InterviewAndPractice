package com.pattern_matching;

public class KMPSubstring {

    public static void main(String[] args) {

        KMPSubstring kmp = new KMPSubstring();
        kmp.search("ABABDABACDABABCABAB", "AAACAAAA");
        kmp.search("ABABDABACDABABCABAB@ABABCABAB", "ABABCABAB");

    }

    static void search(String text, String pattern) {
        int[] lps = largestPrefixSuffix(pattern);
        int i = 0;
        int j = 0; //will contain pattern length
        while (i < text.length()  ){ //- j+ pattern.length() //if we want to avoid last len calculation from i
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j==pattern.length()){ //during iteration if j reached to end
                System.out.println("Pattern Found at index : "+(i-j));
                j=lps[j-1];
            }else if(i<text.length() && text.charAt(i) != pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
            System.out.println(lps);

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
}
