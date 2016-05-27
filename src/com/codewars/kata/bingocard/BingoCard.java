package com.codewars.kata.bingocard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;

public class BingoCard {

	public static String[] getCard() {
		List<String> results = new LinkedList<>();;
		results.addAll(createMutualRandomNumbers("B", 5, 1, 15));
		results.addAll(createMutualRandomNumbers("I", 5, 16, 30));
		results.addAll(createMutualRandomNumbers("N", 4, 31, 45));
		results.addAll(createMutualRandomNumbers("G", 5, 46, 60));
		results.addAll(createMutualRandomNumbers("O", 5, 61, 75));
		Assert.assertEquals(24, results.size());
		return results.toArray(new String[0]);
	}
	
	public static List<String> createMutualRandomNumbers(String prefix, int size, int start, int end) {
		List<Integer> numbers = IntStream.range(start, end).boxed().collect(Collectors.toList());
		Collections.shuffle(numbers);
		
		List<String> rands = 
				numbers.stream()
					.limit(size)
					.map(i -> Integer.toString(i))
					.map(str -> prefix + str)
					.collect(Collectors.toList());
		// A more efficient way:
//		List<String> rands = ThreadLocalRandom.current().ints(start, end).distinct().limit(size)
//								.mapToObj(i -> prefix + i).collect(Collectors.toList());
		
		return rands;
	}
}
