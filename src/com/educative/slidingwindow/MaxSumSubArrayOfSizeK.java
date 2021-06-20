package com.educative.slidingwindow;

public class MaxSumSubArrayOfSizeK {
	
	public static int findMaxSumSubArray(int k, int[] arr) {
		int max=0;
		int sum=0;
		int i=0;
		for(;i<k;i++)
		{
			sum+=arr[i];
			max=Math.max(sum, max);
			
		}
		for(int j=i;j<arr.length;j++) {
			
			sum=sum-arr[j-k]+arr[j];
			max=Math.max(sum, max);
		}
		
		
		return max;
	}
	
	
	 public static void main(String[] args) {
		    System.out.println("Maximum sum of a subarray of size K: "
		        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		    System.out.println("Maximum sum of a subarray of size K: "
		        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
		  }
	 
	 

}
