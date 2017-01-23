package Lintcode.Array;


/*
Find Minimum in Rotated Sorted Array II

30:00
 Start
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
Given [4,4,5,6,7,0,1,2] return 0


 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] num = new int[]{3,4,5,1,1,1,1,1,2,2,3,3};

		int[] num = new int[]{3,3,3,3,3,3,3,3,22};
		System.out.println(""+findMin(num));
		System.out.println(""+findMinIndex(num));
	}

	
	//3.如果中间数等于数组第一个元素，需要特殊处理。
//  3.1 如果中间数大于数组最后一个元素，说明最小数存在后半段， 范围缩小到中间数到最后一个元素左开右闭区间
//  3.2 如果中间数等于数组最后一个元素，则需分别找出这第一个元素到中间数，和中间数到最后一个元素这两个区间的最小数，然后对这两个最小数进行比较，最后取最小值。
    
    //worked, 非递归解法, 有重复元素是找最小
    //从index的角度看，是找到最左边的那个最小元素
    public static int findMin(int[] num) {
        if(num == null || num.length == 0) return -1;
        int start = 0, end = num.length-1;
        while(start+1<end) {
            if(num[start] < num[end]) return num[start];
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                //特别处理当num[mid]==num[end]的情况
//                end--;
            	start++;
        }
        return num[start] <= num[end] ? num[start] : num[end];//等号很重要了
    }
    
    public static int findMinIndex(int[] num) {
        if(num == null || num.length == 0) return -1;
        int start = 0, end = num.length-1;
        while(start+1<end) {
        	System.out.println("start:end "+start + ":"+end);
//            if(num[start] < num[end]) return start;
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;//此处已经将右边的可能的最小值忽略了
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                //特别处理当num[mid]==num[end]的情况
//                end--;
            	start++;
        }
    	System.out.println("start:end "+start + ":"+end);
        return num[start] <= num[end] ? start : end;
    }


    //第二种解法：非递归解法
    //worked, 
    public int findMin23(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start < end){
            //下面一行，精彩之笔
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid有可能是min，所以得保留
            } else{
                start = mid + 1; //mid肯定不是min，不必保留
                // start = mid;   //Time Limit Exceeded, 错误
            }
        }
        return nums[start];
    }
    
    //worked, 非递归解法， 有重复元素是找最小
    public int findMin76(int[] num) {
        int start = 0, end = num.length-1;
        while(start<end) {
            if(num[start] < num[end]) return num[start];
            int mid = start + (end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;
            else if(num[mid]>num[end])
                start = mid + 1;
            else
                end--;
        }
        return num[start];
    }
    
    public int findMin33(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        
        // find the first element <= target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }


//worked
    public int findMin7(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end){
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[start]){
                start = mid + 1;  // mid有可能是min，所以得保留
            } else if(nums[mid] < nums[start]){
                end = mid; //mid肯定不是min，不必保留
                //start = mid;   //也是正确的，都可以通过
            }else{
                if(nums[mid] > nums[end]){
                    start = mid + 1;
                }else{
                    int min = nums[start];
                    for(int i = start + 1; i < end; i++){
                        min = Math.min(nums[i], min);
                    }
                    return min;
                }
            }
            
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
        
    }

//not worked, retest
    public int findMin99(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        // if(nums[start] < nums[end]) return nums[start];
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid有可能是min，所以得保留
            } else if(nums[mid] > nums[end]){
                start = mid + 1; //mid肯定不是min，不必保留
                //start = mid;   //也是正确的，都可以通过
            }else{
                end--;
                // if(nums[start] < nums[end])
                //     end = mid - 1;
                // else
                //     start = mid;
            }
            
        }
        return nums[start];
        // return nums[start] < nums[end] ? nums[start] : nums[end];
        
    }
    public int findMinNoDup(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid有可能是min，所以得保留
            } else{
                start = mid + 1; //mid肯定不是min，不必保留
                //start = mid;   //也是正确的，都可以通过
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

}
