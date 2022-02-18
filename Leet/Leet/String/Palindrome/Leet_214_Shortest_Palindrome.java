package Leet.String.Palindrome;

import Utils.SU;

public class Leet_214_Shortest_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SU.leet("416. Partition Equal Subset Sum\n" + 
		"");
	}
	
//	worked, Time: O(N^2), Space: O(N)
    // public String shortestPalindrome(String s) {        
    public String shortestPalindrome_ite(String s) {        
        int end = s.length() - 1;
        // int i = 0, j = end;
        // char[] arr = s.toCharArray();
        for( ;end >= 0; end--){
            if(isPal(s, 0, end)){
                break;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

//  worked, Time: O(N^2), Space: O(N)
	// public String shortestPalindrome(String s) {        
	public String shortestPalindrome_rec_1(String s) {
	    return shortestPalindrome(s, 0, s.length() - 1);
	}

	private String shortestPalindrome(String s, int start, int end) {
		if (isPal(s, start, end)) {
			return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
		}
		return shortestPalindrome(s, start, end - 1);
	}

//  worked
	// public String shortestPalindrome(String s) {        
	// public String shortestPalindrome_rec_2(String s) {        
	//     char[] arr = s.toCharArray();
	//     int end = shortestPalindrome(arr, 0, arr.length - 1);
	//     return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
	// }
	// private int shortestPalindrome(char[] arr, int start, int end){
	//     if(start == end){
	//         return end;
	//     }
	//     if(isPal(arr, start, end)){
	//         return end;
	//     }
	//     return shortestPalindrome(arr, start, end - 1);
	// }

	private boolean isPal(char[] arr, int left, int right) {
		while (left < right) {
			if (arr[left] != arr[right])
				return false;
			++left;
			--right;
		}
		return true;
	}

	private boolean isPal(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			++left;
			--right;
		}
		return true;
	}

}
