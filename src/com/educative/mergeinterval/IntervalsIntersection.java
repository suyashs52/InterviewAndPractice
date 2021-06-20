package com.educative.mergeinterval;

import java.util.*;

public class IntervalsIntersection {

	public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
		List<Interval> intervalsIntersection = new ArrayList<Interval>();
		
		int i = 0;
		int j = 0;
		// two array check min time interval
		while (true) {
			Interval o = arr1[i];
			Interval s = arr2[j];

			if (o.start <= s.start && o.end >= s.start) { // (1,3) (2,4) merged 1,(4,7) (6,8) //return the common interval

				intervalsIntersection.add(new Interval(s.start, Math.min(o.end, s.end)));
			}else if(s.start<=o.start && s.end >=o.start) {
				intervalsIntersection.add(new Interval(o.start, Math.min(o.end, s.end)));
				
			}
			//disjoint interval
			//increment i not j to check next overlapping between next arr1,curr arr2 as arr1 has lesser time
			if(o.end < s.end) {
				i++; 
			}else {
				j++;
			}
			
			if(i>= arr1.length || j>=arr2.length) {
				break;
			}

		}

		return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
	}

	public static void main(String[] args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		Interval[] result = IntervalsIntersection.merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
		input2 = new Interval[] { new Interval(5, 10) };
		result = IntervalsIntersection.merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");

	}

}
