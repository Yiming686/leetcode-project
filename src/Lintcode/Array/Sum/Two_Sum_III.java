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
        //hashMap存储元素和index的对应值，set存储已经返回的元素对
        //所以你知道怎么用set了吗？如何使用？一旦发现在set里面，跳过不用处理了。如何更新？一旦发现有效元素对，二者就加入set
        //如何使用Map呢？key用来检测是否存在元素对，value用来存储index信息
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
