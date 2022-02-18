package Lai.Hybrid_Data_Structure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFU_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+Integer.MIN_VALUE);
		System.out.println(""+Integer.MAX_VALUE);
	}
//worked, Best ever,
    Map<Integer, Integer> keyToValMap;
    Map<Integer, Integer> keyToFreqMap;
    Map<Integer, LinkedHashSet<Integer>> freqToKeysMap;
    int minFreq;
    int capacity;
    
    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        this.keyToValMap = new HashMap<>();
        this.keyToFreqMap = new HashMap<>();
        this.freqToKeysMap = new HashMap<>();
    }
    
    public int get(int key) {
         Integer val =  keyToValMap.get(key);
        if(val == null){
            return -1;
        }
        updateFreq(key);
        return val;
    }
    
    public void put(int key, int value) { 
        if(capacity <= 0){
            return;
        }
        Integer oldVal = keyToValMap.get(key);
        if(oldVal != null){
            keyToValMap.put(key, value);
            updateFreq(key);
        }else{
            if(keyToValMap.size() == capacity){
                removeLfu();
            }
            keyToValMap.put(key, value);
            updateFreq(key);
            // keyToFreqMap.put(key, 1);            
            // minFreq = 1;
            // //BUG: LinkedHashSet<Integer> keys = freqToKeysMap.getOrDefault(1, new LinkedHashSet<>());
            // freqToKeysMap.putIfAbsent(1, new LinkedHashSet<>());
            // freqToKeysMap.get(1).add(key);
        }
    }
    
    private void removeLfu(){
        LinkedHashSet<Integer> keys = freqToKeysMap.get(minFreq);                
        //NOT BEST: Iterator<Integer> it = keys.iterator();
        // Integer lfuKey = it.next();
        // it.remove();                
        Integer lfuKey = keys.iterator().next();
        keys.remove(lfuKey);

        if(keys.size() == 0){
            freqToKeysMap.remove(minFreq);
        }
        keyToValMap.remove(lfuKey);
        keyToFreqMap.remove(lfuKey);        
    }
    
    //key's freq++, remove from old bucket and move to new one; 
    //if minFreq and last one in the bucket, update minFreq
    private void updateFreq(int key){
        //update keyToFreqMap
        // int oldFreq = keyToFreqMap.get(key);
        int oldFreq = keyToFreqMap.getOrDefault(key, 0);
        int newFreq = oldFreq + 1;
        keyToFreqMap.put(key, newFreq);
        //update freqToKeysMap + minFreq
        if(oldFreq == 0){//new key
            minFreq = 1;
        }else{//old key
            LinkedHashSet<Integer> keys = freqToKeysMap.get(oldFreq);
            // LinkedHashSet<Integer> keys = freqToKeysMap.getOrDefault(oldFreq, new LinkedHashSet<>());
            keys.remove(key);
            if(keys.size() == 0){//last key in the bucket
                freqToKeysMap.remove(oldFreq);//            
                if(minFreq == oldFreq){//right time to update
                    minFreq = newFreq;
                }
            }            
        }    
        //BUG: keys = freqToKeysMap.getOrDefault(newFreq, new LinkedHashSet<>());
        // keys.add(key);
        freqToKeysMap.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeysMap.get(newFreq).add(key);
    }

}
