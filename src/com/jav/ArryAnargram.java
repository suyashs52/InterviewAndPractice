package com.jav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArryAnargram {
	public static void code() {
		 String arr[] = { "cat", "dog", "tac", "god", "act" };
		 
		 Map<String,List<String>> m=new HashMap<>();
		 
		 for(String a:arr) {
			 char[] cr=a.toCharArray();
			 Arrays.sort(cr);
			 String s=new String(cr);
			 if(m.containsKey(s)) {
				   m.get(s).add(a);
			 }else {
				 List<String> ls=new ArrayList<String>();
				 ls.add(a);
				 m.put(s, ls);
			 }
			 
			
		 }
		 System.out.println(m);
	}
}
