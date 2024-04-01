package com.leetcode.array;

import java.util.*;

public class RestoreTheArray {

    public static void main(String[] args) {
        int[] s = new RestoreTheArray().restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
    }

    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] ad : adjacentPairs) {
            if (!map.containsKey(ad[0])) {
                map.put(ad[0], new ArrayList<>());
            }
            if (!map.containsKey(ad[1])) {
                map.put(ad[1], new ArrayList<>());
            }

            map.get(ad[0]).add(ad[1]);
            map.get(ad[1]).add(ad[0]);
        }

        int size = map.size();
        Set<Integer> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {

            int k = e.getKey();

            if (visited.contains(k)) {
                continue;
            }

            ans.add(k);
            List<Integer> list = e.getValue();

            for (Integer v1 : list) {
                if (!visited.contains(v1)) {
                    ans.add(v1);
                    visited.add(v1);
                }

            }


        }

        return new int[20];
    }
}
