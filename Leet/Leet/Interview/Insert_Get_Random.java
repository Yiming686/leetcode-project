package Leet.Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import Utils.SU;

public class Insert_Get_Random {

	public static void main(String[] args) {
		SU.leet("307. Range Sum Query - Mutable");
		// TODO Auto-generated method stub
		insert("str1", 3);//O(1)
		insert("str2", 1);
		insert("str3", 6);
		insert("str1", 0);//O(1)
		insert("str1", 0);//O(1)
//		remove("str1");
//		remove("str2");
//		remove("str3");
//		System.out.println(""+getRandom());//O(1)
//		System.out.println(""+getRandom());//O(1)
		int count = 1000;
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < count; i++) {
			String key = getRandom();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
	}

	static List<String> list = new ArrayList<>();
	static Map<String, Set<Integer>> key2IndexSetMap = new HashMap<>();
	static int weightInTotal;
	static Random random = new Random();
	
	Insert_Get_Random(){
		list = new ArrayList<>();
		key2IndexSetMap = new HashMap<>();
		weightInTotal = 0;
		random = new Random();
	}
	
//	O(diff)
	public static void insert(String key, int weight) {
//		key, valid, weight > 0
		if(key == null || weight < 0) {
			return;
		}
		
		Set<Integer> set = key2IndexSetMap.get(key);
		if(set == null) {
//			if(weight == 0) {
//				return;
//			}
			set = new HashSet<>();
			key2IndexSetMap.put(key, set);
		}
		int prevCount = set.size();
		if(prevCount == weight) {
			return;
		}
		weightInTotal += weight - prevCount;//update weightInTotal
		if(prevCount < weight) {
			for(int i = 0; i < weight - prevCount; i++) {//add more
				list.add(key);//update weightInTotal
				set.add(list.size() - 1);//update key2IndexSetMap
			}
		}else {
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				int index = it.next();
				it.remove();
				String lastKey = list.get(list.size() - 1);
				Set<Integer> lastKeySet = key2IndexSetMap.get(lastKey);
				lastKeySet.remove(list.size() - 1);//
				lastKeySet.add(index);
				list.set(index, lastKey);//swap
				list.remove(list.size() - 1);//remove last
			}
			
//			if(weight == 0) {
//				key2IndexSetMap.remove(key);
//			}
		}
	}
	
	//O(weight)
	public static void remove(String key) {
		if(key == null) {
			return;
		}
		Set<Integer> set = key2IndexSetMap.get(key);
		if(set == null) {
			return;
		}
		int prevCount = set.size();
		if(prevCount == 0) {
			key2IndexSetMap.remove(key);
			return;
		}

		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int index = it.next();
			it.remove();
			list.set(index, list.get(list.size() - 1));//swap
			list.remove(list.size() - 1);//remove last
		}
		key2IndexSetMap.remove(key);
	}
	
//O(1)
	public static String getRandom() {
		if(list.size() ==0) {
			return null;
		}
		int index = random.nextInt(weightInTotal);
		return list.get(index);
	}
	
}
