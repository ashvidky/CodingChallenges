package com.ashvidky.challenge.islands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashvidky.challenge.islands.Islands;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class IslandsTest {

	@Test
	public void countIslands() {
	    
	    int[][] mat =  {{1, 1, 0, 0, 0, 0},
		                {0, 1, 0, 0, 1, 0},
		                {1, 0, 0, 1, 1, 0},
		                {0, 0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1, 0}};
	    
	    int countIslands = new Islands().countIslands(mat);
	    
	    log.info("Number Of Islands:{}", countIslands);
	}
}
