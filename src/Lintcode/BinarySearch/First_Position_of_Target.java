package Lintcode.BinarySearch;

public class First_Position_of_Target {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{3,5,7};
		int target =7;
		System.out.println(""+binarySearch(arr, target));

	}
    public static int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        return helper(nums, start, end, target);
    }
    private static int helper(int[] nums, int start, int end, int target){
        if(nums == null || nums.length == 0) return -1;
        if(target < nums[start] || target > nums[end]) return -1;
        if(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) 
                end = mid;//must be end, not start
            else if(nums[mid] < target)
                start = mid + 1;
            else{
                end = mid - 1;
            }
            return helper(nums, start, end, target);
        }
        //先start后end，次序不可颠倒
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

}
