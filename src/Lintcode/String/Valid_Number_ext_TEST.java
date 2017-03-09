package Lintcode.String;

import static org.junit.Assert.*;

import org.junit.Test;

public class Valid_Number_ext_TEST {
	
    @Test
    public void isNumberTest() {
    	int a = 9, b = 9;
        assertEquals("de", a, b);
//    	Assert True
    	assertTrue(Valid_Number_ext.isNumber("3 "));
    	assertTrue(Valid_Number_ext.isNumber(" 0"));
    	assertTrue(Valid_Number_ext.isNumber(" 9 "));
    	assertTrue(Valid_Number_ext.isNumber("2e0"));
    	assertTrue(Valid_Number_ext.isNumber("-3.21e-9"));
    	
        assertTrue(Valid_Number_ext.isNumber("0"));
        assertTrue(Valid_Number_ext.isNumber(".1"));
        assertTrue(Valid_Number_ext.isNumber("0.1"));
        assertTrue(Valid_Number_ext.isNumber("999.999999"));
        assertTrue(Valid_Number_ext.isNumber("1000."));
        assertTrue(Valid_Number_ext.isNumber("0.0"));
        assertTrue(Valid_Number_ext.isNumber("-0"));
        assertTrue(Valid_Number_ext.isNumber("-.1"));
        assertTrue(Valid_Number_ext.isNumber("-0.1"));
        assertTrue(Valid_Number_ext.isNumber("-999.999999"));
        assertTrue(Valid_Number_ext.isNumber("-1000."));
        
        //spec
//        assertTrue(Valid_Number_ext.isNumber("-"));//
//        assertTrue(Valid_Number_ext.isNumber("-."));

        //spec
        assertFalse(Valid_Number_ext.isNumber("0e"));
        assertFalse(Valid_Number_ext.isNumber("-"));//
        assertFalse(Valid_Number_ext.isNumber("-."));
        
        //Assert False, Not a number
        assertFalse(Valid_Number_ext.isNumber("."));
        assertFalse(Valid_Number_ext.isNumber(". "));
        assertFalse(Valid_Number_ext.isNumber(" ."));
        assertFalse(Valid_Number_ext.isNumber(" . "));
        
        assertFalse(Valid_Number_ext.isNumber(null));
        assertFalse(Valid_Number_ext.isNumber(""));
        assertFalse(Valid_Number_ext.isNumber(" "));
//        assertFalse(Valid_Number_ext.isNumber(" -0")); //should be true
        assertFalse(Valid_Number_ext.isNumber("0.0.0"));
        assertFalse(Valid_Number_ext.isNumber("0..0"));
        assertFalse(Valid_Number_ext.isNumber(".0.0"));
        assertFalse(Valid_Number_ext.isNumber("0-0"));
        assertFalse(Valid_Number_ext.isNumber("a"));
        assertFalse(Valid_Number_ext.isNumber("null"));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
