package Lintcode;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String arrayToString(int[] arr) {
		String str = "[";
		String prefix = "";
		for(int val : arr){
			str += prefix + val;
			prefix = ", ";
		}
		str += "]";
		return str;
	}

}
