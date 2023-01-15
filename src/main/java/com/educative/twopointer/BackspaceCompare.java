package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackspaceCompare {

	public static boolean compare(String str1, String str2) {
		boolean flag = false;
		// base case --no case

		int index = str1.length() - 1;
	 	int index1 = str2.length() - 1;
		int sp = 0;
		int sp1 = 0;
		while (index > -1 || index1 > -1) { // run till both index

			// xp# , xyz##

			while (str1.charAt(index) == '#') {
				sp++;
				index--;
			}
			while (sp > 0) {
				index--;
				sp--;
			}
			while (str2.charAt(index1) == '#') {
				sp1++;
				index1--;
			}
			while (sp1 > 0) {
				index1--;
				sp1--;
			}
//			index1--;
//			index--; 
			//no # key then check index char before decrementing
			if(index1==-1 && index==-1) return true; //match found
			if(index1 ==-1 || index ==-1) return false; //if anyone finished early no match than
			
			if(str1.charAt(index)!=str2.charAt(index1)) return false;
			index1--;
			index--;
		}

		return true;

	}

	public static void main(String[] arg) throws InterruptedException {

		System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
		System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
		System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
		System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));

	}

}
