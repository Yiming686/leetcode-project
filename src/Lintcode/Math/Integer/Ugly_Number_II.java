package Lintcode.Math.Integer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 Ugly Number II

 Description
 Notes
 Testcase
 Judge
Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

 Notice

Note that 1 is typically treated as an ugly number.

Have you met this question in a real interview? Yes
Example
If n=9, return 10.

Challenge 
O(n log n) or O(n) time.

Tags 
LintCode Copyright Priority Queue
Related Problems 
Medium Super Ugly Number 26 %
Medium Perfect Squares 27 %
Easy Happy Number 31 %
Medium Merge k Sorted Lists 28 %

 *
 */
public class Ugly_Number_II {

//	��ϰPriorityQueue��TreeSet��ʵ���Լ��ṹ�Ͳ����ӿ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //worked, pq solution, actually, need a HashSet, not a HashMap
    public long nthUglyNumber1(int n) {        
        Queue<Long> queue = new PriorityQueue<Long>();//ȡ��С�����մ���
        Long[] primes = new Long[3];
        primes[0] = 2L;
        primes[1] = 3L;
        primes[2] = 5L;
        for (int i = 0; i < 3; i++) {
            queue.offer(primes[i]);
        }
        Long number =1L;
        for (int i = 0; i < n-1; i++) {
            number = queue.poll();//�ҵ���С
            for (int j = 0; j < 3; j++) {
                long candidate =  primes[j] * number;
                if (!queue.contains(candidate)) {
                    queue.add(candidate);
                }
            }
        }
        return number;
    }

    //worked, TreeSet solution
    public long nthUglyNumber(int n) {        
        TreeSet<Long> set = new TreeSet<Long>();//ȡ��С�����մ���
        //�ؼ��Ǻ���Ҫ�����õ�
        Long[] primes = new Long[3];
        primes[0] = 2L;
        primes[1] = 3L;
        primes[2] = 5L;
        for (int i = 0; i < 3; i++) {
            set.add(primes[i]);
        }
        Long number =1L;
        for (int i = 0; i < n-1; i++) {
            number = set.pollFirst();//�ҵ���С,poll����
            // number = set.first();//�ҵ���С��������peekһ��
            for (int j = 0; j < 3; j++) {
                long num = primes[j] * number;//���ﷴ���õ�
                if (!set.contains(num)) {
                    set.add(num);
                }
            }
        }
        return number;
    }

    
    
    
}
