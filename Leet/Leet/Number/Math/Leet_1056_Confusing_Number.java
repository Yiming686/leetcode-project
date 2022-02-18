package Leet.Number.Math;

import java.util.HashMap;
import java.util.Map;

public class Leet_1056_Confusing_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+confusingNumber(916));
		int arr[] = {9,2,4};
		int i = 0;
		int k =1;
		 if(k<0 && arr[i++]==0) {//µ±k<0,Ö±µ½k<0,
			 System.out.println("----");
	     }
		 System.out.println("i: "+ i);
	}

	public static boolean confusingNumber(int N) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		String str = String.valueOf(N);
		char[] arr = str.toCharArray();
		if (arr.length == 1) {
			if (arr[0] == '6' || arr[0] == '9') {
				return true;
			} else {
				return false;
			}
		}
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			char temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
		for (int i = 0; i < arr.length; i++) {
			char temp = arr[right];
			if (temp == '2' || temp == '3' || temp == '4' || temp == '5'|| temp == '7') {
				return false;
			}
			if (arr[i] == '6') {
				arr[i] = '9';
			}else if (arr[i] == '9') {
				arr[i] = '6';
			}
		}
		int newN = Integer.valueOf(String.valueOf(arr));
		if (newN == N) {
			return false;
		}
		return true;
	}

}
