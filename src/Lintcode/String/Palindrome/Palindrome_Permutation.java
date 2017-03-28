package Lintcode.String.Palindrome;

import java.util.HashSet;
import java.util.Set;

/**

Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

For example, "code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice? 
Count the frequency of each character. If each character occurs even number of times, 
then it must be a palindrome. How about character which occurs odd number of times?

 *
 */
public class Palindrome_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+canPermutePalindrome("code"));
		System.out.println(""+canPermutePalindrome("aab"));
		System.out.println(""+canPermutePalindrome("carerac"));
	}

    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            // ���ֵĵ�ż���Σ������Set���Ƴ�
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            } else {
            // ���ֵĵ������Σ��������Set��
                set.add(s.charAt(i));
            }
        }
        // ���ֻ����һ���������ַ�
        return set.size() <= 1;
    }

}
