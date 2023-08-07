package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class TRIPLETMIN {
    static TRIPLETMIN.FastScanner fs = new TRIPLETMIN.FastScanner();

    public static void main(String[] args) throws Exception {


        // your code goes here
        //  https://www.codechef.com/problems/TRIPLETMIN?tab=statement
        //triplet : min element out of 3 i<j<k , need to find kth smallest element in triplet array,
        //so their is an array, contain set of elements, each element is min of 3 element and elements are in sortest order
        //need to sort because we need to find smallest kth
        //2 4 2 1 sorting is 1 2 2 4, so if Kth is 2, 2nd smallest element in triplet array
        //1 2 2 , 1 2 4, 2 2 4 in 2nd it is 1 only , if 1 is smallest amound all triplet form using remainig 3c2 elemnts
        // so till 3 kth we have 1, 224 ll form group 22,24,24 add 1 along with it
        //4th smallest is 2 , because last triplet is 224,
        //input K always found  so here we do prefix sum, first 3 key 0k, from 4th  we have 2 , prefix sum is [3, 4]
        //nearest minimum of k ll be the answer

        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int len = fs.nextInt();
            int k = fs.nextInt();
            int[] array = new int[len];
            for (int j = 0; j < len; j++) {
                array[j] = fs.nextInt();
            }
            long[] query=new long[k];
            for (int j = 0; j < k; j++) {
                query[j]=fs.nextLong();
            }
            Arrays.sort(array);
            long[] prefix=new long[len-2];
            long psum=0;
            for (int j = 0; j < len-2; j++) {
                //nc2
                long remainingElement=len-j-1;
                long sum= (remainingElement*(remainingElement-1))/2;
                psum+=sum;
                prefix[j]=psum;


            }

            for (int j = 0; j < k; j++) {
                System.out.println(array[binaryNearestSearch(prefix,query[j])]);
            }

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
