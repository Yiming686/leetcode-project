package Lintcode.String.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
Subsets Show result 

30:00
 Start
Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Challenge
Can you do it in both recursively and iteratively?

Tags Expand 
Recursion Facebook Uber


Related Problems Expand 
Medium Restore IP Addresses 18 %
Medium Subsets II
 *
 */
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //∏¥‘”∂»ƒÿ£ø
   public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
       // write your code here
   // }
   
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(nums == null || nums.length == 0) return result;
       
       ArrayList<Integer> list = new ArrayList<Integer>();
       Arrays.sort(nums);  

       helper(result, list, nums, 0);
       return result;
   }
   
   private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int start){
       
       result.add(new ArrayList<Integer>(list));
       // if(start == nums.length) return;

       // if(start >= S.size()) {
       //     result.add(list);
       //     return;
       // }

       for(int i = start; i < nums.length;  i++){
           // if(!list.contains(nums[start])){
               list.add(nums[i]);
               helper(result, list, nums, i + 1);
               list.remove(list.size()-1);
           // }
       }        
   }

}
