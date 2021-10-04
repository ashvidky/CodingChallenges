package com.ashvidky.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

	public static void main(String[] args) {
		
		
		String IP = "172:16:254.1";
		String[] split = IP.split(":");
		
		
		
		int[] A = {1,1,2,1,2,3,4,4};
		for (int i : A) {
			
		}
//		
//		
//		
//		IntStream streamOfA = IntStream.of(A);		
//		
//		List<Integer> collect = streamOfA
//			.distinct()
//			.boxed()
//			.collect(Collectors.toList());
//		
//		log.info(collect.toString());
//		
//		String mystring = "aafkvdAdirDFRDV";
//		
//		Comparator<String> c = String.CASE_INSENSITIVE_ORDER;
//		Comparator<String> co = c.thenComparing(Comparator.reverseOrder());
//		
//		String[] chars = mystring.split("");
//		Arrays.sort(chars, String.CASE_INSENSITIVE_ORDER);
//		List<String> distinct = Stream.of(chars).distinct().collect(Collectors.toList());
//		
//		log.info("Sorted, distinct:{}", distinct);
//
//		
//		List<String> charList = mystring
//				.chars()			  
//				.mapToObj(e -> (char)e)
//				.map(e -> e.toString())
//				.distinct()
//				.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
//				.collect(Collectors.toList());
//
//		log.info(charList.toString());
//
//		if (charList.size() < 2)
//			return ;
//
//
//		int i = charList.size() - 1;
//		int j = charList.size() - 2;
//		while (j >= 0) {
//
//			if (charList.get(i).equalsIgnoreCase(charList.get(j)))
//				log.info(charList.get(i - 1));
//
//			i--;
//			j--;
//		}
//		
//		Stream<String> sortedDistinct =  Stream.of(mystring.split(""))
//			.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
//			.distinct()
//			.map(s -> s.toUpperCase())
//			.distinct();
//		
//		Optional<String> first = sortedDistinct.findFirst();
//		log.info("Top:{}", first.get());
//		
//		List<String> collect = sortedDistinct.collect(Collectors.toList());
//		log.info("Sorted, distinct #2:{}", collect);

		

//				Arrays.sort(fruits, String.CASE_INSENSITIVE_ORDER);
		
//				String[] chars = str.split("");
//				Arrays.sort(chars, String.CASE_INSENSITIVE_ORDER);
				
//				String sortedString =
//					    Stream.of("hello".split(""))
//					    .sorted()
//					    .collect(Collectors.joining());
	}
}
