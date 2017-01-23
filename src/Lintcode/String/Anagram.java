package Lintcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

/**
Anagrams

30:00
 Start
Given an array of strings, return all groups of strings that are anagrams.

Have you met this question in a real interview? Yes
 Notice

All inputs will be in lower-case

Example
Tags
Related Problems
 Notes
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

 *
 */
public class Anagram {

	public static void main(String[] args) {
		int[] height = {0,1,2,3,4,5,6,7,8,9};
        int left = 4;
        int right = 5;
        int leftHeight = 6;
//                  4 < 5 && 
		Boolean bool = false;			
		
		
		bool = left < right && leftHeight > height[++left];
		
        int[] key = new int[256];
        key[0] = 2;
        Map<int[], List<String>> map = new HashMap<int[], List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("abc");
        map.put(key, list);
        
        int[] key2 = new int[256];
        key2[0] = 2;
        
        System.out.println(""+map.containsKey(key2));

        String[] strs = {"","",""};
        System.out.println(""+anagrams12(strs));

	}
	
    // worked, string-->char[]-->Arrays.sort()-->key
    public static List<String> anagrams11(String[] strs) {  
        if (strs.length < 1) return null;  
        List<String> result = new ArrayList<String>();  
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();  
        for (int i = 0; i < strs.length; i++) {  
            char[] chs = strs[i].toCharArray();  
            Arrays.sort(chs);  
            String key = String.valueOf(chs); 
            if(!map.containsKey(key)){
                 List<String> list = new ArrayList<String>();  
                 list.add(strs[i]);
                map.put(key, list);
            }else{
                map.get(key).add(strs[i]);
                // map.put(key, map.get(key).add(strs[i]));
            }
        }  
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                result.addAll(map.get(key));
            }
        }
        // result.add(map.values());
        return result;  
    }  
    
    
    // not worked, i.e. ["",""]
    public static List<String> anagrams12(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) return result;
        Map<int[], List<String>> map = new HashMap<int[], List<String>>();
        for(String str : strs){
            int[] count = new int[2560];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)]++;
            }
            int[] key = count ; 
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }else{
                map.get(key).add(str);
            }
        }
        for(Map.Entry<int[], List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                result.addAll(entry.getValue());
            }
        }
        return result;
    }


}
