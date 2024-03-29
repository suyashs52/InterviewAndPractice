package com.educative.mergeinterval;

import java.util.*;

public class ConflictingAppointments {
	// https://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/

	public static boolean canAttendAllAppointments(Interval[] intervals) {
		// TODO: Write your code here
		Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i + 1].start <= intervals[i].end)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = ConflictingAppointments.canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);

	}

}
