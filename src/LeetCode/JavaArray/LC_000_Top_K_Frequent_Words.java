package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Medium 

Top K Frequent Words Show result 

10% Accepted
Given a list of words and an integer k, return the top k frequent words in the list.

Have you met this question in a real interview? Yes
Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],

Note
You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.

Challenge
Do it in O(nlogk) time and O(n) extra space.

Extra points if you can do it in O(n) time with O(k) extra space.



 *
 */


public class LC_000_Top_K_Frequent_Words {

    public static String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0) return null;
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for(String key : words){
            if(!map1.containsKey(key)){
                map1.put(key, 1);
            }else{
                map1.put(key, map1.get(key)+1);
            }
        }
        
        Map<Integer, List<String>> map2 = new HashMap<Integer, List<String>>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(!map2.containsKey(value)){
                List<String> list = new ArrayList<String>();
                list.add(key);
                map2.put(value, list);
            }else{
                List<String> list = map2.get(value);
                list.add(key);
                map2.put(value, list);
            }
        }
        return map2.get(k).toArray(new String[0]);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr ={"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"}; 
//			{    "yes", "lint", "code",
//			    "yes", "code", "baby",
//			    "you", "baby", "chrome",
//			    "safari", "lint", "code",
//			    "body", "lint", "code"};
//		
		System.out.println(topKFrequentWords(arr, 3));
		
	}

}
