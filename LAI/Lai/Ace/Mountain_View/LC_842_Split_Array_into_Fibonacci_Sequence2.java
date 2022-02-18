package Lai.Ace.Mountain_View;

import static Utils.TreeNodeUtils.BINARY_TREE_GENERAL;

public class LC_842_Split_Array_into_Fibonacci_Sequence2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "12345657923465844323447833443455656"; //true
		String str =		"5511816597";
		int end = 2;
        String numStr = str.substring(0, end);
        System.out.println("numStr:"+numStr);
        if(numStr.compareTo("2147483647") < 0) {
        		System.out.println("numStr:"+numStr);
		}
//        int num = Integer.valueOf(str.substring(0, end));
        
//        System.out.println("min:"+Integer.MIN_VALUE);
//        System.out.println("num:"+numStr);
        System.out.println("max:"+Integer.MAX_VALUE);
//		String str = "11235813";//true
//		String str = "112358130";//false
//		String str = "0123";//false
//		String str = "1101111";//true
//		System.out.println(""+splitIntoFibonacci(str));
		
	}
	
    public static boolean splitIntoFibonacci(String str) {
    		if(str == null || str.length() == 0) {
    			return false;
    		}
//    		return splitIntoFibonacci(str, 0, -1, -1);
    		return splitIntoFibonacci(str, 0, -1, -1);
    }

    private static boolean splitIntoFibonacci(String str, int index, int prev1, int prev2) {
		if(index == str.length()) {
//			return prev1 != -1 && prev2 != -1;
		}
		for(int i = index; i < str.length(); i++) {
			int num = Integer.valueOf(str.substring(index, i+1));
			
			
		}
        return false;
    }

}
