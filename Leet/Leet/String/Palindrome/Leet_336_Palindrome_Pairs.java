package Leet.String.Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_336_Palindrome_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abcd","dcba","lls","s","sssll"};
		System.out.println(""+palindromePairs(words));
	}

	//===========================
    
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, boolean[][]> word2IsPalMap = getWord2IsPalMap(words);//O(N * Len^2 )
        Map<String, String[][]> word2SubstrMap = getWord2SubstrMap(words);//O(N * len^3)
        // lls -> sll 
        Map<String, Integer> reverseMap = getReverseMap(words);//O(N * len)
        
        for (int i = 0; i < words.length; i++) {//O(N)
            String word = words[i];
            int l = word.length();
            String subStr = word;
            Integer revIndex = reverseMap.get(subStr);
            boolean[][] isPal = word2IsPalMap.get(word);
            String[][] substr = word2SubstrMap.get(word);
            
            // abc -> cba
            if (revIndex != null && revIndex != i) {
                ans.add(Arrays.asList(i, revIndex));
            }
            // abcdd ->looking for   cba 
            for (int j = 0; j < l; j++) {//O(len)
                subStr = substr[0][j];//O(len)
                revIndex = reverseMap.get(subStr);
                if (isPal[j][l-1] && revIndex != null) {//O(len)
                    ans.add(Arrays.asList(i, revIndex));
                }                
                subStr = j+1 < l ? substr[j+1][l-1] : "";
                // subStr = substr[j+1][l-1];
                revIndex = reverseMap.get(subStr);
                if (isPal[0][j] && revIndex != null) {
                    // ans.add(Arrays.asList(i, reverseMap.get(word.substring(j+1,l))));
                    ans.add(Arrays.asList(revIndex, i));
                }                
            }
        }
        return ans;
    }

//  Time: O(N*len^3), Space: O(N*len^2)
    private static Map<String, String[][]> getWord2SubstrMap(String[] words){    
        Map<String, String[][]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {//O(N)
            map.put(words[i], buildSubstr(words[i]));//(len^3)
        }
        return map;
    }
  //Time: O(len^3), Space: O(len^2)
    private static String[][]  buildSubstr(String str){    
        int len = str.length();
        String[][] substr = new String[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
               substr[i][j] = str.substring(i, j+1); 
            }            
        }
        return substr;
    }
    
//  Time: O(N*len^2), Space: O(N*len^2)
    private static Map<String, boolean[][]> getWord2IsPalMap(String[] words){
        Map<String, boolean[][]> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {//O(N)
            map.put(words[i], buildIsPal(words[i]));//(len^2)
        }
        return map;
    }
  //Time: O(len^2), Space: O(len^2)
    private static boolean[][] buildIsPal(String str){
        int len = str.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            isPal[i][i] = true;
            for (int j = i+1; j < len; j++) {
                if(str.charAt(i) == str.charAt(j) && j-i+1 <= 3 || isPal[i+1][j-1]){
                    isPal[i][j] = true;
                }
            }
        }
        return isPal;
    }

    //Time: O(N * len), Space: O(N)
    private static Map<String, Integer> getReverseMap(String[] words) {//O(N * len)
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            map.put(sb.toString(), i);
        }
        return map;
    }

}
