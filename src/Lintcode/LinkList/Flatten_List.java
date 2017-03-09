package Lintcode.LinkList;

import java.util.ArrayList;
import java.util.List;

/**

 Flatten List

 Description
 Notes
 Testcase
 Judge
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

 Notice

If the element in the given list is a list, it can contain list too.

Have you met this question in a real interview? Yes
Example
Given [1,2,[1,2]], return [1,2,1,2].

Given [4,[3,[2,[1]]]], return [4,3,2,1].

Challenge 
Do it in non-recursive.

Tags 
LintCode Copyright Recursion Non Recursio


 *
 */
public class Flatten_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<Integer>();
        flatten(result, nestedList);
        return result;
    }
    public List<Integer> flatten(List<Integer> result, List<NestedInteger> nestedList) {
        // Write your code here
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(result, ele.getList()));
        return result;
    }

    static class NestedIntegerImpl implements NestedInteger{

		@Override
		public boolean isInteger() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer getInteger() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<NestedInteger> getList() {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }
    public interface NestedInteger {
    	 
    	 // @return true if this NestedInteger holds a single integer,
    	 // rather than a nested list.
    	 public boolean isInteger();
    	 // @return the single integer that this NestedInteger holds,
    	 // if it holds a single integer
    	 // Return null if this NestedInteger holds a nested list
    	 public Integer getInteger();
    	 // @return the nested list that this NestedInteger holds,
    	 // if it holds a nested list
    	 // Return null if this NestedInteger holds a single integer
    	 public List<NestedInteger> getList();
    
    }
}