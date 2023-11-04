package com.chef;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static Codechef.FastScanner fs = new Codechef.FastScanner();

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            Long j=fs.nextLong();
            int mod=(int)1e9+7;
            float remain= (float) (j/5.0);

            float max= (float) (100.0/remain);

            System.out.println((Math.ceil(max)+"").replace(".0",""));
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
