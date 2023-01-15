package pp.gu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class MakingTeams {
	public static void main(String[] args) throws java.lang.Exception {

//		There are N boys and  M girls attending a class.The teacher needs to choose a group containing exactly 
//		X students containing no less than 4 boys and no less than one girl for an project.
//		How many ways are there to choose a group?
//				1≤T≤10 5
//				4≤N≤30
//				1≤M≤30
//				5≤X≤N+M
//				1
//				5 2 5
//				
//				10

		// to choose x record from M is MCx // M+NCx is total choosen student
		// x students must contain at least 4 boys ,1 girls for x=15 check from 8,7
		// 8c4*7c11
		// if there are a path that needs to map with b path so total path is a*b
		// for x=10, b=4,5,6,7,8,9 for x=15 b=4to 14 so b can be dyn
		// we can calculate b=0,1,2,3 and g=0 and substract from total it ll give the
		// same result
// so mc0*ncx,mc1*mcx-1,mc2*ncx-2,mc3ncx-3 // here if x-3 is greater then n/m means not possible selecting 
		// more value from existing number is not possible so answer is 0

		// to calculate we need cataln number

		long[][] catno = new long[61][61]; // n,m size is 60
		catno[0][0] = 1;// 0c0
		catno[1][0] = 1; // 1c0 is 1
		catno[1][1] = 1;// 1c1 is 1

		for (int i = 2; i < 61; i++) {
			catno[i][0] = 1;
			for (int j = 1; j < i; j++) {
				catno[i][j] = catno[i - 1][j - 1] + catno[i - 1][j];
			}
			catno[i][i] = 1;
		}

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		for (int i = 0; i < t; i++) {
			int boys = fs.nextInt();
			int girls = fs.nextInt();
			int choose = fs.nextInt();

			long total = catno[boys + girls][choose]; // given boy is greater then 4 and girl is greater than 1
			long b0 = 0;
			if (girls >= choose) {
				b0 = catno[boys][0] * catno[girls][choose];
			}
			long b1 = 0; // choosing 1 boy
			if (girls >= choose - 1) {
				b1 = catno[boys][1] * catno[girls][choose - 1];
			}
			long b2 = 0;
			if (girls >= choose - 2) {
				b2 = catno[boys][2] * catno[girls][choose - 2];
			}
			long b3 = 0;
			if (girls >= choose - 3) {
				b3 = catno[boys][3] * catno[girls][choose - 3];

			}
			long g0 = 0;// choosing 0 girl
			if (boys >= choose) {
				g0 = catno[boys][choose] * catno[girls][0];
			}

			System.out.println(total - b0 - b1 - b2 - b3 - g0);

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