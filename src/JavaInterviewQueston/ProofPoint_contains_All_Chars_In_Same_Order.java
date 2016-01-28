package JavaInterviewQueston;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProofPoint_contains_All_Chars_In_Same_Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			String str1 = "gogloe";google
			String str1 = "google";
			String str2 = "goe";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "geo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "gto";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str2 = "goo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));
			str1 = "ooooooooo";
			str2 = "ooo";
			System.out.println(""+containsAllCharsInSameOrder(str1, str2));

	}
	
	static boolean containsAllCharsInSameOrder(String string1, String string2)
	{ 
		if(string1 == null|| string2 == null) return false;//if null string is not allowed
		if(string1.length() == 0 || string2.length() == 0) return false;//if empty string is not allowed 
	    char[] arr1 = string1.toCharArray();
	    char[] arr2 = string2.toCharArray();
	    int len1 = arr1.length;
	    int len2 = arr2.length;
	    Map<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();
	    for(int i = 0; i < len1; i++){
	    	char key1 = arr1[i];
	    	LinkedList<Integer> list = map.containsKey(key1) ? map.get(key1) : new LinkedList<Integer>();
		    list.add(i);
		    map.put(arr1[i], list);
	    }
	    int prevIndex = -1;//index of the previous element
	    for(int i = 0; i < len2; i++){
	    	char key2 = arr2[i];
	        if(!map.containsKey(key2)){ 
	        	return false; 
	        }else{
	        	LinkedList<Integer> list = map.get(key2);
	        	if(list.size() == 0){
	        		return false;
	        	}else{
	        		Integer currIndex = list.removeFirst();//index of the current element
	                if(currIndex < prevIndex) return false;  
	                prevIndex = currIndex;		        		
	        	}
	        }
	    }
	    System.out.println("prevIndex:"+prevIndex);
	    return true;
	}


}
