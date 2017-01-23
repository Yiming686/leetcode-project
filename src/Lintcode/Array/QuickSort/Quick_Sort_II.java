package Lintcode.Array.QuickSort;

import java.util.Arrays;

import com.sun.jmx.snmp.internal.SnmpAccessControlSubSystem;


/**
 * 
 
����partition()�����������Ŀ���ɾ���򵥵�quicksort������
������������Ҳ�����������򡣻�����

 *
 */
public class Quick_Sort_II {

		public static void main(String[] args) {
//			int[] arr = { 9, 2, 4, 7, 3, 7, 10};
//			int[] arr = {3};
//			int[] arr = {3, -3};
//			int[] arr = { 3,3,3,6,3,6,3,6,3,6,6,6,6};
			int[] arr = { 9, 2, 4, 7, 3, 7, 10, 2, 3};
			System.out.println(Arrays.toString(arr));
	 
			int left = 0;
			int right = arr.length - 1;
	 
			quickSort(arr, left, right);
			System.out.println(Arrays.toString(arr));
		}
	 
		public static void quickSort(int[] arr, int left, int right) {
	         if(left >= right) return;
	        int pos = partition(arr, left, right); //first indexth found       
	        quickSort(arr, left, pos - 1);
	        quickSort(arr, pos + 1, right);
		}
		
	    private static int partition(int[] arr, int left, int right){
	         if(left == right) return right;
//	        int pivot = arr[left];
	        int pivot = arr[right];
	        int pos = left;//�������ѭ���У�pos�Ǵ�����λ��
	        for(int i = left; i<=right; i++){
	            if(arr[i] <= pivot){
	                int temp = arr[i];
	                arr[i] = arr[pos];
	                arr[pos] = temp;
	                pos++;
	            }
	        }
	        return --pos;//��ʱposָ�����һ�����ڵ���pivot��Ԫ��,���ǿ�������Ԫ��
	    }
	    //������Ĵ���������������ĵ�k�����Ԫ�أ������ǻ���left���index��
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

}
