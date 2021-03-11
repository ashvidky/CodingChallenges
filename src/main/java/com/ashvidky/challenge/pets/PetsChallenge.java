package com.ashvidky.challenge.pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PetsChallenge {

	public boolean solution(int[] P, int[] T, int[] A, int[] B) {
		
		// check not null
		if (P == null || T == null || A == null || B == null)
			return false;
		
		// groups
		int[] C = new int[P.length];
		buildConnections(A, B, C);
		
		// exchangeResult
		HashMap<Integer, Integer> exchangeResultMap = new HashMap<Integer, Integer>();
				
		// calculate results
		for (int i = 0; i < P.length; i++) {
			
			// wrong toy
			if (P[i] != T[i]){
				
				int factor = 0;
				if (T[i] == 1) 
					factor = 1;
				else
					factor = -1;
				
				
				Integer exchange = exchangeResultMap.get(C[i]);
				if (exchange == null)
					exchange = 0;
				
				exchangeResultMap.put(C[i], (exchange + factor));
			}
		}
		
		Collection<Integer> values = exchangeResultMap.values();
		Iterator<Integer> it = values.iterator();
		while (it.hasNext()) {
			if (it.next() != 0)
				return false;
		}
		
		return true;
	}

	private void buildConnections(int[] A, int[] B, int[] C) {
		int group = 0;
		
		HashMap<Integer, Set<Integer>> groups = new HashMap<Integer, Set<Integer>>();

		for (int k = 0; k < A.length; k++) {
			int person1 = A[k];
			int person2 = B[k];
			
			int group1 = C[person1];
			int group2 = C[person2];
			if (group1 == 0 && group2 == 0) {
				// new group
				group++;
				
				C[person1] = group;
				C[person2] = group;
				
				Set<Integer> groupSet = new HashSet<>();
				groupSet.add(person1);
				groupSet.add(person2);
				groups.put(group, groupSet);
			}
			else if (group1 > 0 && group2 > 0 && group1 != group2){			
				unifyGroups(C, group1, group2, groups);
			}
			else if (group1 == 0) {
				C[person1] = group2;
				Set<Integer> groupSet = groups.get(group2);
				if (groupSet != null)
					groupSet.add(person1);
			}
			else {
				C[person2] = group1;
				Set<Integer> groupSet = groups.get(group1);
				if (groupSet != null)
					groupSet.add(person2);
			}
				
//			log.info("End of person:" + k);
//			log.info("Connections:{}",  C);

		}	
	}

	private void unifyGroups(int[] C, int group1, int group2, HashMap<Integer, Set<Integer>> groups) {
		
		int minGroup = Math.min(group1, group2);
		int maxGroup = Math.max(group1, group2);
		Set<Integer> maxGroupPeople = groups.remove(maxGroup);
		if (maxGroupPeople != null) {
			for (Integer p : maxGroupPeople) 
				C[p] = minGroup;
			
			groups.get(minGroup).addAll(maxGroupPeople);
		}
	}

}
