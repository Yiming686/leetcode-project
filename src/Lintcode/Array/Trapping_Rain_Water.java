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
    public static int trapRainWater(int[] A) {  
        if (A == null || A.length < 3) return 0;  
          
        int ans = 0;  
        int l = 0, r = A.length - 1;  
          
        // find the left and right edge which can hold water  
        while (l < r && A[l] <= A[l + 1]) l++;  //1, length - 1
        while (l < r && A[r] <= A[r - 1]) r--;  //1, length - 1
//        System.out.println("l:r "+l+":"+r);

        while (l < r) {
            System.out.println("l:r "+l+":"+r);
            int left  = A[l];  
            int right = A[r];  
//            System.out.println("left:right "+left+":"+right);
            if (left <= right) {  
                // add volum until an edge larger than the left edge  
                // l++;
                while (l < r && left >= A[++l]) {  //等号必须的，否则Time Limit Exceeded
//                    System.out.println("left:right "+left+":"+right);
                    ans += left - A[l];  
                    System.out.println("l<r::l:r:A[l]:left:right:ans "+l+" : "+r+" : "+A[l]+" : "+left+" : "+right+" : "+ans);

                    // l++;
                }  
            } else {  
                // add volum until an edge larger than the right volum  
                while (l < r && A[--r] <= right) {  
                    ans += right - A[r];  
                    System.out.println("l>=r::l:r:A[l]:left:right:ans "+l+" : "+r+" : "+A[l]+" : "+left+" : "+right+" : "+ans);
                }  
            }  
        }  
        return ans;  
    }  
}
