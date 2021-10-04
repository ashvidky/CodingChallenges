package com.ashvidky.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class StringArraysTest {

	@Test
	public void uniqueChars() {
		
		StringsArrays sa = new StringsArrays();
		
		assertTrue(sa.uniqueCharacters("abcd"));
		assertFalse(sa.uniqueCharacters("bcaad"));
		assertFalse(sa.uniqueCharacters("bacad"));
		assertTrue(sa.uniqueCharacters("bc dsa"));

	}
	
	@Test
	public void reverseString() {
		
		StringsArrays sa = new StringsArrays();

		assertEquals(sa.reverseString("abcd"), "dcba");
		assertEquals(sa.reverseString("abcde"), "edcba");


	}
	
	@Test
	public void smsMessages() {
		
		String s = "SMS messages are really short";
		assertEquals(3, StringsArrays.smsMessages(s, 12));
	}
}
