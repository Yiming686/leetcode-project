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
Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
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
        //Ϊʲôpath?������洢ʲô�أ�
        ArrayList<Integer> path = new ArrayList<Integer>();
        //��sortҲ�ǿ��Եģ�������ĿҪ����������list�Ǵ�С�����,����unique
//         Arrays.sort(candidates);
        //������Ҫ�����ݣ�׼����ϣ�
        helper( result,  path, candidates, 0, target);
        return result;
    }

    //������caditates�����ҳ����еĺ�Ϊtarget�����list of path����0��ʼ
    //һ�ִ����˼ά��ʽ�ǣ�ֱ��������ôȥ�����ݣ������ˣ��ֳ�����
    //��ȷ���ǣ��������ݽ�ʽ�����������Ĺ�ģ����һ���߼��룬���������
     private static void helper(ArrayList<List<Integer>> result, ArrayList<Integer> path,int[] candidates, int index, int target) {
 		System.out.println(""+path);

        if(target < 0) return;//���û�о�ava.lang.StackOverflowError
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //��Ϊ�ٶ�����ȫ��Ϊ����
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            //�������������ֵ�������ǰ���һ��ֵ��ȣ�����
            if(i!=index && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            //��󿼵㣺����������Ƕ�index��������⣬������i����i+1
            //�����iλ�õ�Ԫ�أ������ˣ�index��Ϊi+1,�Ǿ�©���˺ܶ�����Ľ�
            //iλ�ñ��ֲ��䣬��ѭ������һ�������Ǳ�֤������ѭ����
            //��ĿҪ��Ԫ�ؿ��ظ���Σ���������indexȡֵΪi��
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
