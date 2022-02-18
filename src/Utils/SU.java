package Utils;

public class SU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "66. All Valid Permutations Of Parentheses I";
//		String str = "Determine If One String Is Another's Substring";
//		System.out.println(""+connByUnderscore(str));
		System.out.println(leet(str));
//		System.out.println(""+connByUnderscore(str));
	}

	public static String lai(String str) {
		char[] arr = str.trim().replaceAll("\\.", "").toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ' || ( !Character.isDigit(arr[i]) && !Character.isLetter(arr[i])) ){
				arr[i] = '_';
			}
		}
		String result = "Lai_"+new String(arr);
		System.out.println(result);
		return result; 
	}
	
	public static String leet(String str) {
		char[] arr = str.trim().replaceAll("\\.", "").toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ' || ( !Character.isDigit(arr[i]) && !Character.isLetter(arr[i])) ){
				arr[i] = '_';
			}
		}
		String result = "Leet_"+new String(arr);
//		String result = ""+new String(arr);
		System.out.println(result);
		return result; 
	}
	
	public static String ll(String str) {
		return leet(str);
	}
	
}
