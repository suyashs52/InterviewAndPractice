package pp.gu.recur;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GenerateBracket {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/powx-n/
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(5));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		String sb = new String();

		generate(sb, list, n, 0, 0);

		return list;
	}

	private static void generate(String sb, List<String> list, int n, int open, int close) {

		if (sb.length() == n * 2) {
			list.add(sb.toString());
			return;
		}
		
		if (open < n) {
			sb += "(";
			generate(sb, list, n, open + 1, close);
			sb=sb.substring(0,sb.length()-1);

		}
		
		if ( close < open) {
			sb += ")";
			generate(sb, list, n, open, close + 1);
			sb=sb.substring(0,sb.length()-1);
		}

		

	}

}