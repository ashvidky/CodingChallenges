package com.ashvidky.challenge.islands;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Islands {

	
	public int countIslands(int[][] mat) {
		
		int rows = mat.length;
		int collumns = mat[0].length;
		log.info("Length:{}, height:{}", rows, collumns);
		
		int[][] visited = new int[rows][collumns];
		
		int numOfIslands = 0;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				
				// check if visit before
				if (!isVisited(visited, i, j)) {
					
					if (mat[i][j] == 1) {
						// found an new island
						log.info("Found new island [{},{}]", i, j);
						
						numOfIslands++;
						exploreTheLand(i, j, mat, visited);
					}
				}
			}
		}
		
		return numOfIslands;
	}
	
	private void exploreTheLand(int i, int j, int[][]mat, int[][]visited) {
		int rows = mat.length;
		int collumns = mat[0].length;
		
		log.info("Start Exploring from [{},{}]", i,j);
		
		ArrayList<Coordinate> land = new ArrayList<>() ;
		
		land.add(new Coordinate(i, j));
		
		while(land.size() > 0) {
			
			Coordinate c = land.remove(0);
			
			// mark as visited
			visited[c.x][c.y] = 1;
			
			int startRow = Math.max(0, c.x - 1);
			int startCol = Math.max(0, c.y - 1);
			int endRow = Math.min(c.x + 1, rows - 1);
			int endCol = Math.min(c.y + 1, collumns - 1);
			
			log.info("Exploring area from [{},{}] to [{},{}]", startRow,startCol, endRow, endCol);
			for (int k = startRow; k <= endRow; k++) {
				for (int l = startCol; l <= endCol; l++) {
					
					log.info("Exploring land [{},{}]", k, l);
					
					if (!isVisited(visited, k, l) && mat[k][l] == 1) {
						log.info("More island land {},{}]", k, l);
						land.add(new Coordinate(k, l));
					}
					visited[k][l] = 1;
				}
			}
			
		}
		
	}

	private boolean isVisited(int[][] visited, int i, int j) {
		
		return visited[i][j] == 1;
	}
	
	class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
