package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {


    public static void main(String[] args) {


        //  System.out.println(new Test().minFallingPathSum(new int[][]{{7}}));
        System.out.println(new Test().compareVersion("1.2","1.10"));


    }
    public int compareVersion(String version1, String version2) {

        int i=0;
        int j=0;

        while(i<version1.length() || j < version2.length()){
            int v1=0;
            int v2=0;

            while(i<version1.length() && version1.charAt(i)!='.'){
                v1=v1*10 + (version1.charAt(i)-'0');
                i++;
            }
            while(j<version2.length() && version2.charAt(j)!='.'){
                v2=v2*10 + (version2.charAt(j)-'0');
                j++;
            }

            if(v1<v2) return -1;
            else if (v1>v2) return 1;

        i++;
        j++;
        }

        return 0;


    }


}
