package Lintcode.Array;

/**
Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Have you met this question in a real interview? Yes
Example
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].

Tags Expand 
Two Pointers Array Facebook


Related Problems Expand 
Easy Remove Element 31 %
Easy Remove Duplicates from Sorted Array II 

*
 */
public class Remove_Duplicates_from_Sorted_Array {

    //worked, 
    public int removeDuplicates(int[] A) {
        // write your code here
    // }
    // public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //size标记第几个不同的值，也就是新的数组index
        int pos = 0;
        //i从0到length或者从1到length都可以
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[pos]) {
                ++pos;//发现新的值，size++
                A[pos] = A[i];//新的值赋到size位置
            }
        }
        return pos + 1;//size+1即是长度或者个数
    }

    //worked as well
    public int removeDuplicates2(int[] A) {
        // write your code here
    // }
    // public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //size标记第几个不同的值，也就是新的数组index
        int size = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[size-1]) {
                ++size;//发现新的值，size++
                A[size-1] = A[i];//新的值赋到size位置
            }
        }
        return size;//size+1即是长度或者个数
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
