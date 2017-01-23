package Lintcode.Math.Integer;

/**
 Ugly Number

 Description
 Notes
 Testcase
 Judge
Write a program to check whether a given number is an ugly number`.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Notice

Note that 1 is typically treated as an ugly number.

Have you met this question in a real interview? Yes
Example
Given num = 8 return true
Given num = 14 return false

Tags 
Mathematics
Related Problems 
Medium Super Ugly Number 26 %
Easy Happy Number 31 %
 *
 */
public class Ugly_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isUgly(int num) {
        // Write your code here
        if(num < 1) return false;
        if(num == 1) return true;
        while(num % 2 == 0){  //是2的倍数
            num /= 2;         //去掉一个因数2
        }
        while(num % 3 == 0){  //是3的倍数
            num /= 3;         //去掉一个因数3
        }
        while(num % 5 == 0){  //是5的倍数
            num /= 5;         //去掉一个因数5
        }
        return num == 1 ? true : false;
    }

}
