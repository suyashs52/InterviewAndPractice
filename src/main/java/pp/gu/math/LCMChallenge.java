package pp.gu.math;

import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class LCMChallenge {
	public static void main(String[] args) throws java.lang.Exception {


        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc= new Scanner(System.in);
       int testCase= sc.nextInt();
       
       for(int i=0;i<testCase;i++){
           int n=sc.nextInt();
           int m=sc.nextInt();
           boolean[] visit=new boolean[n+1];
           int [] res=new int[n+1];
           List<List<Integer>> graph=new ArrayList<>();
           
           int[] fwt=new int[n+1];
           for(int j=0;j<=n;j++){
               graph.add(new ArrayList<>());
             
               res[j]=-1;
           }
           for(int j=0;j<m;j++){
               int node=sc.nextInt();
               int ch=sc.nextInt();
               graph.get(node).add(ch);
               graph.get(ch).add(node);
           }
           int start =sc.nextInt();
           res[start] =0;
           Queue<Integer> queue=new LinkedList<>();
           queue.add(start);
           visit[start] =true;
           while(queue.isEmpty()==false){
               int temp=queue.poll();
               List<Integer> child=graph.get(temp);
               for(int k:child){
                   if(visit[k]==false){
                      res[k]=res[temp]+6;
                        visit[k] =true; 
                        queue.add(k);
                   }
                   
                   
               }
           }
           
           for(int l=1;l<n+1;l++){
               if(res[l]==0){
                   continue;
               }
               System.out.print(res[l]+" ");
           }
           System.out.println();
           
           
           
       }
       
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return b;

		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}