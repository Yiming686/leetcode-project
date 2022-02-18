package Lai.String_I;

/**
 * 
 * ���������⣺���ظ�������£���������ظ�Ԫ�أ�һ��Ҳ�������������ظ�Ԫ�� �����Ƿ��ź������ظ�������£���������ظ�Ԫ�أ�һ��Ҳ�������������ظ�Ԫ��
 * 
 * ���� ����û�� �ź����ˣ�IV�Ľⷨ �� ��Ȼ����
 * 
 * 
 * Remove adjacent, repeated characters in a given string, leaving no character
 * for each group of such characters. The characters in the string are sorted in
 * ascending order.
 * 
 * Assumptions
 * 
 * Try to do it in place. Examples
 * 
 * ��aaaabbbc�� is transferred to ��c�� Corner Cases
 * 
 * If the given string is null, we do not need to do anything.
 *
 * 
 */
public class Remove_Adjacent_Repeated_Characters_III_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "bbbbtttttbaaaac";
//		String str = "abbbaaabbaccczc";
//		String str = "caaaabbbc"; // caaaabbbc --> cc
//		String str = "abbbaaccz"; // abbbaaccz --> az
		String str = "dcdccdcccdccccddcccdddcceeg"; // gdddccbabbbaacccz --> gcbaz
//		String str = "gdddcbabbbaacccz"; // gdddccbabbbaacccz --> gcbaz
		System.out.println("" + deDup(str));

	}

//	Best ever, by me
	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			int count = 1;
			while(right + 1 < arr.length && arr[right] == arr[right + 1]) {
				count++;
				right++;
			}
			if(count == 1) {
				arr[left++] = arr[right];
			}
		}
		return new String(arr, 0, left);
	}
	
	public static String deDup03(String input) {
		// Write your solution here
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
//        boolean hasAdjacentDup = false;
		int left = 0;
//        for (int right = 0; right < arr.length; right++){
		int right = 0;
		while (right + 1 < arr.length) {
			if (arr[right] == arr[right + 1]) {				
				while (right + 1 < arr.length && arr[right + 1] == arr[right]) {
					right++;
				}
			} else {
				arr[left++] = arr[right];
			}
			right++;
		}
		return new String(arr, 0, left);
	}

	//	wrong solution
	public static String deDup908(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 0;
		boolean hasAdjacentDup = false;
		for (int right = 0; right < arr.length; right++) {
			if (left == 0 || arr[right] != arr[left - 1]) {
				arr[left++] = arr[right];
				hasAdjacentDup = false;
			} else {
				if (!hasAdjacentDup) {//û�з����ظ���
					left--;
				}
				hasAdjacentDup = true;
				while (right + 1 < arr.length && arr[right + 1] == arr[left]) {
					right++;
				}
			}
		}
		return new String(arr, 0, left);
	}

}
