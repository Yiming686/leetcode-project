package Lintcode.Array;

import java.util.LinkedList;
import java.util.Stack;

/**
Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Have you met this question in a real interview? Yes
Example
Given height = [2,1,5,6,2,3],
return 10.

Tags Expand 
Array Stack


Related Problems Expand 
Hard Max Tree

 *
 */
public class Largest_Rectangle_in_Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{2,1,5,5,5,6,2,3};
		System.out.println(""+largestRectangleArea(arr));
	}
	
	
	//worked
    public  static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();//既然等于都要pop(),那么stack对应的序列就是要严格递增
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = (i == heights.length) ? -1 : heights[i];
            //不空才能peek(), 小于可以计算，为什么等于也可以计算呢
            while (!stack.isEmpty() && currHeight <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                System.out.println(""+height * width);
                max = Math.max(max, height * width);
            }
            stack.push(i);
            System.out.println(""+stack);
        }
        
        return max;
    }

    //not worked
    public int largestRectangleArea3(int[] heights) {
        int max = 0;
        int temp = 0;
        int height = 0;
        int width = 0;
        int prevHeight = -1;
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for(int i = 1; i <= heights.length; i++){
            int curr = (i == heights.length)? -1 : heights[i];
            if(!stack.isEmpty() && heights[stack.peek()] <= curr){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && heights[stack.peek()] > curr){
                int right = stack.pop();
                height = heights[right];
                if(height == prevHeight){
                    width++;
                }else{
                    width = i - right - 1;
                }    
                temp = width * height;
                
                max = Math.max(max, temp);
                prevHeight = height;
                temp = 0;
            }
            if(i < heights.length) stack.push(i);
            
            prevHeight = -1;
            height = -1;
            width = 0;
        }
        return max;
    }

}
