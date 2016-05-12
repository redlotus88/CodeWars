package com.codewars.kata.keypad;

import static org.junit.Assert.*;
import org.junit.Test;

public class KeypadTest {

	@Test
	public void simpleTest() {
//		assertEquals(9, Keypad.presses("LOL"));
		assertEquals(13, Keypad.presses("HOW R U"));
		
		assertEquals(14, Keypad.presses("wbo;DM,xUB"));
		
//		assertEquals(19, Keypad.presses("1234213423894280312"));
		
		assertEquals(47, Keypad.presses("WHERE DO U WANT 2 MEET L8R"));
	}
}
