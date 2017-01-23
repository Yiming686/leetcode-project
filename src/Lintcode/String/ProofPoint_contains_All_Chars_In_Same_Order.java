package Lintcode.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



/**
【题意】给定两个String，如果第一个String，按照顺序依次包含第二个String中的字符序列，
则返回true，否则返回false
【解答】
问题就是准确记录第二个String的详细信息：字符信息，位置信息

比如google这个词，记录如下：
g:0,3 (g这个字符出现0，3的位置)
o:1,2 (o这个字符出现1, 2的位置)
l:4   (l这个字符出现4的位置)
e:5   (e这个字符出现5的位置)
注意拿到这些信息就可以准确复制原来字符串了.
【Test Cases】
null, null --> false
"", null   --> false
null, ""   --> false
"a", null
null, "b"
"",""
"", "a"
"c", ""



 *
 */
public class ProofPoint_contains_All_Chars_In_Same_Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			String str1 = "gogloe";google
			String str2 = "google";
			String str1 = "goe";
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

	//简单实现，非常好！看成两个字符序列了
	//此题检测String1里面是否完全包含String2，str1 = "google";str2 = "goe";则返回true
	//此题目String1和String2不对称，如果String1里面完全包含String2，String2里面可能不完全包含String1
	static boolean containsAllCharsInSameOrder(String string1, String string2)
	{ 
		if(string1 == null|| string2 == null) return false;             //if null string is not allowed
		if(string1.length() == 0 || string2.length() == 0) return false;//if empty string is not allowed 
	    char[] arr1 = string1.toCharArray();
	    char[] arr2 = string2.toCharArray();
	    int len1 = arr1.length;
	    int len2 = arr2.length;
	    int i1 = 0;
	    int i2 = 0;
	    for(; i1 < len1 && i2 < len2; i1++, i2++){
	    	char ch2 = arr2[i2];
	    	while(i1<len1 && ch2 != arr1[i1]){
//	    		System.out.println("ch2:ch1  "+ch2 +" : "+arr1[i1]);
	    		i1++;
	    	}
	    }
	    if(i2 == len2) 
	    	return true;
	    else
	    	return false;
	}
	
	//对第一个string建立map，对第二个字符逐个字符扫描，看看map里面是否包含，若都包含，返回true，一旦发现不包含，返回false。
	static boolean containsAllCharsInSameOrder2(String string1, String string2)
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
		    list.addLast(i);
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
//	    System.out.println("prevIndex:"+prevIndex);
	    return true;
	}


}
