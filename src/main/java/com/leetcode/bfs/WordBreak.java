package com.leetcode.bfs;

import java.util.*;

public class WordBreak {
    //https://leetcode.com/problems/word-break/editorial/
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak_dp_new("leetcode", new ArrayList<>() {{
            add("leet");
            add("code");
        }}));
        System.out.println(new WordBreak().wordBreak_trie("leetcode", new ArrayList<>() {{
            add("leet");
            add("code");
        }}));

        System.out.println(new WordBreak().wordBreak_botom_up("leetcode", new ArrayList<>() {{
            add("leet");
            add("code");
        }}));


        //top down

    }

    public boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }

    public boolean wordBreak_trie(String s, List<String> wordDict) {
        //build up trie using wordDict
        //O(n^2 +mk) mk for trie building , n2 for iteration
        //space mk+n, n is dp array mk trie
        TrieNode node = new TrieNode('&');

        for (String str : wordDict) {

            TrieNode h = node;

            for (int i = 0; i < str.length(); i++) {
                if (h.map.containsKey(str.charAt(i)) == false) {
                    h.map.put(str.charAt(i), new TrieNode(str.charAt(i)));
                }
                h = h.map.get(str.charAt(i));
            }

            h.isWord = true;


        }

        TrieNode node1 = node;
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true; not true String s="a" wordDict=["b"]
        int count = 0;

        for (int sub = 0; sub < s.length(); sub++) { //leet , code ...start from l and check le, lee , leet, leetc exist or not
            //in trie if yes then dp[sub] =true;
            //ex sub=1, l"e", if "l" not exist in dictionary so no need to iterate from sub=1
            if (sub == 0 || dp[sub - 1] == true) {
                TrieNode tnode = node;


                for (int j = sub; j < s.length(); j++) {


                    if (tnode.map.containsKey(s.charAt(j))) {
                        tnode = tnode.map.get(s.charAt(j)); //leet (leetcode)//when c comes in s.charAt(j) ,
                        // so child of trienode t not contain c..ode..
                        //so null break; start fresh
                    } else {
                        break; //no word exist till here only substring present after that check
                        //for another substring for dictionary
                    }

                    if (tnode.isWord == true) {
                        dp[j] = true;
                    }

                }
            }


        }

        return dp[s.length() - 1];


    }

    public boolean wordBreak_botom_up(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()];
        //check if length i , substring possible from worddict

        for (int i = 0; i < s.length(); i++) {

            for (String w : wordDict) {
                if (w.length() - 1 > i) { //if i is less then last character of word
                    continue;
                }

                if (i == w.length() - 1 || dp[i - w.length()] == true) { //leet , i=4-w:leet(c)..4==0
                    //when leetcod(e) w=code, i=7, 7-4=3,dp[3]=true (leet)  //below s.substring =code,
                    if (s.substring(i - (w.length() - 1), i + 1).equals(w)) {

                        dp[i] = true;

                    }
                }
            }


        }

        return dp[s.length() - 1];

    }

    public boolean wordBreak_dp_new(String s, List<String> wordDict) {
        //till j, if substring possible
        //O(n^3+mk) m=length of worddict, k=avg length of substring
        //set contain O(mk) , slength =n , 2 loop till i =n, so n^2 setcontains check for each n again take O(n)
        //so total O(n^3)
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];//check if it is ok to build ith index string from wordDict

        dp[0] = true; //0 lenght string is always possible

        for (int i = 1; i <= s.length(); i++) {
            //is it possbile to form substring of length < i
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) //if substring present in dictionary
                { //and prev substring too present
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()]; //this will return true if using wordDict s length string possible
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return true;
    }

    static class TrieNode {
        Character s;
        boolean isWord;
        Map<Character, TrieNode> map = new HashMap<>();

        TrieNode(Character s) {
            this.s = s;
        }
    }
}
