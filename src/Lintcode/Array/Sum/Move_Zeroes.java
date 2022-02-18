
package Lintcode.Array.Sum;

import java.util.Arrays;

//Move Zeroes
//0，1，0，2，0，3，0，4，0
//变为
//1，2，3，4，0，0，0，0，0 （同向移动：指针都同左边开始找不等于0的值）
//0，0，0，0，0，1，2，3，4 （同向移动：指针都同右边开始找不等于0的值）
//4，3，2，1，0，0，0，0，0（异向移动：一个指针从右向左找不等于0的值）
//0，0，0，0，0，4，3，2，1（异向移动：一个指针从左向右找不等于0的值）

/**

Move Zeroes 

 Description
 Notes
 Testcase
 Judge
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Notice

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Have you met this question in a real interview? Yes
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Tags 
Related Problems 
Easy Remove Element 30 %

 *
 */
public class Move_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0};
		moveZeroes123400000(arr);
		System.out.println("123400000: "+Arrays.toString(arr));
		arr = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0};
		moveZeroes000001234(arr);
		System.out.println("000001234: "+Arrays.toString(arr));
		arr = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0};
		moveZeroes432100000(arr);
		System.out.println("432100000: "+Arrays.toString(arr));
		arr = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0};
		moveZeroes000004321(arr);
		System.out.println("000004321: "+Arrays.toString(arr));
	}

    private static void moveZeroes000004321(int[] nums) {
		// TODO Auto-generated method stub
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int count = 0;//Minimize the total number of operations.
        
        int left = len - 1, right = len - 1;
        while(left >= 0){
            if(nums[left] != 0){
            	count++;
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            left--;
        }
        left = len - count;
        right = len - 1;
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }

	}

	private static void moveZeroes432100000(int[] nums) {
		// TODO Auto-generated method stub
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int count = 0;//Minimize the total number of operations.
        
        int left = 0, right = 0;
        while(right < len){
            if(nums[right] != 0){
            	count++;
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        left = 0;
        right = count - 1;
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
	}

	private static void moveZeroes000001234(int[] nums) {
		// TODO Auto-generated method stub
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int left = len - 1, right = len - 1;
        while(left >= 0){
            if(nums[left] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            left--;
        }

	}

	public static void moveZeroes123400000(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int left = 0, right = 0;
        while(right < len){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }


}
