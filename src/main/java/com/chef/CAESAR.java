package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class CAESAR {
    static CAESAR.FastScanner fs = new CAESAR.FastScanner();

    public static void main(String[] args) throws java.lang.Exception {

//https://www.codechef.com/problems/CAESAR?tab=solution
        // your code goes here


        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int test = fs.nextInt();
            String a = fs.next();
            String b = fs.next();
            String c = fs.next();

            int shift = b.charAt(0) - a.charAt(0);
            //if a>b so negative value ex: def bcd so b-d=-2
            //add 26, why we want d to convert to b d+26-2=d+26 is next d -2 is b
            //becuase alphabet is in circle d+24=b
            if (shift < 0) shift += 26

                    ;

            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < test; j++) {
                int next = (int) (c.charAt(j) - 'a') + shift;
                if (next > 25) next -= 26; //if 26 is 26 it should be 0
                sb.append((char) ('a' + next));
            }

            System.out.println(sb.toString());


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
