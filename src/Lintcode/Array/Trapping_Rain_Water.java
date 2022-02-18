package Lintcode.Array;

/**
Trapping Rain Water

30:00
 Start
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge
O(n) time and O(1) memory

O(n) time and O(n) memory is also acceptable.

Tags Expand 
Two Pointers Forward-Backward Traversal Array


Related Problems Expand 
Medium Container With Most Water

 *
 */
public class Trapping_Rain_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(""+trapRainWater(arr));
	}

	
    //best solution than jiuzhang, very clear
    public static int trapRainWater(int[] height) {  
        if (height == null || height.length < 3) return 0;  //少于三个没意义
          
        int max = 0;  
        int left = 0, right = height.length - 1;  
          
        // find the left and right edge which can hold water  
        while (left < right && height[left] <= height[left + 1]) left++;  //1, length - 1
        while (left < right && height[right] <= height[right - 1]) right--;  //1, length - 1
//        System.out.println("l:r "+l+":"+r);

        while (left < right) {
            System.out.println("l:r "+left+":"+right);
            int leftHeight  = height[left];  
            int rightHeight = height[right];  
//            System.out.println("left:right "+left+":"+right);
            if (leftHeight <= rightHeight) {  
                // add volum until an edge larger than the left edge  
                // l++;
                while (left < right && leftHeight >= height[++left]) {  //等号必须的，否则Time Limit Exceeded
//                    System.out.println("left:right "+left+":"+right);
                    max += leftHeight - height[left];  
                    System.out.println("l<r::l:r:A[l]:left:right:ans "+left+" : "+right+" : "+height[left]+" : "+leftHeight+" : "+rightHeight+" : "+max);

                    // l++;
                }  
            } else {  
                // add volum until an edge larger than the right volum  
                while (left < right && height[--right] <= rightHeight) {  
                    max += rightHeight - height[right];  
                    System.out.println("l>=r::l:r:A[l]:left:right:ans "+left+" : "+right+" : "+height[left]+" : "+leftHeight+" : "+rightHeight+" : "+max);
                }  
            }  
        }  
        return max;  
    }  
}
