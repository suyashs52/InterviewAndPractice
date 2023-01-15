package com.chef.JAN231C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ARRHALVES {

    static ARRHALVES.FastScanner fs = new ARRHALVES.FastScanner();
    public static void main (String[] args) throws Exception {

        int n=fs.nextInt();

        for(int i=0;i<n;i++){
            int size=fs.nextInt();
            long[] array=new long[size*2];
            int s2=size;
            size=size*2;
            for(int j=0;j<size;j++){
                array[j]=fs.nextLong();
            }

            List<Integer> mis1=new ArrayList<>();
            List<Integer> mis2=new ArrayList<>();

            for (int j=0;j<s2;j++){
                if(array[j]>s2){
                    mis1.add(j+1);
                }
            }
            for(int j=s2;j<size;j++){
                if(array[j]<=s2){
                    mis2.add(j+1);
                }
            }

            Collections.sort(mis1);
            Collections.sort(mis2);

            long ans=Integer.MAX_VALUE;
            for(int j=0;j<mis1.size();j++){
                ans+= mis2.get(j)-mis1.get(j);
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

