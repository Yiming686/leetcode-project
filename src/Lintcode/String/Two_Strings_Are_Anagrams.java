package Lintcode.String;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Two_Strings_Are_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(""+anagram("abcbccc", "abcdcad"));
		System.out.println(""+anagram("abcabsjdhbc", "abc"));
									 //abc  sjdh						
	}
	
    // O(n) time, O(1) extra space
    public static  boolean anagram(String s, String t) {
//        if (s.length() != t.length()) {
//           return false;
//        }
        
        int[] count = new int[256];
        int numOfChars = 0;
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if(count[ch] == 0) numOfChars++;
            count[ch]++;
        }
        System.out.println(""+numOfChars);
        System.out.println(""+Arrays.toString(count));
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

	
	
	//TC is O(N), SC is O(N)
    public static boolean anagram44(String A, String B) {
    // public boolean compareStrings(String A, String B) {
        List<Character> list = new LinkedList<Character>();
        for(Character ch : A.toCharArray()){
            list.add(ch);
        }
        System.out.println(""+list);
        for(Character ch : B.toCharArray()){
            if(!list.contains(ch))
                return false;
            else{
            	list.remove(ch);
                System.out.println(""+list);
            }
        }
        return true;
    } 
    
    // O(nlog(n)) time, O(n) extra space
    public static boolean anagram3(String s, String t) {
        // write your code here
        if(s == null || t == null) return false;
        
        if(s.length()!=t.length()) return false;

        char[] arr1 = s.toCharArray();      
        char[] arr2 = t.toCharArray();  
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
        // return String.valueOf(arr1).equals(String.valueOf(arr2));
        // return new String(arr1).equals(new String(arr2));
        // for(int i = 0; i< arr1.length; i++){
        //     if(arr1[i]!=arr2[s.length()-1-i]) return false;
        // }
        // return true;
    }


}
