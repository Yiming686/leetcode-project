package Lintcode.BinarySearch;

public class Find_Minimum_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr = new int[]{4, 5, 6, 7, 0, 1, 2};
		System.out.println(""+findMin(arr));
	}
	
    //只有两种曲线（类似问题考虑有几种曲线），然后看看mid和谁比较起点或者终点
    // 递归和非递归方法非常相似，非递归用while迭代变化中的start和end
    // 递归用if在递归调用中，check start和end，然后改变其中的一个
    // if和while语句，条件和block中的部分一模一样
    // findMin一定的澄清，null或者长度为0时，怎么返回？什么值被返回？
    // 请画出递归树
    
	//第一种解法：非递归解法
    //worked，寻找最小的非递归解法，和end点比较
    public int findMin2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            if(nums[start] < nums[end]) return nums[start];
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[end]){
                end = mid;  // mid有可能是min，所以得保留
            } else{
                start = mid + 1; //mid肯定不是min，不必保留
                //start = mid;   //因为至少三个元素，所以也是正确的，都可以通过
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

    //第二种解法：非递归解法
    //worked, as well
    public static int findMin(int[] nums) {
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
                // start = mid;   //当两个元素时，Time Limit Exceeded, 错误
            }
        }
        return nums[start];
    }
     
    //第三种解法：递归解法 
    //寻找最小的递归解法 
    public int findMin3(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length -1);
    }
    private int helper(int[] nums, int start, int end){
        if(nums == null || nums.length == 0) return -1;
        if(start + 1 >= end){
            return nums[start] < nums[end] ? nums[start] : nums[end];
        }
        int mid = start + (end - start)/2;
        if(nums[mid] < nums[end]){
            end = mid;
        } else{
            start = mid + 1;
        }
        return helper(nums, start, end);
    }


}
