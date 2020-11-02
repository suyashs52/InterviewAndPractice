package com.array;

import java.util.ArrayList;
import java.util.List;

public class PermuteArray {
	public static void main(String ...str) {
		int[] num=new int[] {1,2,3};
		System.out.println(permute(num));
	}
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			List<List<Integer>> current = new ArrayList<>();
	 
			for (List<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<>(current);
		}
	 
		return result;
	}
	
	
	static List<List<Integer>> permuteRecr(int n,int[] nums) {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
         if(nums.length==1) {
        	 list.add(input(nums));
         }
         else {
        	 for(int i=0;i<n-1;i++) {
        		 permuteRecr(n-1,nums);
        		 if(n % 2 == 0) {
                     swap(nums, i, n-1);
                 } else {
                     swap(nums, 0, n-1);
                 }
        		 
        	 }
        	 permuteRecr(n-1,nums);
         }
         
         return list;

    }
	
	private static void swap(int[] input, int a, int b) {
	    int tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}
	
	
	private static List<Integer> input(int[] input) {
		List<Integer> list=new ArrayList<Integer>();
		
	    for(int i = 0; i < input.length; i++) {
	    	list.add(input[i]);
	        
	    }
	    
	    return list;
	}
    
}
