package com.codewars.kata.mixing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mixing {
	public static String mix(String s1, String s2) {
		// your code
		List<Frequency> result = new ArrayList<>();
		Map<Character, Frequency> fres1 = parseString(s1);
		Map<Character, Frequency> fres2 = parseString(s2);
		
		for (Character c : fres1.keySet()) {
			Frequency fre1 = fres1.get(c);
			Frequency fre2 = fres2.get(c);
			
			if (fre2 == null) {
				fre1.setStatus(1);
				result.add(fre1);
			} else if (fre1.getOccur() - fre2.getOccur() > 0) {
				fre1.setStatus(1);
				result.add(fre1);
			} else if (fre1.getOccur() - fre2.getOccur()  < 0) {
				fre2.setStatus(2);
				result.add(fre2);
			} else {
				fre2.setStatus(3);
				result.add(fre2);
			}
		}
		
		for (Character c : fres2.keySet()) {
			Frequency fre1 = fres1.get(c);
			Frequency fre2 = fres2.get(c);
			
			if (result.contains(fre2)) {
				continue;
			} 
			
			if (fre1 == null || fre2.getOccur() - fre1.getOccur()  > 0) {
				fre2.setStatus(2);
				result.add(fre2);
			}
		}
		
		Collections.sort(result);
		return generate(result);
	}
	
	public static String generate(List<Frequency> result) {
		StringBuilder sb = new StringBuilder();
		for (Frequency f : result) {
			if (f.getOccur() < 2) {
				continue;
			}
			
			int status = f.getStatus();
			if (status == 3) {
				sb.append("=");
			} else {
				sb.append(status);
			}
			
			sb.append(":");
			for (int i = 0; i < f.getOccur(); i++) {
				sb.append(f.getC());
			}
			sb.append("/");
		}
		
		if (sb.length() > 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	public static Map<Character, Frequency> parseString(String s) {
		Map<Character, Frequency> result = new HashMap<>();
		if (s == null || s.length() == 0) {
			return new HashMap<>();
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('a' <= c && c <= 'z') {
				if (result.get(c) == null) {
					Frequency fre = new Frequency(c);
					result.put(c, fre);
				} else {
					Frequency fre = result.get(c);
					fre.addOnce();
				}
			}
		}
		return result;
	}
	
	static class Frequency implements Comparable<Frequency> {
		char c;
		int occur;
		int status;
		
		Frequency(char c) {
			this.c = c;
			occur++;
		}
		
		public void addOnce() {
			occur++;
		}
		
		public char getC() {
			return c;
		}
		
		public int getOccur() {
			return occur;
		}
		
		public void setStatus(int status) {
			this.status = status;
		}
		
		public int getStatus() {
			return status;
		}
		
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

		@Override
		public int compareTo(Frequency o) {
			if (this == o) {
				return 0;
			}
			if (o == null) {
				return 1;
			}
			
			if (this.occur < o.occur) {
				return 1;
			} else if (this.occur > o.occur) {
				return -1;
			}
			
			if (this.status < o.status) {
				return -1;
			} else if (this.status > o.status) {
				return 1;
			}
			
			if (this.c < o.c) {
				return -1;
			} else if (this.c > o.c) {
				return 1;
			}
			
			return 0;
		}
		
	}
}
