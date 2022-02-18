package Leet.OA.Microsoft;

import Utils.SU;

public class Min_Moves_to_Make_String_Without_3_Identical_Consecutive_Letters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SU.ll("Max Network Rank");
//		String str = "baaaaa";//baa
//		String str = "eedaaad";//eedaad
//		String str = "xxxtxxx";//xxtxx
		String str = "uuuuxaaaaxuuu";//uuxaaxuu
		System.out.println("" + solution(str));
	}
	
	public static String solution(String str) {
		if(str == null || str.length() <= 2) {
			return str;
		}
//		char[] arr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				count++;
			}else {
				count = 1;
			}
			if(count <= 2) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

}
