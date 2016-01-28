package Lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Top_K_Frequent_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"aa","ab"};
		String[] words = {"a","a"};
		int k = 1;
		topKFrequentWords(words, k);
	}
	
    public static String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0) return null;
        // Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new TreeMap<String, Integer>();

        int max = 0;
        for(String key : words){
            if(!map1.containsKey(key)){
                map1.put(key, 1);
                max = Math.max(max, 1);

            }else{
                map1.put(key, map1.get(key)+1);
                max = Math.max(max, map1.get(key));
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
        String [] arr = new String[k];
       
        // for(int i = 0; i<=max-k; i++){
        //     arr[i] = map2.get(k+i);
        // }
        // return map2.get(k).toArray(new String[0]); 
        int count = 0;
        for(int i = max; i>0 ; i--){
            for(String str : map2.get(i)){
                if(count < k){
                    arr[count] = str;
                    count++;
                }else{
                    return arr;
                }
            }
        }

        return arr;
    }


}
