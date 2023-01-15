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
public class Subset {

	static List<Integer> prime = new ArrayList<>();
	static int pkey = 0;

	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		// https://leetcode.com/problems/subsets/

		int[] a = new int[] { 1, 2, 3 };
		int n = a.length;
		subsets(a);
		System.out.println("------");
		subsets(a, 0, new int[n], 0);
		System.out.println("----subsetsGenerateFromExisting-");
		List<List<Integer>> la = subsetsGenerateFromExisting(a);
		for (List<Integer> list : la) {
			System.out.println(list);
		}

		System.out.println("----subsetsGenerateUsingBitMasking-");
		subsetsGenerateUsingBitMasking(a);
		for (List<Integer> list : la) {
			System.out.println(list);
		}

	}

	static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> l = new ArrayList<List<Integer>>();

		List<Integer> temp = new ArrayList<Integer>();
		subsetrec(nums, -1, -1, temp, l);

		for (List<Integer> list : l) {
			System.out.println(list);
		}
		return l;
	}

	static void subsets(int[] nums, int index, int[] temp, int size) {
		if (index == nums.length) {
			for (int i = 0; i < size; i++) {
				System.out.print(temp[i] + ",");
			}
			System.out.println("\n---");
			return;
		}

		// taking index element
		temp[size] = nums[index];
		subsets(nums, index + 1, temp, size + 1);
		// not taking index element
		subsets(nums, index + 1, temp, size);

	}

	static void subsetrec(int[] nums, int index, int level, List<Integer> temp, List<List<Integer>> l) {
		if (index == nums.length - 1) {
			if (level == -1) {
				l.add(new ArrayList<Integer>());

			} else {
				l.add(new ArrayList<Integer>(temp));
			}
			return;
		}

		// element should not included
		subsetrec(nums, index + 1, level, temp, l);
		level = level + 1;
		index = index + 1;
		temp.add(nums[index]);
		subsetrec(nums, index, level, temp, l);
		// backtrack
		index = index - 1;
		level = level - 1;
		temp.remove(temp.size() - 1);

	}

	public static List<List<Integer>> subsetsGenerateFromExisting(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());

		for (int n : nums) {
			List<List<Integer>> nr = new ArrayList<List<Integer>>();
			for (List l : result) {

				nr.add(new ArrayList<Integer>(l) {
					{
						add(n);
					}
				});

			}
			for (List l : nr) {

				result.add(l);

			}

		}

		return result;

	}

	public static List<List<Integer>> subsetsGenerateUsingBitMasking(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		int n = nums.length;
		String bitmask = Integer.toBinaryString(8).substring(1);
		System.out.println(Integer.toBinaryString(10));
		System.out.println(bitmask);

		int s = (int) Math.pow(2, n);
		int l = (int) Math.pow(2, n + 1);

		for (int i = s; i < l; i++) {

			List<Integer> k = new ArrayList<Integer>();
			String bitmas1k = Integer.toBinaryString(i).substring(1);

			for (int j = 0; j < bitmas1k.length(); j++) {
				if (bitmas1k.charAt(j) == '1')
					k.add(nums[j]);
			}
			output.add(k);

		}
		return output;
 
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