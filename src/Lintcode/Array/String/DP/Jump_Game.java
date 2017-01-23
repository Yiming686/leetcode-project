package Lintcode.Array.String.DP;

/**
Jump Game

 Description
 Notes
 Testcase
 Judge
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2).

We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

Have you met this question in a real interview? Yes
Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Tags 
Greedy Dynamic Programming Array
Related Problems 
Medium Jump Game II 35 %

 *
 */
public class Jump_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{2,3,1,1,4};
		int[] arr2 = new int[]{3,2,1,0,4,5};
		System.out.println(""+canJump(arr1));
		System.out.println(""+canJump(arr2));
	}

//	DP算法
//	错错错：canJump[i]表示是否可以从i跳到n-1， 默认false
//	对对对：canJump[i]表示是否可以跳到i， 起点默认true, 其他默认false
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        
        boolean[] canJump = new boolean[len];
        canJump[0] = true;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && j + nums[j] >= i){
                    canJump[i] = true;
                    break;
                }
            }
            //此句可加上，优化
            // if(can[i] == false)return false;

        }
        return canJump[len - 1];
   }

//    greedy 算法
    public static boolean canJump3(int[] A) {
        // think it as merging n intervals
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = 0 + A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i > farthest) {//i可达，并且从i计算出的farthest更大
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }

}
