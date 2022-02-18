package Leet.XB.Mock;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Transaction_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		KVStore kvStore = new KVStore();
		Transaction_Map kv = new Transaction_Map();
		Map<String, String> map = kv.map;
		kv.put("a", "va1");
		kv.put("b", "vb1");
		kv.put("c", "vc1");
		
		kv.begin();
		kv.put("b", "vb2");
		kv.put("b", "vb3");
		kv.remove("a");
		kv.put("c", "vc2");		
		kv.put("b", "vb4");
		kv.commit();
		
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
	Transaction_Map(){
		map = new HashMap<>();
		deque = new ArrayDeque<>();
	}
	private   Map<String, String> map;
	private  boolean isTranctional;
	private Deque<Operation> deque;
	
	class Operation{
		String op;
		String[] paras;
		Operation(String op, String[] paras){
			this.op = op;
			this.paras = paras;
		}
		public void exec() {
			switch(op) {
				case "PUT":
					map.put(paras[0], paras[1]);
					break;
				case "REMOVE":
					map.remove(paras[0]);
					break;
				default:;
			}
		}
	}
	 void put(String key, String value) {
		if(!isTranctional) {
			map.put(key, value);
		}else {
			deque.offer(new Operation("PUT", new String[] {key, value}));
		}
	}
	 String get(String key) {
		return map.get(key);
	}
	 void remove(String key) {
		if(!isTranctional) {
			map.remove(key);
		}else {
			deque.offer(new Operation("REMOVE", new String[] {key}));
		}
	
	}
	 void begin(){
		isTranctional = true;
	}
	 void rollback() {
		deque.clear();
		isTranctional = false;
	}
	 void commit() {
		while(!deque.isEmpty()) {
			Operation operation = deque.poll();
			operation.exec();
		}
		isTranctional = false;
	}
}
