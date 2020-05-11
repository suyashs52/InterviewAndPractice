package com.udemy.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {
	private String name;
	private int index;
	private ArrayList<WeightedNode> neighbours = new ArrayList<>();
	private HashMap<WeightedNode, Integer> weightMap = new HashMap<WeightedNode, Integer>();
	private boolean isVisited;
	private WeightedNode parent;
	private int distance;

	public WeightedNode(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public WeightedNode(String name) {

		this.name = name;
		this.distance = Integer.MAX_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<WeightedNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<WeightedNode> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public WeightedNode getParent() {
		return parent;
	}

	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}
 
	
	public HashMap<WeightedNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return name;
	}

	
	@Override
	public int compareTo(WeightedNode o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
}
