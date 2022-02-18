package Lintcode.BinarySearch;

/**

Maximum Number in Mountain Sequence 

 Description
 Notes
 Testcase
 Judge
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10

Tags 
Binary Search
Related Problems 
Medium Find Peak Element

 *
 */
public class Maximum_Number_in_Mountain_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,8,6,3};
		System.out.println(""+mountainSequence(arr));
	}
    public static int mountainSequence(int[] nums) {
        // Write your code here
        // if(nums == null || nums.length == 0)
        int len = nums.length;
        int start = 0; 
        int end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return nums[mid];
            }else if(nums[mid] > nums[mid-1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return nums[start] > nums[end] ? nums[start] : nums[end];
    }

	// worked,
    public static int mountainSequence00(int[] nums) {
        // Write your code here
        // if(nums == null || nums.length == 0)
        int len = nums.length;
        int start = 0; 
        int end = len - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return nums[start] > nums[end] ? nums[start] : nums[end];
    }

    
}
