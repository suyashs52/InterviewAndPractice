package com.educative.mergeinterval;

import java.util.*;

class Interval {
	  int start;
	  int end;

	  public Interval(int start, int end) {
	    this.start = start;
	    this.end = end;
	  }

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	  
	  
	};
	
public class MergeIntervals {

	public static List<Interval> merge(List<Interval> intervals) {
	    List<Interval> mergedIntervals = new LinkedList<Interval>();
	    //write edge case
	    
	    //binary search here , check sort method 
	    Collections.sort(intervals,(a,b)->Integer.compare(a.start, b.start));
	    
	    
	    //while loop , iterator
	    //do while - (n-1)
	    Interval first=intervals.get(0);
	    //(1,3) (2,6)
	    for(int i=1;i<intervals.size();i++) {
	    	Interval sec=intervals.get(i);
	    	if(sec.start <=first.end) {
	    		first= new Interval(first.start, Math.max(first.end, sec.end));
	    		//mergedIntervals.add(first);
	    		
	    		
	    	}
	    	else {
	    		mergedIntervals.add(first);
	    		//mergedIntervals.add(sec);
	    		first =sec;
	    		 
	    	}
	    }
	    
	    mergedIntervals.add(first);
	    return mergedIntervals;
	  }
	

	  public static void main(String[] args) {
	    List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 5));
	    input.add(new Interval(7, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(6, 7));
	    input.add(new Interval(2, 4));
	    input.add(new Interval(5, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 6));
	    input.add(new Interval(3, 5));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : MergeIntervals.merge(input))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();
	  }
	
	
}
