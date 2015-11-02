package JavaBasics;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.DADD;
import com.sun.org.apache.bcel.internal.generic.DDIV;

import LeetCode.ArrayBuilder;
import LeetCode.ArrayPrinter;

public class Java_String {
	public static void main(String[] args) {
		String sd = "adfewww";
		
		StringBuilder sb = new StringBuilder();
//		sb.reverse()
//		sb.deleteCharAt(sb.length()-1);
//		String s = "47";
		char[] arr1 = {'3','r','t','w'};
		
		String s = "2Fffaasfeas";
		Set<Character> op = new HashSet<Character>();
		System.out.println(Integer.valueOf('0').intValue());
//		s.indexOf('c');
//		Integer.valueOf(c);
//		Character.valueOf(c);
//		s.s
//		String ss = s + arr1;
//		System.out.println(ss);
		System.out.println(s+arr1[0]);
		System.out.println(s.contains("============="));
		System.out.println(s.contains("2"));
		System.out.println(s.contains("aas"));
		System.out.println(rotateString(s.toCharArray(), 2));
		System.out.println(rotateString(s.toCharArray(), 60));
		
		int i=47;
		
		Integer count = Integer.bitCount(i);
		count = Integer.valueOf(s);

		System.out.println(count);

//		s.toCharArray();
		i = Integer.valueOf(s);
		s = Integer.toBinaryString(i);
		System.out.println(s);
		s = Integer.toHexString(i);

		System.out.println(s);


		String str  = "abcdefg";
		System.out.println(str.substring(4, 7));
		System.out.println("---------------------");
		String str1  = "abc";
		str1 =  "xyz";
		String str2 =  "xyz";

		System.out.println(str1== str2);
		System.out.println("---------------------");

		String operators = "+-*/";
		System.out.println(operators.contains("-"));
		
		int[] arr = new int[10];

		System.out.println(arr.length);
		
		ArrayPrinter.printIntegerArray(arr);
		int[] arr2 = ArrayBuilder.createIntegerArray_NoDups(10,5, 24);
		ArrayPrinter.printIntegerArray(arr2);
//		int[] arr3 = ArrayBuilder.createIntegerArray_WithDups(10, -2, 9);
//		ArrayPrinter.printIntegerArray(arr3);

	}
	
    public static char[] rotateString(char[] A, int offset) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        offset = offset % A.length;
        reverse(A, 0, A.length - offset - 1);
        reverse(A, A.length - offset, A.length - 1);
        reverse(A, 0, A.length - 1);
        return A;
    }
    
    private static void reverse(char[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    
    
	public String multiplyTwoStrings(String num1, String num2) {
	    if (num1 == null || num1.length() == 0) {
	        throw new IllegalArgumentException();
	    }
	    if (num2 == null || num2.length() == 0) {
	        throw new IllegalArgumentException();
	    }
	    int len1 = num1.length();
	    int len2 = num2.length();
	    for(int i = 0; i < len1; i ++){
	        char ch = num1.charAt(i);
	        if(ch < '0' || ch > '9') throw new IllegalArgumentException();
	}
	for(int i = 0; i < len2; i ++){
	    char ch = num2.charAt(i);
	    if(ch < '0' || ch > '9') throw new IllegalArgumentException();
	}
	
	int len3 = len1 + len2;
	int i, j, product, carry;
	
	int[] num3 = new int[len3];
	for (i = len1 - 1; i >= 0;i--) {
	    // reset carry
	    carry = 0;
	    int a = num1.charAt(i) - '0';
	    for (j = len2 - 1; j >= 0; j--) {
	        int b = num2.charAt(j) - '0';
	        product = carry + num3[i + j + 1] + a * b ; 
	        num3[i + j + 1] = product % 10;
	        carry = product / 10;
	    }
	    // keep the carry
	    num3[i + j + 1] = carry;
	}
	
	StringBuilder sb = new StringBuilder();
	i = 0;
	// check from 0 to len3 - 1
	    while (i < len3 - 1 && num3[i] == 0) {
	        i++;
	    }
	    while (i < len3) {
	        sb.append(num3[i]);
	        i++;
	    }
	
	    return sb.toString();
	}
}
