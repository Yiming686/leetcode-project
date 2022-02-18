package Lai.String_II;

public class Hexadecimal_Representation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + hex(0));
		System.out.println("" + hex(7));
		System.out.println("" + hex(255));
	}

	public static String hex(int num) {
		// Write your solution here
		StringBuilder sb = new StringBuilder();
		int radix = 16;
		while (num != 0) {
			int rem = num % radix;
//			sb.insert(0, Character.toUpperCase(Character.forDigit(rem, radix)));
			if(rem < 10) {
				sb.append(Character.toUpperCase(Character.forDigit(rem, radix)) + "0");
			}else {
				sb.append(Character.toUpperCase(Character.forDigit(rem, radix)));
			}
//			num /= radix;
			num >>>= 4;
		}
		sb.append("x0");
		sb.reverse();
//		sb.insert(0, "0x");
		return sb.toString();
	}

}
