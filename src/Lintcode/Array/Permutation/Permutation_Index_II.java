package Lintcode.Array.Permutation;

/**
 * 
Permutation Index II Show result 

Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given the permutation [1, 4, 2, 2], return 3.

Related Problems Expand 
Medium Next Permutation II 

*
 */
public class Permutation_Index_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
A:���Ҵ����ظ�Ԫ�������е����

�������ڲ��Ҳ������ظ�Ԫ����������ŵĻ���֮�ϣ�

��P(n) = P(n-1)+C(n-1)

C(n-1) = (��Ԫ��ΪС�ڵ�ǰԪ�أ�֮���ȫ����ֵ)
P(1) = 1;

���������ظ�Ԫ�ص�ȫ����ֵC(n-1) = (n-1)!*k(kΪ��Ԫ��֮��С�ڵ�ǰԪ�صĸ���)

�ڴ����ظ�Ԫ�ص�����������ȫ���е�ֵ���󷨱�Ϊ��

C(n-1) = (n-1)!/(A1!*A2!*������*Aj!)*k(����Ai Ϊ�ظ�Ԫ�صĸ�����kΪС����Ԫ��ǰ���ظ��ĸ���)

 * */


