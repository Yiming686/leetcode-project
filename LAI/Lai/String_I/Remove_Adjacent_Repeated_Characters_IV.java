package Lai.String_I;

import Utils.ArrayUtils;

public class Remove_Adjacent_Repeated_Characters_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+removeSpaces("babbbaa"));
//		System.out.println("" + deDup("aabccbxyyz"));//没有相连的相同的字符
		System.out.println("" + deDup("abbbaaabbaccczc"));//没有相连的相同的字符

	}

	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		ArrayUtils.printCharArray(arr);
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			int count = 1;
			while (right + 1 < arr.length && arr[right] == arr[right + 1]) {
				count++;
				right++;
			}
			if (left >= 1 && arr[right] == arr[left - 1]) {//能消消乐，就立马消掉
				left--;
			} else if (count == 1) {//&& (left == 0 || arr[right] != arr[left - 1])
				arr[left++] = arr[right];
			}
			System.out.println("right: " + right );
			System.out.println("left: " + left);
		}
		return new String(arr, 0, left);
	}

//	end的物理含义：对应stack的顶端
//	i的物理含义：依次遍历待检测元素
//	worked
	public static String deDup00(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (slow == 0 || arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			} else {
				slow--;
				while (fast + 1 < arr.length && arr[fast] == arr[fast + 1]) {
					fast++;
				}
			}
		}
		return new String(arr, 0, slow);
	}

//	Not good solution: because use end, and end == -1
	public static String removeSpaces00(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for (int i = 1; i < arr.length; i++) {
			if (end == -1 || arr[i] != arr[end]) {
				arr[++end] = arr[i];
			} else {
				end--;
				while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
					i++;
				}
			}
		}
		return new String(arr, 0, end + 1);
	}
}
