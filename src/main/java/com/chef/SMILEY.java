package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class SMILEY {
    static SMILEY.FastScanner fs = new SMILEY.FastScanner();

    public static void main(String[] args) throws Exception {


        // your code goes here
      //  https://www.codechef.com/problems/SMILEY?tab=solution

        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int len = fs.nextInt();
            String s = fs.next();

            int f = 0;
            int count = 0;
            int c = 0;
            int baseC = 0;
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == ':' && c == 0) {
                    c = 1;
                } else if (c == 1 && s.charAt(j) == ')') {
                    baseC = 1;
                    continue;
                } else if (c == 1 && baseC == 1 && s.charAt(j) == ':') {
                    count++;
                    c = 1;
                    baseC = 0;
                } else {
                    c=0;
                    if (s.charAt(j) == ':')
                        c = 1;

                    baseC = 0;
                }
            }
            System.out.println(count);

            //we can also use str.split(":"), then iterate from 1 to n-1

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
