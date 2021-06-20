package com.educative.mergeinterval;

import java.util.*;

class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
};

public class MinimumMeetingRooms {
	// https://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/

	public static int findMinimumMeetingRooms(List<Meeting> intervals) {
		int max = 1;
		List<Meeting> f = new ArrayList<Meeting>();
		f.addAll(intervals);
		List<Meeting> s = new ArrayList<Meeting>();
		s.addAll(intervals);
		Collections.sort(f, (a, b) -> {
			return a.start - b.start == 0 ? a.end - b.end : a.start - b.start;
		});
		Collections.sort(s, (a, b) -> {
			return a.end - b.end == 0 ? a.start - b.start : a.end - b.end;
		});

		int i = 0;
		int j = 0;
		 
		int count = 0;
		while (i < f.size() && j < s.size()) { //(2,3) (2,4) (3,5) (4,5)  2,2,3,4  3,4,5,5
			count=0;
			while(i<f.size() && f.get(i).start <s.get(j).end ) {
				count++;
				i++;
			}
			
			if(max<count) max=count;
			j++;
		
		}
		
		//return max;
		
		//using priority queue
		//sort data in natural ordering so sort based on end value
		PriorityQueue<Integer> queue =new PriorityQueue<Integer>();
		
		queue.add(f.get(0).end);
		i=0;
		for( i=1;i<f.size();i++) {
			if(f.get(i).start<queue.peek()) {
				queue.add(f.get(i).end); //sort based on end value
				max=Math.max(max, queue.size());
			}else {
				//else mean no next end collide of queue
				while(!queue.isEmpty() && f.get(i).start>=queue.peek() ) { //we ll start from count 0 for fresh new value 
					queue.poll();  //(3,5) > (2,3) (2,4)
				}
				
				queue.add(f.get(i).end);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 5));
				add(new Meeting(7, 9));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(6, 7));
				add(new Meeting(2, 4));
				add(new Meeting(8, 12));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(1, 4));
				add(new Meeting(2, 3));
				add(new Meeting(3, 6));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

		input = new ArrayList<Meeting>() {
			{
				add(new Meeting(4, 5));
				add(new Meeting(2, 3));
				add(new Meeting(2, 4));
				add(new Meeting(3, 5));
			}
		};
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		System.out.println("Minimum meeting rooms required: " + result);

	}

}
