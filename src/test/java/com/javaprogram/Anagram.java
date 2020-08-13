package com.javaprogram;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {

		Map<Integer,String> map=new HashMap();
		Map<Integer,String> map1=new HashMap();
		Map<Integer,String> map2=new HashMap();
		map.put(1, "Mayur");
		map.put(2,"Shrutika");
		map.put(3, "abc");
		map.put(4, "erfdsfd");
		
		map2.put(5, "Mayur");
		map2.put(6,"Shrutika");
		map2.put(7, "abc");
		map2.put(8, "erfdsfd");
		
		for(Map.Entry m:map.entrySet()) {
			System.out.println(m.getKey() + "  "+ m.getValue());
			
		}
		map.putAll(map2);
		
		for(Map.Entry m:map.entrySet()) {
			System.out.println(m.getKey() + "  "+ m.getValue());
			
		}
		
		
		
		System.out.println(map==map2);
		String s1="asa";
		String s2="asa";
		
		if(map.equals(map2))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}

}
