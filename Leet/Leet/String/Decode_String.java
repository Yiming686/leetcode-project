package Leet.String;

import java.util.ArrayDeque;
import java.util.Deque;

public class Decode_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2[abc]3[cd]ef";
		
		decodeString(s);
		System.out.println(""+decodeString(s));		
	}

	public static String decodeString(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder sb = new StringBuilder();//output
		Deque<String> strStack = new ArrayDeque<>();
		Deque<Integer> countStack = new ArrayDeque<>();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				count = count * 10 + ch - '0';
			} else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				sb.append(ch);
			} else if (ch == '[') {
				if (count > 0) {
					countStack.push(count);
				}
				strStack.push(sb.toString());
				sb.setLength(0);
				count = 0;
			} else {
				StringBuilder tmp = new StringBuilder().append(strStack.pop());
				int times = countStack.pop();
				for (int j = 0; j < times; j++) {
					tmp.append(sb);
				}
				sb = tmp;
			}
		}
		return sb.toString();
	}

}
