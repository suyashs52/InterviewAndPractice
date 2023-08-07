package com.leetcode.bs;

public class MissingElementInSorted {
    //https://leetcode.com/problems/missing-element-in-sorted-array/
    public static void main(String[] args) {

//        kth missing element
//
//        at i
//        total element = i+1
//        existing ele=arr[i]-arr[0]+1
//
//        total missing element till ith index= arr[i]-arr[0]+1-i-1=arr[i]-arr[0]-i
//
//        if a[i]-a[0]-i <k //total missing element at ith index is <=k means ill find element more at right side so left=mid
////if missing total element is > k , right=mid-1
//
//        ex lets answer is missing element answer-a[0]+1 might be the lengh
//        also left+1 is total element at left index , and kth is missing element so left+1+k will be the answer
//        answer-a[0]+1=left+1+k
//        answer=left+k+a[0];

        System.out.println(new MissingElementInSorted().missingElement(new int[]{4, 7, 9, 10}, 3));
        System.out.println(new MissingElementInSorted().missingElement(new int[]{1, 2, 4}, 3));
    }

    public int missingElement(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] + k;
        }

        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if ((nums[mid] - nums[0]) - mid < k) {
                left = mid + 1;
                //  right=mid;
            } else {
                //left=mid+1;
                right = mid;
            }
        }
        left--; // stops at el, that [l-1,l] has k-th missed num, go to l-1
        // int skipped=(nums[left]-nums[0])-left;
        // return nums[left]+(k-skipped);
        return nums[0] + k + left;


//        int n = nums.length;
//        int left = 0, right = n - 1;
//
//        while (left < right) {
//            int mid = right - (right - left) / 2; //check here right-(
//            if (nums[mid] - nums[0] - mid < k) {
//                left = mid;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return nums[0] + k + left;
//

    }
}
