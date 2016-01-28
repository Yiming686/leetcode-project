package LeetCode.JavaArray;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
Subscribe to see which companies asked this question

Hide Tags Array Two Pointers Sort
Hide Similar Problems (M) Sort List 

 * @author yiming
 *
 */
public class LC_75_Sort_Colors {
    public void sortColors(int[] a) {
        if(a == null || a.length <= 1)
            return;
        //����ָ�룬�첽�˶�
        int left = 0;//��¼��ǰ����0��λ�ã��������0
        int right = a.length - 1;//��¼��ǰ����2��λ�ã��������2
        int curr = 0;//��ǰָ�룬ָ�������Ԫ�أ�ֻ�ƶ�0����2�����ƶ�1
        
        while(curr <= right){
            if(a[curr] == 0){
                swap(a, left, curr);
                left++;
                curr++;
            }else if(a[curr] == 1){
                curr++;
            }else{
                swap(a, curr, right);
                right--;
            }
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
