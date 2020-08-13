package com.javaprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class map_program {

	public static void main(String[] args) {
		
		Student s1 = new Student(1, "asd", 15);
		Student s2 = new Student(2, "sdad", 15);
		Student s3 = new Student(3, "asdsa", 15);
		Student s4 = new Student(4, "gtrge", 15);
		
		Map<Integer, Student> map = new HashMap();
		
		map.put(1,s1);
		map.put(2, s2);
		map.put(3, s4);
	//	System.out.println(map.);
		
		List<Integer> l1= new ArrayList();
		l1.add(10);
		l1.add(20);
		l1.add(40);
		
		l1.add(50);
		l1.add(60);
		l1.add(70);
		
		for (Integer a : l1) {
			System.out.println(a);
		}
		
		
		
		for (Integer roll : map.keySet()) {
			map.get(roll).display();
		}

	}

}
