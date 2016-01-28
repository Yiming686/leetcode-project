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
A:查找存在重复元素中排列的序号

这道题基于查找不存在重复元素中排列序号的基础之上，

即P(n) = P(n-1)+C(n-1)

C(n-1) = (首元素为小于当前元素，之后的全排列值)
P(1) = 1;

而不存在重复元素的全排列值C(n-1) = (n-1)!*k(k为首元素之后小于当前元素的个数)

在存在重复元素的排列中首先全排列的值的求法变为：

C(n-1) = (n-1)!/(A1!*A2!*···*Aj!)*k(其中Ai 为重复元素的个数，k为小于首元素前不重复的个数)

 * */


