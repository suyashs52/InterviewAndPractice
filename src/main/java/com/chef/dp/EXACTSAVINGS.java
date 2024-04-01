package com.chef.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class EXACTSAVINGS {
//https://www.codechef.com/problems/EXACTSAVINGS?tab=statement



    static EXACTSAVINGS.FastScanner fs = new EXACTSAVINGS.FastScanner();

    public static void main(String[] args) throws java.lang.Exception {
        //5y=(sum of ai)+Z we need to find y
        //y=((sum of ai) mod x+z mod x)mod x
        //if we find subset sum that make some remainder that above condition holds
        //we are good


        int n = fs.nextInt();

        for (int s = 0; s < n; s++) {

            int size = fs.nextInt();
            int money = fs.nextInt();
            int target = fs.nextInt();

            int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = fs.nextInt();
            }

            //find the min sum that makes a remainder
            //after taking size elemnts and x mods (0 to x-1)
            //yx=target+sumArray
            long[][] dp = new long[size + 1][money]; //taking n element so +1
            //dp is min sum possible by taking ith no of array, having j remainder  //target+sumArray more means y will be more so min sum we need

            for (int i = 0; i <= size; i++) {
                Arrays.fill(dp[i], Long.MAX_VALUE);
                dp[i][0] = 0; //if sum is 0 any value of array remainder will always be 0 //dont take any gift means sum is 0
            }

            for (int i = 1; i <= size; i++) {

                for (int j = 0; j < money; j++) { //0-money-1 remainder

                    long currValue = arr[i - 1];
                    long prevSum = dp[i - 1][j]; //0 for first time as 0 remainder
                    //take i-1 gifts for
                    long currRemainder =
                            currValue % money;
                    dp[i][j] = min(dp[i-1][j], dp[i][j]); //current min sum with ith arrays and j mod
                    //take min of min same sum possible by taking i-1 th array and j mod
                    //we must do it to reduce max value on current sum dp

                    if (prevSum == Long.MAX_VALUE && i > 1) {
                        //no min sub exist so continue

                        continue;
                    }
                    if (i > 1) { //means prev sum will be empty for i=1 dp[i][0]
                        //as we are starting from i=1
                        currRemainder = (currRemainder + prevSum % money) % money;
                        currValue = currValue + prevSum;
                    }

                    int rem = (int) currRemainder;
                    //min sum when taking i elemnts giving rem remainder
                    //min sum obtain from prev taken gift value
                    //currValue
                    dp[i][rem] = min(dp[i - 1][rem], currValue);

                }
            }

            //dp will contain min sum needed with i array all remainder
            //we need remainder
            //money*y=target+dp value
            //y=(target%money+k%money)%money so rhs always < money
            //expected remainder=(money-target%money )%money
            // 5 money , target= 12 we need remainder 3
            // 5-12%5=3 will make everything 0 so this will make 5 perfex division
            int rmndr = target % money;
            rmndr = (money - rmndr)%money;

            if (dp[size][rmndr] == Long.MAX_VALUE) {
                System.out.println("-1"); //no sum exist with expected remainder
                //so y can be getten
            } else {
                // we will get a y such that
                //y*money=min sum + target
                System.out.println((dp[size][rmndr] + target) / money);
            }

/*

3
        3 5 12
        1 2 5
        2 4 8
        3 5
        1 5 12
        2




    1
            2 3 576719
            181714 3059

*/


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


