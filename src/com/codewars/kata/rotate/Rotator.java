package com.codewars.kata.rotate;

public class Rotator {
	
	public Object[] rotate(Object[] data, int n) {
		int size = data.length;
		Object[] result = new Object[size];
		int start = (size - n % size) % size;
		for (int i = 0; i < size; i++) {
			result[i] = data[(start + i) % size];
		}
		return result;
	}
}
