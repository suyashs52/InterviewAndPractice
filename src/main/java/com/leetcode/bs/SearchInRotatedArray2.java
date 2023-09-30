package com.leetcode.bs;

public class SearchInRotatedArray2 {

    public static void main(String[] args) {
        //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
        //duplicate value can be present

        System.out.println(new SearchInRotatedArray2().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedArray2().search(new int[]{3, 5, 1}, 1));


    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            //we ll have 1 pivot
            if (nums[left] < nums[mid]) {
                //if mid element is greater nums left and if array is rotated
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]) { //we dont know where to go prev to pivot or next
                while (left <= mid && nums[left] == nums[mid]) {
                    left++;
                }
            } else if (nums[right] == nums[mid]) { //we dont know where to go prev to pivot or next
                while (right >= mid && nums[right] == nums[mid]) {
                    right--;
                }
            } else {
                //nums[left]> num[mid] it means nums mid lies  in second part of pivot
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    //target > nums[right]
                    right = mid - 1;
                }
            }
        }

        return false;

    }

    public boolean search_optimized(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            //check if same element are getting
            if (nums[mid] == nums[start]) {
                while (start < mid && nums[start] == nums[mid]) {
                    start++;
                }
            }
            //if start element is greater mid element , means mid lies left side of pivot
            boolean isArrayOnLeft = nums[start] <= nums[mid];
            boolean isTargetOnLeft = nums[start] <= target; //if target is greater then start means lies on left side

            //if both are left means start<=mid<=target
//If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
              if (isArrayOnLeft ^ isTargetOnLeft) { //pivotArray ^ targetArray
                //both are on different side
                if (isArrayOnLeft) { //means target on right side
                    start = mid + 1;
                } else {
                    //target is on left
                    end = mid - 1;
                }
            }else{
                if (nums[mid] < target) {
                    //target is greater then nums[mid]
                    start = mid + 1; //nums mid is already greater then start
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

}

