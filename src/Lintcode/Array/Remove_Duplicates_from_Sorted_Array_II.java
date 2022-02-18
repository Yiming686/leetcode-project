package Lintcode.Array;

import java.util.Arrays;

/**
Remove Duplicates from Sorted Array II Show result 

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

Have you met this question in a real interview? Yes
Example
Tags Expand 
Two Pointers Array Facebook


Related Problems Expand 
Easy Remove Element 31 %
Easy Remove Duplicates from Sorted Array

 *
 */
public class Remove_Duplicates_from_Sorted_Array_II {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		removeDuplicates1();
//		int[] arr = {1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7,7};
		int[] arr = {3,3,3,3,3,3,3,3,8};
		removeDuplicates00(arr);
//		removeDuplicates(arr);
//		removeDuplicates1(arr);
	}
	
//	Best solution:
    public static int removeDuplicates00(int[] nums) {
    	int limit = 5;
        if (nums.length <= limit) return nums.length;
        int index = limit;
        for (int i = limit; i < nums.length; i++){
            if (nums[i] != nums[index - limit]){
            	nums[index++] = nums[i];
            }
        }
        
        System.out.println(""+Arrays.toString(nums));
        System.out.println(""+index);
        return index;
    }

	//my solution, worked, better than jiuzhang
    public static int removeDuplicates(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        //size��ǵڼ�����ͬ��ֵ��Ҳ�����µ�����index
        int count = 1;
        int pos = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[pos]) {
                count = 1;
                ++pos;//�����µ�ֵ��size++
                A[pos] = A[i];//�µ�ֵ����sizeλ��
            }else{
                count++;
                if(count<=2){
                    ++pos;
                    A[pos] = A[i];
                }
            }
        }
        System.out.println(""+Arrays.toString(A));
        return pos + 1;//size+1���ǳ��Ȼ��߸���

    }

    //jiuzhang, worked
    public static int removeDuplicates1(int[] nums) {
        // write your code here
        if(nums == null)
            return 0;
        int cur = 0;
        int i ,j;
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for( j = i; j < nums.length; j++){
                if(nums[j] != now)
                    break;
                if(j-i < 2)
                    nums[cur++] = now; 
            }
            i = j;
        }
        return cur;
    }


	
}
