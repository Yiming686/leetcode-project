package Lintcode.String;

/**

Minimum Window Substring Show result 

Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Have you met this question in a real interview? Yes
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Note
If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Challenge
Can you do it in time complexity O(n) ?

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Tags Expand 
LinkedIn Hash Table Facebook

 *
 *
 */
public class Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        //因为要找到最小，所以有此变量，沿途记录最小的长度
        int min = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] sourcehash = new int[256];
        int[] targethash = new int[256];
        
        //buecket统计字符个数
        for (char ch : Target.toCharArray()) {
            targethash[ch] ++;
        }
        
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            //source does not contain all the characters in target, loop
            //找到第一个或者找遍都没有找到，就跳出
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                // if(j < Source.length() )
                    j++;
                // else 
                //     break;
            }
            if(valid(sourcehash, targethash) ){
                if(min > j - i ) {
                    min = Math.min(min, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }
	
    //只要targethash > sourcehash,就返回false
    //valid means that the source contains all the characters in target
    boolean valid(int []sourcehash, int []targethash) {
        
        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])    
                return false;//任一个targethash大于sourcehash，都是无效的
        }
        return true;//所有targethash都小于等于sourcehash，此时才是一个全包含
    }

}
