package com.codewars.kata.zeros;

public class Solution {
	public static int zeros(int n) {
		int zeroNum = 0;
		int f = (int) (Math.log(n) / Math.log(5));
		int[] powerFive = new int[f];
		
		for (int i = 0; i < f; i++) {
			powerFive[i] = (int) Math.pow(5.0d, (double)(i + 1));
		}
		
		for (int i = 0; i < powerFive.length; i++) {
			zeroNum += n / powerFive[i];
		}
		
		return zeroNum; 
		
		// Best practice
//		if(n/5 == 0)
//	        return 0;
//	      return n/5 + zeros(n/5);
	}
}
