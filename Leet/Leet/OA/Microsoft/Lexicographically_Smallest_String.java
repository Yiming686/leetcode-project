package Leet.OA.Microsoft;

/**
 * Lexicographically smallest string formed by removing at most one character.
 * 
 * Example 1:
 * 
 * Input: "abczd" Output: "abcd"
 * 
 * Since you could only remove one char, you should remove the first char you
 * see that is greater than the next from left to right, i.e. peak char. If
 * there is no such string, I think you should just remove the last char, i.e.
 * if the string is sorted ascending.
 *
 * 
 * 
 */
public class Lexicographically_Smallest_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSmallestByRemovingOnlyOneChar("abcdz"));
		System.out.println(findSmallestByRemovingOnlyOneChar("adzabzczdz"));//adabzczdz
		System.out.println(findSmallestByRemovingOnlyOneChar("abcczccdz"));
//		abcd
//		abcdz
//		abccccdz

	}

//	��Ϊ�ֵ���ÿһ����Ļ�����д�С˳��ģ�Ȼ������Ҹ����ַ��Ĵ�С˳���������
//	���Կ��Դ�����ɨ�裬���������ַ�ԽСԽ�ã����ɾ����ǰ�ַ����Ҳ���ַ��ͻ�ݽ�����ǰλ�ã�
//	���Ե��Ҳ���ַ��ȵ�ǰ�ַ����ʱ�򣬾Ͳ���ɾ����ǰ�ַ������������
//	����һ�η����Ҳ���ַ��ȵ�ǰ�ַ�С��ʱ�򣬾Ϳ���ɾ����ǰ�ַ������Ҳ�Ƚ�С���ַ����ݽ�����ǰλ�ã�
//	��ôȫ�ֿ��������ַ����ͱ�С�ˣ�Ȼ��Ͳ���ɾ���ˣ� ֻ�ǰ�ʣ����ַ�����һ�£����ɡ�
	public static String findSmallestByRemovingOnlyOneChar(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		if(input.length() == 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		boolean foundOne = false;

		for (int i = 0; i < arr.length - 1; i++) {
			if (!foundOne && arr[i] > arr[i + 1]) {//��һ�η��֣����Һ����С��ɾ����ǰ�����Ҳ��ַ�����һλ
				foundOne = true;
			}else {//foundOne == true || arr[i] <= arr[i + 1]
				sb.append(arr[i]);
			}
		}

		if (foundOne) {
			sb.append(arr[arr.length - 1]);
		}

		return sb.toString();
	}

}
