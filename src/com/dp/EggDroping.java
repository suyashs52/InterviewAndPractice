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
		System.out.println(recur(5,10)); 
		//System.out.println(recur(5,100)); //it will take so much time go for dp
		

	}

	public static int recur(int egg, int floor) {
		if (egg == 1)
			return floor; // we need to visit
		if (floor == 0)
			return 0;
		int min = 10000;
		for (int x = 1; x <= floor; x++) { //x is xth floor, 
			//egg if break, down a floor, with down a egg
			// if not break go up with remaining floor same login and same egg
			int v = 1+Math.max(recur(egg - 1, x - 1), recur(egg, floor - x));

			if (v < min)
				min = v;
		}
		return min;
	}

}
