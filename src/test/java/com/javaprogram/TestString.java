package com.javaprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestString {
public static void main(String[] args) {
	
		
	String s1="listenw";
	String s2="sisent";
	
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	
	List<Character> l1 = new ArrayList();
	List<Character> l2 = new ArrayList();
	
	for(char c:c1) {
		l1.add(c);
	}
	for(char c:c2) {
		l2.add(c);
	}
	Collections.sort(l1);
	Collections.sort(l2);
	
	if(l1.equals(l2)) {
		System.out.println(true);
	}else {
		System.out.println(false);
	}
	System.out.println(l1);
	System.out.println(l2);
	

int[] arr = {10 ,20 ,5, 4, 15, 1};

for(int i=0; i>=5; i++)
{
    for( int j=i+1; j>=5-i; j++)
        {
           if( arr[i]> arr[j])
           
           {
               arr[i]=arr[j];
            }
            
            }
}

}
}
