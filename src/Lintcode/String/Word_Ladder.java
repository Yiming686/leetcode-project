package Lintcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
Word Ladder

30:00
 Start
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Have you met this question in a real interview? Yes
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Tags Expand 
LinkedIn Breadth First Search


Related Problems Expand 
Hard Word Ladder II

 *
 */
public class Word_Ladder {

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		String[] arr = new String[]{"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(arr));
		System.out.println(""+ladderLength(start, end, dict));
	}

	
    public static int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return 0;
        }
        dict.add(end);

        HashSet<String> set = new HashSet<String>();//已经visited
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        set.add(start);
        
        int minLen = 1;
        
        while(!queue.isEmpty()){
            minLen++;
            int size = queue.size();
            //traverse words in the same layer
            for(int i = 0; i < size; i++ ){
                //poll 
                String word = queue.poll();
                //process
                for(String next : getNextWords(word, dict)){
                    // process each next
                    if(set.contains(next)){continue;}//required:avoid infinite loop，不能往回走或者横向走
                    if(next.equals(end)) return minLen;
                    //offer
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        return 0;
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    //一定必须在字典里面
    private static ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < word.length(); i++) {
            	System.out.println(""+word);       
                char[] arr = word.toCharArray();
                if (ch != arr[i]) {
                    arr[i] = ch;
                    String nextWord = new String(arr);
                    if (dict.contains(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }
            }
        }
        return nextWords;
    }

    private static  ArrayList<String> getNextWords3(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < word.length(); i++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, ch);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    // replace character of a string at given index to a given character
    // return a new string
    private static String replace(String s, int index, char c) {
        char[] arr = s.toCharArray();
        arr[index] = c;
        return new String(arr);
    }
}
