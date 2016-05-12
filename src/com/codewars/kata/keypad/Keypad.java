package com.codewars.kata.keypad;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
	
	private static Map<Character, Integer> keyPressNum = new HashMap<Character, Integer>();
	
	static {
		init();
	}
	
	private static void init() {
		keyPressNum.put(' ', 1);
		keyPressNum.put('*', 1);
		keyPressNum.put('#', 1);
		
		for (int c = '0'; c <= '9'; c++) {
			keyPressNum.put((char) c, 4);
		}

		keyPressNum.put('0', 2);
		keyPressNum.put('1', 1);
		keyPressNum.put('7', 5);
		keyPressNum.put('9', 5);
		
		for (int c = 'a'; c < 'z'; c++) {
			int pressTimes = 0;
			if (c == 's') {
				continue;
			} else if (c > 's') {
				pressTimes = ((c - 97) - 1) % 3 + 1;
			} else {
				pressTimes = (c - 97) % 3 + 1;
			}
			
			keyPressNum.put((char) c, pressTimes);
		}
		
		keyPressNum.put('s', 4);
		keyPressNum.put('z', 4);
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

	private static int getCount(char ch) {
		char lowcase = Character.toLowerCase(ch);
		Integer result = keyPressNum.get(lowcase);
		if (result == null) {
			return 0;
		}
		return result; 
	}
}
