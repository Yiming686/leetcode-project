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
        int factor = 1;//factor ��(n-1)!
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        //i�Ǵ����ҵڼ�λ�ã�j�Ǵ�0��n-1�ڼ������֣�����factore�� ������С
        for (int i = 0; i < n; i++) {
            int index = k / factor;//���Ǵ�0��n-1��index
            k = k % factor;//indexָ��bucket�Ĵ���
            //������indexָ���bucket�����ҵ�k��
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
            //�Ѿ��ҵ�������������ң�����i���ܵ���n-1
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }

        return sb.toString();
    }

}
