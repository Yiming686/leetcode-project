package Lintcode.Array;

import java.util.ArrayList;
import java.util.List;

/**

Single Number III Show result 

Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.

Tags Expand 
Greedy LintCode Copyright


Related Problems Expand 
Medium Single Number II 38 %
Easy Single Number 57 %
Medium Majority Number III 25 %
Medium Majority Number II 27 %
Easy Majority Number

 *
 *
 */
public class Single_Number_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        int xor = 0;

		Integer xor = 10;
        System.out.println(""+Integer.toBinaryString(xor));
        System.out.println(""+Integer.toBinaryString(xor & (xor - 1)));
        System.out.println(""+Integer.toBinaryString(xor ^ (xor & (xor - 1))));

        Integer lastBit = xor ^ (xor & (xor - 1));//也可以这样，找相异的最后一个bit
//        System.out.println(""+Integer.lowestOneBit(lastBit));
        System.out.println(""+Integer.toBinaryString(lastBit));
	}
	
	
    //这个是看明白了？ 
    public List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];//标记了二个数字相异的位置
        }
        
        // int lastBit = xor - (xor & (xor - 1));//找到相异的最后一个bit
        int lastBit = xor ^ (xor & (xor - 1));//也可以这样，找相异的最后一个bit
        //利用此来分组，二个2n+1组，转换为2n+1问题了
        int group0 = 0, group1 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((lastBit & A[i]) == 0) {
                group0 ^= A[i];
            } else {
                group1 ^= A[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }
 
     //哪里来的solution？
    public List<Integer> singleNumberIII8(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {  
            return null;  
        }  
        List<Integer> list = new ArrayList<Integer>();
        int res[] = new int[2];  
        int diff = 0;  
        for (int i = 0; i < A.length; i++) {  
            diff ^= A[i];  
        }  
          
        int diffPos = 0;  
        for (int i = 0; i < 32; i++) {  
            if ((diff >> i & 1) == 1) diffPos = i;  
        }  
          
        ArrayList<Integer> A1 = new ArrayList<Integer>();  
        ArrayList<Integer> A2 = new ArrayList<Integer>();  
        for (int i = 0; i < A.length; i++) {  
            if ((A[i] >> diffPos & 1) == 1) {  
                A1.add(A[i]);  
            } else {  
                A2.add(A[i]);  
            }  
        }  
          
        for (int i = 0; i < A1.size(); i++) {  
            res[0] ^= A1.get(i);  
        }  
        for (int i = 0; i < A2.size(); i++) {  
            res[1] ^= A2.get(i);  
        }  
        list.add(res[0]);
        list.add(res[1]);
        return list; 
    }

}
