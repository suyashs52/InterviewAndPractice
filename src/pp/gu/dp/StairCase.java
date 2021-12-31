package pp.gu.dp;

/* package codechef; // don't place package name! */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class StairCase {

	static List<Integer> prime = new ArrayList<>();
	static int pkey = 0;

	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		// https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
		int mod=1000000007;
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n=in.nextInt();
			TopBottom(n);
			BottomTop(n);
			
			//1:1,2:0-2->1 1-2->1 f(2)=f(1)+f(0)
			int f=1; //to reach at 1; one way
			int s=2; //to reach at 2 ; 2 way 0-2,0-1-2
			//we can reach at 3:only from 1 and 2 f(1)+f(2)
			for(int k=3;k<=n;k++) {
				
				int l=f+s;
				f=s;
				s=l;
			}
			System.out.println(s);
		}
	}

	static void TopBottom(int num) {

		// solve top to bottom 0 -> 1,2->1->2,3
		int[] dp = new int[num + 1];
		topbotrec(0, num, dp);
		// num=2: from 0 to 1 1 way , 0 to 2 1 way ,1 to 2 1 way so 0 to 2 2 way
		System.out.println(dp[0]);

	}

	static void BottomTop(int num) {

		// num: 3, we can reach 2,and 1 from 3
		int[] dp = new int[num + 1];
		bottoprec(num, dp);
		// num=2: from 0 to 1 1 way , 0 to 2 1 way ,1 to 2 1 way so 0 to 2 2 way
		System.out.println(dp[num]);

	}

	private static int bottoprec(int i, int[] dp) {
		if (i == 0)
			return 1;
		if (i < 0)
			return 0;
		if (dp[i] == 0)
			dp[i] = bottoprec(i - 1, dp) + bottoprec(i - 2, dp);
		return dp[i];

	}

	static int topbotrec(int i, int n, int[] dp) {
		if (i == n)
			return 1;
		if (i > n)
			return 0;
		if (dp[i] == 0)
			dp[i] = topbotrec(i + 1, n, dp) + topbotrec(i + 2, n, dp);
		return dp[i];

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine().trim());
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