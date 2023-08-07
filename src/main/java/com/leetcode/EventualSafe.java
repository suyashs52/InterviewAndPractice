package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EventualSafe {

    //https://leetcode.com/problems/find-eventual-safe-states/description/
    //also check topological sort algorithm in editorial
    public static void main(String[] args) {
        EventualSafe es=new EventualSafe();
        System.out.println(es.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] terminal=new boolean[graph.length];
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
            if(visited[i]==false)
                dfs(graph,terminal,i,visited);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(terminal[i]){
                result.add(i);
            }
        }

        return result;

    }

    boolean dfs(int[][] graph,boolean[] terminal, int index,boolean[] visited){

        if(index>graph.length-1) return false;
        if(terminal[index]) return true;
        if(visited[index]==true) return false;
        if(graph[index].length==0){
            visited[index]=true;
            terminal[index]=true;
            return true;
        }
        visited[index]=true;
        boolean isSafe=true;
        for(int i=0;i<graph[index].length;i++){
            boolean found=    dfs(graph,terminal,graph[index][i],visited);
            if(found==false){
                isSafe=false;
            }
        }
        if(terminal[index]==false)
            terminal[index]=isSafe;
        return isSafe;

    }
}
