package com.ashvidky.challenge.bactraking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LotteryNumbers {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner scanner = new Scanner(System.in);
        Integer nums = scanner.nextInt();
        String[] input = new String[nums];
        for (int i = 0; i < nums; i++){
            input[i] = scanner.nextLine();
        }
        
        for (String s : input) {
            List<List<Integer>> perm = permute(s, 7, new ArrayList<>());
            for (List<Integer> p : perm) {
                String result = p.stream().map(String::valueOf).collect(Collectors.joining(" "));
                System.out.println(s + "->" + result);
            }
        }
    }
    
    
    public static List<List<Integer>> permute(String input, int remaining, List<Integer> state){
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (input.length() == 0 && remaining == 0){
            //System.out.println("State:" + state);
            result.add(new ArrayList(state));
            return result;
        }
        
        if (input.length() < remaining
            || input.length() > remaining * 2){
                
            return new ArrayList<>();
        }
        
        Integer n1 = Integer.parseInt(input.substring(0, 1));
        String r1 = input.substring(1);
        if (isValid(n1, state)){
            state.add(n1);
            List<List<Integer>> perm = permute(r1, remaining - 1, state);
            if (perm.size() > 0)
                result.addAll(perm);
                
            state.remove(n1);
        }
        
        if (input.length() > 1){
            Integer n2 = Integer.parseInt(input.substring(0, 2));
            String r2 = input.substring(2);
            if (isValid(n2, state)){
                state.add(n2);
                List<List<Integer>> perm = permute(r2, remaining - 1, state);
                if (perm.size() > 0)
                    result.addAll(perm);
            }
            
            state.remove(n2);
        }
        
        return result;
    }
    
    public static boolean isValid(Integer number, List<Integer> state){
        
        if (number < 1 || number > 59)
            return false;
            
        if (state.contains(number))
            return false;
            
        return true;
    }
}