package com.javaprogram;

import java.util.HashMap;

public class find_unique_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="rtea";
		int flag=0;
		for(int i=0; i<s.length(); i++)
		{
			char c=s.charAt(i);
			for(int j=i+1; j<s.length(); j++)
			{
				char c1=s.charAt(j);
				if(c==c1)
				{
					//System.out.println("Error");
					flag=1;
				}
				else
				{
					//System.out.println("True");
				}
				
			}
			
			
		}
		
		if(flag==0)
		{
			System.out.println("Unique char");
		}
		else
		{
			System.out.println("Error");
		}
		HashMap<Character,Integer> map=new HashMap();
		map.put('a', 1);
		

	}

}
