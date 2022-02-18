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
//		n=30,С�ڵ���n����������Ϊcount=n/2=15����
//		Ȼ��������С��n���������⡣��Ȼ1��������count��Ҫ��һ������2��������count�ֵü�һ������ȷ�����ǿ���Ϊ�����������ܸ�����
//		������������2�ı������������������Ժ���2��ֱ�Ӵ�3��ʼѰ����Щ�����еĿ��ܵ�����
//		�����ҳ����������ģ���ʣ�¶��������������������Ϊtrue��
	}

//	Count Primes ����˼·��
//	1. �ӷ���
//	2. ����������"��������������""����+����=ż��""����+ż��=����"ԭ���ȼ����ܼƶ��ٿ��ܵ�����,Ȼ���ҳ�"��������"������,ǰ��-���߼�Ϊ����
	
//	С��n�������У��ҳ����������ģ�ʣ�µĶ�������
    public static int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
//      Ĭ��false����ʾ���������������ȷ��"��������"����ר�ű��Ϊtrue�����һ����ͬʱcount--      
        boolean[] notPrime = new boolean[n];
//        isPrime[2] = true;
        //Arrays.fill(f, true); boolean[] are initialed as false by default
//      ͳ��Prime����,��ʼֵΪС��n�������ĸ���(1,3,5...)����С�ڵ���n��ż���ĸ���(2,4,6,8,...)
        int count = n / 2;
//         ��������������3��i(i*i<n), 3,5,7,9,...������Ϊ���ܵ����ӣ���Ѱ���ж��ĸ�������������������������������true
//        i�ǿ����������ӣ�j�Ǵ���������
        for (int i = 3; i * i <= n; i += 2) {
//        	�����������û�б�ȷ��"��������"����Ҫ��������;һ���Ѿ���ȷ�Ϲ�����������û��Ҫ������
            if (!notPrime[i]){
//            	9, 15, 21, 27, �˴�i�϶���һ������������"����*������������"��ԭ��i * i һ����������
//            	����"����+����*��������ż��,����+ż��*������������"��ԭ����������������i, j��i*i��ʼ����������2*i,ֱ��j<n��
                for (int j = i * i; j < n; j += 2 * i) {
//                	ȷ����ʱj��Ϊ���������j��û�б���ע"��������",���������Ϊ����Ϊfalse����count--��
                    if (!notPrime[j]) {
                        --count;
                        notPrime[j] = true;//�����߼����ҵ� Prime ��
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
