package Lai.String_I;


/**
 * 
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 *
 */
public class LC_Remove_All_Adjacent_Duplicates_In_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + removeDuplicates("abbaca"));//没有相连的相同的字符

	}

//	duplicate removal consists of choosing two adjacent and equal letters, 
//	仅仅一次删除两个相同的相邻元素
//	两个指针+两个挡板
	public static String removeDuplicates(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (end == 0 || arr[i] != arr[end - 1]) {
				arr[end++] = arr[i];
			} else {
				end--;
//				i++;
				// while(i+ 1 < arr.length && arr[i] == arr[i+1]){
				// 	i++;
				// }
			}
		}
		return new String(arr, 0, end);
	}

}
