package com.chef.JAN231C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ARRSWAP {

    static ARRSWAP.FastScanner fs = new ARRSWAP.FastScanner();
    public static void main (String[] args) throws java.lang.Exception {

        int n=fs.nextInt();

        for(int i=0;i<n;i++){
            int size=fs.nextInt();
            long[] array=new long[size*2];
            int s2=size;
            size=size*2;
            for(int j=0;j<size;j++){
                array[j]=fs.nextLong();
            }

            Arrays.sort(array);
            long min=100000000000l;
            System.out.println(min);
            if(size==2){
                System.out.println(array[1]-array[0]);
                continue;
            }

            //now slide
            for(int k=-1;k<s2;k++){
                min=Math.min(min,array[s2+k]-array[k+1]);
            }
    ///working on corner cases
            for(int k=0;k<=s2;k++){
                min=Math.min(min,array[s2+k-1]-array[k]);
            }
            System.out.println(min);

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

