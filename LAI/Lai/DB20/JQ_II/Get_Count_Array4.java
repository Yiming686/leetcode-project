package Lai.DB20.JQ_II;

import static Utils.TreeNodeUtils.toStr;

import com.sun.istack.internal.FinalArrayList;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Utils.ArrayUtils;
import Utils.StringUtils;
import Utils.StringUtils.toStr;
import Utils.TreeNodeUtils.TP;

public class Get_Count_Array4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {5,1,3,2};
		int[] arr = {5,3,1,4,2,6,1};//小：right: 5302110, left: 0002150, all: 5,3,0,4,2,6,0 why 1100 右边比大的有几个？
//		                                                       5302110
//		                                                       5304260
//		int[] arr = {5,2,6,1};//小：right: 2110, left: 0,0,2,0, all: 2,1,3,0 why 1100 右边比大的有几个？
//		int[] arr = {5,2,6,1};//大：right: 1100, left: 0,1,0,3, all:1,2,0,3  why 1100 右边比大的有几个？
//		int[] arr = {5,4,3,2,1};
//		int[] arr = {1,2,3,4,5};
		System.out.println(""+(5 >= 4));
//		int[] arr = {5,3,1,4, 2,6};
		ArrayUtils.print(arr);
		ArrayUtils.printIntArray(arr);
		System.out.println(""+StringUtils.toStr(countArray(arr)));
	}

	public static int[] countArray(int[] array) {
		// The indexArray contains the indices in the original array,
		// and it will be sorted by the corresponding number in the
		// original array.
		// The countArray is the actual return array.
		// The helper array is to help the merge sort.
		int[] indexArray = initialIndexArray(array);
		int[] countArray = new int[array.length];
		int[] helper = new int[array.length];//shared by all
		TP root = TP.build("", "011111","root", null);
		mergeSort(array, indexArray, countArray, helper, 0, array.length - 1, root);TP.build("root", null, StringUtils.toStr(array), StringUtils.toStr(indexArray), StringUtils.toStr(countArray), StringUtils.toStr(helper), 0, array.length - 1);
		root.print();
		ArrayUtils.printIntArray("array-", array);
		ArrayUtils.printIntArray("indexArray-",indexArray);
		for(int i = 0; i < array.length; i++) {
			int index = indexArray[i];
			int val = indexArray[index];
			indexArray[index] = val;
		}
		return countArray;
	}

	// The indices are just a - (array.1ength - 1)
	private static int[] initialIndexArray(int[] array) {
		int[] indices = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	private static void mergeSort(int[] arr, int[] indexArr, int[] countArr, int[] prevIndexArr, int start, int end, TP root) {
//		ArrayUtils.printConsecutiveChar('-', 100);
//		ArrayUtils.printIntArray("indexArray",indexArray);
//		ArrayUtils.printIntArray("countArray",countArray);
//		ArrayUtils.printIntArray("helper",helper);

		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
//		int mid = start + (end - start) / 2;
		mergeSort(arr, indexArr, countArr, prevIndexArr, start, mid,TP.build("left", root)); TP.build("left", root, StringUtils.toStr(arr), StringUtils.toStr(indexArr), StringUtils.toStr(countArr), StringUtils.toStr(prevIndexArr), start, mid);
		mergeSort(arr, indexArr, countArr, prevIndexArr, mid + 1, end,TP.build("right", root)); TP.build("right", root, StringUtils.toStr(arr), StringUtils.toStr(indexArr), StringUtils.toStr(countArr), StringUtils.toStr(prevIndexArr), mid + 1, end);

		merge_00(arr, indexArr, countArr, prevIndexArr, start, mid, end);
		
		ArrayUtils.printIntArray("indexArray+",indexArr);
		ArrayUtils.printIntArray("countArray+",countArr);
		ArrayUtils.printIntArray("preIndexArray+",prevIndexArr);

	}

//	left, mid, right 表示区间里面的位置，分割为两个排好序的区段，[left, mid]和[mid+1, right]，
//helper数组保持先前的这个区间里面元素的index；先前的元素在这个区间里面的排序后的位置，可能是后面区间的任意位置，
//indexArray数组保持排序后，这个区间里面元素的index
//	merge之前，左右区间都排好序了，indexArray就是所有元素的index；countArray就是在当前区间范围里面，当前index所对应的arr里面的元素，其右边小于自己的元素的个数
//	当前区间排序就是要把indexArray数组里面所有元素的index重新进行排序，位置需要变动，所以helper用来原封不动标记先前的indexArray里面的值
	
//	若是从左到右扫描，谁小向左移谁，这样得到的是右侧比当前小的个数，怎么得到右侧比当前大的呢，左右侧谁决定？大小谁决定的？
//	若是从左到右扫描，谁大向左移谁，这样的到的是右侧比当前大的个数
//	若是从右到左扫描，谁小向右移谁，左侧大右侧小，这样对当前需要移动的元素， 的到的是右侧比当前大的个数
//	
	private static void merge_00(int[] arr, int[] indexArr, final int[] countArr, int[] preIndexArr, final int start,final  int mid, final int end) {
		copyArray(indexArr, preIndexArr, start, end);
		ArrayUtils.printConsecutiveChar('-', 100);
		ArrayUtils.printIntArray("array-",arr);
		System.out.println(""+String.format("[left, mid], [mid + 1, right]: [%d, %d], [%d, %d]  ", start, mid, mid+1, end));
		ArrayUtils.printIntArray("indexArray-",indexArr);
		ArrayUtils.printIntArray("countArray-",countArr);
		ArrayUtils.printIntArray("preIndexArray-",preIndexArr);
		
		int left = start;
		int right = mid + 1;
		int curr = start;//表示当前l和r比较大小后其index应该放置的位置
		while (left <= mid) {
			// When sorting the indexArray, we use the corresponding value in the
			// original array.
			if (right > end || arr[preIndexArr[left]] <= arr[preIndexArr[right]]) {
//			if (right > end || arr[preIndexArr[left]] >= arr[preIndexArr[right]]) {
//				countArr[preIndexArr[left]] += (left - start);
				countArr[preIndexArr[left]] += (right - mid - 1);//WORKED
//				countArr[preIndexArr[left]] += (left - start + right - mid - 1);
//				countArr[preIndexArr[left]] += (left - start + right - mid - 1) - (right - mid - 1);
//				countArr[preIndexArr[left]] += (left - start);
				indexArr[curr++] = preIndexArr[left++];
			} else {
//				countArr[preIndexArr[right]] += (right - mid - 1 + left - start);
				indexArr[curr++] = preIndexArr[right++];
			}
		}
	}

	private static void merge(int[] arr, int[] indexArr, final int[] countArr, int[] preIndexArr, final int start,final  int mid, final int end) {
		copyArray(indexArr, preIndexArr, start, end);
		ArrayUtils.printConsecutiveChar('-', 100);
		ArrayUtils.printIntArray("array-",arr);
		System.out.println(""+String.format("[left, mid], [mid + 1, right]: [%d, %d], [%d, %d]  ", start, mid, mid+1, end));
		ArrayUtils.printIntArray("indexArray-",indexArr);
		ArrayUtils.printIntArray("countArray-",countArr);
		ArrayUtils.printIntArray("preIndexArray-",preIndexArr);
		
		int left = mid;//start;
		int right = end;//mid + 1;
		int curr = end;//start;//表示当前l和r比较大小后其index应该放置的位置
//		for(int curr = end; curr >= start; ) {
		while (right >= mid + 1) {//以距离循环起点最近的区间的最后一位为边界
			// When sorting the indexArray, we use the corresponding value in the
			// original array.
			if (left < start || arr[preIndexArr[right]] <= arr[preIndexArr[left]]) {//move left			
//			if (right > end || arr[preIndexArr[left]] <= arr[preIndexArr[right]]) {
//			if (right > end || arr[preIndexArr[left]] >= arr[preIndexArr[right]]) {
//				countArr[preIndexArr[left]] += (left - start);
//				countArr[preIndexArr[left]] += (right - mid - 1);//WORKED
//				countArr[preIndexArr[left]] += (left - start + right - mid - 1);
//				countArr[preIndexArr[left]] += (left - start + right - mid - 1) - (right - mid - 1);
//				countArr[preIndexArr[left]] += (left - start);
				countArr[preIndexArr[right]] += (mid - left);//WORKED
				indexArr[curr--] = preIndexArr[right--];
			} else {//move right
//				countArr[preIndexArr[right]] += (right - mid - 1 + left - start);
				indexArr[curr--] = preIndexArr[left--];
			}
		}
	}
	
/*
问题域：left-->right, 所有小于left位置的都小于最小值，所有大于right位置的都小于最大值；
只需要将[left，right]区间里面的排好序就可以了; 
r > right ::= <==> arr[left] < arr[right]

只在[left, mid, mid+1，right] 这个区间里面操作
array 记录区间里面的 原始数值
helper记录区间里面的 原始index，为什么l和r不是绝对index呢？如果是就不用这样写：array[helper[l]] <= array[helper[r]
helper记录的是indexArray在此区间原来的值，下面需要更新indexArray里面的值

countArray
不停给indexArray更新值，curr++， 用helper数组的值，那么helper里面保存的是数组的index，并且每次merge开始时候都是用同范围的indexArray里面的值来覆盖
逻辑：r > right时，l里面可能还有，

	
*/
	
	private static void copyArray(int[] indexArray, int[] prevIndexArray, int start, int end) {
		for (int i = start; i <= end; i++) {
			prevIndexArray[i] = indexArray[i];
		}
	}

}
