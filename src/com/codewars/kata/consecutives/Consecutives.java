package com.codewars.kata.consecutives;

import java.util.ArrayList;
import java.util.List;

public class Consecutives {
    
    public static List<Integer> sumConsecutives(List<Integer> s) {
        // your code
    	List<Integer> result = new ArrayList<>();
    	Integer pre = null;
    	int preResult = 0;
    	boolean putin = false;
    	
    	for (int index = 0; index < s.size(); index++) {
    		int currect = s.get(index);
    		if (pre == null || pre == currect) {
    			putin = false;
    		} else {
    			putin = true;
    		}
    		
    		if (putin) {
    			result.add(preResult);
    			preResult = 0;
    		}
    		
    		preResult += currect;
    		pre = currect;
    	}
    	result.add(preResult);
    	return result;
    }

}
