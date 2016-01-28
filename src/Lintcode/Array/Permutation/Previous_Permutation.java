package Lintcode.Array.Permutation;

import java.util.ArrayList;

public class Previous_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.arraycopy(src, srcPos, dest, destPos, length);;
	}

    public static ArrayList<Integer> previousPermuation(ArrayList<Integer> num) {
		// write your code
        if (num == null) {
            return num;
        }
        int len = num.size();
        for (int i = len - 2; i >= 0; i--) {
            if (num.get(i + 1) < num.get(i)) {//find i
                int j;
                for (j = len - 1; j >= i; j--) {
                    if (num.get(j) < num.get(i)) {//find first one less than i
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
     
    static void  swap(ArrayList<Integer> num, int i, int j) {
        int tmp = num.get(i);
        num.set(i, num.get(j));
        num.set(j, tmp);
    }

    static void reverse(ArrayList<Integer> num, int beg, int end) {
        for (int i = beg, j = end; i < j; i ++, j --) {
            swap(num, i, j);
        }
    }

}
