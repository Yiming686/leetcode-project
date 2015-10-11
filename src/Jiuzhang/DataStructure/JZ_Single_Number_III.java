package Jiuzhang.DataStructure;

import java.util.ArrayList;
import java.util.List;

/*
Medium Single Number III Show result 

33% Accepted
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.

Tags Expand 
Greedy LintCode Copyright


Related Problems Expand 
Medium Single Number II 40 %
Easy Single Number 60 %
Medium Majority Number III 24 %
Medium Majority Number II 24 %
Easy Majority Number 39 %

 */

public class JZ_Single_Number_III {
    public List<Integer> singleNumberIII(int[] A) {
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
