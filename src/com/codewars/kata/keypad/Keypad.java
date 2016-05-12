package com.codewars.kata.keypad;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
	
	private static Map<Character, Integer> keyPressNum = new HashMap<Character, Integer>();
	
	static {
		init();
	}
	
	private static void init() {
	}
	
	public static int presses(String phrase) {
		int count = 0;
		int phraseLen = 0;
		
		if (phrase == null || phrase == "") {
			return 0;
		}
		
		phraseLen = phrase.length();
		for (int index = 0; index < phraseLen; index++) {
			char c = phrase.charAt(index);
			count += getCount(c);
		}
		
		return count;
	}

	private static int getCount(char c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
