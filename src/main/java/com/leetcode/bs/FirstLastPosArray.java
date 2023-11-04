package com.leetcode.bs;

public class FirstLastPosArray {

    public static void main(String[] args) {
        //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
        int[] res1 = new FirstLastPosArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res1[0] + "," + res1[1]);
         res1 = new FirstLastPosArray().searchRange(new int[]{2,2}, 2);
        System.out.println(res1[0] + "," + res1[1]);
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        if (nums.length == 0) return result;
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            else return result;
        }

        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);

        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target, boolean b) {

        //n=5, 0-4, mid will be (1,2,3,4,5) 4/2=2 a[ind]=3,n=6, mid=2 5/2=2
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (b == true) { //left
                if (nums[mid] == target) {

                    if (mid > 0 && nums[mid - 1] != target) {
                        return mid;
                    }
                    if (mid == 0) //when reach at 0 index, and found answer so return it
                        return mid;
                }
                if (target <= nums[mid]) {
                    //we need to search left side, target is less then mid element  so will found in left section
                    //so try to move left most possible  so condition on left , if equal again move to left
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else if (b == false) { //right
                if (nums[mid] == target) {
                    //if we not reached to last element and found our answer on right side return it
                    if (mid < nums.length - 1 && nums[mid + 1] != target)
                        return mid;
                    else if (mid == nums.length - 1) { //no further movement
                        return mid;
                    }
                }
                if (target >= nums[mid]) { //target is greater then mid element  so will move left to right side
                    //here we need right element so try to move right how so move l to right on equal and greater element
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }


        }

        return -1;
    }



    private int binarySearch_better(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {

            int mid = (begin + end) / 2;

            if (nums[mid] == target) {

                if (isFirst) {

                    // This means we found our lower bound.
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }

                    // Search on the left side for the bound.
                    end = mid - 1;

                } else {

                    // This means we found our upper bound.
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }

                    // Search on the right side for the bound.
                    begin = mid + 1;
                }

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }
}
