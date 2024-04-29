package com.leetcode;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        //  System.out.println(new Test().minFallingPathSum(new int[][]{{7}}));
        System.out.println(new Test().minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10}));
        System.out.println(new Test().minimumAddedInteger(new int[]{4, 6, 3, 1, 4, 2, 10, 9, 5}, new int[]{5, 10, 3, 2, 6, 1, 9}));


    }


    public int medianOfUniquenessArray(int[] nums) {
        List<Integer> unique = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);

                unique.add(set.size());
            }
        }

        Collections.sort(unique);

        int mid = unique.size() / 2;
        if ((unique.size() & 1) == 0) {
            //even
            return Math.min(unique.get(mid - 1), unique.get(mid));
        }else {
            return unique.get(mid);
        }


    }


    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int maxdiff = 1000000;
        int countCheck = nums2.length;
        if (nums2.length < 3) countCheck = nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {

                if (i != j) {

                    int prevDiff = 1000000;
                    int count = 0;

                    for (int k = 0, l = 0; k < nums2.length; k++) {
                        if (l == i || l == j) {
                            l++;
                            k--;
                            continue;
                        }
                        int diff = nums2[k] - nums1[l];
                        if (prevDiff == 1000000) {
                            prevDiff = diff;
                            count = 1;
                        } else if (prevDiff == diff) {
                            count++;
                        }
                        l++;
                        //  if(count>=Math.min(nums2.length,3)) break;
                    }

                    if (count == countCheck && prevDiff < maxdiff) {
                        maxdiff = prevDiff;
                    }


                }

            }
        }


        return maxdiff;
    }


    public long numberOfRightTriangles(int[][] grid) {

        int count = 0;

        int[] dprow = new int[grid.length];
        int[] dpcol = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dprow[i]++;
                    dpcol[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && dprow[i] > 1 && dpcol[j] > 1) {
                    count += (dprow[i] - 1) * (dpcol[j] - 1);

                }
            }
        }

        return count;
    }

    public int findRotateSteps(String ring, String key) {

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < ring.length(); i++) {
            int index = ring.charAt(i) - 'a';
            lists.get(index).add(i);
        }
        int ans = 0;
        int j = 0;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            List<Integer> source = lists.get(index);
            boolean found = false;
            for (int s : source) {
                if (s == j) {
                    ans++;
                    found = true;
                    break;
                }
            }

            if (found) continue;

            List<Integer> possible = lists.get(index);
            int min = 1000;
            int temp = 0;
            for (int k : possible) {

                if (k > j) {  // .j....k..
                    int m = k - j;
                    int m2 = (j + ring.length() - k) % ring.length();
                    if (m < m2) {
                        m2 = m;
                    }
                    if (m2 < min) {
                        min = m2;
                        temp = k;
                    }
                } else { // .k....j..
                    int m = j - k;
                    int m2 = (k + ring.length() - j) % ring.length();
                    if (m < m2) {
                        m2 = m;
                    }
                    if (m2 < min) {
                        min = m2;
                        temp = k;
                    }

                }
            }

            if (min != 1000) {
                j = temp;
                ans += min + 1;
            }

        }

        return ans;

    }


    public int minFallingPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        int[] prev = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            dp[i] = grid[0][i];
        }
        int maxVal = 100 * 200;

        for (int i = 1; i < grid.length; i++) {
            prev = dp;
            dp = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                int leftVal = maxVal;
                if (j > 0) {
                    leftVal = prev[j - 1];
                }
                int rightVal = maxVal;
                if (j < grid[0].length - 1) {
                    rightVal = prev[j + 1];
                }

                dp[j] = grid[i][j] + Math.min(leftVal, rightVal);
            }
            prev = dp;
        }
        maxVal = 100 * 200;
        for (int i = 0; i < grid[0].length; i++) {
            maxVal = Math.min(prev[i], maxVal);
        }

        return maxVal;


    }
}
