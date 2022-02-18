package Lai.HashTable_String_I;

public class My_AtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+myAtoI("      "));
	}
	
//	
	public static int myAtoI(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		int n = str.length();
		int i = 0;
		while(i < n && str.charAt(i) == ' ' ) {
			i++;
		}
		if(i == n) return Integer.MIN_VALUE; //all " ", do not foget it 
		boolean positive = true;
		if(str.charAt(i) == '+' || str.charAt(i) == '-') {//StringIndexOutOfBoundsException
			positive = str.charAt(i) == '+';
			i++;
		}
		long sum = 0;
		while(i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			sum = sum * 10 + str.charAt(i) - '0';
			if(sum > (long)Integer.MAX_VALUE + 1) {
				break;
			}
			i++;
		}
		sum = positive ? sum : -sum;
		if(sum > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if(sum < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return (int)sum;
	}

}
