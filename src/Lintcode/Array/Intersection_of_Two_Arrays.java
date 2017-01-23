package Lintcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import Lintcode.Utils;

/**
Intersection of Two Arrays

 Description
 Notes
 Testcase
 Judge
Given two arrays, write a function to compute their intersection.

 Notice

Each element in the result must be unique.
The result can be in any order.
Have you met this question in a real interview? Yes
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Challenge 
Can you implement it in three different algorithms?

Tags 
Binary Search Two Pointers Sort Hash Table
Related Problems 
Easy Intersection of Two Arrays II 19 %
Medium Count of Smaller Number 20 %
Easy Merge Two Sorted Arrays 35 %

 *
 *
 */
public class Intersection_of_Two_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = { 0, 1, 2,1,1, 10 };
//		int[] arr2 = { 1,1, 2, 3, 4, 5 };
		int[] arr1 = { 5,1,2,2,3,3,3,3,6,7,8 };
		int[] arr2 = { 11,3,3,3,2,2,1,14,23 };
		System.out.println(""+Utils.arrayToString(intersection(arr1, arr2)));
		Arrays.sort(arr1);
		Arrays.sort(arr2);
//		System.out.println(""+intersection1(arr1, arr2));
        if( 1 == 1)return;

	}
	// ½â·¨Ò»£¬best, two sets
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            Integer val = nums2[i];
            if (set1.contains(val) && !set2.contains(val) ) {
                set2.add(val);
            }
        }
        int size = set2.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : set2) {
            result[index++] = num;
        }
        return result;
    }

    
	// worked, but not looks good, solution: Two sets
    public static int[] intersection11(int[] nums1, int[] nums2) {
        // Write your code here
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int val1 : nums1){
            set1.add(val1);
        }
        for(int val2 : nums2){
            set2.add(val2);
        }
        set1.retainAll(set2);
        
        int size = set1.size();
        int[] arr = new int[size];
        int i = 0;
        for(int val : set1){
            arr[i++] = val;
        }
        return arr;
    }


}
