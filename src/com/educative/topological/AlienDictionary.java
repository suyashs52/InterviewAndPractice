package com.educative.topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AlienDictionary {
	public static String findOrder(String[] words) {

		Map<Character, Integer> indegree = new HashMap<Character, Integer>();
		Map<Character, List<Character>> graph = new HashMap<>();
		String result = "";
		for (int i = 0; i < words.length; i++) {
			for (Character c : words[i].toCharArray()) {
				indegree.put(c, 0);
				graph.put(c, new ArrayList<>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String p = words[i - 1];
			String c = words[i];
			for (int j = 0; j < Math.min(p.length(), c.length()); j++) {
				if (p.charAt(j) != c.charAt(j)) {
					indegree.put(c.charAt(j), indegree.get(c.charAt(j)) + 1);
					graph.get(p.charAt(j)).add(c.charAt(j));
					break;
				}
			}

		}

		Queue<Character> queue = new LinkedList<>();
		for (Map.Entry<Character, Integer> m : indegree.entrySet()) {
			if (m.getValue() == 0) {
				queue.add(m.getKey());
			}
		}

		StringBuilder sb = new StringBuilder();

		while (queue.isEmpty() == false) {
			Character c = queue.poll();
			sb.append(c);
			List<Character> l = graph.get(c);
			for (char cd : l) {
				indegree.put(cd, indegree.get(cd) - 1);
				if (indegree.get(cd) == 0) {
					queue.add(cd);
				}

			}

		}

		

		
		List<String> l1=new ArrayList<String>();
		l1.add("aaa");
		l1.add("a");
		l1.add("aa");
		
		Comparator<String> c=new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int l1=o1.length();
				int l2=o2.length();
				if(l1<l2) return -1;
				else if (l1>l2) return 1;
				else return o1.compareTo(o2);
				 
			}
		};
	
		Collections.sort(l1,c);
		
		System.out.println(l1);
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		String result = AlienDictionary.findOrder(new String[] { "ba", "bc", "ac", "cab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "cab", "aaa", "aab" });
		System.out.println("Character order: " + result);

		result = AlienDictionary.findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
		System.out.println("Character order: " + result);

	}

}
