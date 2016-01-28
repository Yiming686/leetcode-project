package Lintcode.Array.QuickSort;

/**
Kth Largest Element Show result 

Find K-th largest element in an array.

Have you met this question in a real interview? Yes
Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.

Note
You can swap elements in the array

Challenge
O(n) time, O(1) extra memory.

Tags Expand 
Quick Sort Sort


Related Problems Expand 
Medium Kth Smallest Number in Sorted Matrix

 *
 */
public class Kth_Largest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //����left��right֮���index
    // ѡ�����һ��Ԫ��Ϊpivot��Ȼ��ӵ�һ�������������ڶ������Ѵ��ڵ������Ԫ�ص�ֵ���η�����ǰ�棬�ҵ��˻�����pivot���Ԫ�ؾͷ������һ��index
    private int partition(int[] nums, int left, int right){
        // if(left == right) return right;
        int pivot = nums[right];
        int index = left;
        for(int i = left; i<right; i++){
            if(nums[i] >= pivot){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        //��ʱindexָ����һ�������λ�ã���Χ��0--n-1
        int temp = nums[index];
        nums[index] = pivot;
        nums[right] = temp;
        return index;
    }
    private int helper2(int[] nums, int left, int right, int k){
        int index = partition(nums, left, right); //first indexth found       
        if(index + 1 == k ) 
            return nums[index];//��������ǵ�k��Ԫ��
        else if(index + 1 < k)
            return helper2(nums, index + 1, right, k);
            // return helper2(nums, index + 1, nums.length - 1, k);//Ҳwork
        else
            return helper2(nums, left, index - 1, k);
            // return helper2(nums, 0, index - 1, k);//Ҳwork
    }
    
    
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper2(nums, 0, nums.length - 1, k);
    }
	
}
