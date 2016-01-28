package Lintcode.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
Data Stream Median

Numbers keep coming, return the median of numbers at every time a new number added.

Have you met this question in a real interview? Yes
Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge
Total run time in O(nlogn).

Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Tags Expand 
LintCode Copyright Heap Priority Queue Google


Related Problems Expand 
Easy Median 21 %
Hard Median of two Sorted Arrays

 *
 */
public class Data_Stream_Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr2 = {4, 5, 1, 3, 2, 6, 0};
		int[] arr3 = {2, 20, 100};
//		System.out.println(""+Arrays.toString(arr));
//		System.out.println(""+Arrays.toString(medianII(arr)));
//		
//		System.out.println(""+Arrays.toString(arr2));
//		System.out.println(""+Arrays.toString(medianII(arr2)));
//
//		System.out.println(""+Arrays.toString(arr3));
//		System.out.println(""+Arrays.toString(medianII(arr3)));

		System.out.println(""+Arrays.toString(arr));
		System.out.println(""+Arrays.toString(medianIII(arr)));
		
		System.out.println(""+Arrays.toString(arr2));
		System.out.println(""+Arrays.toString(medianIII(arr2)));

		System.out.println(""+Arrays.toString(arr3));
		System.out.println(""+Arrays.toString(medianIII(arr3)));
	}
	
    public static int[] medianII(int[] nums) {
        // write your code here
        //edge cases
        if(nums == null || nums.length == 0) return null;
        //new datastructure
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        int[]  result = new int[nums.length];
        //initiate 
        int median = nums[0];
        result[0] = nums[0];
        //iterate each element
        for(int i = 1; i < nums.length; i ++){
            int curr = nums[i];
            //第一步，比较送入堆中
            if(curr < median){
                maxHeap.offer(curr);
            }else{
                minHeap.offer(curr);
            }
            //第二步，均衡两个堆同时可能改变median
            //median取得是中间或者中间偏小的值，所以一旦maxHeap大于minHeap，立即调整改变median值
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(median);
                median = maxHeap.poll();
            }else if(maxHeap.size() + 1 < minHeap.size()){
                maxHeap.offer(median);
                median = minHeap.poll();
            }
            System.out.println(""+median);
            result[i] = median;
        }
        return result;
    }

    //高级题目了，真是要求median了
    public static double[] medianIII(int[] nums) {
        // write your code here
        //edge cases
        if(nums == null || nums.length == 0) return null;
        //new datastructure
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        double[]  result = new double[nums.length];
        //initiate 
        int median = nums[0];
        result[0] = nums[0];
        //iterate each element
        for(int i = 1; i < nums.length; i ++){
        	int curr = nums[i];
        	//第一步，比较后，送入堆中
        	if(curr < median){
        		maxHeap.offer(curr);
        	}else{
        		minHeap.offer(curr);
        	}
        	//第二步，均衡两个堆同时可能改变median
        	//median取得是中间或者中间偏小的值，所以一旦maxHeap大于minHeap，立即调整改变median值
        	if(maxHeap.size() > minHeap.size()){
        		minHeap.offer(median);
        		median = maxHeap.poll();
        	}else if(maxHeap.size() + 1 < minHeap.size()){
        		maxHeap.offer(median);
        		median = minHeap.poll();
        	}
        	System.out.println(""+median);
        	if(i%2 ==0){
	            result[i] = median;
        	}else{
	            if(maxHeap.size() > minHeap.size()){
	            	result[i] = (median + maxHeap.peek())/2.0 ;
	            }else{
	            	result[i] = (median + minHeap.peek())/2.0 ;
	            }
        	}
        }
        return result;
    }

}
