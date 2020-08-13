package com.javaprogram;

import java.util.ArrayList;

public class Arraylist {
	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("Mayur");
		list.add("dsv");
		list.add("dsfds");
		
		String s="";
		for(int i=0; i<=2;i++)
		{
			String s1=list.get(i);
			String s2=",";
		//	s=s+s1+s2;	
		//	s=s+","+s1;
			
		//	s=s+s1.concat(",");
			
			if(i==0)
			{
			
				s=s+s1;
				
			}else
			{
				s=s+","+s1;
			}
		}
		
		System.out.println(s);
	}

}
