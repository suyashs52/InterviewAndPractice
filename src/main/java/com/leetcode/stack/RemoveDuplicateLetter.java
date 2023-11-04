package com.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetter {

    //https://leetcode.com/problems/remove-duplicate-letters/description/

    public static void main(String[] args) {
        // System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters_stack("bcabc"));
        //System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters_stack("cbacdcbc"));
        System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters_stack("bbcaac"));
        System.out.println(new RemoveDuplicateLetter().removeDuplicateLetters("bbcaac"));

        Arrays.sort(new Integer[]{1,2,3},(a,b)->Integer.compare(a%2,b%2)); //this will sort even and odd Integer.compare
        //comare asce order sorting 1,0 will be change to 0,1 if(a>b) return 1

        Integer.compare(4%2,5%2);
    }


    public String removeDuplicateLetters_stack(String s) {

        //need to find smallest ordered string
        //if count of char is >1, so can comes latter
        //if char is smaller then added and other string later present remove other string, add smaller string

        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        //we can use map char,index of last occurence and compare it
        //or can count freq

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            //abac -->ab  dont add next a as a already added
            //either use list of seen element or replace the character in next substring
            if (set.contains(s.charAt(i))) {
                freq[s.charAt(i) - 'a']--;
                continue;
            }

            int index = s.charAt(i) - 'a';
            //remove if top stack elemnt apprear later too and > current char
            while (stack.isEmpty() == false && stack.peek() > s.charAt(i) && freq[stack.peek() - 'a'] > 0) {
                Character c1 = stack.pop();
                set.remove(c1);
            }

            set.add(s.charAt(i));
            stack.add(s.charAt(i));
            freq[index]--;
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();


    }

    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) return "";
        //add the smallest elemtent or single occur character

        int pos = 0;
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i; //if ith char is less then current change position
            freq[s.charAt(i) - 'a']--;
            if (freq[s.charAt(i) - 'a'] == 0) break; //means we found single char and now it is 0
            //so position is either 0 or point to smallest character till yet and we break loop
            //becuase after this we cant move ahead
            // dabcda so pos=1,, a b not b freq is 0 so we break and add a to result becuaes next
            // aba we will have ab not ba to contain unique sort substring, so once it is finalize
            //we never cositer pos selected index,

        }

        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1)
                .replace(s.charAt(pos) + "", ""));
    }
}
