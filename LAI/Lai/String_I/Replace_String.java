package Lai.String_I;

/**
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"

 *
 */
public class Replace_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+findIndexOf("dodododo", "ddod", 3));
	}

	public static String replace(String input, String source, String target) {
		StringBuilder sb = new StringBuilder();
		int fromIndex = 0;
//		int matchIndex = input.indexOf(source, fromIndex);
		int matchIndex = findIndexOf(input, source, fromIndex);
		while (matchIndex != -1) {
			sb.append(input, fromIndex, matchIndex);//不包含matchIndex指向的字符，增加长度为matchIndex-fromIndex
			sb.append(target);
			fromIndex = matchIndex + source.length();
//			matchIndex = input.indexOf(source, fromIndex);
			matchIndex = findIndexOf(input, source, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}

	//在input里面从fromIndex开始，从左到右，找到第一个source，返回index
	private static int findIndexOf(String input, String source, int fromIndex) {
		for(int i = fromIndex; i < input.length(); i++) {
			if(input.charAt(i) == source.charAt(0)) {
				int indexSource = 0;//表示待检测元素
				int indexInput = i;//表示待检测元素
				while(indexInput < input.length() && indexSource < source.length() && input.charAt(indexInput) == source.charAt(indexSource)) {
					indexInput++;
					indexSource++;
				}
				if(indexSource == source.length()) {
					return i;//找到第一个，返回index
				}
			}
		}
		return -1;
	}
}
