package Lintcode.BinarySearch;

import java.util.Arrays;

/**
 * 
204. Count Primes

DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Description:

Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Seen this question in a real interview before?   Yes  No
Difficulty:Easy
Total Accepted:121.6K
Total Submissions:458K
Contributor: LeetCode
Subscribe to see which companies asked this question.

Related Topics 
Hash Table Math 
Similar Questions 
Ugly Number Ugly Number II Perfect Squares

 *
 */
public class Count_Primes {

//	count : i : j   41540 : 691 : 489919
//	count : i : j   41539 : 691 : 496829
//	count : i : j   41538 : 701 : 491401
//	count : i : j   41537 : 701 : 497009
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+countPrimes(499979));; //Expected answer : 41537
//		countPrimes(122);
//		n=30,小于等于n的奇数个数为count=n/2=15个；
//		然后考虑所有小于n的质数问题。虽然1不是质数count需要减一，但是2又是质数count又得加一，可以确定这是可能为质数的最大可能个数。
//		并且由于所有2的倍数都不是质数，可以忽略2，直接从3开始寻找这些奇数中的可能的质数
//		从中找出不是质数的，则剩下都是质数。不是质数标记为true。
	}

//	Count Primes 总体思路：
//	1. 加法：
//	2. 减法：根据"质数必须是奇数""奇数+奇数=偶数""奇数+偶数=奇数"原理，先计算总计多少可能的奇数,然后找出"不是质数"的奇数,前者-后者即为所求。
	
//	小于n的奇数中，找出不是质数的，剩下的都是质数
    public static int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
//      默认false，表示可能是质数，如果确定"不是质数"，则专门标记为true，标记一个则同时count--      
        boolean[] notPrime = new boolean[n];
//        isPrime[2] = true;
        //Arrays.fill(f, true); boolean[] are initialed as false by default
//      统计Prime总数,初始值为小于n的奇数的个数(1,3,5...)或者小于等于n的偶数的个数(2,4,6,8,...)
        int count = n / 2;
//         遍历所有奇数从3到i(i*i<n), 3,5,7,9,...，依次为可能的因子，来寻找判断哪个奇数不是质数，如果不是质数，标记true
//        i是可能奇数因子，j是待检测的奇数
        for (int i = 3; i * i <= n; i += 2) {
//        	如果此奇数还没有被确认"不是质数"，需要继续处理;一旦已经被确认过不是质数，没不要继续了
            if (!notPrime[i]){
//            	9, 15, 21, 27, 此处i肯定是一个奇数，根据"奇数*奇数就是奇数"的原理，i * i 一定是奇数。
//            	根据"奇数+奇数*奇数就是偶数,奇数+偶数*奇数就是奇数"的原理，跳过奇数个数的i, j从i*i开始，依次增加2*i,直到j<n。
                for (int j = i * i; j < n; j += 2 * i) {
//                	确保此时j仍为奇数，如果j还没有被标注"不是奇数",此奇数如果为还是为false，则count--；
                    if (!notPrime[j]) {
                        --count;
                        notPrime[j] = true;//核心逻辑，找到 Prime 了
                        System.out.println("count : i : j   "+ count +" : "+ i +" : "+ j);
                    }
                }
            }
        }
//        System.out.println("n/2 : "+ n/2 +"   count : " + count);
//        for(int i = 0; i < notPrime.length; i++){
//        	System.out.println(i+" : "+ notPrime[i]);
//        }
        return count;
    }
	
}
