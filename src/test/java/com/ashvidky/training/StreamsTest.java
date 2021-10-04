package com.ashvidky.training;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashvidky.training.Streams.Person;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class StreamsTest {



	@Test
	public void lengthSearch() {

		String[] stringArray = {"abcd", "ccc", "de", "ddd", "aaa"};
		List<String> result = new Streams().search(Arrays.asList(stringArray));

		log.info(result.toString());

		String[] expectedResult = {"aaa"};
		assertEquals(Arrays.asList(expectedResult), result);
	}


	@Test
	public void transformShouldFlattenCollection() {
		List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
		List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
		assertEquals(Streams.transform(collection), expected);
	}

	@Test
	public void getOldestPersonShouldReturnOldestPerson() {
		Person sara = new Streams().new Person("Sara", 4);
		Person viktor = new Streams().new Person("Viktor", 40);
		Person eva = new Streams().new Person("Eva", 42);
		List<Person> collection = asList(sara, eva, viktor);

		Person oldestPerson_Traditional = Streams.getOldestPerson_Traditional(collection);
		Person oldestPerson_Java8 = Streams.getOldestPerson_Java8(collection);

		assertEquals(oldestPerson_Traditional.getAge(), oldestPerson_Java8.getAge());
	}

	@Test
	public void calculateShouldSumAllNumbers() {
		
		List<Integer> numbers = asList(1, 2, 3, 4, 5);
		
		Streams.calculate_Traditional(numbers);
		
		assertEquals(Streams.calculate_Traditional(numbers), Streams.calculate_Java8(numbers));;
	}
	
	@Test
	public void getKidNameShouldReturnNamesOfAllKidsUnder18() {
		Person sara = new Streams().new Person("Sara", 4);
		Person viktor = new Streams().new Person("Viktor", 40);
		Person eva = new Streams().new Person("Eva", 42);
		Person anna = new Streams().new Person("Anna", 5);
		List<Person> collection = asList(sara, eva, viktor, anna);

		assertEquals(Streams.getKidNames_Traditional(collection), Streams.getKidNames_Java8(collection));
	}
	
	
	@Test
	public void findAlphabeticallyLargest() {
		
		// 1. Given S = "aaBabcDaA", return "B". ("B" > "A")
		// 2. Given S = "Codility", return "NO". 
			    	
		String s1 = "aaBabcDaA";
		assertEquals("B", Streams.findAlphabeticalLargest(s1));
		
		String s2 = "Codility";
		assertEquals("NO", Streams.findAlphabeticalLargest(s2));

		String s3 = "aafkvdAdirDFRDVz";
		assertEquals( "V", Streams.findAlphabeticalLargest(s3));

	}
}
