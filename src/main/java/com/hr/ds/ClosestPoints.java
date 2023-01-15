package com.hr.ds;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClosestPoints {

	public static void main(String... yx) {
		Integer[] x = new Integer[] { 542243, 5000 };
		Integer[] y = new Integer[] { 0, 322 };
		List<Integer> x1 = Arrays.asList(x);
		List<Integer> y1 = Arrays.asList(y);
		System.out.println(closestSquaredDistance(x1, y1));
		System.out.println(p1);
		System.out.println(p2);
		long pxq1=Math.abs(p1.x - p2.x) ;
		long pxq2=Math.abs(p1.y - p2.y);
		//BigInteger ans = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
		System.out.println(p1.x - p2.x);
		String s1=multiply(String.valueOf(pxq1),String.valueOf(pxq1));
		String s2=multiply(String.valueOf(pxq2),String.valueOf(pxq2));
		String s3=findSum(s1,s2);
		System.out.println(s3);
		System.out.println(Long.valueOf(s3));
		BigInteger b=new BigInteger(s1);
	}

	public static String multiply(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		if (n1 == 0 || n2 == 0)
			return "0";

		// will keep the result number in vector
		// in reverse order
		int[] result = new int[n1 + n2];

		// Below two indexes are used to find positions
		// in result.
		int i_n1 = 0;
		int i_n2 = 0;

		// Go from right to left in num1
		for (int i = n1 - 1; i >= 0; i--) {
			int carry = 0;
			int n_1 = num1.charAt(i) - '0';

			// To shift position to left after every
			// multiplication of a digit in num2
			i_n2 = 0;

			// Go from right to left in num2
			for (int j = n2 - 1; j >= 0; j--) {

				// Take current digit of second number
				int n_2 = num2.charAt(j) - '0';

				// Multiply with current digit of first number
				// and add result to previously stored result
				// at current position.
				int sum = n_1 * n_2 + result[i_n1 + i_n2] + carry;

				// Carry for next iteration
				carry = sum / 10;

				// Store result
				result[i_n1 + i_n2] = sum % 10;

				i_n2++;
			}

			// store carry in next cell
			if (carry > 0)
				result[i_n1 + i_n2] += carry;

			// To shift position to left after every
			// multiplication of a digit in num1.
			i_n1++;
		}

		// ignore '0's from the right
		int i = result.length - 1;
		while (i >= 0 && result[i] == 0)
			i--;

		// If all were '0's - means either both or
		// one of num1 or num2 were '0'
		if (i == -1)
			return "0";

		// generate the result string
		String s = "";
		while (i >= 0)
			s += Long.toString(result[i--]);

		return s;
	}

	static String findSum(String str1, String str2) {
		// Before proceeding further, make sure length
		// of str2 is larger.
		if (str1.length() > str2.length()) {
			String t = str1;
			str1 = str2;
			str2 = t;
		}

		// Take an empty String for storing result
		String str = "";

		// Calculate length of both String
		int n1 = str1.length(), n2 = str2.length();

		// Reverse both of Strings
		str1 = new StringBuilder(str1).reverse().toString();
		str2 = new StringBuilder(str2).reverse().toString();

		int carry = 0;
		for (int i = 0; i < n1; i++) {
			// Do school mathematics, compute sum of
			// current digits and carry
			int sum = ((int) (str1.charAt(i) - '0') + (int) (str2.charAt(i) - '0') + carry);
			str += (char) (sum % 10 + '0');

			// Calculate carry for next step
			carry = sum / 10;
		}

		// Add remaining digits of larger number
		for (int i = n1; i < n2; i++) {
			int sum = ((int) (str2.charAt(i) - '0') + carry);
			str += (char) (sum % 10 + '0');
			carry = sum / 10;
		}

		// Add remaining carry
		if (carry > 0)
			str += (char) (carry + '0');

		// reverse resultant String
		str = new StringBuilder(str).reverse().toString();

		return str;
	}

	static long closestSquaredDistance(List<Integer> x, List<Integer> y) {
		double l = 0;

		Point[] p = new Point[x.size()];
		Point[] px = new Point[x.size()];
		Point[] py = new Point[x.size()];

		Set<Point> set = new TreeSet<Point>();
		int count = 0;
		for (int i = 0; i < x.size(); i++) {
			p[count] = new Point(x.get(i), y.get(i));
			px[count] = new Point(x.get(i), y.get(i));
			py[count] = new Point(x.get(i), y.get(i));
			count++;

		}
		Arrays.sort(px);
		Arrays.sort(py, new CompareY());

		l = closest(px, 0, px.length - 1, py);

		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	static Point p1, p2;

	private static double closest(Point[] px, int low, int high, Point[] py) {
		if (low >= high) // Zero or one point in the set
			return Double.MAX_VALUE;
		else if (low + 1 == high) {
			// Two points in the set
			p1 = px[low];
			p2 = px[high];
			return closest(px[low], px[high]);
		}

		int mid = (low + high) / 2;
		Point[] pointsOrderedOnYL = new Point[mid - low + 1];
		Point[] pointsOrderedOnYR = new Point[high - mid];
		int j1 = 0;
		int j2 = 0;

		for (int i = 0; i < py.length; i++) {
			if (py[i].compareTo(px[mid]) <= 0)
				pointsOrderedOnYL[j1++] = py[i];
			else
				pointsOrderedOnYR[j2++] = py[i];
		}

		double d1 = closest(px, low, mid, pointsOrderedOnYL);
		double d2 = closest(px, mid + 1, high, pointsOrderedOnYR);
		double d = Math.min(d1, d2);

		int count = 0;
		for (int i = 0; i < pointsOrderedOnYL.length; i++)
			if (pointsOrderedOnYL[i].x >= px[mid].x - d)
				count++;
		Point[] stripL = new Point[count];
		count = 0;
		for (int i = 0; i < pointsOrderedOnYL.length; i++)
			if (pointsOrderedOnYL[i].x >= px[mid].x - d)
				stripL[count++] = pointsOrderedOnYL[i];

		// stripR: the points in pointsOrderedOnYR within the strip d
		count = 0;
		for (int i = 0; i < pointsOrderedOnYR.length; i++)
			if (pointsOrderedOnYR[i].x <= px[mid].x + d)
				count++;
		Point[] stripR = new Point[count];
		count = 0;
		for (int i = 0; i < pointsOrderedOnYR.length; i++)
			if (pointsOrderedOnYR[i].x <= px[mid].x + d)
				stripR[count++] = pointsOrderedOnYR[i];

		// Find the closest pair for a point in stripL and
		// a point in stripR
		double d3 = d;
		int j = 0;
		for (int i = 0; i < stripL.length; i++) {
			while (j < stripR.length && stripL[i].y > stripR[j].y + d)
				j++;

			// Compare a point in stripL with six points in stripR
			int k = j; // Start from r1 up in stripR
			while (k < stripR.length && stripR[k].y <= stripL[i].y + d) {
				if (d3 > closest(stripL[i], stripR[k])) {
					d3 = closest(stripL[i], stripR[k]);
					if (d3 < 0) {
						System.out.println(d3);
					}
					p1 = stripL[i];
					p2 = stripR[k];
				}
				k++;
			}
		}

		return Math.min(d, d3);

	}

	private static double closest(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return closest(p1.x, p1.y, p2.x, p2.y);
	}

	private static double closest(Integer x1, Integer y1, Integer x2, Integer y2) {
		if ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) < 0) {
			System.out.println((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}
		// TODO Auto-generated method stub
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	static class CompareY implements java.util.Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if (p1.y < p2.y)
				return -1;
			else if (p1.y == p2.y) {
				// Secondary order on x-coordinates
				if (p1.x < p2.x)
					return -1;
				else if (p1.x == p2.x)
					return 0;
				else
					return 1;
			} else
				return 1;
		}
	}

	static double closest(Point[] px, Point[] py, int size) {
		int mid = size / 2;
		Point midPoint = px[mid];
		Point[] pyl = new Point[mid];
		Point[] pyr = new Point[size - mid];

		int li = 0, ri = 0; // indexes of left and right subarrays
		for (int i = 0; i < size; i++) {
			if (py[i].x <= midPoint.x && li < mid)
				pyl[li++] = py[i];
			else
				pyr[ri++] = py[i];
		}
		double dl = closest(px, pyl, mid);
		Point[] pn = new Point[px.length - mid];
		for (int i = mid + 1; i < px.length; i++) {
			pn[i] = px[i];
		}
		double dr = closest(pn, pyr, size - mid);
		double m = min(dl, dr);

		Point[] strip = new Point[size];
		int j = 0;
		for (int i = 0; i < size; i++)
			if (Math.abs(py[i].x - midPoint.x) < m) {
				strip[j] = py[i];
				j++;
			}

		return stripClosest(strip, j, m);
	}

	static double stripClosest(Point[] strip, int size, double m) {
		double min = m; // Initialize the minimum distance as d

		// Pick all points one by one and try the next points till the difference
		// between y coordinates is smaller than d.
		// This is a proven fact that this loop runs at most 6 times
		for (int i = 0; i < size; ++i)
			for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j)
				if (dist(strip[i], strip[j]) < min)
					min = dist(strip[i], strip[j]);

		return min;
	}

	private static double min(double x, double y) {
		// TODO Auto-generated method stub
		return (x < y) ? x : y;
	}

	static double dist(Point p1, Point p2) {
		return ((p1.x - p2.x) * (p1.x - p2.x) - (p1.y - p2.y) * (p1.y - p2.y));
	}

	static class Point implements Comparable<Point> {
		Integer x;
		Integer y;

		Point(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		public int compareTo(Point p2) {
			if (this.x < p2.x)
				return -1;
			else if (this.x == p2.x) {
				// Secondary order on y-coordinates
				if (this.y < p2.y)
					return -1;
				else if (this.y == p2.y)
					return 0;
				else
					return 1;
			} else
				return 1;
		}
	}

}
