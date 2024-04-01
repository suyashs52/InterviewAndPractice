package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GRAPHROOK {
    static GRAPHROOK.FastScanner fs = new GRAPHROOK.FastScanner();

    public static void main(String[] args) throws IOException {


/*

        1
        5 4 1 5
        1 2
        2 3
        3 4
        4 5



1
16 15 1 10
1 9
2 3
6 7
4 7
9 16
8 10
5 11
2 5
8 12
4 8
2 13
4 14
4 15
2 4
2 16


1
3 2 1 2
1 2
1 3

*/


        int t = fs.nextInt();
        while (t-- > 0) {

            int nodes = fs.nextInt();
            int edges = fs.nextInt();
            int x = fs.nextInt();
            int y = fs.nextInt();

            List<Integer>[] graph = new ArrayList[nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] degrees = new int[nodes + 1];
            Arrays.fill(degrees, 0);
            for (int i = 0; i < edges; i++) {

                int a = fs.nextInt();

                int b = fs.nextInt();
                graph[a].add(b);
                graph[b].add(a);
                degrees[a]++;
                degrees[b]++;
            }
            for (int i = 1; i <= nodes; i++) {
                Collections.sort(graph[i]);
            }
            Map<Pair, Integer> map = new HashMap<>();

            map.put(new Pair(x, 0), 0);
            Deque<Pair> deque = new ArrayDeque<>();
            deque.add(new Pair(x, 0));
            while (!deque.isEmpty()) {
                Pair p = deque.poll();
                int node = p.first;
                int node_rank = p.second;
                int currMove = map.getOrDefault(new Pair(node, node_rank), 0);
                if (map.containsKey(new Pair(node, 0)) == false) {
                    map.put(new Pair(node, 0), currMove);
                    deque.addFirst(new Pair(node, 0));
                } else if (map.get(new Pair(node, 0)) > currMove) {
                    map.put(new Pair(node, 0), currMove);
                    deque.addFirst(new Pair(node, 0));
                }
                if (node_rank == 0) {
                    for (int i = 0; i < degrees[node]; i++) { //if n degree
                        int neighbour_node = graph[node].get(i); //get smallest node first
                        int neighbour_node_rank = i + 1;
                        if (neighbour_node_rank > degrees[neighbour_node])
                            neighbour_node_rank = 0;
                        if (map.containsKey(new Pair(neighbour_node, neighbour_node_rank)) == false) {
                            map.put(new Pair(neighbour_node, neighbour_node_rank), currMove + 1);
                            deque.addLast(new Pair(neighbour_node, neighbour_node_rank));
                        } else if (map.get(new Pair(neighbour_node, neighbour_node_rank)) > currMove + 1) {
                            map.put(new Pair(neighbour_node, neighbour_node_rank), currMove + 1);
                            deque.addLast(new Pair(neighbour_node, neighbour_node_rank));
                        }
                    }
                } else {
                    int neighbour_node = graph[node].get(node_rank - 1);
                    int neighbour_node_rank = node_rank;
                    if (neighbour_node_rank > degrees[neighbour_node])
                        neighbour_node_rank = 0;
                    if (map.containsKey(new Pair(neighbour_node, neighbour_node_rank)) == false) {
                        map.put(new Pair(neighbour_node, neighbour_node_rank), currMove);
                        deque.addFirst(new Pair(neighbour_node, neighbour_node_rank));
                    } else if (map.get(new Pair(neighbour_node, neighbour_node_rank)) > currMove) {

                        map.put(new Pair(neighbour_node, neighbour_node_rank), currMove);
                        deque.addFirst(new Pair(neighbour_node, neighbour_node_rank));
                    }
                }
            }
            System.out.println(map.get(new Pair(y, 0)));
        }

    }


    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
