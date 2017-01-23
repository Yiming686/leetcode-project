package Lintcode.Array.String.DP;

/**
Backpack IV

Problem �ظ�ѡ��+Ψһ����+װ������������
Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may be chosen unlimited number of times

Example
Given candidate items [2,3,6,7] and target 7,

A solution set is:

[7]
[2, 2, 3]
return 2
 *
 */
public class Backpack_IV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	ǰ�����ֶ���Ҫ�򱳰�����Ŷ�����������dp[0]��ʼ��Ϊ0
//	�������ֶ����ʣ��򱳰��Ŷ����ķ�������������dp[0]��ʼ��Ϊ1����ʾ���ŵķ�����һ��

//	ǰ�����ַ���������Ҫ�ŵ�ǰ����������ȽϺ���ȷ��һ�ַ���
//	�������ַ���������Ҫ�ŵ�ǰ���������رȽϣ�ֱ�����
//	�������ڶ�dp[j]�ĺ��������ʹ��
//	dp[j]�ĺ��壺���ظ����ã�װ����Ӧ������С�ķ�������
	
//	dp[j]�ĺ���ÿ�ο϶���һ������ʼ��0λ�õ�ֵҲ��һ��
//	�Ե�ǰ����˵��ֻҪ�����ܷŵ��£���Ҫ���Է�һ��
//	
    public int backPackIV(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
//            ԭ���ⷨ
//                if (nums[i] == j) dp[j]++;
//                else if (nums[i] < j) dp[j] += dp[j-nums[i]];
            	if ( j- nums[i] >= 0){
            		dp[j] += dp[j-nums[i]];
            	}
            }
        }
        return dp[target];
    }

}
