package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import Utils.ArrayUtils;
import Utils.TreeNodeUtils.TP;

public class LC493_Reverse_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr = {5,1,3,2};
//		int[] arr = {5,3,1,4,2,6,1};//小：right: 5302110, left: 0002150, all: 5,3,0,4,2,6,0 why 1100 右边比大的有几个？
//		                                                       5302110
//		                                                       5304260
//		int[] arr = {5,2,6,1};//小：right: 2110, left: 0,0,2,0, all: 2,1,3,0 why 1100 右边比大的有几个？
//		int[] arr = {5,2,6,1};//大：right: 1100, left: 0,1,0,3, all:1,2,0,3  why 1100 右边比大的有几个？
//		int[] arr = {5,4,3,2,1};
//		int[] arr = {1,2,3,4,5};
		int[] arr = {5,3,1,4, 2,6};
		
//		int[] arr = {1,3,2,3,1};
//		int[] arr = {2,4,3,5,1};
//		int[] arr = ArrayUtils.generateIntArrayAllDup(4, Integer.MAX_VALUE);
//		int[] arr = {233,2000000001,234,2000000006,235,2000000003,236,2000000007,237,2000000002,2000000005,233,233,233,233,233,2000000004};
		ArrayUtils.print(arr);
		ArrayUtils.printIntArray(arr);
		System.out.println("e:"+reversePairs(arr));
	}
	
    public static int reversePairs(int[] arr) {
		int[] tempArr = new int[arr.length];//shared by all
		copyArray(arr, tempArr, 0, arr.length - 1);
		
		// TP root = TP.build("", "1111","root", null);
		int count = mergeSort(arr, tempArr, 0, arr.length - 1);//TP.build("root", null, toStr(arr), toStr(tempArr), 0, arr.length - 1);
		// root.print();
		return count;
	}



	private static int mergeSort(int[] arr, int[] tempArr, int start, int end/*, TP root*/) {
		if (start >= end) {
			return 0;
		}
		int mid = start + (end - start) / 2;
		int left = mergeSort(arr,  tempArr, start, mid);// TP.build("left", root, toStr(arr),  toStr(tempArr), start, mid);
		int right = mergeSort(arr, tempArr, mid + 1, end); //TP.build("right", root, toStr(arr), toStr(tempArr), mid + 1, end);

		int rem = merge_00(arr, tempArr, start, mid, end);
				
		return left + right + rem;
	}

	//two sections in tempArr are sorted, merge them into arr, count the num of desired pairs in tempArr
	private static int merge_00(int[] arr, int[] tempArr, final int start,final  int mid, final int end) {
		copyArray(arr, tempArr, start, end);

//		count the num of desired pairs in tempArr, return it
		int count = 0;
		int left = start;
		int right = mid + 1;
		int curr = start;//表示当前l和r比较大小后其index应该放置的位置
// 		while (left <= mid) {
//             if (right > end) {
//     			count += (right - mid - 1);
//                 arr[curr++] = tempArr[left++];	    		
// 			}else if (Long.valueOf(arr[left])  <= Long.valueOf(2L * arr[right]) || tempArr[left] <= tempArr[right]){
                
//                 if (Long.valueOf(arr[left])  <= Long.valueOf(2L * arr[right]) ){
//                        count += (right - mid - 1); 
//                 }
//                 if (tempArr[left] <= tempArr[right]) {
// 			    	arr[curr++] = tempArr[left++];
// 			    }else{
//                     left++;
//                 }                                               
//             }else{
//                 right++;
//             }            
// 		}
        
		while (left <= mid) {
         if (right > end || Long.valueOf(arr[left])  <= Long.valueOf(2L * arr[right])) {
    			count += (right - mid - 1);
	    		left++;                
			}else{
             right++;
         }            
		}

		left = start;
		right = mid + 1;
		curr = start;//表示当前l和r比较大小后其index应该放置的位置
		while (left <= mid) {
			if (right > end || tempArr[left] <= tempArr[right]) {
				arr[curr++] = tempArr[left++];
			} else {
				arr[curr++] = tempArr[right++];
			}
		}
		return count;
	}

	
	private static void copyArray(int[] sourceArr, int[] targetArr, int start, int end) {
		for (int i = start; i <= end; i++) {
			targetArr[i] = sourceArr[i];
		}
	}

}
