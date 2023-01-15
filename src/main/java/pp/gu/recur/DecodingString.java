package pp.gu.recur;

import java.util.Stack;

public class DecodingString {

	public static void main(String... strings) {
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("3[a]2[bc]"));

	}

	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stnumber = new Stack<>();
		Stack<StringBuilder> ststring = new Stack<>();
		StringBuilder curr = new StringBuilder();
		int num = 0;

		for (char c : s.toCharArray()) {
//			System.out.println("--------------");
//			System.out.println("number stack");
//			System.out.println(stnumber);
//			System.out.println("string stack");
//			System.out.println(ststring);
//			System.out.println("string");
//			System.out.println(curr);
			// 30900[a2[c]]
			// c
			// ab , abc , def
			if (Character.isAlphabetic(c)) {
				curr.append(c);
			} else if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else if (c == '[') {
				// we have number
				stnumber.push(num);
				// whatever string push
				ststring.push(curr);
				num = 0;
				curr = new StringBuilder();
			} else if (c == ']') {
				StringBuilder temp = new StringBuilder();
				temp = ststring.pop();
				int i = stnumber.pop();
				for (int j = 0; j < i; j++) {
					temp.append(curr);
				}
				curr = temp;
			}
		}
		return curr.toString();

	}

}
