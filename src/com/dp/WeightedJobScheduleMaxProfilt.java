package com.dp;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduleMaxProfilt {
	 
	static class Job {
		int start;
		int end;
		int profit;

		Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}

	// set of jobs with start and end interval and profit, how to maximize profit
	// such that
	// jobs in subset do not overlap.
	public static void main(String... str) {
		//WeightedJobScheduleMaxProfilt wj=new WeightedJobScheduleMaxProfilt();
		Job jobs[] = new Job[6];
		jobs[0] = new Job(1, 3, 5);
		jobs[1] = new Job(2, 5, 6);
		jobs[2] = new Job(4, 6, 5);
		jobs[3] = new Job(6, 7, 4);
		jobs[4] = new Job(5, 8, 11);
		jobs[5] = new Job(7, 9, 2);
		code(jobs);

	}

	public static void code(Job jobs[]) {

		// sort based on end date
		Comparator<Job> comp = new Comparator<WeightedJobScheduleMaxProfilt.Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				if (o1.end < o2.end) {
					return -1;
				} else {
					return 1;
				}
			}
		};

		Arrays.parallelSort(jobs, comp);

		int t[] = new int[jobs.length];
		t[0] = jobs[0].profit; // take first profit

		for (int j = 1; j < t.length; j++) {
			t[j] = jobs[j].profit;
			if (t[j - 1] > t[j]) { // take profit maximum untill time if overlap last max is max profit
				t[j] = t[j - 1];
			}
			// (1,3->5), (2,5->6), (4,6->5)
			// if no overlap than profit is sum of max(currentProfilt+lastIndexProfitt,
			// currentValueInProfit)
			for (int k = j - 1; k >= 0; k--) {
				if (jobs[k].end <= jobs[j].start) {
					t[j] = Math.max(t[j], jobs[j].profit + t[k]);
					break;// if last found it would be maximum as from starting we are running loop
				}
			}
		}

		int max = -1;
		for (int val : t) {
			if (max < val)
				max = val;
		}

		System.out.println("maximum value : " + max);
	}

}
