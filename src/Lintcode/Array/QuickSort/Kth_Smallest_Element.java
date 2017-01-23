package Lintcode.Array.QuickSort;

import java.util.Arrays;

/**

Kth Smallest Element Show result 
其本质和 Kth Largest Element Show result 一模一样！
只不过改变一下 partition() 方法而已
把if(nums[i] <= pivot)， 变为  if(nums[i] >= pivot).

 *
 */
public class Kth_Smallest_Element {

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

    //返回left到right之间的index
    // 选定最后一个元素为pivot，然后从第一个遍历到倒数第二个，把大于等于这个元素的值依次放在最前面，找到了基本比pivot大的元素就返回最后一个index
    //其实就是把数组，分成两部分，左边大，右边小。pos指向左边最小的数
    private static int partition(int[] nums, int left, int right){
        // if(left == right) return right;
        int pivot = nums[right];
        int pos = left;//在下面的循环中，pos是待插入位置
        for(int i = left; i<=right; i++){
            if(nums[i] <= pivot){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }
        //此时index指向下一个插入的位置，范围：0--n-1
        // int temp = nums[index];
        // nums[index] = nums[right];
        // nums[right] = temp;
        return --pos;//此时pos指向最后一个大于等于pivot的元素,才是可能求解的元素
    }
    //在数组的此区间里面找数组的第k个最大元素，而不是基于left这个index的
    private static  int helper2(int[] nums, int left, int right, int k){
        int index = partition(nums, left, right); //first indexth found       
        if(index + 1 == k ) 
            return nums[index];//表明这就是第k个元素
        else if(index + 1 < k)
            return helper2(nums, index + 1, right, k);
            // return helper2(nums, index + 1, nums.length - 1, k);//也work
        else
            return helper2(nums, left, index - 1, k);
            // return helper2(nums, 0, index - 1, k);//也work
    }
    
    //called, 在数组里面找数组的第k个最大元素
    public static int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException();
        }
        //在数组的此区间里面找数组的第k个最大元素
        return helper2(nums, 0, nums.length - 1, k);
    }	
}
