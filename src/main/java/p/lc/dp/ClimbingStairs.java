package p.lc.dp;

public class ClimbingStairs {
//https://leetcode.com/problems/climbing-stairs
    //fibonacci number
    public static void main(String[] args) {
        System.out.println(climbStairs_memo(3));
    }

    public static int climbStairs_memo(int n) {
        int[] noOfWay=new int[n+1];
        noOfWay[0]=1;
        noOfWay[1]=1;

        for(int i=2;i<=n;i++){
            noOfWay[i]=noOfWay[i-1]+noOfWay[i-2];
        }

        return noOfWay[n];
    }
}
