package Lintcode.Array.String.DP;

import java.util.ArrayList;

/**
Minimum Adjustment Cost Show result 

Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Have you met this question in a real interview? Yes
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Note
You can assume each number in the array is a positive integer and not greater than 100.

Tags Expand 
LintCode Copyright Dynamic Programming Backpack 

*
 */
public class Minimum_Adjustment_Cost {

    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
        	return 0;
        }

        int curMinCost[] = new int[101]; //curMinCost[v]: the min cost in A[0..i] if A[i] is changed to v
        int lastMinCost[] = new int[101]; //lastMinCost[v]: the min cost in A[0..i - 1] if A[i - 1] is changed to v

        //initialize
        for (int v = 1; v <= 100; v++) {
        	curMinCost[v] = Math.abs(v - A.get(0));
        }

	    //curMinCost[curV]  ��ʾԪ��A[i]  Ҫ��ΪcurV ��Ҫ��������С�ɱ�
        //lastMinCost[lastV]��ʾԪ��A[i-1]Ҫ��ΪlastV��Ҫ��������С�ɱ�
        //����dpע�⵱ǰi��i-1�����𣬵�ǰ���������iʱ�̵Ļ���i-1ʱ�̵�
        for (int i = 1; i < A.size(); i++) {
        	System.arraycopy(curMinCost, 1, lastMinCost, 1, 100);
        	for (int curV = 1; curV <= 100; curV++) {
        	    //A�е�i��ֵ��Ҫ��ΪcurV��Ҫ�Ĵ��ۣ���ʼ��Ϊ�������ֵ
        	    //��ô���أ�����ǰ��һ�����п��ܵı仯���ҵ���С��
        	    //lastMinCost[lastV]Ϊǰ��һ��ֵ��ΪLastV�Ĵ��ۼ��ϵ�ǰA[i]��ΪcurV�Ĵ���
        	    //curMinCost����Ҫ��lastMinCost��������滻�����һ��curMinCost���鼴�������
        	    curMinCost[curV] = Integer.MAX_VALUE;
        		for (int lastV = 1; lastV <= 100; lastV++) {
        			if (Math.abs(curV - lastV) > target) {
        				continue;
        				// break; //����Ϊbreak��ֻ��continue��
        			}
        			curMinCost[curV] = Math.min(curMinCost[curV], lastMinCost[lastV] + Math.abs(curV - A.get(i)));
        		}
        	}
        }
        //�ҵ�curMinCost�����е���Сֵ�������������С�ɱ�
        int min = Integer.MAX_VALUE;
        for (int v = 1; v <= 100; v++) {
        	min = Math.min(min, curMinCost[v]);
        }

        return min;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
