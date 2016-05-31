package com.codewars.kata.diamond;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiamondTest {
    @Test
    public void testDiamond3() {
      StringBuffer expected = new StringBuffer();
      expected.append(" *\n");
      expected.append("***\n");
      expected.append(" *\n");
      
      System.out.println(Diamond.print(3));
      
      assertEquals(expected.toString(), Diamond.print(3));
    }
    
    @Test
    public void testDiamond5() {
      StringBuffer expected = new StringBuffer();
      expected.append("  *\n");
      expected.append(" ***\n");
      expected.append("*****\n");
      expected.append(" ***\n");
      expected.append("  *\n");
      
      assertEquals(expected.toString(), Diamond.print(5));
    }    
}