package com.ashvidky.challenge.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Codility {

	public static String largestAlphabeticalLetter(String s) {
		
		List<Character> lowerSet = new ArrayList<>();
		HashSet<Character> upperSet = new HashSet<>();
		
		s.chars().mapToObj(c -> Character.valueOf((char)c)).forEach(ch -> {
			
			if (Character.isUpperCase(ch))
				upperSet.add(ch);
			else
				lowerSet.add(ch);
		});
		
		Collections.sort(lowerSet, Comparator.reverseOrder());
		
		for (Character c : lowerSet) {
			
			char upperCase = Character.toUpperCase(c);
			if (upperSet.contains(Character.valueOf(upperCase)))
				return String.valueOf(upperCase);
			
		}
		
		return "NO";
	}
	
	public static int numberOfSmsMessages(String s, int K) {
		
		List<StringBuffer> sms = new ArrayList<>();
		StringBuffer message = new StringBuffer();
		String[] words = s.split(" ");
		for (String word : words) {
			
			if (message.length() == 0) {
				if (word.length() <= K)
					message.append(word);
			}
			else {
				if ( (word.length() + 1) <= (K - message.length()) ) 
					message.append(" ").append(word);
				else {
					sms.add(message);
					message = new StringBuffer(word);
				}
			}
		}
		
		sms.add(message);
		
		return sms.size();
	}
}
