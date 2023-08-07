package com.leetcode;

public class MinSpeedArriveTime {
    public static void main(String[] args) {
        System.out.println(new MinSpeedArriveTime().minSpeedOnTime(new int[]{1,3,2},2.7));
    }


    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=(int)1e7;

        int minSpeed=-1;

        while(left<=right){
            int mid=left+right/2;

            if(timer(dist,mid)<=hour){
                //more speed less hour so reduce the speed as needed more time
                //2.66 <=2.7  and hours is 3
                minSpeed=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return minSpeed;
    }

    double timer(int[] dist,int speed){
        double time=0.0;

        for(int i=0;i<dist.length;i++){
            double t= (double)dist[i]/(double) speed;
            //add the next int if value is not integer
            time+=(i==dist.length-1)?t:Math.ceil(t);
        }

        return time;
    }


}