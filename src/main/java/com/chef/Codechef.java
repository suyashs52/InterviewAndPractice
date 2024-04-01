package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Codechef {
    static Codechef.FastScanner fs = new Codechef.FastScanner();
    static int[] dp;

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here

        /*
       3
3 2
3 2 4
3 5
3 2 4
4 5
3 7 8 2


1
3 5
3 2 4

        */
        System.out.println(1+ 2+ 4+ 8 +16+ 32+ 64);

        int test = fs.nextInt();

        for (int i = 0; i < test; i++) {

            int n = fs.nextInt();
            int m = fs.nextInt();



            Set<Integer> set = new HashSet<>();

            int current = 0;
            int maxGcd = m/2;

            if(m==n){
                for (int j = 1; j < n; j++) {
                    System.out.print(j+" ");
                }
                System.out.println();
            }else {
                int maxlenWithGCD=n/2;
                if(m<=maxlenWithGCD){
                    int count=0;
                    for(int j=maxGcd;j<=n;j+=maxGcd){
                        System.out.print(j+" ");
                        count++;
                        if(count>=m){
                            break;
                        }

                    }
                    System.out.println("");
                }else{
                    for (int j = 1; j <= m; j++) {
                        System.out.println(j+" ");
                    }
                    System.out.println();
                }
            }


            for (Integer j : set) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }


    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
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