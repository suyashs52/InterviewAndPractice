package com.educative.mergeinterval;

import java.util.*;

public class EmployeeFreeTime {

	public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> result = new ArrayList<>();

		if (schedule.size() == 0)
			return result;

		PriorityQueue<Interval> queue = new PriorityQueue<Interval>((a, b) -> {
			return a.start - b.start;
		});

		for (List<Interval> sch : schedule) {
			for (Interval inc : sch) {
				queue.add(inc);
			}
		}

		Interval first = queue.poll();

		while (!queue.isEmpty()) {
			Interval sec = queue.poll();
			if (sec.start <= first.end) {
				first = sec;
			} else {
				result.add(new Interval(first.end, sec.start));
				first = sec;
			}
		}

		// 0 ,1 ,-1 method
		List<int[]> timer = new ArrayList<>();
		for (List<Interval> sch : schedule) {
			for (Interval inc : sch) {

				timer.add(new int[] { inc.start, -1 });
				timer.add(new int[] { inc.end, 1 }); // since we need to check non overlapping interval

			}
		}

		// idea is even no of start end end when occur it allow
		// queue to have 0 after this so when 0 take end of last poll and next start
		// poll
		// (1,3) (2,4) (6,8) (9,12)
		Queue<Integer> qu = new PriorityQueue<>();
		result.clear();
		qu.add(0);
		// sorted based on time
		Collections.sort(timer, (a, b) -> {
			return a[0] - b[0];
		});
		int startTime = 0;
		boolean found = false;
		for (int[] t : timer) {
			if (t[1] == -1) { // get start time
				qu.add(-1);
			} else {
				qu.remove(-1); // get 1 as end time so remove first start time
			}
			if (found) { //next pick ll has start point 6 as value
				//before last line cause take next value
				result.add(new Interval(startTime, t[0]));
				found = false;

			}
			
			if (qu.peek() == 0) {
				startTime = t[0];
				found = true;
				// have 4 as value
			}

			
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Interval>> input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
		List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		System.out.println();

		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
		result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
		System.out.println();

		input = new ArrayList<>();
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
		input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
		result = EmployeeFreeTime.findEmployeeFreeTime(input);
		System.out.print("Free intervals: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + ", " + interval.end + "] ");
	}

}
