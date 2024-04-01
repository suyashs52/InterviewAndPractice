package com.leetcode.dp;

import java.util.*;

public class ArithmaticsSlice2 {
    static int[] fac = new int[10001];

    //https://leetcode.com/problems/arithmetic-slices-ii-subsequence/editorial/
    {
        preFact();
    }

    public static void main(String[] args) {
      //  System.out.println(new ArithmaticsSlice2().numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(new ArithmaticsSlice2().numberOfArithmeticSlices(new int[]{7,7,7,7,7}));

    }

    static int ncr(int n, int r) {
        int remainder=n-r;
        remainder=Math.max(n-r,r);
        return (fac[n] / (fac[r] * fac[n - r]));
    }

    static void preFact() {
        fac[0] = 1;
        fac[1] = 1;
        fac[2] = 2;

        for (int i = 3; i < 10001; i++) {
            fac[i] = i * fac[i - 1];
        }
    }

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);//at j index how many element have diff diference
                int origin = cnt[i].getOrDefault(diff, 0); //at given ith(last) index how many element has same different
               //abb tak ith index mai diff kai kitne element aa chuke hai
                //jth tak pai kitne element diff kai aa chuke hai , sabko sum +1
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int)ans;
    }

    public int numberOfArithmeticSlices1(int[] nums) {

        Arrays.sort(nums);

        int diff = 0;
        if (nums.length <= 2) return -1;

        List<Integer> count = new ArrayList<>();
        diff = nums[1] - nums[0];
        int diffCount = 2;
        boolean change = false;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                diffCount++;
                change = false;
            } else {
                change = true;
                count.add(diffCount);
                if (i + 1 < nums.length) {
                    diffCount = nums[i + 1] - nums[i];
                    diffCount = 2;
                }
            }
        }
        if (diffCount > 2 && change == false) {
            count.add(diffCount);
        }
        int ans = 0;
        for (Integer c : count) {
            //nc3+nc4+nc5
            //
            for (int i = 3; i <= c; i++) {
                ans += ncr(c, i);
            }
        }
        return ans;


    }
}
