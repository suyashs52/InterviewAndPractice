package com.leetcode.bs;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        //https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

        System.out.println(new SearchInRotatedArray().search(new int[]{4,5,6,7,0,1,2},0));

    }

    public int search(int[] nums, int target) {
        //find pivot search if nums[left]>arr[mid] so move left to mid+1
        //if we dont want to search 3 time , now we no pivot element so
        //start index needs to shift by nums.length-pivot in n:8-pivot:5=3 in example case
        //so shift=n-pivot; left=pivot+shift %n , right pivot-1+shift %n ,
        //now we search regularly ..hear is the case exact index can be found only if
        //here we are shifting right side by shift so to get exact index shift mid by left by shift param
        // soo num[(mid-shift+n)%n]==target return mid-shift+n %n;

        ///
        /// now try solving using single binary search without using pivot
        //hint: check if left..mid / mid..right is sorted and where target lies
        if(nums[0]==target) return 0;
        if(nums[nums.length-1]==target) return nums.length-1;



        int left=0;
        int right=nums.length-1;
        if(nums[left]<=nums[right]) return bs(nums,target,left,right);
        //finding pivot
        int pivot=-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]>nums[nums.length-1]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        int ans=  bs(nums,target,0,left-1);
        if(ans==-1){
            ans=bs(nums,target,left,nums.length-1);
        }

        return ans;



    }

    int bs(int[] nums,int target,int left,int right){

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}

