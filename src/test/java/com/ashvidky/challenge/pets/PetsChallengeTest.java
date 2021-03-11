package com.ashvidky.challenge.pets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class PetsChallengeTest {

	@Test
	public void allKnowAll() {
		
		int[] P = {2, 2, 1, 1, 1};
		int[] T = {1, 1, 1, 2, 2};
		
		int[] A = {0, 1, 2, 3};
		int[] B = {1, 2, 3, 4};
		
		PetsChallenge pc = new PetsChallenge();
		boolean result = pc.solution(P, T, A, B);
		
        assertTrue(result);

	}
	
	@Test
	public void noWrongToys() {
		
		int[] P = {2, 2, 1, 1, 1};
		int[] T = {2, 2, 1, 1, 1};
		
		int[] A = {0, 1, 2, 3};
		int[] B = {1, 0, 3, 4};
		
		PetsChallenge pc = new PetsChallenge();
		boolean result = pc.solution(P, T, A, B);
		
        assertTrue(result);

	}
}
