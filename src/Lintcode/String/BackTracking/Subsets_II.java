package Lintcode.String.BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
Subsets II

30:00
 Start
Given a list of numbers that may has duplicate numbers, return all possible subsets

Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Note
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Challenge
Can you do it in both recursively and iteratively?

Tags Expand 
Recursion


Related Problems Expand 
Medium Subsets

 *
 */
public class Subsets_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S){
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0) return result;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        //【考点】这里是考点
        Collections.sort(S);  

        helper(result, list, S, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int start){
        
        result.add(new ArrayList<Integer>(list));
        // if(start == S.size()) return;

        for(int i = start; i < S.size();  i++){
            //【考点】 前提是排序以后，才能这样判断，否则判断不了
            if ( i != start && S.get(i) == S.get(i - 1)) {
                continue;
            }    

            list.add(S.get(i));
            helper(result, list, S, i + 1);
            list.remove(list.size()-1);
        }        
    }


}
