package Lintcode.Array;

import java.util.Arrays;

/**
Maximum Gap Show result 

45:00
 Start
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Have you met this question in a real interview? Yes
Example
Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.

Note
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Challenge
Sort is easy but will cost O(nlogn) time. Try to solve it in linear time and space.

Tags Expand 
Greedy Sort


 *
 */
public class Maximum_Gap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 9, 2, 5};
//		int[] arr = {2147483647,0};
		
		System.out.println(""+maximumGap(arr));
	}
	
    //worked, but O(nlogn)
    public static int maximum4Gap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);        
        int maxGap = 0;	
        for(int i = 1; i< nums.length; i++){
            int gap = nums[i] - nums[i-1];
            if(gap>maxGap){
                maxGap = gap;
            }
        }
        return maxGap;
    }

	//worked,O(n) solution, 彻底明白了，分段，最大gap肯定不gap大，这是秘诀中的秘诀，由此产生了巧妙解法
    public static int maximumGap(int[] num) {
    	//第0步：当长度小于2，直接返回
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        //第一步：一个for循环求出最小值和最大值
        int min = num[0];
        int max = num[0];
        for (int val:num) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        // the minimum possibale gap, ceiling of the integer division
        //第二步：根据最小值和最大值和len，直接求出平均间隔gap，上升沿整数
        int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        //第三步：建立最小和最大bucket数组并初始化, 以备后用
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        //第四步：update最小最大bucket数组，注意当为最小值和最大值时，不用扔进bucket
        for (int val:num) {
            if (val == min || val == max)
                continue;
            int index = (val - min) / gap; // index of the right position in the buckets
            bucketsMIN[index] = Math.min(val, bucketsMIN[index]);
            bucketsMAX[index] = Math.max(val, bucketsMAX[index]);
        }
        // scan the buckets for the max gap
        //第五步：遍历最小最大bucket，暂时求出maxGap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        //第六步：记得还要用到max，和最大bucket的最后一位最大值，来更新maxGap
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    } 
	
    //not worked
    public static int maximumGap33(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int max = nums[0];
        for(int i = 1; i< nums.length; i++){
            int val = nums[i];
            if(val>max){
                max = val;
            }
        }
        int min = nums[0];
        for(int i = 1; i< nums.length; i++){
            int val = nums[i];
            if(val<min){
                min = val;
            }
        }
        //OutOfMemoryError, [2147483647,0]
        // int[] arr = max-min < Integer.MAX_VALUE ?new int[max-min+1] : new int[max-min] ;
        int len = (int)Math.ceil((double)(max-min)/(nums.length-1));//均分
        int[] arr = new int[len];
        for(int i = 0; i< nums.length; i++){
            int val = nums[i];
            if(val != min){
                arr[(val-min)%len] = val;
            }
        }
        int maxGap = 0;
        // int prev = Integer.MAX_VALUE;
        // for(int i = 1; i< arr.length; i++){
        //     if(arr[i] == 1){
        //         if(prev == Integer.MAX_VALUE){
        //             prev = i;
        //             continue;
        //         }
        //         int gap = i - prev;
        //         if(gap>maxGap){
        //             maxGap = gap;
        //         }
        //         prev = i;    
        //     }
        // }
        int prev = min;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]-prev > maxGap){
                maxGap = arr[i]-prev;
            }
            prev = arr[i];    
        }

        return maxGap -1;
    }
}
