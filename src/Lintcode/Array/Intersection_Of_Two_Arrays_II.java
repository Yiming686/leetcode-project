package Lintcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Lintcode.Utils;

/**
 Intersection of Two Arrays II

 Description
 Notes
 Testcase
 Judge
Given two arrays, write a function to compute their intersection.

 Notice

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Have you met this question in a real interview? Yes
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Challenge 
Tags 
Binary Search Two Pointers Sort Hash Table
Related Problems 
Easy Intersection of Two Arrays 23 %
Medium Count of Smaller Number 20 %
Easy Merge Two Sorted Arrays 35 %

 *
 *
 */
public class Intersection_Of_Two_Arrays_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = { 0, 1, 2,1,1, 10 };
//		int[] arr2 = { 1,1, 2, 3, 4, 5 };
		int[] arr1 = { 5,1,2,2,2,3,3,3,3,3,6,7,8 };
		int[] arr2 = { 11,3,3,3,2,2,1,14,23 };
		System.out.println(""+Utils.arrayToString(intersection(arr1, arr2)));

		System.out.println(""+Utils.arrayToString(intersection2(arr1, arr2)));

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(""+Utils.arrayToString(intersection1(arr1, arr2)));
        if( 1 == 1)return;

	}
	

    //解法一：  TC is O(Nlog(N)), SC is O(N)
    public static int[] intersection1(int[] nums1, int[] nums2) {
        // Write your code here
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> comm = new ArrayList<Integer>();
		int len = 0;
		for(int i =0, j=0; i<nums1.length && j < nums2.length;){
			int val1 = nums1[i];
			int val2 = nums2[j];
			if(val1 == val2){
				comm.add(val1);
				len++;
				i++;
				j++;
			}else if(val1 < val2){
				i++;
			}else{
				j++;
			}
		}

		int[] arr = new int[len];
		int i = 0;
		for(int val : comm){
		    arr[i++] = val;
		}
		return arr;
    }

    // 解法二：TC is O(N) ,SC is O(N), looks good
    public static int[] intersection(int[] nums1, int[] nums2){	
	    if(nums1==null || nums2==null) return null;
	    List<Integer> result = new ArrayList<Integer>();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i = 0; i< nums1.length; i++){
	        Integer key = nums1[i];
	        if(!map.containsKey(key)){
	            map.put(key, 1);
	        }else{
	            map.put(key, map.get(key)+1);
	        }
	    }
	    for(int i = 0; i< nums2.length; i++){
	        Integer key = nums2[i];
	        if(map.containsKey(key) && map.get(key) > 0){
	            result.add(key);
	            map.put(key, map.get(key)-1);
	        }
	    }
	   
	    int len = result.size();
	    int[] arr = new int[len];
		int i = 0;
		for(int val : result){
		    arr[i++] = val;
		}
		return arr;
	}
	
	
    // worked,ignore it,  解法二：TC is O(N) ,SC is O(N), not looks good
    public static int[] intersection2(int[] nums1, int[] nums2){	
	    if(nums1==null || nums2==null) return null;
	    List<Integer> result = new ArrayList<Integer>();
	    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
	    for(int i = 0; i< nums1.length; i++){
	        Integer key = nums1[i];
	        if(!map1.containsKey(key)){
	            map1.put(key, 1);
	        }else{
	            map1.put(key, map1.get(key)+1);
	        }
	    }
	    for(int i = 0; i< nums2.length; i++){
	        Integer key = nums2[i];
	        if(!map2.containsKey(key)){
	            map2.put(key, 1);
	        }else{
	            map2.put(key, map2.get(key)+1);
	        }
	    }
	   
	    for(Integer key: map1.keySet()){
	        if(map2.containsKey(key)){
	            int count = Math.min(map1.get(key), map2.get(key));
	            for(int j = 0; j<count; j++){
	                result.add(key);
	            }
	        }
	    }
	    int len = result.size();
	    int[] arr = new int[len];
		int i = 0;
		for(int val : result){
		    arr[i++] = val;
		}
		return arr;
	}

}
