package Lai.String_II;

import sun.net.www.content.audio.x_aiff;

public class Leet_405_Convert_a_Number_to_Hexadecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + hex(0));
//		System.out.println("" + hex(16));
//		System.out.println("" + hex(26));

	}

	public static String hex(int num) {
		// Write your solution here
        if(num == 0){
            return "0";
        }   
		char[] arr = new char[8];
		for (int i = 0; i < 8; i++) {
			int val = convertToInt(num, i);
			arr[7 - i] = converetToHex(val);
		}
		int first = 0;
		while (first < 8 && arr[first] == '0') {
			first++;
		}
		return new String(arr, first, 8 - first);
	}

	private static int convertToInt(int num, int pos) {
		return (num & (15 << (pos * 4))) >>> (pos * 4);
	}

	private static char converetToHex(int val) {
		if (val < 10) {
			return (char) (val + '0');
		} else {
			return (char) (val - 10 + 'a');
		}
	}

}
