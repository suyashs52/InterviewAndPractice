package com.rec;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KSubset {

	public static void main(String... str) {

		// abcde how many subset possible
		// abcd (e) add e in

		Polygon p =new Polygon();
		Polygon triangle=new Triangle();
		Polygon sqare =new Square();
		
		Map<Integer,Polygon> m=new HashMap<>();
		m.put(1,triangle);
		m.put(2,sqare);
		 
		while(true) {
			p.input();
			Polygon s=m.getOrDefault(p.option,p);
			s.output();
			
			
		}
		
	}

}

class Polygon {
	int option;
	int area;
	public void input() {
		Scanner sc = new Scanner(System.in);

				System.out.println("Enter desired option");
				option =sc.nextInt();
				System.out.println("Enter area of figure");
				area= sc.nextInt();
				

	}
	
	public void output() {
		//area logic change here 
		System.out.println("Radious/Apothem of fugure with area given: "+ area*area);
		System.out.println("Area of inscribed figure (C) :" + area * area *area);
		
	}
}


class Triangle extends Polygon {
	@Override
	public void output() {
		//area logic change here 
		System.out.println("Radious/Apothem of fugure with area given: "+ area*area);
		System.out.println("Area of inscribed figure (T) :" + area * area *area);
		
	}
	
}

class Square extends Polygon {
	@Override
	public void output() {
		//area logic change here 
		System.out.println("Radious/Apothem of fugure with area given: "+ area*area);
		System.out.println("Area of inscribed figure (P) :" + area * area *area);
		
	}
	
}