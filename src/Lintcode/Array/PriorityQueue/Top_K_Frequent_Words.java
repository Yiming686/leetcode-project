package Lintcode.Array.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Top_K_Frequent_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] words = {"aa","ab"};
//		String[] words = {"a","a"};
		String[] words = {"yes", "lint", "code",
		    "yes", "code", "baby",
		    "you", "baby", "chrome",
		    "safari", "lint", "code",
		    "body", "lint", "code"};
		int k = 4;
		System.out.println(""+Arrays.toString(topKFrequentWords(words, k)));;
	}
    static class Pair{
        String word;
        Integer count;
        Pair(String word, Integer count){
            this.word = word;
            this.count = count;
        }
    }
    public static String[] topKFrequentWords(String[] words, int k) {
        String[] arr = new String[k];
        if(words == null || words.length == 0) return null;
        if(k<=0) return arr;
        
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for(String key : words){
            if(!map.containsKey(key)){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
        }
        System.out.println("map: "+map);
        //一定要知道是最小堆还是最大堆？count从大到小排列，留下最大的，需要最小堆
        // word从小到大，留下最小的，需要最大堆
        Queue<Pair> queue = new PriorityQueue<Pair>(11, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.count == p2.count){
                    return p2.word.compareTo(p1.word);//最大堆
//                    return p1.word.compareTo(p2.word);//最大堆
                }else{
                    return p1.count - p2.count;//最小堆
                }
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key    = entry.getKey();
            Integer value = entry.getValue();
            if(queue.size() < k){
                queue.offer(new Pair(key, value));
            }else{
                if(value > queue.peek().count){
                    Pair oldPair = queue.poll();
                    // Pair newPair = oldPaire 
                    queue.offer(new Pair(key, value));
                }else{
                    
                }
            }
        }
//        System.out.println(""+queue);
        //按照queue的size来输出，而不是k，如果size小于k，剩下的为默认值null
        for(int i = queue.size()-1; i >= 0; i--){
            arr[i] = queue.poll().word;
        }
        return arr;        
        
    }     
	
    public static String[] topKFrequentWords22(String[] words, int k) {
        // Write your code here
        if(words == null || words.length == 0) return null;
        //TreeMap needed, not HashMap
        // Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new TreeMap<String, Integer>();

        // int max = 0;
        //O(nlogn)
        for(String key : words){
            if(!map1.containsKey(key)){
                map1.put(key, 1);
                // max = Math.max(max, 99999999);
            }else{
                map1.put(key, map1.get(key)+1);
                // max = Math.max(max, map1.get(key));
            }
        }
        
        Map<Integer, List<String>> map2 = new TreeMap<Integer, List<String>>(
            new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                    return i2 - i1;
                }
            }
            );
            
        //O(nlogn)
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
       
        int count = 0;
        for(Map.Entry<Integer, List<String>> entry : map2.entrySet()){
            Integer key = entry.getKey();
            List<String> value = entry.getValue();

            for(String str : value){
                if(count < k){
                    arr[count] = str;
                    count++;
                    if(count == k)return arr;
                }else{
                    return arr;
                }
            }
        }

        return arr;
    }

    public static String[] topKFrequentWords33(String[] words, int k) {
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
