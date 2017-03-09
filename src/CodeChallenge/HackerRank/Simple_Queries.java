package CodeChallenge.HackerRank;

import java.util.Arrays;

public class Simple_Queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,10,5,4,8};
		int[] maxes = {3,1,7,8};
		System.out.println(""+Arrays.toString(counts(nums, maxes)));
		nums = new int[]{1,4,2,4};
		maxes = new int[]{3,5,4};
		System.out.println(""+Arrays.toString(counts(nums, maxes)));
	}	
	
    static int[] counts(int[] nums, int[] maxes) {
        if(nums == null || nums.length == 0 || maxes == null || maxes.length == 0){
            throw new IllegalArgumentException();
        }
        int[] result = new int[maxes.length];
        int index = 0;        
        Arrays.sort(nums);        
        for(int num : maxes){
			result[index++] = searchLastInsertPos(nums, num);
		}		
		return result;
    }


    public static int searchLastInsertPos(int[] nums, int num) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(num < nums[0]) return 0;
        if(num > nums[nums.length-1]) return nums.length;
        int start = 0, end = nums.length - 1;
        while (start +1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == num) {
                start = mid;
            } else if (nums[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (num < nums[start]) {
        	return start;
        }else if(num < nums[end]){
        	return end; 
        }else{
        	return end + 1;
        }
    }
//    Given a sorted array and a target value, return the index if the target is found. If not, 
//    return the index where it would be if it were inserted in order.
//You may assume NO duplicates in the array.
//    和Search Insert Position仅仅三处区别
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid; //区别一
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (A[start] >= target) { //区别二
            return start;
        } else if (A[end] >= target) {//区别三
            return end;
        } else {
            return end + 1;//考虑超出数组长度的情况
        }
    }

}
