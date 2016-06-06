package com.codewars.kata.maxsum;

import java.util.Arrays;
import java.util.OptionalInt;

public class Max {
	public static int sequence(int[] arr) {
		OptionalInt oi = Arrays.stream(arr).max();
		if (!oi.isPresent()) {
			return 0;
		}
		
		int max = oi.getAsInt();
		if (max < 0) {
			return 0;
		}
		
		for (int i = 0; i < arr.length; i++) {
			int cur = arr[i];
			int sum = cur;
			
			if (cur < 0) continue;
			
			for (int j = i + 1; j < arr.length; j++){
				sum += arr[j];
				if (max < sum) {
					max = sum;
				}
			}
		}
		
		return max;
	}
}
