package Lintcode;

import java.util.ArrayList;
import java.util.Iterator;

public class Delete_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Character> numStr = new ArrayList<Character>();
//        Iterator<Character> it = numStr.iterator();
//
//		numStr.toArray();
		String numStr = "euoer";
		int j = numStr.length() - 1; 
		System.out.println(""+numStr);
		System.out.println(""+numStr.substring(0, j));
		System.out.println("4:"+numStr.substring(4));
		System.out.println("5:"+numStr.substring(5));
		System.out.println("0-5:"+numStr.substring(0, numStr.length()));
		System.out.println("len:"+numStr.substring(numStr.length()));
//		System.out.println("6"+numStr.substring(6));
        numStr = numStr.substring(0, j) + numStr.substring(j + 1);
        System.out.println(""+numStr);
        
		System.out.println(""+DeleteDigits("90249",2));
	}

    static String DeleteDigits(String numStr, int k) {
        if (numStr.length() == k) {
            return "";
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < numStr.length(); j++) {
                if (j == numStr.length() - 1 || numStr.charAt(j) > numStr.charAt(j + 1)) {
                    numStr = remove(numStr, j);
                    break;
                }
            }
        }
        int i = 0;
        while (i < numStr.length() - 1 && numStr.charAt(i) == '0') {
            i++;
        }
        return numStr.substring(i);
    }
     
    private static String remove(String A, int pos) {
        if(pos == A.length() - 1) return A.substring(0, pos);
        return A.substring(0, pos) + A.substring(pos + 1);
    }
}