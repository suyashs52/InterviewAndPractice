package com.chef;/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class TAG {
    static TAG.FastScanner fs = new TAG.FastScanner();
    static List<List<Integer>> graph;
    static int[] friendTime, chefTime, noOfFriendsAtaNode;

    public static void main(String[] args) throws Exception {


        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            Integer total_node = fs.nextInt();

            graph = new ArrayList<>(total_node+3);
            friendTime = new int[total_node + 1];
            chefTime = new int[total_node + 1];
            noOfFriendsAtaNode = new int[total_node + 1];

            for (int k = 0; k < total_node + 1; k++) {
                graph.add(new ArrayList<>());
            }
            for (int k = 0; k < total_node - 1; k++) {
                int node1 = fs.nextInt();
                int node2 = fs.nextInt();

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
            dfs(1, 0, 0); //1 root has no parent so 0, friend wil start from root so timing is 0
            //chef can tag a friend
            //if its timing is <= arrival of friend at node
            int tagByChef = 0;
            for (int k = 1; k < total_node + 1; k++) {
                if(chefTime[k]<=friendTime[k] && chefTime[k]!=0){ //chef if able to reach that node or not a leaf node
                    tagByChef=Math.max(tagByChef,noOfFriendsAtaNode[k]);
                }
            }

            System.out.println(tagByChef);


        }


    }

    static void dfs(int index, int parent, int level) {
        if (graph.get(index).size() == 1 && graph.get(index).get(0) == parent) //3-->6, 3-->7, index=6, list will have only 1 size , and graph has only its parent
        {
            chefTime[index] = 0; //chef will start from any leaf
            friendTime[index] = level + 1; //timing of friend at leaf
            noOfFriendsAtaNode[index] = 1; //at each leaf we will have exactly 1 friend
        } else {
            List<Integer> child = graph.get(index);
            //at each intermediate node friend time will be node level
            //chef timing will always be minimum time it takes to reach that node
            //leaf node if have parent so it would be 1
            chefTime[index] = Integer.MAX_VALUE;
            friendTime[index] = level ;
            noOfFriendsAtaNode[index]=0; //we calculate by sum of friend at child node so current right now is 0
            for (int i = 0; i < child.size(); i++) {
                if (child.get(i) == parent) continue; //if node is parent node

                dfs(child.get(i), index, level + 1);
                //all child node already traversed so take minimum time to reach child node+1
                chefTime[index] = Math.min(chefTime[index], chefTime[child.get(i)]+1);
                //at leaf we will have 1 friend, so intermediatory will have sum of friend present at child node
                noOfFriendsAtaNode[index] += noOfFriendsAtaNode[child.get(i)];
            }
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