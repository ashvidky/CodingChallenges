package com.ashvidky.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Streams {

	public List<String> search(List<String> list) {

		return list
				.stream()
				.filter( (s) -> (s.length() == 3))
				.filter(s -> s.startsWith("a"))
				.collect(Collectors.toList());
	}

	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {

		return Arrays.stream(names)
				.filter(s -> s.length() > 5)
				.mapToInt(s->s.length()).sum();

	}

	public static List<String> transform(List<List<String>> collection) {
		//	List<String> newCollection = new ArrayList<>();
		//	for (List<String> subCollection : collection) {
		//		for (String value : subCollection) {
		//			newCollection.add(value);
		//		}
		//	}
		//	return newCollection;

		return collection.stream()
				.flatMap(c -> c.stream())
				.collect(Collectors.toList());
	}
	
	public static Person getOldestPerson_Traditional(List<Person> people) {
		Person oldestPerson = new Streams().new Person("", 0);
		for (Person person : people) {
			if (person.getAge() > oldestPerson.getAge()) {
				oldestPerson = person;
			}
		}
		return oldestPerson;
	}
	
	public static Person getOldestPerson_Java8(List<Person> people) {
		
		Optional<Person> oldetsPerson = people.stream().max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		return oldetsPerson.get();
	}
	
	class Person {

		private String name;
		private int age;
		private String nationality;

		public Person(String name, int age, String nationality) {
			this.name = name;
			this.age = age;
			this.nationality = nationality;
		}

		public Person(String name, int age) {
			this(name, age, "");
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

	  public String getNationality() {
	    return nationality;
	  }
	}

	public static int calculate_Traditional(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}
	
	public static int calculate_Java8(List<Integer> numbers) {
	
		return numbers.stream().mapToInt(i -> i).sum();
	}
	
	public static int calculate_Java8_reduce(List<Integer> numbers) {
		
		return numbers.stream().reduce(0, (a,b) -> a + b);
	}
	
	public static Set<String> getKidNames_Traditional(List<Person> people) {
		Set<String> kids = new HashSet<>();
		for (Person person : people) {
			if (person.getAge() < 18) {
				kids.add(person.getName());
			}
		}
		return kids;
	}
	
	public static Set<String> getKidNames_Java8(List<Person> people) {
		
		return people.stream()
				.filter(p -> p.getAge() < 18)
				.map(p -> p.getName())
				.collect(Collectors.toSet());
	}
	
	public static Map<Boolean, List<Person>> partitionAdults_Traditional(List<Person> people) {
		Map<Boolean, List<Person>> map = new HashMap<>();
		map.put(true, new ArrayList<>());
		map.put(false, new ArrayList<>());
		for (Person person : people) {
			map.get(person.getAge() >= 18).add(person);
		}
		return map;
	}
	
	public static Map<Boolean, List<Person>> partitionAdults_Java8(List<Person> people) {
		
		return people.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
		
	}
	
    public static Map<String, List<Person>> groupByNationality_Traditional(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.getNationality())) {
                map.put(person.getNationality(), new ArrayList<>());
            }
            map.get(person.getNationality()).add(person);
        }
        return map;
    }
    
    public static Map<String, List<Person>> groupByNationality_Java8(List<Person> people) {
        
    	return people.stream().collect(Collectors.groupingBy(p->p.getNationality()));
    }
    
    public static String namesToString_Traditional(List<Person> people) {
		String label = "Names: ";
		StringBuilder sb = new StringBuilder(label);
		for (Person person : people) {
			if (sb.length() > label.length()) {
				sb.append(", ");
			}
			sb.append(person.getName());
		}
		sb.append(".");
		return sb.toString();
	}
    
    public static String namesToString_Java8(List<Person> people) {
    	
    	return people.stream()
    		.map(p -> p.getName())
    		.collect(Collectors.joining(","));
    	
    }
    
    /*
     * We are given S containing N letters.
     * Find alphabetically largest letter that occurs in BOTH lowercase and uppercase.
     * Otherwise return "NO"
     * 
     * Examples:
     * 1. Given S = "aaBabcDaA", return "B". ("B" > "A")
     * 2. Given S = "Codility", return "NO". 
     * 
     * Assumptions:
     * S consists only of letters
     * N is integer [1...200000]
     */
    public static String findAlphabeticalLargest(String s) {
    	
    	List<String> sortedDistinct = Stream.of(s.split(""))
    			.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
    			.distinct()
    			.collect(Collectors.toList());

    	log.info("sortedDistinct:{}", sortedDistinct);
    	
    	if (sortedDistinct.size() < 2)
    		return "NO";
    	    		
    	for(int i = 0, j = 1; j < sortedDistinct.size(); i++, j++) {
    		String s1 = sortedDistinct.get(i).toUpperCase();
    		String s2 = sortedDistinct.get(j).toUpperCase();
    		
    		if (s1.equals(s2))
    			return s1;
    	}
    	
    	return "NO";
    }
    
    
//    public static String getString(List<Integer> list) {
//    	
//         return list.stream().map(i -> ({
//        	 "a" + i;
//         })).collect(Collectors.joining(","));
//         
//    }
}
