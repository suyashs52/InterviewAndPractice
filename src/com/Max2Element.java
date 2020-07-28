package com;

public class Max2Element {

	public static void main(String... str) {
		// min + max=x+y
		// if x> y => x=y+d, / x<y , y=x+d;
		// d=math.abs(x-y)
		// min+ max=y+d +y => max= 2y + d -min
		// let say y is min so max=min+d let say d=2k max=min+2k, x+y=max+min
		// x+y=max+max-2k=> (x+y)/2+k=max=>max= (x+y)/2+d/2=> (x+y)/2+abs(x-y)/2

		int x = 5;
		int y = 10;
		System.out.println((Math.abs(x - y) + x + y) / 2);
		//min is (x+y)-max=> (x+y)/2-(x-y)/2 
		x=6;
		y=7;
		//min
		System.out.println(((x+y)-(Math.abs(x-y)))/2);
		

	}
}
