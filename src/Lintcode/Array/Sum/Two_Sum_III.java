package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Two_Sum_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{7, 2, 2, 2, 9, 10, 2, 2, 11, 9, 1, 0};
//		int[] arr = new int[]{5,5,3,9,12};
		int target = 9;
		System.out.println("twoSum3 : "+twoSum3 (arr, target));
//		System.out.println("twoSumII2: "+twoSumII2(arr, target));

	}
	/*
     * follow up: do not allow duplicates
     * [7, 2, 2, 2, 9, 10, 2, 2, 11, 9, 1,0] target 9, just one solution
     */
    public static List<List<Integer>> twoSum3(int[] numbers, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numbers == null || numbers.length < 2){
            return res;
        }
        //hashMap�洢Ԫ�غ�index�Ķ�Ӧֵ��set�洢�Ѿ����ص�Ԫ�ض�
        //������֪����ô��set�������ʹ�ã�һ��������set���棬�������ô����ˡ���θ��£�һ��������ЧԪ�ضԣ����߾ͼ���set
        //���ʹ��Map�أ�key��������Ƿ����Ԫ�ضԣ�value�����洢index��Ϣ
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(hashSet.contains(numbers[i])) continue;
            int diff = target - numbers[i];
            if(hashMap.containsKey(diff)){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(hashMap.get(diff) + 1);
                list.add(i + 1);
                res.add(list);
                hashSet.add(diff);
                hashSet.add(numbers[i]);
            }
            hashMap.put(numbers[i], i);
        }
        return res;
    }
}
