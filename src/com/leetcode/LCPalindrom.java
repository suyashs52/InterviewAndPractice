package com.leetcode;

public class LCPalindrom {

	public static void main(String... str) {
		System.out.println("test");
		// agbdba
		// GEEKSFORGEEKS
		// for len :4 x1abx2--if x1,and x2 are same 2 count 2+palin(intermid)
		// if not same we prev calculate palin of 3 so count can be from x1ab, abx2 take
		// max so can be of len 4

		char[] s = "EEKGEEK".toCharArray();
		int len = s.length;
		int[][] t = new int[len][len];

		// 0 1 2 3
		// 0
		// 1
		// 2
		// 3

		// 11,22,33 is same has count =1 this can be staritng point

		for (int i = 0; i < len; i++) {
			t[i][i] = 1;
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) // 1st -0,3/0,2/0,1/0 add above for loop
			{
				int k = j + i; // 1st:x,y has 1 differencce,2nd iteration has 2 difference so add i in j
				System.out.print("(" + j + "," + k + ")" + ", ");

			}
			System.out.println();
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) // 1st -0,3/0,2/0,1/0 add above for loop
			{
				int k = j + i; // 1st:x,y has 1 differencce,2nd iteration has 2 difference so add i in j

				if (i == 1 && s[j] == s[k]) { // 1st 2 is equal
					t[j][k] = 2;
				} else if (s[j] == s[k]) { // from 3 len and beyond abbba adding a get 2+palinof mid
					t[j][k] = 2 + t[j + 1][k - 1];
				} else { // first and last not equal take max of last palindrop seq
					t[j][k] = Math.max(t[j + 1][k], t[j][k - 1]);
				}

			}

		}
		System.out.println("palindromic sequence is --->");
		System.out.println(t[0][len - 1]);

	}

	void longPalin(String s) {
		int n = s.length();
		boolean[][] palin = new boolean[n][n];

		for (int i = 0; i < n; i++) { // for single char
			palin[i][i] = true;
		}
		int maxl = 0;
		int maxr = 0;
		for (int i = 0; i < n - 1; i++) { // for aa, bb cc,dd
			palin[i][i + 1] = true;
			maxl = i;
			maxr = i + 1;
		}

		// for paling has size>2 max size can be of len

		for (int size = 3; size <= n; size++) {

			for (int l = 0, r = size + l - 1; r < n; r++, l++) { // size=r-l+1 0to5 if palind has size :6 r-l+1 ,5-0+1
																	// so right is: size+l-1

				if(palin[l+1][r-1] && s.charAt(l)==s.charAt(r)) { //mid is palin, left and right are same 
					
					palin[l][r]=true;
					maxl=l;
					maxr=r;
				}
			}
		}
		
		System.out.println(s.substring(maxl,maxr));

	}

}
