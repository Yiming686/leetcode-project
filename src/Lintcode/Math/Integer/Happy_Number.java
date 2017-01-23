package Lintcode.Math.Integer;

import java.util.HashSet;
import java.util.Set;

/**
 Happy Number

 Description
 Notes
 Testcase
 Judge
Write an algorithm to determine if a number is happy.

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Have you met this question in a real interview? Yes
Example
19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
Tags 
Hash Table Mathematics
Related Problems 
Easy Ugly Number 36 %
Medium Ugly Number II 23 %


 *
 */
public class Happy_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+isHappy1(19));
	}

    public static  boolean isHappy1(int n) {
        // Write your code here
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1){
            if(set.contains(n)){
            	return false;
            }
            set.add(n);
            int sum = 0;
            while(n>0){
                int digit = n % 10;//last digit
                sum += digit * digit;
                n = n / 10;//digits but the last
            }
            n = sum;
        }
        return true;
    }

}
