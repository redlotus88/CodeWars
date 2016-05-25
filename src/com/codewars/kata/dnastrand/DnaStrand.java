package com.codewars.kata.dnastrand;

import java.util.HashMap;
import java.util.Map;

public class DnaStrand {
	
	public static Map<Character, Character> pairs = new HashMap<>();
	
	static {
		pairs.put('T', 'A');
		pairs.put('A', 'T');
		pairs.put('G', 'C');
		pairs.put('C', 'G');
	}
	
	public static String makeComplement(String dna) {
		StringBuilder result = new StringBuilder();
		for (char c : dna.toCharArray()) {
			result.append(pairs.get(c));
		}
		return result.toString();
	}
	
}
