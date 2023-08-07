package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));

        System.out.println(new Combinations().combine(4, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();

        //4,2---[1->2,3,4 [1,2],[1,3],[1,4], 2->3,4 [2,3],[2,4], 3-> 4 [3,4] , 4* ,
        //here when i=3 and pass dfs(4,1..) i=4:4 it will add [3,4] then i>n so exit
        //for i=4 to 4 k=2, it will pass(5,1..) so it will return from last line of dfs no
        //list will be added
        dfs(n, k, 1, k, list, new ArrayList<>());

        return list;
    }

    void dfs(int n, int k, int index, int subk, List<List<Integer>> list, List<Integer> sublist) {

        if (subk == 0) { //add only k size
            list.add(new ArrayList<>(sublist));
            return;
        }
        if (index > n) return; //

        //
        int need = subk; //k-sublist.size(); 2-1=1 more step need to travel for k=2, and sub list has 1 element
        int remain = n - index + 1; // n=4, index=2 , we have sublist 1 element ex: 1, we need to travel 3 more index 2,3,4
        //if n=4,index=4 , range that we need to travel 1 element more that is 4
        int available = remain - need; //represents the count of numbers available to us as children.
        //remain is next some element we can traverse, index=1, so remaing is 4-1+1=4
        //in starting subk=2, so available will be 2 so traverse {} to 1,2,3 (total child) of empty list, 1->1,2,3,
        //----
        //  --
        //--- //this we move last one because = symbol, max element till their we can go in child
        //so traver only index to index+available
        //so index+available = index+remain-need=index + n-index+1-subk=n+1-subk
        // for (int i = index; i <= n; i++) {
        //for (int i = index; i <= n + 1 - subk; i++) {
        for (int i = index; i <= n + 1 - subk; i++) {
            sublist.add(i);
            dfs(n, k, i + 1, subk - 1, list, sublist);
            sublist.remove(sublist.size() - 1);
        }


        return;


    }
}
