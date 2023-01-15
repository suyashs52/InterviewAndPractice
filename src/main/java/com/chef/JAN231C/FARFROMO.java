package com.chef.JAN231C;

import pp.m2.search.CustomSortString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FARFROMO {

    public static void main (String[] args) throws java.lang.Exception{

         int n=fs.nextInt();
         for(int i=0;i<n;i++){
             int x1= fs.nextInt();
             int y1= fs.nextInt();
             int x2=fs.nextInt();
             int y2= fs.nextInt();

             int a=x1*x1+y1*y1;
             int b=x2*x2+y2*y2;


             if(a==b){
                 System.out.println("EQUAL");
             }else if(a>b){
                 System.out.println("ALEX");
             }else{
                 System.out.println("BOB");
             }

        }


    }
    static FARFROMO.FastScanner fs = new FARFROMO.FastScanner();

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
