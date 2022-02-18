package Lai.String_I;


/**
第一种问题：有重复的情况下，保留顶多一个重复元素，不希望看见有重复的

不一定要求排好序，但是结果是把相连的重复元素，有重复的情况下，保留顶多一个重复元素，当不希望看见有重复的时候，用它
排好序的话，有重复的情况下，保留顶多一个重复元素，不希望看见有重复的
 *
 */
public class Remove_Adjacent_Repeated_Characters_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ccccbbbaaaabbbc";
		System.out.println("" + deDup(str));

	}

	public static String deDup(String input) {
		// Write your solution here
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 1;
		for (int fast = 1; fast < arr.length; fast++) {
			if(arr[fast] != arr[slow - 1]) {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

}
