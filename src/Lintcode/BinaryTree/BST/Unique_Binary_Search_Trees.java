package Lintcode.BinaryTree.BST;

/**
Unique Binary Search Trees Show result 

30:00
 Start
Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

Have you met this question in a real interview? Yes
Example
Given n = 3, there are a total of 5 unique BST's.

1           3    3       2      1
 \         /    /       / \      \
  3      2     1       1   3      2
 /      /       \                  \
2     1          2                  3
Tags Expand 
Catalan Number Dynamic Programming


Related Problems Expand 
Medium Generate Parentheses 29 %
Easy First Position of Target

 *
 */
public class Unique_Binary_Search_Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numTrees(3);
	}

    public static int numTrees(int n) {
        // write your code here
        //���壺dp[i]��ʾ����i���ڵ������������ʵ�ֵĶ����������и���
        //i���ڵ㣺��߿���0��i-1���ڵ㣬�ұ�Ҳ�п���0��i-1���ڵ�
        //��Զ��ֿ�����ͼ���
        int[] count = new int[n+1];
        count[0] = 1;
        // count[1] = 1;
        // count[2] = 2;
        for(int i=1;  i<= n; i++){
            for(int j=0; j<i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }

}
