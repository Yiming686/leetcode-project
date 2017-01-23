package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Combination Sum

 Description
 Notes
 Testcase
 Judge
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Have you met this question in a real interview? Yes
 Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Tags 
Related Problems 
 *
 */
public class Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = new int[]{8,7,4,3};
		int target = 11;
		System.out.println(""+combinationSum(candidates, target));
	}

	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        //为什么path?它里面存储什么呢？
        ArrayList<Integer> path = new ArrayList<Integer>();
        //不sort也是可以的，但是题目要求输出结果的list是从小到大的,而且unique
//         Arrays.sort(candidates);
        //所有需要的数据，准备完毕！
        helper( result,  path, candidates, 0, target);
        return result;
    }

    //从数组caditates里面找出所有的和为target的组合list of path，从0开始
    //一种错误的思维方式是，直接想着怎么去找数据，进入了，又出不来
    //正确地是：如何巧妙递进式减少求解问题的规模，减一或者减半，这才是正解
     private static void helper(ArrayList<List<Integer>> result, ArrayList<Integer> path,int[] candidates, int index, int target) {
 		System.out.println(""+path);

        if(target < 0) return;//这句没有就ava.lang.StackOverflowError
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //因为假定数组全部为正数
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            //对于数组里面的值，如果和前面的一个值相等，跳过
            if(i!=index && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            //最大考点：经典问题就是对index参数的理解，到底是i还是i+1
            //如果把i位置的元素，放入了，index变为i+1,那就漏掉了很多想求的解
            //i位置保持不变，和循环变量一样，但是保证不是死循环呢
            //题目要求元素可重复多次，就体现在index取值为i上
            helper(result,path, candidates, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
    
    void helper3(ArrayList<List<Integer>> result, ArrayList<Integer> list, int[] candidates, int index,int target  
        ) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if(i!=index && candidates[i] == candidates[i-1]){
                continue;
            }

            list.add(candidates[i]);
            helper(result, list, candidates, i, target - candidates[i] );
            list.remove(list.size() - 1);

        }
    }

}
