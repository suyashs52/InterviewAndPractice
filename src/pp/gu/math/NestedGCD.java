 package pp.gu.math;/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class NestedGCD
{
    public static void main (String[] args) throws java.lang.Exception
    {
				
        
		// your code goes here
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		//divisor method is if a number divide all >2 return 0 else return 1
		//it can be gcd of all element > 1
		for (int i = 0; i < a; i++) {
			int len = s.nextInt();
			int[] subsequence = new int[len];
			for (int j = 0; j < len; j++) {
				subsequence[j] = s.nextInt();
			}

			if(len<=1) {
				System.out.println(1);
				 return;
			}
			int c = gcd(Math.max(subsequence[0], subsequence[1]), Math.min(subsequence[0], subsequence[1]));
			if(c==1) {
				System.out.println(1);
				continue;
			}
			boolean one=false;
			for(int j=2;j<len;j++) {
				c=gcd(subsequence[j],c);
				if(c==1) {
					System.out.println(1);
					one=true;
					break;
				}
				
			}
			if(!one) {
				System.out.println(0);
			}
		}

		 
		s.close();

	
    }
		
		static int gcd(int a, int b) {
		if (b == 0)
			return b;

		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}