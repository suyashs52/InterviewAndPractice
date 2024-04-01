package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class GRAPHROOK1 {

    /*
      1
              5 4 1 5
              1 2
              2 3
              3 4
              4 5

    */




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;

            List<List<Integer>> graph = new ArrayList<>();
            List<List<Integer>> moves = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());

            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int minMove = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int size = graph.get(i).size() + 1;
                ArrayList<Integer> temp = new ArrayList<>(Collections.nCopies(size, Integer.MAX_VALUE));
                moves.add(temp);
                Collections.sort(graph.get(i));
            }
            print_list(graph, "graph");
            print_list(moves, "moves");

            for (int i = 0; i <= graph.get(src).size(); i++) {
                moves.get(src).set(i, 1);
            }
            System.out.println("after setting source " + src);
            print_list(graph, "graph");
            print_list(moves, "moves");


            Deque<Pair> queue = new ArrayDeque<>();

            for (int j = 1; j <= graph.get(src).size(); j++) {
                queue.add(new Pair(src, j));
            }

            while (!queue.isEmpty()) {

                Pair frontNd = queue.poll();
                int node = frontNd.node;
                int currentMove = frontNd.degree;

                System.out.println("queue poll data " + frontNd);
                 for (int i = 1; i <= graph.get(node).size(); i++) {

                    if (moves.get(node).get(i) > moves.get(node).get(currentMove) + 1) {
                        moves.get(node).set(i, moves.get(node).get(currentMove) + 1);
                        queue.add(new Pair(node, i));
                    }
                }

                int nextNode = graph.get(node).get(currentMove - 1);

                if (nextNode == dest) {
                    minMove = Math.min(minMove, moves.get(node).get(currentMove));
                }
                //total degree of next node (moves) > current degree
                if (graph.get(nextNode).size() >= currentMove) {

                    if (moves.get(nextNode).get(currentMove) > moves.get(node).get(currentMove)) {

                        moves.get(nextNode).set(currentMove, moves.get(node).get(currentMove));
                        queue.addFirst(new Pair(nextNode, currentMove));

                    }
                } else {

                    for (int i = 1; i <= graph.get(nextNode).size(); i++) {

                        if (moves.get(nextNode).get(i) > moves.get(node).get(currentMove) + 1) {
                             moves.get(nextNode).set(i, moves.get(node).get(currentMove) + 1);
                            queue.add(new Pair(nextNode, i));
                              }
                    }
                }
            }

            out.println(minMove);
        }
        out.flush();
    }

    static void print_list(List<List<Integer>> list, String text) {
        System.out.println("----" + text + "----");
        int count = 0;
        for (List<Integer> l1 : list) {
            System.out.print(count++ + " >");
            for (Integer in : l1) {
                System.out.print(in + " , ");
            }
            System.out.println( " ||");
        }
        System.out.println("@----" + text + "----@");
    }

    static void p_list(List<Integer> list, String text) {
        System.out.println("s----" + text + "----s");
        for (Integer in : list) {
            System.out.print(in + " , ");
        }
        System.out.println("  ");
        System.out.println("@s----" + text + "----s@");

    }

    static class Pair {
        int node, degree;

        Pair(int node, int degree) {
            this.node = node;
            this.degree = degree;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", degree=" + degree +
                    '}';
        }
    }
}
