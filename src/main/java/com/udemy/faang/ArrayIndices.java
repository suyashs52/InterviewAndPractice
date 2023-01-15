package com.udemy.faang;

import java.util.*;

public class ArrayIndices {

	public static void main(String ...strings) {
		Map<String,String> map=new Hashtable<>();
		map.put("test","test");
		map.values().iterator();
		System.out.println(map);
		String[] ls = (String[]) map.values().toArray();
		System.out.println(ls);
		
	}
}
