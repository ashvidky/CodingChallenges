package com.ashvidky.challenge.topological;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* 
 * Suppose we have some input data describing a graph of relationships between parents and children 
 * over multiple generations. The data is formatted as a list of (parent, child) pairs, 
 * where each individual is assigned a unique positive integer identifier.
*/

//For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

//1   2    4   15
//\ /   / | \ /
//3   5  8  9
//\ / \     \
//6   7    11


//Sample input/output (pseudodata):

//parentChildPairs = [
//(1, 3), (2, 3), (3, 6), (5, 6), (15, 9),
//(5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
//]

//(parent, child)

/* 
 * Write a function that takes this data as input and returns two collections: 
 * one containing all individuals with zero known parents, 
 * and one containing all individuals with exactly one known parent.
 */


//Output may be in any order:

//findNodesWithZeroAndOneParents(parentChildPairs) => [
//[1, 2, 4, 15],       // Individuals with zero parents
//[5, 7, 8, 11]        // Individuals with exactly one parent
//]

//Complexity Analysis variables:

//n: number of pairs in the input


public class ParentsChildren {
public static void main(String[] argv) {
 int[][] parentChildPairs = new int[][] {
   {1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7}, 
   {4, 5}, {4, 8}, {4, 9}, {9, 11}
 };
 
 //System.out.println("Start");
 List<List<Integer>> result = solution(parentChildPairs);
 List<Integer> zeroParents = result.get(0);
 for (Integer i : zeroParents){
   
   System.out.println(i);
   
 }
 
 List<Integer> oneParents = result.get(1);
 for (Integer i : oneParents){
   
   System.out.println(i);
   
 }
}


public static List<List<Integer>> solution(int[][] parentChildPairs){
   
 List<Integer> zeroParents = new ArrayList<>();
 List<Integer> oneParents = new ArrayList<>();

 Map<Integer, Set<Integer>> graph = new HashMap<>();
 
   for (int i = 0; i < parentChildPairs.length; i++){
     
     int[] pair = parentChildPairs[i];
     
     Set<Integer> parents = graph.get(pair[1]);
     if (parents == null){
       
       parents = new HashSet<>();
       graph.put(pair[1], parents);
     }
     
     parents.add(pair[0]);
     
     
     Set<Integer> p = graph.get(pair[0]);
     if (p == null)
       graph.put(pair[0], new HashSet<>());
           
 }
   
 for (Map.Entry<Integer, Set<Integer>> e : graph.entrySet()){
   
   int numOfParents = e.getValue().size();
   
   //System.out.println("numOfParents: " + numOfParents);
   
   if (numOfParents == 0)
     zeroParents.add(e.getKey());
   
   if (numOfParents == 1)
     oneParents.add(e.getKey());
 }
 
 
 List<List<Integer>> result = new ArrayList<>();
 result.add(zeroParents);
 result.add(oneParents);

 return result;
}
}
