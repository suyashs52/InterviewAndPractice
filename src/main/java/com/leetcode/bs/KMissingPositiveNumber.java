package com.leetcode.bs;

import com.leetcode.Test;

public class KMissingPositiveNumber {

//https://leetcode.com/problems/kth-missing-positive-number/description/
    public static void main(String[] args) {
        //index start from 1 so compare index+1 with arr[index]
        // if no missing element both will be equal
        // if some missing element if diff<k means missing total elment at index < requried missing number
        //left=mid+1 ,otherwise right=mid-1, answer is (right+1)+k , +1 due to index start from 0
        System.out.println(new KMissingPositiveNumber().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));

    }



    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1 + k;
    }

}
