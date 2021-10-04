package com.ashvidky.challenge.order;

import java.util.TreeSet;

public class LexiOrder {

	// ["BCC", "ABC", "ACC", "CCC"]
	
	public void lexiOrder(String[] array) {
		
		TreeSet<String> sorted = new TreeSet<String>();
		
		for (int i = 0; i < array.length; i++) {
			
			String s = array[i];
			for (int j = 0; j < s.length(); j++) {
				sorted.add(String.valueOf(s.charAt(j)));
			}
			
		}
		
		
		
	}
}
