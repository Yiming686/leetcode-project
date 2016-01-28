package Lintcode.Array.Permutation;

/**
Next Permutation Show result 

Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

Have you met this question in a real interview? Yes
Example
For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]

Note
The list may contains duplicate integers.

Tags Expand 
LintCode Copyright Permutation


Related Problems Expand 
Medium Permutation Sequence 25 %
Medium Previous Permutation 26 %
Medium Permutations II


 *
 *
 *
 */
public class Next_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//worked
    public int[] nextPermutation(int[] num) {
        if (num == null) {
            return num;
        }
        //原本次序是：从完全升序到完全降序
        //逻辑是：找到最后一个下降沿的前一个元素即i，找到最后一个大于i的元素即j
        //交换i，j元素，reverse从i+1到最后的元素
        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {
            if (num[i + 1] > num[i]) {
                int j;
                for (j = len - 1; j >= i; j--) {
                    if (num[j] > num[i]) {
                        break;
                    }
                }
                //找到了j就说明i不是同级最后一个，所以移向同级后一位
                swap(num, i, j);//树中元素提升一级
                reverse(num, i + 1, len-1);
                return num;
            }
        }

        reverse(num, 0, len-1);
        return num;
    }

    void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    void reverse(int[] num, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(num, i, j);
        }
    }


}
