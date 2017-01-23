package LeetCode.JavaArray;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/*
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

Hide Tags Array Stack

 * 
 */

public class LC_083_Largest_Rectangle_in_Histogram { 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,1,5,6,2,3};
		int[] arr = {2,1,5,9,9,2,3};
		System.out.println(""+largestRectangleArea(arr));
	}

	
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            System.out.println(MessageFormat.format("index:{0}, height:{1}", i, curt));
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
            	int pop = stack.pop();
            	int peek = -999;
                int h = height[pop];
                int w = stack.isEmpty() ? i : i - (peek = stack.peek()) - 1;
                System.out.println(MessageFormat.format("i:{0},pop:{1}, peek:{2}, h:{3}, w:{4}",i,pop,peek,h,w));
                max = Math.max(max, h * w);
            }
            stack.push(i);
            System.out.println(MessageFormat.format("stack:{0}",Arrays.toString(stack.toArray())));
        }
        
        return max;
    }

}
