package com.leetcode;

public class SquareRootNumArray {
	
	public static void main(String ...str) {
		System.out.println("test");

		System.out.println(alternatingSubarray(new int[]{42,43,44,43,44,43,44,45,46}));
		 System.out.println(alternatingSubarray(new int[]{21,9,5,5}));
		System.out.println(alternatingSubarray(new int[]{2,3,4,3,4}));
		 System.out.println(alternatingSubarray(new int[]{4,5,6}));
	}

	public static int alternatingSubarray(int[] nums) {

		if(nums.length==1) return -1;

		int l=0;
		int num=0;

		int ok=0;
		int max=-1;
		int check=-1;
		boolean valid=false;
		for(int i=1;i<nums.length;i++){
			int diff=nums[i]-nums[i-1];
			if(diff==1 && check==-1) {
				check=1;
				l=i-1;
				num++;
				valid=true;
				continue;
			}
			if(diff==-1 && check==1) {

				num++;
				l=i-1;
				check=-1;
				valid=true;
				continue;
			}
			max=Math.max(num,max);
			num=0;
			check=-1;
			if (valid){
			//	i=l;
			}
				valid=false;



		}
		if(max<=1 && num==0) return -1;
		max=Math.max(num,max);
		return max;
	}
}
