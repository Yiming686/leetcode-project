package Leet.XB.Mock;

import java.util.HashMap;
import java.util.Map;

public class Transaction_Map_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		KVStore kvStore = new KVStore();
		Transaction_Map_2 kv = new Transaction_Map_2();
		kv.put("a", "va1");
		kv.put("b", "vb1");
		kv.put("c", "vc1");
		
		kv.begin();
		kv.put("b", "vb2");
		kv.put("b", "vb3");
		kv.remove("b");
		kv.put("c", "vc2");		
		kv.put("b", "vb4");
		kv.rollback();
		
		kv.begin();
		kv.put("a", "va2");
		kv.put("b", "vb5");
		kv.put("c", "vc3");
		kv.remove("a");
		kv.remove("b");
		kv.remove("c");
		kv.put("b", "vb6");
		kv.put("c", "vc4");
		kv.commit();
		
		kv.put("a", "va8");
		kv.put("b", "vb8");
		kv.put("c", "vc8");		

		kv.put("a", "va9");
		kv.put("b", "vb9");
		kv.put("c", "vc9");		
	}
	Transaction_Map_2(){
		map = new HashMap<>();
		transMap = new HashMap<>();
//		keys = new HashSet<>();
		
	}
	private   Map<String, String> map;
	private  boolean isTranctional;
	private   Map<String, String> transMap;
//	private Set<String> keys;
	 void put(String key, String value) {
		if(isTranctional) {
			transMap.put(key, value);
//			String newValue = transMap.get(key);
//			if(newValue == null) {
//				transMap.put(key, value);
//			}else {
//				transMap.put(key, value);
//			}
		}else {
			map.put(key, value);
		}
	}
	 String get(String key) {
		String value = null;
		if(isTranctional) {
			value = transMap.get(key);
		}else {
			value = map.get(key);
		}
		return value;
	}
	 void remove(String key) {
		if(isTranctional) {
			String newValue = transMap.get(key);
			if(newValue == null) {
				transMap.put(key, null);
			}else {
				transMap.remove(key);
			}
		}else {
			map.remove(key);
		}
	
	}
	 void begin(){
		isTranctional = true;
	}
	 void rollback() {
		transMap.clear();
		isTranctional = false;
	}
	 void commit() {
		for(Map.Entry<String, String> entry : transMap.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
		transMap.clear();
		isTranctional = false;
	}
}
