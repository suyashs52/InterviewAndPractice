package com.leetcode.dp;

import java.util.Arrays;

public class MaxNoOfEvents {

    int[][] dp;

    public static void main(String[] args) {
        System.out.println(new MaxNoOfEvents().maxValue_wout_bs(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
    }

    public int maxValue_wout_bs(int[][] events, int k) { //so give time limit exceed

        //we can start from day 0 and take events
        //sorting take nlog(n) +n*k
        //space is n*k
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int end = -1; //first event can always start
        dp = new int[k + 1][events.length]; //k events, contains max value to attend  all event till jth
        // events max can take k
        for (int[] d : dp)
            Arrays.fill(d, -1);

        // return dfs_wout_bs(events,k,0,0,-1);
        return dfs_bs(events, k, 0, 0, dp);
    }

    int dfs_wout_bs(int[][] event, int k, int index, int count, int prevEndDay) {
        //O(n*(k+log(n)) as
        //O(n^2 * k
        //like [1, 100, 1], [2, 100, 1], [3, 100, 1], ... [99, 100, 1], [101, 102, 1]
        //for each index it need to iterate n-i index so n*n from if condition prevEndDay >=event[index][0]
        //so time out
        if (count == k) return 0;
        if (index == event.length) return 0;

        if (prevEndDay >= event[index][0]) { //if prev end time is greater then current start time so can't attend current event
            return dfs_wout_bs(event, k, index + 1, count, prevEndDay);
        }

        if (dp[count][index] != -1) {
            return dp[count][index];
        }

        int ans = Math.max(event[index][2] + dfs_wout_bs(event, k, index + 1, count + 1, event[index][1]),
                dfs_wout_bs(event, k, index + 1, count, prevEndDay));

        dp[count][index] = ans;

        return ans;


    }


    int dfs_bs(int[][] event, int k, int index, int count, int[][] dp) {
        if (count == k) return 0;
        if (index == event.length) return 0;
        if (dp[count][index] != -1) return dp[count][index];
        int val = event[index][2];
        int next = binarySearch(event, index, event[index][1]);

        return dp[count][index] = Math.max(val + dfs_bs(event, k, next, count + 1, dp),
                dfs_bs(event, k, index + 1, count, dp));

    }


    public int maxValue_bottom_up(int[][] events, int k) {
        //n*k*log(n)
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int curIndex = n - 1; curIndex >= 0; --curIndex) {
            for (int count = 1; count <= k; count++) {
                int nextIndex = binarySearch(events,curIndex, events[curIndex][1]);
                dp[count][curIndex] = Math.max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex]);
            }
        }
        return dp[k][0];//return k count, 0 index reached
    }
    int binarySearch(int[][] event, int left, int target) {
        int l = left;
        // int r=event.length-1;
        int r = event.length; //we use this becuase left can be event.length if no event found

        while (l < r) {//at last l=event.length if no value found so l==r break :)
            //  while(l<=r){
            int mid = l + (r - l) / 2;

            if (event[mid][0] > target) { //if start time of event[mid] > target/means we will get right in left-mid
                r = mid;
            } else { //event[mid][0]<=target event start time <= target time so move to mid+1
                l = mid + 1;
            }

        }
        return l;
    }
}
