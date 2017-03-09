package Lintcode.String;

/**
Valid Number Show result 

Validate if a given string is numeric.

Have you met this question in a real interview? Yes
Example
"0" => true

" 0.1 " => true

"abc" => false

"1 a" => false

"2e10" => true

Tags Expand 
String LinkedIn


 *
 */
public class Valid_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-0.5::true::  "+isNumber("-0.5"));
		System.out.println("-0.5::true::  "+isNumber("-0.5"));
		System.out.println("-0.5::true::  "+isNumber("-0.5"));
		System.out.println("-0.5::true::  "+isNumber("-0.5"));
		System.out.println("-0.5::true::  "+isNumber("-0.5"));
		System.out.println("00.5::false::  "+isNumber("00.5"));
	}

	public static boolean isNumber(String str) {
		// Write your code here
		int len = str.length();
		int start = 0, end = len - 1;
		while (start <= end && Character.isWhitespace(str.charAt(start)))
			start++;
		if (start > len - 1)
			return false;
		while (end >= start && Character.isWhitespace(str.charAt(end)))
			end--;
		// skip leading +/-
		if (str.charAt(start) == '+' || str.charAt(start) == '-')
			start++;
		boolean isNum = false; // is a digit
		boolean hasDot = false; // is a '.'
		boolean hasE = false; // is a 'e'
		while (start <= end) {
			char ch = str.charAt(start);
			if (Character.isDigit(ch)) {
				isNum = true;
			} else if (ch == '.') {
				if (hasE || hasDot)
					return false;
				hasDot = true;
			} else if (ch == 'e') {
				if (hasE || isNum == false)
					return false;
				hasE = true;
				isNum = false;
			} else if (ch == '+' || ch == '-') {
				if (str.charAt(start - 1) != 'e')
					return false;
			} else {
				return false;
			}
			start++;
		}
		return isNum;
	}
}
