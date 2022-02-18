package Leet.OA.Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given an Array A consisting of N Strings, calculate the length of the longest string S 
such that:

S is a concatenation of some of the Strings from A.
every letter in S is different.
Example -
A = ["co","dil","ity"] , function should return 5, resulting string S could be 
codil , dilco, coity,ityco
A = ["abc","kkk","def","csv"] , returns 6 , resulting Strings S could be 
abcdef , defabc, defcsv , csvdef
A = ["abc","ade","akl"] , return 0 , impossible to concatenate as letters wont be unique.

N is [1..8] ; A consists of lowercase English letters ; sum of length of strings 
in A does not exceed 100.

Related problems:

https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

 *
 */
public class Concatenated_String_Length_with_unique_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] strArr = {"co","dil","ity"};//longest:5, codil , dilco, coity,ityco
//		String[] strArr = {"abc","kkk","def","csv"};//longest:6,  abcdef , defabc, defcsv , csvdef
		String[] strArr = {"abc","ade","akl"};//longest:0,
		System.out.println(""+maxLength(strArr));
		System.out.println(""+ comb(Arrays.asList("co","dil","ity")));
	}
//	[, ity, dil, dility, co, coity, codil, codility]
//	[, ity+, dil+, dil+ity+, co+, co+ity+, co+dil+, co+dil+ity+]

//	[+co+dil+ity, +co+dil, +co+ity, +co, +dil+ity, +dil, +ity, ]

	public static List<String> comb(List<String> list) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		List<Integer> levels = new ArrayList<>();
		comb(result, list, sb, levels, 0 );
		return result;
	}
	
    private static void comb(List<String> result, List<String> list, StringBuilder sb,  List<Integer> levels, int level) {
    		if(level == list.size()) {
    			result.add(sb.toString());
    			return;
    		}
    		boolean toAdd = levels.size() == level;
    		if(toAdd) {
    			levels.add(level);
   		}else {
	    		sb.append("+");
	    		sb.append(list.get(level));
	    		comb(result, list, sb, levels, level + 1);
	    		sb.delete(sb.length() - list.get(level).length() - 1, sb.length());
    		}
    		sb.append("+");
    		sb.append(list.get(level));
    		comb(result, list, sb, levels, level + 1);
    		sb.delete(sb.length() - list.get(level).length() - 1, sb.length());
    		if(toAdd) {
//    			sb.delete(sb.length() - list.get(level).length() - 1, sb.length());
    		}else {
//    			sb.delete(sb.length() - list.get(level).length() , sb.length());
    		}
    		toAdd = false;

    		comb(result, list, sb, levels, level + 1);
	}

	public static int maxLength(String[] A) {
    		int longest = 0;
    		
    		int len = A.length;
//    		Set[] setArr0 = new HashSet[len];
    		Set<Character>[] setArr = new HashSet[len];
    		for(int i = 0; i < len; i++) {
    			setArr[i] = new HashSet<>();
    		}
    		for(int i = 0; i < len; i++) {
    			int lenCurrStr  = A[i].length();
    			for( int j = 0; j < A[i].length(); j++) {
    				setArr[i].add(A[i].charAt(j));	
    			}
    			if(setArr[i].size() != lenCurrStr) {//had duplicate chars
    				setArr[i].clear();//clear all, make size == 0
    			}
    		}
    		for(int i = 0; i < len; i++) {
    			if(setArr[i].isEmpty()) {
    				continue;
    			}
    			for(int j = i+1; j < len; j++) {
    				if(setArr[j].size() == 0) {
        				continue;
        			}
    				if(!hasCommon(setArr[i], setArr[j])) {
//    					result += 2;
    					longest = Math.max(longest, setArr[i].size() + setArr[j].size());
    				}
    			}
    		}
        return longest;
    }
     private static boolean hasCommon(Set<Character> set1, Set<Character> set2) {
    	 	for(Character ch : set1) {
    	 		if(set2.contains(ch)) {
    	 			return true;
    	 		}
    	 	}
    	 	return false;
     }
    

    //    public int maxLength(List<String> arr) {
//        
//    }

}
