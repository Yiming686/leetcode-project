package Lintcode.Array.Median;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int median(int[] nums) {  
	    int k = nums.length%2 == 0 ? nums.length/2-1 : nums.length/2;  
	    return helper(nums, 0, nums.length-1, k);  
	}  
	  
	static int helper(int[] nums, int left, int right, int k) {  
	    int pivot = right;  
	    int num = nums[pivot];  
	    int low = left, high = right;  
	      
	    while (low < high) {  
	        while (low < high && nums[low] < num) {  
	            low++;  
	        }  
	        while (low < high && nums[high] >= num) {  
	            high--;  
	        }  
	        swap(nums, low, high);  
	    }  
	    swap(nums, low, right);  
	  
	    if (low == k) {  
	        return nums[low];  
	    } else if (low < k) {  
	        return helper(nums, low+1, right, k);  
	    } else {  
	        return helper(nums, left, low-1, k);  
	    }  
	}  
	  
	static void swap(int[] num, int left, int right) {  
	    int tmp = num[left];  
	    num[left] = num[right];  
	    num[right] = tmp;  
	}  

}
