package Lintcode.Math.Integer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
Super Ugly Number

 Description
 Notes
 Testcase
 Judge
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Notice

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000
Have you met this question in a real interview? Yes
Example
Given n = 6, primes = [2, 7, 13, 19] return 13

Tags 
Heap Mathematics Google
Related Problems 
Easy Ugly Number 36 %
Medium Ugly Number II 23 %


 *
 */
public class Super_Ugly_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long s = 22L;
		s.intValue();
	}

	
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        Queue<Long> queue = new PriorityQueue<Long>();//取最小，按照次序
        // Long[] primes = new Long[3];
        // primes[0] = 2L;
        // primes[1] = 3L;
        // primes[2] = 5L;
        // for (int i = 0; i < 3; i++) {
        //     queue.offer(primes[i]);
        // }
        for(int prime : primes){
            queue.offer(Long.valueOf(prime));
        }
        Long number =1L;
        for (int i = 0; i < n-1; i++) {
            number = queue.poll();//找到最小
            for(int prime : primes){
                Long candidate =  prime * number;
                if (!queue.contains(candidate)) {
                    queue.add(candidate);
                }
            }
        }
        return number.intValue();
    }

}
