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
			sb.append(input, fromIndex, matchIndex);//������matchIndexָ����ַ������ӳ���ΪmatchIndex-fromIndex
			sb.append(target);
			fromIndex = matchIndex + source.length();
//			matchIndex = input.indexOf(source, fromIndex);
			matchIndex = findIndexOf(input, source, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}

	//��input�����fromIndex��ʼ�������ң��ҵ���һ��source������index
	private static int findIndexOf(String input, String source, int fromIndex) {
		for(int i = fromIndex; i < input.length(); i++) {
			if(input.charAt(i) == source.charAt(0)) {
				int indexSource = 0;//��ʾ�����Ԫ��
				int indexInput = i;//��ʾ�����Ԫ��
				while(indexInput < input.length() && indexSource < source.length() && input.charAt(indexInput) == source.charAt(indexSource)) {
					indexInput++;
					indexSource++;
				}
				if(indexSource == source.length()) {
					return i;//�ҵ���һ��������index
				}
			}
		}
		return -1;
	}
}
