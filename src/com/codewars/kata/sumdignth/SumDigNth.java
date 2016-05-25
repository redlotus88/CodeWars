package com.codewars.kata.sumdignth;

public class SumDigNth {
	
	public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {
		long next = initval;
		int len = patternl.length;
		
		for (int i = 0; i < nthterm - 1; i++) {
			next = next + patternl[i % len];
		}
		return sumDigit(next);
    }
	
	public static long sumDigit(long num) {
		long result = 0;
		int digit = 0;
		do {
			digit = (int) (num % 10);
			result += digit;
			num /= 10;
		} while (num != 0);
		return result;
	}
}
