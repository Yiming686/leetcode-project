package Lintcode.Array;

import java.util.PriorityQueue;

public class Kth_Largest_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,3,2,4,8};
		System.out.println("1:"+kthLargestElement(1, arr));
		System.out.println("2:"+kthLargestElement(2, arr));
		System.out.println("3:"+kthLargestElement(3, arr));
		System.out.println("4:"+kthLargestElement(4, arr));
		System.out.println("5:"+kthLargestElement(5, arr));
//		System.out.println("6:"+kthLargestElement(6, arr));
//		System.out.println("7:"+kthLargestElement(7, arr));
//		System.out.println("8:"+kthLargestElement(8, arr));
//		System.out.println("9:"+kthLargestElement(9, arr));
	}
	
	public static int kthLargestElement(int k, int[] nums) {
        if(nums == null || nums.length == 0) throw new IllegalArgumentException();
        int len = nums.length;
        if(k < 0 || k > len ) throw new IllegalArgumentException();
        return helper(nums, 0, len-1, k);
    }
    
    //找nums中的第k个元素，绝对位置，
    private static int helper(int[] nums, int start, int end, int k){
        int pos = partition(nums, start, end);
        if(pos + 1 == k ){//可以看出，绝对index
            return nums[pos];
        }else if(pos + 1 < k){
            return helper(nums, pos+1, end, k);  
        }else{
            return helper(nums, start, pos-1, k);  
        }
    }
    
    //Best solution, pos is valid index
    private static int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int pos = left;//在下面的循环中，pos是待插入位置
        for(int i = left; i <= right; i++){
            if(nums[i] >= pivot){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }
        return --pos;//此时pos指向最后一个大于等于pivot的元素，才是可能求解的元素
    }
    
//    时间 O(NlogK) 空间 O(K)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) p.poll();
        }
        return p.poll();
    }
}
