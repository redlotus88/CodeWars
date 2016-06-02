package com.codewars.kata.josephus;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
		if (items == null || items.isEmpty()) {
			return items;
		}
		
		T[] copy = (T[]) items.toArray();
		List<T> result = new ArrayList<>();
		while (copy.length != 1) {
			int posToRemove = (k - 1) % copy.length;
			result.add(copy[posToRemove]);
			copy = renewArray(copy, posToRemove);
		}
		result.add(copy[0]);
		return result;
		
		// Best practice.
//	    Collection<Object> permutation = new ArrayList<Object>();
//	    int position = 0;
//	    while(items.size() > 0) {
//	      position = (position + k - 1) % items.size();
//	      permutation.add(items.remove((int) position));
//	    }
//	    return permutation;
	}
	
	private static <T> T[] renewArray(T[] array, int posStart) {
		int index = 0;
		Object[] result = new Object[array.length - 1];
		for (int i = posStart + 1; i < array.length; i++, index++) {
			result[index] = array[i];
		}
		
		for (int i = 0; i < posStart; i++, index++) {
			result[index] = array[i];
		}
		return (T[]) result;
	}
}