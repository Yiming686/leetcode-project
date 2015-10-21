package LeetCode.JavaArray;


/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

Hide Tags Array Two Pointers

 * 
 */
public class LC_088_Merge_Sorted_Array {
	
//	【思路】排好序的AB数组，从最大数组元素开始，
//	m，n的含义非常重要。目前nums1还有m个元素需要处理，nums2还有n个元素需要处理
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n>0){
        	if(m<=0 || nums1[m-1]<nums2[n-1]){
        		nums1[m+n-1] = nums2[--n];
        	}else{
        		nums1[m+n-1] = nums1[--m];
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
