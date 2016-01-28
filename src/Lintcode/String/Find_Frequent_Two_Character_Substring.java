package Lintcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 
Find the most frequent two-character substring within a string.
For example: Given the string ¡°abcab¡±, your function would return the string ¡°ab¡±
 *
 */
public class Find_Frequent_Two_Character_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+find_freq_two_char_substring("abcab"));
		System.out.println(""+find_freq_two_char_substring("aaaabbbbb"));
	}

	  //O(n) Complexity
	  public static String find_freq_two_char_substring(String input) {
	    //Todo
	    if(input == null || input.length() < 2) throw new IllegalArgumentException();
	    int max = 0;
	    String maxStr = null;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(int i = 0; i + 2 <= input.length() ; i++){
	        String key = input.substring(i, i+2); 
	        int value = map.containsKey(key) ? map.get(key) + 1 : 1;
	        map.put(key, value);
	        if(value > max){
	          max = value;
	          maxStr = key;
	        }
	    }
	    System.out.println(max);
	    return maxStr;
	    
	  }

	  //O(n) Complexity
	  public static String find_freq_two_char_substring2(String input) {
	    //Todo
	    if(input == null || input.length() < 2) throw new IllegalArgumentException();
	    int max = 0;
	    String maxStr = null;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for(int i = 0; i + 2 < input.length() ; i++){
	        String str = input.substring(i, i+2); 
	        int val = 0;
	        if(!map.containsKey(str)){
	            val = 1;
	            map.put(str, val);
	        }else{
	            val = map.get(str);
	            val += 1;  
	            map.put(str,val);
	        }
	        if(val > max){
	          max = val;
	          maxStr = str;
	        }
	    }
	    System.out.println(max);
	    return maxStr;
	    
	  }


}
