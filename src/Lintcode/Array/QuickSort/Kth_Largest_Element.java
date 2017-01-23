package Lintcode.Array.QuickSort;

import java.util.Arrays;

/**
Kth Largest Element Show result 

Find K-th largest element in an array.

Have you met this question in a real interview? Yes
Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Note
You can swap elements in the array

Challenge
O(n) time, O(1) extra memory.

Tags Expand 
Quick Sort Sort


Related Problems Expand 
Medium Kth Smallest Number in Sorted Matrix

 *
 */
public class Kth_Largest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 9, 2, 4, 7, 3, 7, 10};
//		int[] arr = {3};
//		int[] arr = {3, -3};
//		int[] arr = { 3,3,3,6,3,6,3,6,3,6,6,6,6};
		int[] arr = { 9, 2, 4, 7, 3, 7, 10, 2, 3};
		System.out.println(Arrays.toString(arr));
 
		int left = 0;
		int right = arr.length - 1;
		int k = 1;
//		int k = 2;
//		int k = 3;
//		int k = 4;
//		int k = 5;
		System.out.println(kthLargestElement(k, arr));

	}

    //����left��right֮���index
    // ѡ�����һ��Ԫ��Ϊpivot��Ȼ��ӵ�һ�������������ڶ������Ѵ��ڵ������Ԫ�ص�ֵ���η�����ǰ�棬�ҵ��˻�����pivot���Ԫ�ؾͷ������һ��index
    //��ʵ���ǰ����飬�ֳ������֣���ߴ��ұ�С��posָ�������С����
    private  static int partition(int[] nums, int left, int right){
        // if(left == right) return right;
        int pivot = nums[right];
        int pos = left;//�������ѭ���У�pos�Ǵ�����λ��
        for(int i = left; i<=right; i++){
            if(nums[i] >= pivot){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }
        //��ʱindexָ����һ�������λ�ã���Χ��0--n-1
        // int temp = nums[index];
        // nums[index] = nums[right];
        // nums[right] = temp;
        return --pos;//��ʱposָ�����һ�����ڵ���pivot��Ԫ��,���ǿ�������Ԫ��
    }
    //������Ĵ���������������ĵ�k�����Ԫ�أ������ǻ���left���index��
    private static int kthLargestElement(int[] nums, int left, int right, int k){
        int index = partition(nums, left, right); //first indexth found       
        if(index + 1 == k ) 
            return nums[index];//��������ǵ�k��Ԫ��
        else if(index + 1 < k)
            return kthLargestElement(nums, index + 1, right, k);
            // return helper2(nums, index + 1, nums.length - 1, k);//Ҳwork
        else
            return kthLargestElement(nums, left, index - 1, k);
            // return helper2(nums, 0, index - 1, k);//Ҳwork
    }
    
    //called, ����������������ĵ�k�����Ԫ��
    public static int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException();
        }
        //������Ĵ���������������ĵ�k�����Ԫ��
        return kthLargestElement(nums, 0, nums.length - 1, k);
    }	
}
