package LeetCode.JavaArray;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Hide Tags Array Dynamic Programming

 */
public class LC_152_Maximum_Product_Subarray {

	    /**
	     * @param nums: an array of integers
	     * @return: an integer
	     */
//	Accepted, 最佳答案,最佳表述
    public int maxProduct5(int[] nums) {
        
        int local_max = nums[0];
        int local_min = nums[0]; 
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr_max = local_max * nums[i];
            int curr_min = local_min * nums[i];
            
            local_max = Math.max(Math.max(curr_max, curr_min), nums[i]);
            local_min = Math.min(Math.min(curr_max, curr_min), nums[i]);
            
            global = Math.max(global, local_max);
        }
        return global;
    }
//	Accepted, 最佳答案
    public int maxProduct4(int[] nums) {
        
        int max = nums[0];
        int min = nums[0]; 
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr_max = max * nums[i];
            int curr_min = min * nums[i];
            
            max = Math.max(Math.max(curr_max, curr_min), nums[i]);
            min = Math.min(Math.min(curr_max, curr_min), nums[i]);
           
            result = Math.max(result, max);
        }
        return result;
    }
	
    public int maxProduct3(int[] nums) {
        
	        int pre_min = nums[0]; 
	        int pre_max = nums[0];
	        int cur_min = nums[0]; 
	        int cur_max = nums[0];
	        int result = nums[0];
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] > 0) {
	                cur_max = Math.max(nums[i], pre_max * nums[i]);
	                cur_min = Math.min(nums[i], pre_min * nums[i]);
	            } else if (nums[i] < 0) {
	                cur_max = Math.max(nums[i], pre_min * nums[i]);
	                cur_min = Math.min(nums[i], pre_max * nums[i]);
	            }else{
	                 cur_max = 0;
	                 cur_min = 0;  
	            }
	            pre_min = cur_min;
	            pre_max = cur_max;
	           
	            result = Math.max(result, cur_max);
	        }
	        return result;
    }
//	both are the same
//	问题是连续乘积，这很关键
//	max[]表示以i结尾的乘积最大值
//	min[]表示以i结尾的乘积最小值
//    Input:  [-2,0,-1]
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
	    public int maxProduct2(int[] nums) {
	        int[] max = new int[nums.length];
	        int[] min = new int[nums.length];
	        
	        min[0] = max[0] = nums[0];
	        int result = nums[0];
	        for (int i = 1; i < nums.length; i++) {
	            min[i] = max[i] = nums[i];
	            if (nums[i] > 0) {
	                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
	                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
	            } else if (nums[i] < 0) {
	                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
	                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
	            }
	            
	            result = Math.max(result, max[i]);
	        }
	        
	        return result;
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
