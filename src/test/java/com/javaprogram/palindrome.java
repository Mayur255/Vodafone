package com.javaprogram;

import java.util.Scanner;

public class palindrome {
	
	 palindrome()
	{
		String s="assaa";
		String rev="";
		int n=s.length();
		System.out.println(n);
		for(int i=s.length()-1; i>=0; i--)
		{
			rev=rev+s.charAt(i);
		}
		System.out.println(rev);
		if(s.equalsIgnoreCase(rev))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}
	}
	
	 void palindrome_num()
	 {
		 
		 int x=12347;
		 int sum=0,y;
		 while(x>0)
			{
			 y=x%10;
			 System.out.println(y);
			 sum=(sum*10)+y;
			 x=x/10;
			 
			}
		 
		 System.out.println("=="+sum);
		 
		 int a,b=0,n;
			Scanner sn=new Scanner(System.in);
			System.out.println("Enter the number");
			n=sn.nextInt();
			
			while(n>0)
			{
				a=n%10;
			//	System.out.println(b);
				b=(b*10)+a;
				n=n/10;
				
				//System.out.println(n);
				
			}
			System.out.println(b);
		 
	 }
	 
	 static boolean  checkpalindrome(){
		 String s="madaM";
		 int j=s.length()-1;
		 for(int i=0;i<s.length();i++,j--) {
			 
			 if(s.charAt(i)!=s.charAt(j)) {
				 return false;
			 }
			 if(i==j) {
				 break;
			 }
			
		 }
		 
		 return true; 
		 
	 }
	 
	 
public static void main(String[] args) {
	
	System.out.println(checkpalindrome());
	
	palindrome p=new palindrome();
	//p.palindrome_num();
	p. checkpalindrome();
	
	
}
}
