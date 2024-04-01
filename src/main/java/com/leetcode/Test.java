package com.leetcode;

public class Test {


    public static void main(String[] args) {

        System.out.println(new Test().subarraysWithKDistinct(new int[]{27,27,43,28,11,20,1,4,49,18,37,31,31,7,3,31,50,6,50,46,4,13,
                31,49,15,52,25,31,35,4,11,50,40,1,49,14,46,16,11,16,39,26,13,4,37,39,46,27,49,39,49,50,37,9,30,45,51,
                47,18,49,24,24,46,47,18,46,52,47,50,4,39,22,50,40,3,52,24,50,38,30,14,12,1,5,52,44,3,49,45,37,40,35,
                50,50,23,32,1,2}, 20));


    }


    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] freq = new int[nums.length + 1];
        int uniqueElement = 0;
        int subArrayCount = 0;
        int duplicateElementIndex = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {

            if (freq[nums[right]] == 0) {
                uniqueElement++;

            }
            freq[nums[right]]++;
            if (uniqueElement == k) {
                while (freq[nums[left]] > 1) {

                    freq[nums[left]]--;
                    left++;
                }

                subArrayCount++;
                subArrayCount += left - duplicateElementIndex; //1 21 ,duplicateElementIndex=0,left=1 , extra count=1
                //121 12, 21, 121 (this is extra)
            } else if (uniqueElement > k) {
                while (uniqueElement > k) {
                    freq[nums[left]]--;
                    if (freq[nums[left]] == 0) {
                        uniqueElement--;
                    }
                    left++;
                }
                duplicateElementIndex = left;

                while (freq[nums[left]] > 1) { //for finding the smallest sub array

                    freq[nums[left]]--;
                    left++;
                }
                subArrayCount++;
                subArrayCount += left - duplicateElementIndex;
            }


        }

        return subArrayCount;
    }


    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        if (left == 0 || right == 0) return 0;

        int bitCount = 1;
        long leftBoundary = 0;
        for (int i = 0; i < 32; i++) {
            long temp = (long) (bitCount << i);
            if (temp <= left) {
                leftBoundary = temp;
            } else {
                break;
            }
        }
        long rightBoundary = leftBoundary << 1;


        if (right < rightBoundary) {
            int temp2 = (int) (left & right);
            int ans = 0;
            int max = (int) leftBoundary;
            int temp3 = 1;
            while (temp3 <= max) {

                if ((temp2 & temp3) == temp3) {
                    ans += temp3;
                }
                temp3 = temp3 << 1;

            }
            return ans;
        }
        return 0;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return 0;

    }


}
