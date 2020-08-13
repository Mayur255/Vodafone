package com.javaprogram;

public class CheckString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="e12wewre2";
	
		int flag=0;
		for(int i=0; i<s.length(); i++)
		{
			char a=s.charAt(i);
			System.out.print(a);
			
			if((a>='A'&&a<='Z') || (a>='a'&& a<='z'))
			{
				System.out.print(a);
				
			}else {
				flag=1;
			}
			
		}
		if(flag==0)
					{
			System.out.println("Only alphabet is ");
		}
		else
		{
			System.out.println("Error");
		}
		}

}
