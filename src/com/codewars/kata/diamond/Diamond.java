package com.codewars.kata.diamond;

class Diamond {
	
	public static String print(int n) {
		if (n % 2 == 0 || n <= 0) {
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		int mid = n / 2 + 1;
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				result.append(mid - Math.abs(col + 1 - mid) > Math.abs(row + 1 - mid) 
						? "*" : col >= mid ? "" : " ");
			}
			result.append("\n");
		}
		
		return result.toString();
	}
}