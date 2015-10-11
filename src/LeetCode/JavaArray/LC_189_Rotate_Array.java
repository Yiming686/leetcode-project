package LeetCode.JavaArray;

import JavaBasics.Java_Swap;
import LeetCode.ArrayBuilder;
import LeetCode.ArrayPrinter;
/*
 *
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

�����⣺����������������ظ�Ԫ����
�����κνⷨ������Ҫ�����K����K ��ΪK1.��Զ�ǵ�Kֵ���ܴܺ�ܴ�

 */
public class LC_189_Rotate_Array {

	// TC is O(n), SC is O(n), need O(n) space
	public void rotate_array_ON(int[] nums, int k) {
		if (nums == null)
			return;
		int len = nums.length;
		if (len < 1)
			return;
		int[] nums2 = new int[2 * len];
		for (int i = 0; i < 2 * len; i++) {
			nums2[i] = nums[i % len];
		}
		// k������ܴܺ󣬴���KΪk1����Ҫ
		int k1 = k % len;
//		����ͷ�����������nums�Ǵ�nums2�ĵڶ��Σ����������ƶ��������Ƿ�֮��
//		����������±꣬�������forѭ���һ���Ǵ�0��len-1��һ����len-k1��2len-1-k1�� 
		for (int i = 0; i < len; i++) {
			nums[i] = nums2[len - k1 + i];
		}
		return;
	}

	// TC is O(n), SC is O(1), NOT need O(n) space
//	Accepted, 320ms, {250, 320,450} 
	public void rotate_array_O1(int[] nums, int k) {

		if (nums == null)
			return;
		int len = nums.length;
		if (len == 0)
			return;
		//���Թ��ص㿼�죬��K�Ĵ���
        int k1 = k%len;
		int left = 0;
		int right = len - 1;
	    while(left < right){
	        swap(nums,left++, right--);
	    }
		left = 0;
		right = k1 - 1;
	    while(left < right){
	        swap(nums,left++, right--);
	    }
	    left = k1;
		right = len - 1;
	    while(left < right){
	        swap(nums,left++, right--);
	    }
	}
	public void swap(int[] nums, int i1, int i2) {
		// TODO Auto-generated method stub

		nums[i1] = nums[i1] ^ nums[i2];
		nums[i2] = nums[i1] ^ nums[i2];
		nums[i1] = nums[i1] ^ nums[i2];
        return;
	}
	


	public static void rotate(int[] nums, int k) {
		ArrayPrinter.printIntegerArray(nums);
		int len = nums.length;
		int k1 = k % len;

		for (int i1 = 0; i1 < len; i1++) {
			int i2 = (i1 + k1) % len;
			// swap(nums, i1, len - k1);
			System.out.println(nums[i2]);
		}
		ArrayPrinter.printIntegerArray(nums);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = ArrayBuilder.createIntegerArray_NoDups(5, 1, 5);

		rotate(nums, 2);
	}

}
