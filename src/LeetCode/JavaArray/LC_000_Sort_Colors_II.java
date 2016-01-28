package LeetCode.JavaArray;

/**

Sort Colors II

Given an array of n objects with k different colors (numbered from 1 to k), 
sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k. *

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. 
That will cost O(k) extra memory. Can you do it without using extra memory?

 */
public class LC_000_Sort_Colors_II {

    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0) return;
        
        int left = 0;//�����
        int curr = left;//��̬�仯��
        int right = colors.length -1;//�����
        
        int min = 1;//�ŵ�����ߵ�ֵ��minֵ
        int max = k;//�ŵ����ұߵ�ֵ��maxֵ
        
        int count = k/2;//how many while loops
        while(count > 0){
        	//curr��ʼ�˶������left���յ�right+1
        	//rightָ���Ԫ�أ���ʵΪ�����أ����Ա����еȺţ����п��ܺ�Ҫ��left������
            while(curr <= right){
                if(colors[curr] == min){
                    swap(colors, left, curr);
                    left++;
                    curr++;
                }else if(colors[curr] == max){
                    swap(colors, curr, right);
                    right--;
                }else{
                    curr++;
                }
            }
            //whileѭ������ı������棬currҪreset��min��max���£�count��һ
            curr = left;
            min++;
            max--;
            
            count--;
        }
    }
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
