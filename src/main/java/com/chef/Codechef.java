package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Codechef {

    static Codechef.FastScanner fs = new Codechef.FastScanner();

    public static void main(String[] args) throws java.lang.Exception {

        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {

            int len=fs.nextInt();
            String s=fs.next();


            if(s.length()%3==1){
                System.out.println("YES");
            }else {
                int[] a=new int[26];
                for (int j = 0; j < 26; j++) {
                    a[j]=-20;
                }
                int remainder=s.length()%3;
                boolean found=false;
                if(remainder==2){
                    //aa abcda
                    for (int j = 0; j < len; j++) {
                        int index=s.charAt(i)-'a';
                        int i2=-1;
                        if(a[index]>0){
                            i2=j-a[index]+1;
                        }
                        if(a[index]==j-1){
                            found=true;
                            break;
                        } else if (a[index]==j-4) {
                            found=true;
                            break;
                        }
                        a[s.charAt(i)-'a']=j;


                    }
                }
                else if(remainder==0){
                    //aaa, aba,
                    for (int j = 0; j < len; j++) {
                        int index=s.charAt(i)-'a';
                        if(a[index]==j-2){
                            found=true;
                            break;
                        } else if (a[index]==j-1) {
                            found=true;
                            break;
                        }
                        a[s.charAt(i)-'a']=j;


                    }

                }

                if(found){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }

            }


        }
        // your code goes here
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
