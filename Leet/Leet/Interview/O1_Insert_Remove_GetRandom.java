package Leet.Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * 
 * 注意: 允许出现重复元素。
 * 
 * insert(val)：向集合中插入元素 val。 remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 * 
 */
public class O1_Insert_Remove_GetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Map<Integer, Set<Integer>> map;

	private List<Integer> list;

	private Random random;

	private int size = 0;

	public O1_Insert_Remove_GetRandom() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}

//	插入是一次插入一个， 可以是重复的值
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			Set<Integer> indexes = map.get(val);
			list.add(size, val);
			indexes.add(size);
			size++;
			return false;
		} else {
			Set<Integer> indexes = new HashSet<>();
			map.put(val, indexes);
			list.add(size, val);
			indexes.add(size);
			size++;
			return true;
		}
	}

//	删除是一次删除一个， 可以一次删除所有重复的值？？答案是前者
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		Set<Integer> indexes = map.get(val);
		if (list.get(size - 1) == val) {
			indexes.remove(size - 1);
			size--;
		} else {
			Iterator<Integer> it = indexes.iterator();
			int index = it.next();
			it.remove();
			int lastVal = list.get(size - 1);
			list.set(index, lastVal);
			Set<Integer> set = map.get(lastVal);
			set.remove(size - 1);
			set.add(index);
			size--;
		}
		if (indexes.size() == 0) {
			map.remove(val);
		}
		return true;
	}

	public int getRandom() {
		return list.get(random.nextInt(size));
	}

}
