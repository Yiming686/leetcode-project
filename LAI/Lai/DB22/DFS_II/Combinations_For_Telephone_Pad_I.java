package Lai.DB22.DFS_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Combinations_For_Telephone_Pad_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+Arrays.toString(combinations(213)));
//		System.out.println(""+Arrays.toString(combinations(9)));
	}

	//
	public static String[] combinations(int number) {
	    // Write your solution here
	    Map<Integer, String> map = new HashMap<>();
	    map.put(0, "");
	    map.put(1, "");
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    String str = String.valueOf(number);
	    char[] arr = str.toCharArray();
	    int len = 1;
	    for(char ch: arr){
	      String val = map.get(ch - '0');
	      if(val.length() == 0){
	        len *=1;
	      }else{
	        len *= val.length();        
	      }    
	    }
	    String[]  result = new String[len];
	    StringBuilder sb = new StringBuilder();
	    helper(result, new int[1], sb, map, arr, 0);
	    return result;
	  }

	private static void helper(String[] result, int[] index, StringBuilder sb, Map<Integer, String> map, char[] arr, int pos) {
		if (pos == arr.length) {
			result[index[0]++] = sb.toString();
			return;
		}
		String str = map.get(arr[pos] - '0');
		if(str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				sb.append(str.charAt(i));
				helper(result, index, sb, map, arr, pos + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}else {
			helper(result, index, sb, map, arr, pos + 1);
		}

	}

}
