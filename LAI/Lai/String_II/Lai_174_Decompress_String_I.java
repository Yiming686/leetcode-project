package Lai.String_II;

public class Lai_174_Decompress_String_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+decompress("ac2d3ef"));
	}

	public static String decompress(String input) {
		// Write your solution here
		if (input == null || input.length() <= 1) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isDigit(ch)) {
				int digit = Character.digit(ch, 10);
				while (--digit > 0) {
					sb.append(input.charAt(i - 1));
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

}
