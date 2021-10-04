package com.ashvidky.challenge.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class CodilityTest {

	@Test
	void largestAlphabeticalLetterTest() {
		
		String s1 = "aaBabcDaA";
		String r1 = Codility.largestAlphabeticalLetter(s1);
		assertEquals("B", r1, "No match");
		
		String s2 = "Codility";
		String r2 = Codility.largestAlphabeticalLetter(s2);
		assertEquals("NO", r2, "No match");
		
		String s3 = "WeTestCodErs";
		String r3 = Codility.largestAlphabeticalLetter(s3);
		assertEquals("T", r3, "No match");
	}

	
	@Test
	void numberOfSmsMessagesTest() {
		
		String s1 = "SMS messages are really short";
		int r1 = Codility.numberOfSmsMessages(s1, 12);
		assertEquals(3, r1, "No match");
		
		String s2 = "SMS messages are really short";
		int r2 = Codility.numberOfSmsMessages(s1, 10);
		assertEquals(4, r2, "No match");
		
	}
}
