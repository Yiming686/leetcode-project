package Lintcode.Array.Permutation;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.StackInstruction;

/**
Permutations

Given a list of numbers, return all possible permutations.

Have you met this question in a real interview? Yes
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.

Tags Expand 
LinkedIn Recursion


Related Problems Expand 
Medium Print Numbers by Recursion 23 %
Medium Permutation Sequence 25 %
Medium Permutations II *
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int n = 3;
		for(int i = 1; i<=n; i++){
			nums.add(i);
		}
		permute(nums);
//		System.out.println(""+permute(nums));
	}
	
    //worked, recursvie solution£¬ TC is O(n!)
    public static  ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return result;
        // Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums);
        
        return result;
    }
    private static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums){
        if(list.size() == nums.size()){
        	ArrayList<Integer> list1 = new ArrayList<Integer>(list);
        	System.out.println(""+list1);
            result.add(list1);
            return;         
        }
        
        for(int i = 0; i < nums.size(); i++){
            if(!list.contains(nums.get(i))){
                list.add(nums.get(i));
                helper(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
    
    
    
    //non-recursive solution,not work
    public ArrayList<ArrayList<Integer>> permute44(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0) return result;
        // Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.size(); i++){
            int j = i;
            while(list.size() != nums.size()){
                // list.remove(list.size() - 1);
                Integer el = nums.get(j);
                if(!list.contains(el)){
                    list.add(el);
                }
                j = (++j)%nums.size();
            }
            // if(list.size() == nums.size()){
                result.add(new ArrayList<Integer>(list));
            // }

            list.clear();
        }
        return result;
    }
    
    
	public static void rotateMatrix(int input[][]) {
		int n = input.length;
		if (n <= 1)
			return;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = input[i][j];
				input[i][j] = input[n - j - 1][i];
				input[n - j - 1][i] = input[n - 1 - i][n - 1 - j];
				input[n - 1 - i][n - 1 - j] = input[j][n - 1 - i];
				input[j][n - 1 - i] = temp;
			}
		}
	}

}
