package Lai.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Lai.Utils.ArrayUtils99;
import SortingAlgorithm.ArrayGenerater;

public class Permutation_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = ArrayGenerater.intArray(4, 1, 10);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("a", 1);
		map.put("b", 1);
		map.put("c", 1);
		map.put("d", 1);
//		map.;
		int[] arr = {5, 7, 7, 3};
		System.out.println(permute(arr));;
	}

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
//        List<Integer> numsArr = new ArrayList<>();
        Integer[] numsArr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsArr[i] = nums[i];
        }
        //List<Integer> path = new ArrayList<>();
        helper(result, numsArr, 0);
        System.out.println("Result:" + result);
        return result;
    }
    
    private static void helper(List<List<Integer>> result,  Integer[] nums, int pos){
    		System.out.println("pos: " + pos + ", entrance: " + Arrays.toString(nums) );
        if(pos == nums.length){
            result.add(Arrays.asList(nums));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for(int i = pos; i < nums.length; i++ ){
            if(used.add(nums[i])){
                ArrayUtils99.swapIntegerArray(nums, pos, i);
                helper(result, nums, pos + 1);
                ArrayUtils99.swapIntegerArray(nums, pos, i);               
            }
 
        }
    }
    
    

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(nums == null || nums.length == 0) return result;
//        List<Integer> numsArr = new ArrayList<>();
//        for(int val: nums){
//            numsArr.add(val);
//        }
//        //List<Integer> path = new ArrayList<>();
//        helper(result, numsArr, 0);
//        return result;
//    }
//    
//    private static void helper(List<List<Integer>> result,  List<Integer> numsArr, int pos){
//    		System.out.println("pos: " + pos + ", entrance: " + numsArr );
//        int len = numsArr.size();
//        if(pos == len){
//            result.add(new ArrayList<Integer>(numsArr));
//            return;
//        }
//        Set<Integer> used = new HashSet<>();
//        for(int i = pos; i < len; i++ ){
//            if(used.add(numsArr.get(i))){
//                swap(numsArr, pos, i);
//                helper(result, numsArr, pos + 1);
//                swap(numsArr, pos, i);               
//            }
// 
//        }
//    }
//    
//    private static void swap(List<Integer> numsArr, int left, int right){
//        int temp = numsArr.get(left);
//        numsArr.set(left, numsArr.get(right));
//        numsArr.set(right, temp);
//    }

}
