package Lintcode.String;

public class If_String_has_Unique_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "edcba";
		System.out.println(""+hasUnique(str));
	}
	
	//TC is O(N), SC is O(1) 
	//suppose it contains one or more lower case characters
	private static boolean hasUnique(String str) {
		if(str == null || str.length() == 0) return false;
		if(str.length() > 26) return false;
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int pos = str.charAt(i) - 'a';
//			int checker = (checker & (1 << val));//(1 << val)À¨ºÅ²»¿ÉÉÙ
			if((checker & (1 << pos)) != 0)return false;
			checker = checker | (1 << pos);
			System.out.println(""+Integer.toBinaryString(checker));
		}
		return true;
	}
	
	//TC is O(N), SC is O(1) 
	//worked, not best
	private static boolean hasUnique1(String str) {
		// TODO Auto-generated method stub
		int value = 0;
		String str2 = "";
		System.out.println(""+str2.isEmpty());
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			int check = (value & (1 << (ch-'a')));
			System.out.println(""+Integer.toBinaryString(check));
			if(check != 0)return false;
			value = value|(1 << (ch-'a'));
		}
		return true;
	}  		 
	        		 
	        		 
			 
}
