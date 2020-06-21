package com.dp;

public class MatrixChainMuliplication {

	public static void main(String... str) {
		//https://www.youtube.com/watch?v=vgLJZMUfnsU
		//ABCD 40, 20, 30, 10,30 so matrix would be 40*20, 20*30, 30*10,10*30
		//possible way of multiplication
		//A(BCD), (AB)(CD), (ABC)D so addition of a new matrix require solution of last n-1 solution
		//check addition of A in solution of BCD, add of AB in solun of CD, add of D in soln of ABC
		// 		A 		B 		C 				D
		//	A	0	   AB	  (AB)C,			(SOLN(ABC))D, (AB)(CD),A(SOLN(BCD)
		//					  A(BC)	  			
		//	B			0		BC				(BC)D,
		//										B(CD)
		//	C					0				CD
		//	D									0
		
		int arr[] = {4,2,3,5,3};
		int mincost=findCost(arr);
		System.out.println(mincost);
		

	}

	private static int findCost(int[] arr) {
		int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int i = 0; i < arr.length; i++) {
			temp[i][i] = 0;
		}
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				 
				temp[i][j] = Integer.MAX_VALUE;

				for (int k = i + 1; k < j; k++) {
					System.out.println("(i,k )"+i+","+k);
					System.out.println("(k,j) "+k+","+j);
					System.out.println("temp(i,k),temp(k,j )"+temp[i][k]+","+temp[k][j]);
					System.out.println("i,val "+i+","+arr[i]);
					System.out.println("j,val "+j+","+arr[j]);
					System.out.println("k,val "+k+","+arr[k]);
					q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
					System.out.println("i,j, val q "+i+","+j+","+q);
					System.out.println("------");
				}
			}
		}
		
		return temp[0][arr.length-1];
	}
	 

}
