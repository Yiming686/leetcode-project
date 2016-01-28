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
        
        int left = 0;//左起点
        int curr = left;//动态变化点
        int right = colors.length -1;//右起点
        
        int min = 1;//放到最左边的值，min值
        int max = k;//放到最右边的值，max值
        
        int count = k/2;//how many while loops
        while(count > 0){
        	//curr开始运动，起点left，终点right+1
        	//right指向的元素，其实为处理呢，所以必须有等号，他有可能后还要和left交换呢
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
            //while循环里面的变量更替，curr要reset，min和max更新，count减一
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
