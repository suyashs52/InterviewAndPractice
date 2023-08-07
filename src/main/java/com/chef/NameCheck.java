package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class NameCheck {
    static NameCheck.FastScanner fs = new NameCheck.FastScanner();

    public static void main(String[] args) throws Exception {

        String name="rown";
        for(int i=0;i<26;i++){
            System.out.println((char)('a'+i)+name+"\t\t"+name+(char)('a'+i));
        }



    }

    private static int binaryNearestSearch(long[] prefix, long q) {
        int f=0;
        int l=prefix.length-1;

        while(f<l){
            int m=f+(l-f)/2;

            if(prefix[m]==q) return  m;
            if(prefix[m]>q){ //value present is greater then kth find element that is not the index, minimize it
                l=m;
            }else {
                f=m+1; //value present is less then q also the same, need to find nearest min match
            }

        }
        return f;
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
