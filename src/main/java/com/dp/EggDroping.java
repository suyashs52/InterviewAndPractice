package com.dp;

public class EggDroping {

	public static void main(String... str) {
		// mininum no of trail need to show egg break from a floor
		// for defferentiation, 2bl show its minima ,
		// floor F, egg E, block B F/B is per floor, if break at floor bth lets say
		// F/B+B (going to b block down as We have tested last B 1st differentiation
		// gives
		// d(F/B+B)/dB b is varaible, 1-N/B^2 =0 as rate , it means it constant dobule
		// willl give always positive
		// so 1-n/b2 is min=0 b=sqrt(n) that is min thrsold for bth floor but we don't
		// take egg here

		// so lets dicuss
		System.out.println(recur(5, 10));
		// System.out.println(recur(5,100)); //it will take so much time go for dp
		System.out.println(dpcalc(5, 10));
		 
		
	}

	public static int recur(int egg, int floor) {
		if (egg == 1)
			return floor; // we need to visit
		if (floor == 0)
			return 0;
		int min = 10000;
		for (int x = 1; x <= floor; x++) { // x is xth floor,
			// egg if break, down a floor, with down a egg
			// if not break go up with remaining floor same login and same egg
			int v = 1 + Math.max(recur(egg - 1, x - 1), recur(egg, floor - x));

			if (v < min)
				min = v;
		}
		return min;
	}

	public static int dpcalc(int egg, int floor) {
		int a[][] = new int[egg + 1][floor + 1];

		 
		for (int i = 0; i <= floor; i++) {
			a[0][i] = 0;
			a[1][i] = i; // 1 egg, 1,2,3,4,5 floor

		}

		for (int i = 0; i <= egg; i++) {
			a[i][1] = 1; // 0,1,2,3,4 egg 1st floor
		}
		int c = 0;
		for (int e = 2; e <= egg; e++) {
			for (int f = 2; f <= floor; f++) {
				a[e][f] = Integer.MAX_VALUE;;
				for (int b = 1; b <= f; b++) {
					c = 1 + Math.max(a[e - 1][b - 1], a[e][f - b]);
					if (c < a[e][f])
						a[e][f] = c;
				}
				
			}
		}
		return a[egg][floor];
	}
	 
}
