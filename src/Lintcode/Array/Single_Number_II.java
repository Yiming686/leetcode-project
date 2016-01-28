package Lintcode.Array;

/**
Single Number II

Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant extra space.

Tags Expand 
Greedy


Related Problems Expand 
Medium Single Number III 33 %
Easy Single Number 57 %
Medium Majority Number III 25 %
Medium Majority Number II 27 %
Easy Majority Number

 *
 */
public class Single_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += (A[j] >> i) & 1;//第i位置有多少个1,放在bits的第i位置上
                // bits[i] %= 3;
            }
            bits[i] %= 3;//应该是3的倍数,bits[i]变为0，1了，不可能为2
            // result |= (bits[i] << i);//二进制位的值，化为十进制
            result += (bits[i] << i);//这个也可以，二进制位的值，化为十进制
        }
        // for (int i = 0; i < 32; i++) {
        //     result |= (bits[i] << i);
        // }
        return result;
    }

}
