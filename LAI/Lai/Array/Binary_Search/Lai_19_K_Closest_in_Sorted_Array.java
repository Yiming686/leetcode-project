package Lai.Array.Binary_Search;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Lai_19_K_Closest_in_Sorted_Array {

	public static void main(String args[]) {
		System.out.println("dd"+0);
		int[] arr = {2,3,4,8,9};
		System.out.println(""+Arrays.toString(arr));
		System.out.println("===============================");
		//        1,-1; 2,0; 3,1; 6,2; 8,3; 9,4; 11,4;
//		System.out.println(""+largestSmallerOrEqual(arr, 1));
//		System.out.println(""+largestSmallerOrEqual(arr, 3));
//		System.out.println(""+largestSmallerOrEqual(arr, 6));
//		System.out.println(""+largestSmallerOrEqual(arr, 9));
//		System.out.println(""+largestSmallerOrEqual(arr, 99));

//		System.out.println(""+Arrays.toString(kClosest(arr, 2, 5)));
//		System.out.println(""+Arrays.toString(kClosest(arr, 3, 5)));
		System.out.println(""+Arrays.toString(kClosest(arr, 6, 5)));
//		System.out.println(""+Arrays.toString(kClosest(arr, 9, 5)));
//		System.out.println(""+Arrays.toString(kClosest(arr, 99, 5)));

		
	}
	
	private static int[] kClosest(int[] arr, int target, int k) {
		int left = largestSmallerOrEqual(arr, target);
		int right = left + 1;
//		System.out.println(String.format("left: %s, right: %s",arr[left], arr[right]));
//		System.out.println(String.format("left: %s, right: %s",left, right));
		//[-1,0],[0,1],...,[n-2,n-1],[n-1,n]
		int[] result = new int[k]; 
		for(int i = 0; i < k; i++) {
			System.out.println(String.format("left: %s, right: %s",left, right));
			if(right >= arr.length || (left>=0 && Math.abs(target - arr[left]) <= Math.abs(target - arr[right]))) {
				result[i] = arr[left--];
			}else {
				result[i] = arr[right++];
			}
		}
		return result;		
	}
	
	//返回插入点的index
	private static int largestSmallerOrEqual(int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		//intent: find the where t is, 在什么指导思想下，搜索区间不断减小，直到两个数；
		//exact：寻找那个最大的比target小或者相等的元素
		//注意：这不是寻找距离t最近的数，而是寻找比t小或者等于t的所有数中，最大的那个，也就是t的左侧距离t最近的数，距离可以为0；那么当mid指向的数等于t时，right=mid，
		//[t,l,r],return -1; [lt,r], return l, [l,t,r], return l; [l,r,t] return r;
		while(left + 1 < right) {
			int mid = left + (right - left)/2;
			if(arr[mid] <= target ) {
				left = mid; //必须这样，相等时移动left，left=mid，不能right=mid，想想最终的退出循环是left和right的相对位置
			}else {
				right = mid;
			}			
		}
//		System.out.println(String.format("left: %s, right: %s",arr[left], arr[right]));
		//[l,r]: [t,l,r], [lt,r], [l,rt], [l,r,t] 四种可能 
		//[lr]：[t,lr], [lrt], [lr, t] 三种可能
		if(arr[right] <= target) {
			return right;
		}
		//[l,r]: [t,l,r], [lt,r],  二种可能 
		//[lr]：[t,lr],  一种种可能
		if(arr[left] <= target) {
			return left;
		}
		return -1;	
	}
	
	@Test
	public void testLargestSmallerOrEqual() {
		int[] arr = new int[] {2,3,5,8,9};
		//        1,-1; 2,0; 3,1; 6,2; 8,3; 9,4; 11,4;
//		Assert.assertEquals(expected, actual);
		Assert.assertEquals(-1, largestSmallerOrEqual(arr, 1));
		Assert.assertEquals(0, largestSmallerOrEqual(arr, 2));
		Assert.assertEquals(1, largestSmallerOrEqual(arr, 3));
		Assert.assertEquals(2, largestSmallerOrEqual(arr, 5));
		Assert.assertEquals(3, largestSmallerOrEqual(arr, 8));
		Assert.assertEquals(4, largestSmallerOrEqual(arr, 9));
		Assert.assertEquals(4, largestSmallerOrEqual(arr, 11));
	}
}

