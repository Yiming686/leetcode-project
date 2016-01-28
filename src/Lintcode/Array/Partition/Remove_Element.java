package Lintcode.Array.Partition;

/**
Remove Element Show result 

Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

Have you met this question in a real interview? Yes
Example
Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]

Tags Expand 
Two Pointers Array


Related Problems Expand 
Easy Remove Duplicates from Sorted Array II 30 %
Easy Remove Duplicates from Sorted Array

 *
 */
public class Remove_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int removeElement(int[] nums, int elem) {
        return partitionArray(nums, elem);
    }
    //Best solution, 几乎和 partitionArray一个题目
    //仅仅if(nums[left]>=k) 变为if(nums[left] == k)了
    public int partitionArray(int[] nums, int k) {
	    //write your code here
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        //left指向待分析元素，right指向待插入位置
        while(left <= right){
            if(nums[left] == k){
                //3lines below, Best
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                //3lines below, sometime not worked
                // nums[left] ^= nums[right];
                // nums[right] ^= nums[left];
                // nums[left] ^= nums[right];
                
                 right--;
            }else{
                left++;
            }
        }
        return left;
        //4 lines below, not best
        // if(nums[left] >= k ) 
        //     return left;
        // else
        //     return left + 1;
    }
	
}
