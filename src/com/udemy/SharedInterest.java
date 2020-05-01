package com.udemy;

import java.security.KeyStore.Entry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class SharedInterest {

	public static void main(String[] args) throws Exception {
		test0();
		test();
		test1();
	}

	private static void test0() {
		int friends_nodes = 4;
		int friends_edges = 5;
		int[] friends_from = new int[] { 1, 1, 2, 2, 2};
		int[] friends_to = new int[] { 2, 2, 3, 3, 4};
		int[] friends_weight = new int[] { 2, 3, 1, 3, 4};
		code(friends_from, friends_to, friends_weight);
	}
	
	private static void test() {
		int friends_nodes = 4;
		int friends_edges = 5;
		int[] friends_from = new int[] { 1, 1, 2, 2, 2 ,1};
		int[] friends_to = new int[] { 2, 2, 3, 3, 4 ,3};
		int[] friends_weight = new int[] { 2, 3, 1, 3, 4 ,4};
		code(friends_from, friends_to, friends_weight);
	}

	private static void test1() {
		int friends_nodes = 4;
		int friends_edges = 5;
		int[] friends_from = new int[] { 1, 1, 2, 2, 2, 2 };
		int[] friends_to = new int[] { 2, 2, 3, 3, 4, 3 };
		int[] friends_weight = new int[] { 2, 3, 1, 3, 4, 4 };
		code(friends_from, friends_to, friends_weight);
	}

	private static int code(int[] friends_from, int[] friends_to, int[] friends_weight) {

		Map<Integer, TreeSet<Integer>> map = new HashMap<>();
		TreeSet<Integer> ts;
		for (int i = 0; i < friends_weight.length; i++) {
			if (map.containsKey(friends_weight[i])) {
				ts = map.get(friends_weight[i]);
				ts.add(friends_from[i]);
				ts.add(friends_to[i]);
			} else {
				ts = new TreeSet<Integer>();
				ts.add(friends_from[i]);
				ts.add(friends_to[i]);
				map.put(friends_weight[i], ts);
			}
		}
		Comparator<Pairs> comp = new Comparator<Pairs>() {

			@Override
			public int compare(Pairs o1, Pairs o2) {
				// TODO Auto-generated method stub
				if (o1.x == o2.x && o1.y == o2.y) {

					return 0;
				}

				return -1;

			}
		};
		Comparator<Pairs> comp1 = new Comparator<Pairs>() {

			@Override
			public int compare(Pairs o1, Pairs o2) {
				// TODO Auto-generated method stub
				if(o1.x==o2.x) return o2.y.compareTo(o1.y);
				else return o2.x.compareTo(o1.x);
				 

			}
		};
		Map<Pairs,Integer> pair = new TreeMap<Pairs,Integer>(comp1);
		Pairs maxPair=new Pairs(0, 0);
		int count=0;
		int maxcount=0;
		for (TreeSet<Integer> t : map.values()) {

			Integer[] a = new Integer[t.size()];
			t.toArray(a);
			for (int i = 0; i < a.length; i++) {
				for (int j = i + 1; j < a.length; j++) {
					Pairs p = new Pairs(a[i], a[j]);
					if (pair.containsKey(p)) {
						
						  count=pair.get(p)+1;
						 
						p.count=count;
						pair.put(p,count);
						
					} else {
						p.count = 1;
						pair.put(p,1);
					}
				}
			}
			

		}
		
		count=-1;
		for(java.util.Map.Entry<Pairs, Integer> en:pair.entrySet()) {
			if(en.getValue()>count) {
				count=en.getValue();
				maxPair=en.getKey();
			}
		}
		 
		System.out.println(maxPair.x*maxPair.y);
		return maxPair.x*maxPair.y;
		 

	}

	static void printval(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}

}

class Pairs   {
	Integer x;
	Integer y;
	int count;

	Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pairs other = (Pairs) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [x=" + x + ", y=" + y + ", count=" + count + "]";
	}
 

}
