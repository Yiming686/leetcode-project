package LeetCode.JavaArray;

import java.util.ArrayList;
import java.util.List;

/*
 Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

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
Hide Tags Array Backtracking Bit Manipulation

 */
public class LC_087_Subsets {

	
//	【错误点】  subsetsHelper(result, list, nums, i + 1);不能写成
//    subsetsHelper(result, list, nums, pos+1);


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(result, list, nums, 0);
        return result;
    }
    
	private void subsetsHelper(List<List<Integer>> result, List<Integer> list,
			int[] nums, int pos) {
		// TODO Auto-generated method stub
		result.add(new ArrayList<Integer>(list));
		
		for(int i = pos; i< nums.length; i++){
			list.add(nums[i]);
	        subsetsHelper(result, list, nums, pos+1);
	        list.remove(list.size() -1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
