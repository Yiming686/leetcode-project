package LeetCode.JavaArray;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Hide Tags Array Hash Table

 */
public class LC_217_Contains_Duplicate_I {

//	Accepted,
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i< nums.length; i ++){
            set.add(nums[i]);
            if(set.size() != i + 1)
                return true;
        }
        return false;

    }
    
//	Accepted,
    public boolean containsDuplicate3(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(Integer el : nums){
            set.add(el);
        }
        if(set.size() == nums.length)
            return false;
        else 
            return true;
    }
	
}
