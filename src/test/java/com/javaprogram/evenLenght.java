package com.javaprogram;

public class evenLenght {

	public static void main(String[] args) {
		String s1="    sdfdsfs        ";
		
		int count=s1.length();
		System.out.println(count);
		
		if(count%2==0)
		{
			System.out.println("Even");
			
		}
		
		else
		{
			System.out.println("Odd");
		}
		
		
		s1=s1.trim();
		if(s1.length()==0) {
			System.out.println("contains white spaces");	
		}else {
			System.out.println("proper string");
		}
			
			
			
	

	}

}
