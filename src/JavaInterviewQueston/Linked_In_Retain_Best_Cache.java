package JavaInterviewQueston;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Linked_In_Retain_Best_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSource<Integer, RankableClass> ds = new DataSourceClass<Integer,RankableClass>();
		ds.put(1, new RankableClass(1l));ds.put(2, new RankableClass(2l));ds.put(3, new RankableClass(3l));
		ds.put(4, new RankableClass(4l));ds.put(5, new RankableClass(5l));ds.put(6, new RankableClass(6l));
		ds.put(7, new RankableClass(7l));ds.put(8, new RankableClass(8l));ds.put(9, new RankableClass(9l));
		ds.put(10, new RankableClass(10L));
		RetainBestCache<Integer, RankableClass> cache = new RetainBestCache<Integer, RankableClass>(ds, 3);
		System.out.println(""+cache.get(2).getRank());
		System.out.println(""+cache.get(3).getRank());
		System.out.println(""+cache.get(4).getRank());
		System.out.println(""+cache.get(5).getRank());
		System.out.println(""+cache.get(6).getRank());
	}

}
class RankableClass implements Rankable{
	private long rank;
	public RankableClass(long rank){ this.rank = rank;}
	@Override
	public long getRank() {
		// TODO Auto-generated method stub
		return rank;
	}
	
}
class DataSourceClass<K, T extends Rankable> implements DataSource<K, T>{
    private Map<K, T> map = new HashMap<K, T>(); 
	public DataSourceClass(){
	}
	@Override
	public T get(K key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}
	@Override
	public void put(K key, T value) {
		// TODO Auto-generated method stub
		map.put(key, value);
	}
	
}

class RetainBestCache<K, T extends Rankable> {
	 
    /* Constructor with a data source (assumed to be slow) and a cache size */
    private class Pair{
        K key;
        T value;
        public Pair(K key, T value){
        	this.key = key;
        	this.value = value;
        }
    }
    private Map<K, Pair> map = new HashMap<K, Pair>(); 
    private int capacity;
    private DataSource<K,T> ds;
    
    private PriorityQueue<Pair> queue;
    
    
    public RetainBestCache(DataSource<K,T> ds, int entriesToRetain) {
        // Implementation here
        this.capacity = entriesToRetain;
        this.ds = ds;
        this.queue = new PriorityQueue<Pair>(
                capacity, new Comparator<Pair>(){
                    public int compare(Pair p1, Pair p2){
                        return (int)(p1.value.getRank() - p2.value.getRank());
                    }
                }
            );
    }
 
    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempts to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        // Implementation here
        if(!map.containsKey(key)){
            T value = ds.get(key);            
            if(map.size() == capacity){
            	Pair newP = new Pair(key, value);
                Pair p = queue.poll();           
                queue.offer(newP);
                map.remove(p.key);
                map.put(key, newP);
            }else{
                Pair newP = new Pair(key, value);
                queue.offer(newP);
                map.put(key, newP);
            }           
            return value;
        }else{         
            return map.get(key).value;
        }
    }
}
 
/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */
 
 interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();
}
 
 interface DataSource<K, T> {
    T get (K key);
    void put (K key, T value);
}