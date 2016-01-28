package Lintcode.Array.Permutation;

public class Permutation_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//worked
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;//factor 是(n-1)!
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        //i是从左到右第几位置，j是从0到n-1第几个数字，所以factore会 不断缩小
        for (int i = 0; i < n; i++) {
            int index = k / factor;//这是从0到n-1得index
            k = k % factor;//index指向bucket的次序
            //下面在index指向的bucket里面找第k个
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            //已经找到，继续向后面找，但是i不能等于n-1
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }

        return sb.toString();
    }

}
