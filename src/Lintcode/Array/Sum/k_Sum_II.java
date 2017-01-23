package Lintcode.Array.Sum;

import java.util.ArrayList;
import java.util.List;

/**
k Sum II Show result 

30:00
 Start
Given n unique integers, number k (1<=k<=n) and target.

Find all possible k integers where their sum is target.

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5. Return:

[
  [1,4],
  [2,3]
]
Tags Expand 
LintCode Copyright Depth First Search


Related Problems Expand 
Hard k Sum

 *
 */
public class k_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,2,3,4};
		int[] arr = {1,4,3,2, 0,5};
		System.out.println(""+kSumII(arr, 2, 5));
	}

    //����֮��������Ŀ��׼ȷʱ�临�Ӷ�Ϊ��O(N,K) = O(Cn1+Cn2+...+Cnk)
    // Ҳ����N��Ԫ��ȡ1������+ȡ2��������+...+ȡk�������е��ܺ�
    // if k=1, it is O(N);if k=2, it is O(N^2);if k=3, it is O(N^3);
    // but if k=N, it is NOT O(N^N), it is O(2^N)
	
    public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(A,0, k, target, path, result);
        return result;
    }
    //��0λ�õ�len-1��ÿһ��λ�ÿ�ʼ��������k��Ԫ��
    //�ݹ����target, k, start, path�Ƚ�����
    private static void helper(int A[], int start, int k,  int target, List<Integer> path, List<ArrayList<Integer>> result) {
        //����������������ͬʱ������������
        if (k == 0 && target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //3 lines below are optional
        if (k <= 0 || target <= 0) {
            return;
        }
        for(int i = start; i < A.length; ++i) {
            path.add(A[i]);
            helper(A, i + 1, k - 1,  target - A[i], path, result);
            path.remove(path.size() - 1);
        }
    }
	
}
