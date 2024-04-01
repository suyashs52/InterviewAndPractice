package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class REVERSE {

    //https://www.codechef.com/LP3TO402/problems/REVERSE?tab=statement

/*
    7 7
            1 2
            3 2
            3 4
            7 4
            6 2
            5 6
            7 5

    */



    static REVERSE.FastScanner fs = new REVERSE.FastScanner();

    public static void main(String[] args) throws java.lang.Exception {

        int node = fs.nextInt();
        int edge = fs.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int fromNode = fs.nextInt();
            int toNode = fs.nextInt();
            graph.get(fromNode).add(new int[]{toNode, 0}); //we can go ahead to new node without weight
            graph.get(toNode).add(new int[]{fromNode, 1}); //we need to revese the edge so add weight 1
        }

        Deque<int[]> deque = new ArrayDeque<>();
        boolean nodeFound = false;

        int[] weight = new int[node + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);

        deque.add(new int[]{1, 0});
        weight[1] = 0;
        while (deque.isEmpty() == false) {
            int[] current = deque.poll();
            List<int[]> neighbour = graph.get(current[0]); //get all linked node
            for (int i = 0; i < neighbour.size(); i++) {
                if (weight[neighbour.get(i)[0]] > weight[current[0]] + neighbour.get(i)[1]) {
                    //consider the child node if reaching at lower weight
                    //otherwise ignore it as it has sortest weight assign
                    weight[neighbour.get(i)[0]] = weight[current[0]] + neighbour.get(i)[1];
                    if (neighbour.get(i)[1] == 0) { //smallest weight carry node should add at first
                        deque.addFirst(neighbour.get(i));

                    } else {
                        deque.add(neighbour.get(i));
                    }
                }

            }
        }

        if (weight[node] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(weight[node]);
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
