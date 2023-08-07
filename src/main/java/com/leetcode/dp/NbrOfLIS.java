package com.leetcode.dp;

public class NbrOfLIS {

    public static void main(String[] args) {
        System.out.println(new NbrOfLIS().findNumberOfLISBottomUp(new int[]{1, 3, 5, 4, 6}));
        System.out.println(new NbrOfLIS().testTopDown(new int[]{1, 3, 5, 4, 6}));


    }

    public int findNumberOfLISBottomUp(int[] nums) {


        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 1;

        //for lis
        dp[0] = 1; //for single element always 1
        count[0] = 1;
        for (int i = 1; i < nums.length; i++) { //till ith index longest increasing subsequence
            dp[i] = 1; //last index single always 1
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) { //if prev number lesser then current
                    if (dp[j] + 1 > dp[i]) { //dp value (count) of prev is greater or equal to ith dp value so increase by 1
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; //this will contribute to conunt
                        max = Math.max(max, dp[i]); //for 1 3 5 4 6 lets i is for 6 j is for 5 so dp(5)=3 before this
                        //dp(6) was 3(1 3 6) ,dp(5)=3 , 3+1>3 so dp(6)=3+1 , count(5)=1 so again count(6)=1
                        //now if j reached to 4 value, dp(4)=3, dp(4):3+1=dp(6):4 so we can reach with lis by this too
                        //so count(6)+=count(4) //no of ways so + ,
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                        max = Math.max(max, dp[i]);

                    }
                }


            }
        }

        int ans = 0;
        for (int j = 0; j < count.length; j++) {
            if (dp[j] == max) {
                ans += count[j];
            }
        }

        return ans
                ;


    }

    public int testTopDown(int[] nums) {
        int n=nums.length;

        int[] dp=new int[n];
        int[] count=new int[n];

        //update length for index i
    int maxLen=0;
        for (int i = 0; i < n; i++) {
            findNumberOfLISTopDown(nums,dp,count,i);
            maxLen=Math.max(maxLen,dp[i]);
        }
        int c=0;
        for (int i = 0; i < n; i++) {
            if(dp[i]==maxLen){
                c+=count[i];
            }
        }
        return c;
    }

    public int findNumberOfLISTopDown(int[] nums, int[] dp, int[] count, int index) {
        if (index > dp.length - 1) return 0;
        if (dp[index] != 0) return dp[index];

        //for single char len will be 1 and count too
        dp[index] = 1;
        count[index] = 1;

        for (int i = 0; i < index; i++) { //let build logic to take max value at given index

            if (nums[i] < nums[index]) { //if valid for longest increasing subsequence
                findNumberOfLISTopDown(nums, dp, count, i); //if sub problem not solved yet solve it

                if (dp[i] + 1 > dp[index]) {
                    dp[index] = dp[i] + 1; //increase the count for current index
                    count[index] = count[i]; //this will update the same count of longest subsequence

                } else if (dp[i] + 1 == dp[index]) { //if same count occur again sum it count
                    count[index] += count[i];
                }

            }

        }

        return  dp[index];


    }


}

