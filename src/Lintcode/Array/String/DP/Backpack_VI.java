package Lintcode.Array.String.DP;

/**
Backpack VI 

AKA: Combination Sum IV

Problem �ظ�ѡ��+��ͬ����+װ������������

Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Notice
The different sequences are counted as different combinations.

Example
Given nums = [1, 2, 4], target = 4

The possible combination ways are:

[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6

 *
 */
public class Backpack_VI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	ǰ�����ֶ���Ҫ�򱳰�����Ŷ�����������dp[0]��ʼ��Ϊ0
//	�������ֶ����ʣ��򱳰��Ŷ����ķ�������������dp[0]��ʼ��Ϊ1����ʾ���ŵķ�����һ��

//	ǰ�����ַ���������Ҫ�ŵ�ǰ�����Ļ�������ȽϺ���ȷ��һ�ַ���
//	�������ַ���������Ҫ�ŵ�ǰ�����Ļ������رȽϣ�ֱ�����
	
//	�������ڶ�dp[j]�ĺ��������ʹ��
//	dp[j]�ĺ��壺���ظ����ã�װ����Ӧ������С�ķ�������	
//	�Ե�ǰ����˵��ֻҪ�����ܷŵ��£���Ҫ���Է�һ��
	
//dp[j]�ĺ��壺	

    public static int backPackVI(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int num: nums) {
                if (j-num>=0){
                	dp[j] += dp[j-num];
                } 
                	
            }
        }
        return dp[target];
    }

}
