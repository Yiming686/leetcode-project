package Lintcode.BinaryTree;

import java.util.ArrayList;

/**
Construct Binary Tree from Inorder and Postorder Traversal Show result 

Given inorder and postorder traversal of a tree, construct the binary tree.

Have you met this question in a real interview? Yes
Example
Given inorder [1,2,3] and postorder [1,3,2], return a tree:

  2
 / \
1   3
Note
You may assume that duplicates do not exist in the tree.

Tags Expand 
Binary Tree
 *
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
        	return 0;
        }

        int curMinCost[] = new int[101]; //curMinCost[v]: the min cost in A[0..i] if A[i] is changed to v
        int lastMinCost[] = new int[101]; //lastMinCost[v]: the min cost in A[0..i - 1] if A[i - 1] is changed to v

        //initialize,��ʼ��״̬curMinCost[0]
        for (int v = 1; v <= 100; v++) {
        	curMinCost[v] = Math.abs(v - A.get(0));
        }

	    //curMinCost[curV]  ��ʾԪ��A[i]  Ҫ��ΪcurV ��Ҫ��������С�ɱ�
        //lastMinCost[lastV]��ʾԪ��A[i-1]Ҫ��ΪlastV��Ҫ��������С�ɱ�
        //����dpע�⵱ǰi��i-1�����𣬵�ǰ���������iʱ�̵Ļ���i-1ʱ�̵�
        for (int i = 1; i < A.size(); i++) {
            //�ѳ�ʼ��״̬curMinCost[0]����lastMinCost[0]
            //�����µĵ��ƹ�ϵ�������µ�״̬curMinCost[i]
            //���curMinCost[A.size()-1]��Ϊ���״̬
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
        //��������״̬curMinCost[A.size()-1]���㣬��������ֵ
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
