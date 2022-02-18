package Lai.String_I;

import static Utils.TreeNodeUtils.EQUAL;

/**
 * Validate if a given string can be interpreted as a decimal number.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true " -90e3 " => true " 1e" => false "e3" => false " 6e-1" => true
 * " 99e2.5 " => false "53.5e93" => true " --6 " => false "-+3" => false
 * "95a54e53" => false
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one. However, here is a
 * list of characters that can be in a valid decimal number:
 * 
 * Numbers 0-9 Exponent - "e" Positive/negative sign - "+"/"-" Decimal point -
 * "." Of course, the context of these characters also matters in the input.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If
 * you still see your function signature accepts a const char * argument, please
 * click the reload button to reset your code definition.
 *
 *
 * 
 */
public class LT65_Valid_Number {

	public static boolean isValidNumberByJava(String input) {
		try {
			Float.parseFloat(input);
			System.out.println(input + " is a valid float number");
			return true;
		} catch (NumberFormatException e) {
			System.out.println(input + " is not a valid float number");
			return false;
		}

	}

/*
 * Here are the three additional parameters the function should take:

n: if n is true, s can be negative. Otherwise it must be positive.
c: if c is true, commas separating triple digits (ex. "1,000,000") should be considered valid. 
The number doesn't have to contain commas, but if it does, it should separate each triplet in the integer part of s.
d: if d is true, s can be a float, i.e. it can contain a single decimal point .. s can't contain . otherwise.

 * 
 */
	static boolean isValidNumber(String s, boolean n, boolean c, boolean d) {
		return s.matches((n ? "-?" : "") + (c ? "(\\d\\d?(,\\d{3})*|\\d+)" : "\\d+") + (d ? "(\\.\\d+)?" : ""));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		System.out.println((str = "+0.2")+":"+isValidNumber(str, true, false, true));;
//		isValidNumberByJava("2.3e5");
//		isValidNumberByJava("2.3");
//		isValidNumberByJava("2.");
//		isValidNumberByJava(".3");
//		isValidNumberByJava(".");
//		isValidNumberByJava("+0.e+2");
//		isValidNumberByJava("1,998");
//		System.out.println("isValidNumberByJava: "+ isValidNumberByJava("2.3e5"));
//		System.out.println((str = "1 ") + "," + isNumber(str));
//		System.out.println((str = " . ") + "," + isNumber(str));
//		System.out.println(str = "     " + "," + isNumber(str));
//		System.out.println(str = "   .  " + "," + isNumber(str));
//		System.out.println("" + isNumber("0")); // "0" => true
//		System.out.println("" + isNumber("0.1")); // " 0.1 " => true
//		System.out.println("" + isNumber("abc")); // "abc" => false
//		System.out.println("" + isNumber("1 a")); // "1 a" => false
//		System.out.println("" + isNumber("2e10")); // "2e10" => true
//		System.out.println("" + isNumber(" -90e3   ")); // " -90e3   " => true
//		System.out.println("" + isNumber(" 1e")); // " 1e" => false
//		System.out.println("" + isNumber("e3")); // "e3" => false
//		System.out.println("" + isNumber(" 6e-1")); // " 6e-1" => true
//		System.out.println("" + isNumber(" 99e2.5 ")); // " 99e2.5 " => false
//		System.out.println("" + isNumber("53.5e93")); // "53.5e93" => true
//		System.out.println("" + isNumber(" --6 ")); // " --6 " => false
//		System.out.println("" + isNumber("-+3")); // "-+3" => falseSystem.out.println(""+ isNumber ("0.1")); // 
//		System.out.println("" + isNumber("95a54e53")); // "95a54e53" => false
	}

//	"1 ", 
	public static boolean isNumber(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		int n = str.length();
		int i = 0;
		int end = n - 1;
		while (i <= end && str.charAt(i) == ' ') {
			i++;
		}
		if (i > end) {
			return false; //all " ", do not foget it 
		}
		while (end >= i && str.charAt(end) == ' ') {
			end--;
		}
		if (end < i) {
			return false;
		}
		boolean hasSignBeforE = false; //已经有+or-
		boolean hasNumBeforeE = false; //?已经有0-9的数组了
		boolean hasDot = false;
		boolean hasE = false;
		boolean hasNumAfterE = false;
		boolean hasSignAfterE = false;
		boolean hasComma = false;
		while (i <= end) { // remember i++
			char ch = str.charAt(i);
			if (ch == '+' || ch == '-') {//可以在开头，也可以在eE后面
				if (!hasE && (hasSignBeforE || hasDot || hasNumBeforeE)) {//++, .+, 38+
					return false;
				}
				if (hasE && hasNumAfterE) {//has eE, e.3.8+
					return false;
				}
				if (!hasE) {
					hasSignBeforE = true;
				} else {
					hasSignAfterE = true;
				}
			} else if (ch >= '0' && ch <= '9') {
				if (!hasE) {
					hasNumBeforeE = true;
				} else {
					hasNumAfterE = true;
				}
			} else if (ch == '.') {
				if (!hasE && hasDot) {// +3.8.
					return false;
				}
				if (hasE) {//3E-2.
					return false;
				}
				hasDot = true;
			} else if (ch == 'e' || ch == 'E') {
				if (hasE || hasNumAfterE || !hasNumBeforeE) {
					return false;
				}
				hasE = true;
			} else {
				return false;
			}
			i++;
		}
		//以上只考虑该位字符前面的情况
		if (hasE && !hasNumAfterE) { //+2.324e
			return false;
		}
		return hasNumBeforeE || hasNumAfterE;
	}

}
