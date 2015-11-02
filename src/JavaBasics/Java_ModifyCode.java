package JavaBasics;

import java.util.ArrayList;
import java.util.List;

public class Java_ModifyCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 3;
		System.out.println(generate(num).size());
		System.out.println(generate(num));
	}

	static List<String> generate(int n) {
		List<String> list = new ArrayList<String>();
		genereate(n, n, new char[2*n], 0, list);
		return list;
	}
	
	private static void genereate(int left, int right, char[] arr, int curr, List<String> list) {
		// TODO Auto-generated method stub
		System.out.printf("%s, %s, %s\n", new String(arr), curr, new String(arr).substring(0, curr));

		if (left == 0 && right == 0) {
			list.add(new String(arr));
			return;
		}
		if(left > 0){
			arr[curr] = '(';
			genereate(left - 1, right , arr, curr + 1,list);
		}
		if(right > 0 && right > left){
			arr[curr] = ')';
			genereate(left, right - 1 , arr, curr + 1, list);
		}
	}

//	private static void genereate(int left, int right, String str, List<String> list) {
//		// TODO Auto-generated method stub
//		if (left == 0 && right == 0) {
//			list.add(str.toString());
//			return;
//		}
//		if(left > 0){
//			genereate(left - 1, right , str + "(", list);
//		}
//		if(right > 0 && right > left){
//			genereate(left, right - 1 , str + ")", list);
//		}
//	}

//	static List<String> generate(int n) {
//		List<String> list = new ArrayList<String>();
//		genereate(n, n, new StringBuffer(), list);
//		return list;
//	}
//
//	private static void genereate(int left, int right, StringBuffer sb, List<String> list) {
//		// TODO Auto-generated method stub
//		if (left == 0 && right == 0) {
//			list.add(sb.toString());
//			return;
//		}
//		if(left > 0){
//			genereate(left - 1, right , sb.append("("), list);
//			sb.deleteCharAt(sb.length() -1 );
//		}
//		if(right > 0 && right > left){
//			genereate(left, right - 1 , sb.append(")"), list);
//			sb.deleteCharAt(sb.length() - 1 );
//		}
//	}
}
