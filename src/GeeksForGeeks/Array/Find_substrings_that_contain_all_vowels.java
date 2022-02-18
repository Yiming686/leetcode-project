package GeeksForGeeks.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**

Find substrings that contain all vowels
We have been given a string in lowercase alphabets. We need to print substrings that contain all the vowels at-least one time and there are no consonants (non-vowel characters) present in the substrings.

Examples:

Input : str = aeoibddaeoiud
Output : aeoiu

Input : str = aeoibsddaeiouudb
Output : aeiou, aeiouu
Reference :- Samsung Interview Questions.

Recommended: Please try your approach on {IDE} first, before moving on to the solution.

We use a hashing based technique and start traversing the string from the start. For every character, we consider all substrings starting from it. If we encounter a consonant, we move to next starting character. Else, we insert current character in a hash. If all vowels are included, we print current substring.



 *
 */
public class Find_substrings_that_contain_all_vowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aeoibsddaeiouudb";
		findAllSubstrings(str);
		
	}
	
//	worked,
//	how to check if the set contains all the vowels: 
//	if the set contains all the vowels and then insert one more, what will happen...
	private static void findAllSubstrings(String str){
		if(str == null || str.length() == 0){
			return;
		}
		Set<Character> set = new HashSet<>();
		char[] arr = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			for(int j = i; j < str.length(); j++){
				if(isVowel(arr[j])){
					set.add(arr[j]);
					if(set.size() == 5){
						System.out.println(" "+ str.substring(i, j+1));//KEP STEP
					}
				}else{
					break;
				}
			}
			set.clear();//KEY STEP
		}
		
	}
	
	private static boolean isVowel(char ch){
		return (ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u');
	}

	
	private static List<String> findListAllSubstrings(String str){
		List<String> list = new ArrayList<>();
		if(str == null || str.length() == 0){
			return list;
		}
		Set<Character> set = new HashSet<>();
		char[] arr = str.toCharArray();
		for(int i = 0; i < str.length(); i++){
			for(int j = i; j < str.length(); j++){
				if(isVowel(arr[j])){
					set.add(arr[j]);
					if(set.size() == 5){
						list.add(str.substring(i, j+1));//KEP STEP
					}
				}else{
					break;
				}
			}
			set.clear();//KEY STEP
		}
		return list;
	}
}
