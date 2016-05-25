package com.codewars.kata.digpow;

import java.util.Stack;

public class DigPow {
	public static long digPow(int n, int p) {
		// your code
		int push = n;
		Stack<Integer> numStack = new Stack<>();
		while (push != 0) {
			numStack.add(push % 10);
			push /= 10;
		}
		
		int sum = 0;
		int num = numStack.size();
		for (int i = 0; i < num; i++) {
			sum += Math.pow(numStack.pop(), (p + i));
		}
		
		int k = sum / n;
		if (k != 0 && k * n == sum) {
			return k;
		}
		return -1;
	}
}

// Best solution
//public class DigPow {
//	  
//	  public static long digPow(int n, int p) {
//	    String intString = String.valueOf(n);
//	    long sum = 0;
//	    for (int i = 0; i < intString.length(); ++i, ++p)
//	      sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
//	    return (sum % n == 0) ? sum / n : -1;
//	  }
//	  
//	}