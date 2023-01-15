package pp.gu.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class EquallyDistriGroup {
	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		// divide array in Each group has exactly X number of integers where x>= 2
		// the integers in each group are equal
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a; i++) {
			int len = s.nextInt();
			int[] subsequence = new int[len];
			int key = 0;
			for (int j = 0; j < len; j++) {

				subsequence[j] = s.nextInt();
				map.put(subsequence[j], map.getOrDefault(subsequence[j], 0) + 1);
			}
			int count = map.get(subsequence[0]);
			if(map.size()==1 && count >1) {
				System.out.println("true");
				continue;
			}else if(map.size()==1) {
				System.out.println("false");
				continue;
			}
			if (count < 2) {
				System.out.println("false");
				continue;
			}
			boolean f = true;
			// 4 6
			// take the gcd

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				count = gcd(Math.max(count, m.getValue()), Math.min(count, m.getValue()));

			}

			if (count > 1) {
				System.out.println("true");
			} else {
				System.out.println("false");
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