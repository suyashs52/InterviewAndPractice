package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        //https://leetcode.com/problems/course-schedule/editorial/
        //need to find circular
        //kahns algorithm start from 0 degree, if no cycle at last we have all node visited
        //dfs visit each node during traversal put old node in stack, if new node again found means
        //if new node already in stack means their is a cycle
        CourseSchedule cs=new CourseSchedule();
        System.out.println(cs.canFinish(20,new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        List[] visited=new ArrayList[numCourses];
        int[] indreee=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            visited[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];

            if(visited[to].contains(from)){
                return false;

            }
            //add flow from to to
            visited[from].add(to);
            //indgree of to will increase, we ll start from node which indegree=0
            //and decrement visited node indegree by 1
            indreee[to]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < indreee.length; i++) {
            if(indreee[i]==0){
                queue.add(i);
            }

        }

        int count=0;

        while (queue.isEmpty()==false){
            Integer ans=queue.poll();
            List<Integer> v=visited[ans];
            count++;
            for (Integer vist:v){
                indreee[vist]--;
                if(indreee[vist]==0){
                    queue.add(vist);
                }
            }
        }

        return count==numCourses;




    }
}
