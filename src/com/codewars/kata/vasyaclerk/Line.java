package com.codewars.kata.vasyaclerk;

public class Line {
	public static String Tickets(int[] peopleInLine) {
		// Your code is here...
		int money25 = 0;
		int money50 = 0;
		
		for (int i = 0; i < peopleInLine.length; i++) {
			switch (peopleInLine[i]) {
			case 25:
				money25++;
				break;
			case 50:
				if (money25 == 0) return "NO";
				money25--;
				money50++;
				break;
			case 100:
				if (money25 == 0) return "NO";
				else if (money50 > 0) {money25--; money50--;break;}
				else if (money50 == 0 && money25 > 2) {money25 -= 3;break;}
				return "NO";
			default:
				break;
			}
		}
		return "YES";
	}
}