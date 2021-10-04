package com.ashvidky.training;

import java.util.Arrays;
import java.util.HashSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringsArrays {

	/*
	 * Implement an algorithm to determine if a string has all unique characters 
	 * What if you can not use additional data structures?
	 */
	public boolean uniqueCharacters(String s) {
		
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		
		if (ca.length <= 1)
			return true;
		
		for (int i = 1; i < ca.length; i++) {
			if (ca[i] == ca[i-1])
				return false;
		}
		
		return true;
	}
	
	public String reverseString(String s) {
		
		char[] ca = s.toCharArray();
		int i = 0, j = ca.length -1;
		while (i < j) {
			char temp = ca[i];
			ca[i] = ca[j];
			ca[j] = temp;
			
			i++;
			j--;
		}
		
		return new String(ca);
	}
	
	public static int smsMessages(String text, int length) {
		
		if (text.length() < length)
			return 1;
		
		String[] splittedText = text.split(" ");
		
		HashSet<String> smsSet = new HashSet<>();
		StringBuilder sms = new StringBuilder();
		for (int i = 0; i < splittedText.length; i++) {
			
			if (sms.length() + splittedText[i].length() + 1 <= length) {
				if (sms.length() == 0)
					sms.append(splittedText[i]);
				else
					sms.append(" ").append(splittedText[i]);
			}
			else {
				if (sms.length() == 0) {
					log.error("Cannot split message to the right size:{}", splittedText[i]);
					return -1;
				}
				else {
					smsSet.add(sms.toString());
					sms = new StringBuilder(splittedText[i]);
				}
			}
		}
		
		if (sms.length() > 0)
			smsSet.add(sms.toString());
			
		log.info(smsSet.toString());
		
		return smsSet.size();
	}
}
