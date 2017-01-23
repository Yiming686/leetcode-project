package Lintcode.Array.String.DP;

/**
Backpack V
Problem ����ѡ��+װ������������
Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is:

[7]
[1, 3, 3]
return 2

 *
 */
public class Backpack_V {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	ǰ�����ֶ���Ҫ�򱳰�����Ŷ�����������dp[0]��ʼ��Ϊ0
//	�������ֶ����ʣ��򱳰��Ŷ����ķ�������������dp[0]��ʼ��Ϊ1����ʾ���ŵķ�����һ��

//	ǰ�����ַ���������Ҫ�ŵ�ǰ����������ȽϺ���ȷ��һ�ַ���
//	�������ַ���������Ҫ�ŵ�ǰ���������رȽϣ�ֱ�����
//	�������ڶ�dp[j]�ĺ��������ʹ��
//	dp[j]�ĺ��壺���ظ����ã�װ����Ӧ������С�ķ�������	
//	�Ե�ǰ����˵��ֻҪ�����ܷŵ��£���Ҫ���Է�һ��
	
//dp[j]�ĺ��壺��Backpack IV�ĺ��岻һ������Ϊÿһ���ֻ��ȡһ�Σ����Բ�����С�ı���Ҫ�Ӵ�С	
	
	public int backPackV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                	dp[j] += dp[j-nums[i]];	
                }
            }
        }
        return dp[target];
    }


}
