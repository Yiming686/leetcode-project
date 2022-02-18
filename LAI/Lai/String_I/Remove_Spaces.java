package Lai.String_I;

public class Remove_Spaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String removeSpaces(String input) {
		// Write your solution here
		char[] arr = input.toCharArray();
//		int pos = removeLeadingSpaces(arr);
//		pos = removeTrailingSpaces(arr);
//		pos = removeInternalDuplicateSpaces(arr);
		boolean isLeading = true;
		boolean isFirst = true;
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if(arr[fast] != ' ') {
				isLeading = false;
				isFirst = true;
				arr[slow++] = arr[fast];
			}else if(!isLeading) {
				if(isFirst) {
					arr[slow++] = arr[fast];
					isFirst = false;
				}
			}
		}
		if(arr[slow-1] == ' ') {
			return new String(arr, 0, slow - 1);		
		}else {
			return new String(arr, 0, slow);
		}
	
	}

//	by me, 
	public static String removeSpaces00(String input) {
		// Write your solution here
		char[] arr = input.toCharArray();
//		int pos = removeLeadingSpaces(arr);
//		pos = removeTrailingSpaces(arr);
//		pos = removeInternalDuplicateSpaces(arr);
		boolean isLeading = true;
		boolean isFirst = true;
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if(arr[fast] != ' ') {
				isLeading = false;
				isFirst = true;
				arr[slow++] = arr[fast];
			}else if(!isLeading) {
				if(isFirst) {
					arr[slow++] = arr[fast];
					isFirst = false;
				}
			}
		}
		if(arr[slow-1] == ' ') {
			return new String(arr, 0, slow - 1);		
		}else {
			return new String(arr, 0, slow);
		}
	
	}

}
