package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BINGRIDFORCE {

    static BINGRIDFORCE.FastScanner fs = new BINGRIDFORCE.FastScanner();

    public static void main(String[] args) throws java.lang.Exception {
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int testCases = fs.nextInt();
            int size = fs.nextInt();

            String[] test = new String[testCases];

            for (int j = 0; j < testCases; j++) {
                test[j] = fs.next();
            }

            if (testCases == 1) {
                System.out.println(1);
            } else {
                String l1 = test[testCases - 1];
            }
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
