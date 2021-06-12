package com.educative;

import java.util.*;

 
	
public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> mergedIntervals = new ArrayList<>();    
	   // Collections.sort(intervals,(a,b)->Integer.compare(a.start, b.start));
	    
	    Interval first=newInterval;
	    //(1,3) (2,6)
	    
	    
//	    Iterator itr = intervals.iterator();
//	    while(itr.hasNext()) {
//	    	itr.next();
//	    }
//	    ListIterator itr1 = intervals.listIterator(2);
//	    while(itr1.hasPrevious()) {
//	    	itr1.previous();
//	    }
//	    
	    int index =0;
	    for(int i=0;i<intervals.size();i++) {
	    	if(intervals.get(i).end<newInterval.start) {
	    		index=i+1;
	    		break;
	    	}
	    }
	    
	    
	    for(int i=0;i<index;i++) {
	    	mergedIntervals.add(intervals.get(i));
	    }
	    
	    
	    //(1,2) (4,8) (9,12) insertedval: (6,7) i at (4,8)
	    while(index<intervals.size() && newInterval.end>=intervals.get(index).start) { //merge untill no overlap
	    	int st= Math.min(newInterval.start, intervals.get(index).start);
		    int end =Math.max(newInterval.end, intervals.get(index).end);
		    newInterval.start=st; //starting point
		    newInterval.end=end;
		    index++;
	    }
	    mergedIntervals.add(newInterval);
	    
	    for(int i=index;i<intervals.size();i++) {
	    	mergedIntervals.add(intervals.get(i));
	    	
	    } 
	     
	    return mergedIntervals;
	  }
	

	  public static void main(String[] args) {
		  
		  List<Interval> input = new ArrayList<Interval>();
		    input.add(new Interval(1, 3));
		    input.add(new Interval(5, 7));
		    input.add(new Interval(8, 12));
		    System.out.print("Intervals after inserting the new interval: ");
		    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
		      System.out.print("[" + interval.start + "," + interval.end + "] ");
		    System.out.println();

		    input = new ArrayList<Interval>();
		    input.add(new Interval(1, 3));
		    input.add(new Interval(5, 7));
		    input.add(new Interval(8, 12));
		    System.out.print("Intervals after inserting the new interval: ");
		    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
		      System.out.print("[" + interval.start + "," + interval.end + "] ");
		    System.out.println();

		    input = new ArrayList<Interval>();
		    input.add(new Interval(2, 3));
		    input.add(new Interval(5, 7));
		    System.out.print("Intervals after inserting the new interval: ");
		    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
		      System.out.print("[" + interval.start + "," + interval.end + "] ");
		    System.out.println();
		  
	  }
	
	
}
