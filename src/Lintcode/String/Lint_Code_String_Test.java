package Lintcode.String;

import java.util.ArrayList;
import java.util.List;

public class Lint_Code_String_Test {

	static List<String> list2 = new ArrayList<String>();
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add(null);list.add(null);list.add(null);
		System.out.println(""+list.size());
		list.add(null);list.add(null);
		System.out.println(""+list.size());
		list.add(null);list.add(null);
		System.out.println(""+list.size());
		list.add(null);list.add(null);
		
		// TODO Auto-generated method stub
//		String str = "dogsareanimals";
//		String str = "dogsare";
		String str = "dogs";
		String s = "";
		list2.add("dogs");
		list2.add("animals");
		list2.add("are");
//		System.out.println(""+list2);
		int start = 0;
		print(s, list, str, start);
	}
	
	private static void print(String s, List<String> list, String str, int start){
//		System.out.println(""+list);
//		if(list2.contains(s)) System.out.println(""+s);
		System.out.println(""+s);
		for(int i = start; i < str.length(); i++ ){
//			String ns = s + str.charAt(i); 
			list.add(str.charAt(i)+"");
			System.out.println("======"+s+":"+(i+1));
			print(s + str.charAt(i), list, str, i + 1);
			list.remove(list.size() - 1);
//			s = s.substring(0, s.length() - 1);
		}
		
	}
	

}
