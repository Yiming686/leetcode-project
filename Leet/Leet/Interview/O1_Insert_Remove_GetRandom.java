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
 * ���һ��֧����ƽ�� ʱ�临�Ӷ� O(1) �£� ִ�����²��������ݽṹ��
 * 
 * ע��: ��������ظ�Ԫ�ء�
 * 
 * insert(val)���򼯺��в���Ԫ�� val�� remove(val)���� val ����ʱ���Ӽ������Ƴ�һ�� val��
 * getRandom�������м����������ȡһ��Ԫ�ء�ÿ��Ԫ�ر����صĸ���Ӧ�������ڼ����е�������������ء�
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

//	������һ�β���һ���� �������ظ���ֵ
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

//	ɾ����һ��ɾ��һ���� ����һ��ɾ�������ظ���ֵ��������ǰ��
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
