package com.hr.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import com.udemy.graph.WeightedNode;

public class OpeningHospitalResult {

	public static void main(String... str) {
		Integer[] a = new Integer[] { 1, 3, 1, 3, 2, 1 };
		Integer[] b = new Integer[] { 2, 6, 4, 7, 5, 3 };

		List<Integer> cityfrom = Arrays.asList(a);
		List<Integer> cityto = Arrays.asList(b);
		int result = hospital(7, cityfrom, cityto);
		System.out.println(result);

		a = new Integer[] { 1, 2, 3 };
		b = new Integer[] { 2, 3, 4 };

		cityfrom = Arrays.asList(a);
		cityto = Arrays.asList(b);
		result = hospital(4, cityfrom, cityto);
		System.out.println(result);

	}

	public static int hospital(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		List<Node> nodelist = new ArrayList<>();
		for (int i = 0; i < cityNodes; i++) {
			nodelist.add(new Node(0, i + 1));
		}
		for (int i = 0; i < cityFrom.size(); i++) {
			Node nf = nodelist.get(cityFrom.get(i) - 1);
			Node nt = nodelist.get(cityTo.get(i) - 1);
			nf.neighbours.add(nt);
			nf.weight += 2;
			nt.neighbours.add(nf);
			nt.weight += 2;

		}

		System.out.println(nodelist);
		queue.addAll(nodelist);
		int count = 0;
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n.isvisited)
				continue;
			count++;
			n.isvisited = true;
			for (Node no : n.neighbours) {
				if (queue.contains(no)) {
					no.weight -= 2;
					if (no.weight == 0) {
						no.isvisited = true;
						queue.remove(no);
					} else {
						queue.remove(no);
						queue.add(no);
					}
				}
			}

		}

		return count;
	}

}

class Node implements Comparable<Node> {
	int weight;
	int index;
	boolean isvisited = false;
	ArrayList<Node> neighbours = new ArrayList<>();

	public Node(int wt, Integer ind) {
		// TODO Auto-generated constructor stub
		weight = wt;
		index = ind;
	}

	@Override
	public String toString() {
		return "Node [weight=" + weight + ", index=" + index + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return o.weight - this.weight;
	}

}