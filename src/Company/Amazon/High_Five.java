package Company.Amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.prism.impl.Disposer.Record;

/**
High Five

 Description
 Notes
 Testcase
 Judge
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return 
Tags 
Heap Amazon
Related Problems 
Medium Top k Largest Numbers 30 %

Input
[[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Expected
1: 72.40
2: 97.40

 *
 *
 */
public class High_Five {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Record[] results = new Record[10];
		results[0] = new Record(1,91);
		results[1] = new Record(1,92);
		results[2] = new Record(2,93);
		results[3] = new Record(2,99);
		results[4] = new Record(2,98);
		results[5] = new Record(2,97);
		results[6] = new Record(1,60);
		results[7] = new Record(1,58);
		results[8] = new Record(2,100);
		results[9] = new Record(1,61);
		System.out.println(""+highFive(results));
	}

    public static Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        if(results == null || results.length == 0){
            return null;
        }
        int len = results.length;
        int size = 5;
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, Queue<Record>> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        for(int i = 0; i < len; i++){
            Record record = results[i];
            int id = record.id;
            int score = record.score;
            System.out.println("id:score:size:: "+ id +", "+score +", " +(map2.get(id) == null?0:map2.get(id).size()));
            if(!map2.containsKey(id)){
                map2.put(record.id, new PriorityQueue<>(1, new Comparator<Record>(){
                    @Override
                    public int compare(Record r1, Record r2){
                        return r1.score - r2.score;//从小到大
                    }
                }) );
                map2.get(id).offer(record);
                map3.put(id, score);
            }else if(map2.get(id).size() < size - 1){
                map2.get(id).offer(record);
                map3.put(id, map3.get(id) + score);
            }else if(map2.get(id).size() < size){
            	System.out.println(":::::::::::::"+id);
                map2.get(id).offer(record);
                map3.put(id, map3.get(id) + score);
                double average = map3.get(id)*1.0/map2.get(id).size();
                map.put(id, average);
            }else{
                if(score > map2.get(id).peek().score){
                    Record min = map2.get(id).poll();
                    map3.put(id, map3.get(id) - min.score + score);
                    double average = map3.get(id)*1.0/map2.get(id).size();
                    map.put(id, average);
                    min.score = score;
                    map2.get(id).offer(min);
                }
            }
        }
        System.out.println("map : "+map);
        System.out.println("map2: "+map2);
        System.out.println("map3: "+map3);
        return map;
    }

    static class Record {
    	public int id, score;
    	public Record(int id, int score){
    			this.id = id;
    			this.score = score;
    	}
    }
    
}
