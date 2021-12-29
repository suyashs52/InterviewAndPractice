/* package codechef; // don't place package name! */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class CountingPrimes
{
		

	static List<Integer> prime = new ArrayList<>();
	static int pkey = 0;

	public static void main(String[] args) throws java.lang.Exception {


		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		// Count the number of prime numbers less than or equal to N
		int[] prime = new int[1000000];
		int[] cou = new int[1000000];
		int pkey = 0;
		boolean[] bprime = new boolean[1000000];
		int num = (int) Math.sqrt(1000000);
		for (int i = 2; i <= num; i++) {
			if (bprime[i] == false) {
				for (int j = i; i * j < 1000000; j++) {
					bprime[i * j] = true;
				}
			}

		}
		for (int i = 2; i < 1000000; i++) {
			if (!bprime[i]) {
				pkey++;
				cou[i] = pkey;
			} else {
				cou[i] = pkey;
			}
		}

		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(cou[in.nextInt()]);
			
		}

	
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