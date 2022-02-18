package Leet.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Leet_1146_Snapshot_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Leet_1146_Snapshot_Array sa = new Leet_1146_Snapshot_Array(3);
//		sa.set(0,5);
//		sa.snap();
//		sa.set(0,6);
//		sa.get(0,0);
		Leet_1146_Snapshot_Array sa = new Leet_1146_Snapshot_Array(4);//numOfSnaps = 0
		sa.snap();//numOfSnaps = 1, return 0
		sa.snap();//numOfSnaps = 2, return 1
		Integer val = sa.get(3,1);//
		sa.set(2,4);//<2, (2,4)>
		sa.snap();//numOfSnaps = 3, return 2
		sa.set(1,4);//<3, (2,1)>
	}
    private List<TreeMap<Integer, Integer>> list;    
    private int numOfSnaps;//num of snaps, consider it as version number
    
    public Leet_1146_Snapshot_Array(int length) {
        numOfSnaps = 0;
        list = new ArrayList<>();
        for(int i = 0; i <length; i++){
            TreeMap<Integer, Integer> map = new TreeMap<>();//numOfSnaps, value
//            map.put(0, 0);
             map.put(0, null);
            list.add(map);
        }
    }
    
//  O(logN)
    public void set(int index, int val) {//先有版本号，然后才有<K, <v, V>>
        if(index < 0 || index >= list.size()){
            return;
        }        
        list.get(index).put(numOfSnaps, val);
    }

    public int snap() {
        
        // for(int i = 0; i < list.size(); i++){
        //     Map<Integer, Integer> map = list.get(i);
        //     map.put(numOfSnaps+1, map.get(numOfSnaps));            
        // }
        numOfSnaps++;
        return numOfSnaps - 1 ;
    }
    
    public Integer get(int index, int snap_id) {
        if(index < 0 || index >= list.size()){
            throw new IllegalArgumentException();
        }        

        TreeMap<Integer, Integer> map = list.get(index);
        if(map == null){
            return 0;
        }       
        int key = map.floorKey(snap_id);
        return map.get(map.floorKey(snap_id));//O(logN) avg
        // for(int i = snap_id; i>= 0; i--){
        //     if(map.containsKey(i)){
        //         return map.get(i);
        //     }
        // }
        // return 0;
        // return map.get(snap_id);        
    }

}
