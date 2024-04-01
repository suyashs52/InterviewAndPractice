package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class MAKE0 {
    //https://www.codechef.com/problems/MAKE0?tab=submissions
    static MAKE0.FastScanner fs = new MAKE0.FastScanner();

    public static void main(String[] args) throws Exception {
/*

        5
        3
        1 1 1
        3
        1 2 1
        4
        1 2 2 2
        5
        1 1 2 2 2
        9
        5 3 3 5 2 4 5 2 1



            */



        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {

            int size = fs.nextInt();

            int[] a = new int[size];

            for (int j = 0; j < size; j++) {
                a[j] = fs.nextInt();
            }
            //save prefix min
            //these will work for step 1 make other reduce by 1
            List<Integer> minV = new ArrayList<>();

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < size; j++) {
                if (a[j] <= min) {
                    min=a[j];
                    minV.add(a[j]);
                }
            }

            //5 3 3 5 2 4 5 2 1
            //for 5 3 3 2 2 1
            int ans = size; //that is max move to take make all 0
            for (int j = minV.size() - 1; j > -1; j--) {
                //total 1st move
                int m1 = minV.get(j);
                //this move will make element from
                //j index to size-1 index 0 of minV , rest we need to
                //make 0 by step 2
                //4521--> at 3rd index: after 2nd move : 2300
                //available elements
                int m2 = (size - (minV.size() - j)); //size=5 , index=4 , element=1

                int totalMove = m1 + m2;

                ans = Math.min(ans, totalMove);
            }

            System.out.println(ans);


        }

    }

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