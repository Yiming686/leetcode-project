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
		int[] arr = {5,3,1,4,2,6,1};//С��right: 5302110, left: 0002150, all: 5,3,0,4,2,6,0 why 1100 �ұ߱ȴ���м�����
//		                                                       5302110
//		                                                       5304260
//		int[] arr = {5,2,6,1};//С��right: 2110, left: 0,0,2,0, all: 2,1,3,0 why 1100 �ұ߱ȴ���м�����
//		int[] arr = {5,2,6,1};//��right: 1100, left: 0,1,0,3, all:1,2,0,3  why 1100 �ұ߱ȴ���м�����
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

//	left, mid, right ��ʾ���������λ�ã��ָ�Ϊ�����ź�������Σ�[left, mid]��[mid+1, right]��
//helper���鱣����ǰ�������������Ԫ�ص�index����ǰ��Ԫ����������������������λ�ã������Ǻ������������λ�ã�
//indexArray���鱣������������������Ԫ�ص�index
//	merge֮ǰ���������䶼�ź����ˣ�indexArray��������Ԫ�ص�index��countArray�����ڵ�ǰ���䷶Χ���棬��ǰindex����Ӧ��arr�����Ԫ�أ����ұ�С���Լ���Ԫ�صĸ���
//	��ǰ�����������Ҫ��indexArray������������Ԫ�ص�index���½�������λ����Ҫ�䶯������helper����ԭ�ⲻ�������ǰ��indexArray�����ֵ
	
//	���Ǵ�����ɨ�裬˭С������˭�������õ������Ҳ�ȵ�ǰС�ĸ�������ô�õ��Ҳ�ȵ�ǰ����أ����Ҳ�˭��������С˭�����ģ�
//	���Ǵ�����ɨ�裬˭��������˭�������ĵ������Ҳ�ȵ�ǰ��ĸ���
//	���Ǵ��ҵ���ɨ�裬˭С������˭�������Ҳ�С�������Ե�ǰ��Ҫ�ƶ���Ԫ�أ� �ĵ������Ҳ�ȵ�ǰ��ĸ���
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
		int curr = start;//��ʾ��ǰl��r�Ƚϴ�С����indexӦ�÷��õ�λ��
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
		int curr = end;//start;//��ʾ��ǰl��r�Ƚϴ�С����indexӦ�÷��õ�λ��
//		for(int curr = end; curr >= start; ) {
		while (right >= mid + 1) {//�Ծ���ѭ������������������һλΪ�߽�
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
������left-->right, ����С��leftλ�õĶ�С����Сֵ�����д���rightλ�õĶ�С�����ֵ��
ֻ��Ҫ��[left��right]����������ź���Ϳ�����; 
r > right ::= <==> arr[left] < arr[right]

ֻ��[left, mid, mid+1��right] ��������������
array ��¼��������� ԭʼ��ֵ
helper��¼��������� ԭʼindex��Ϊʲôl��r���Ǿ���index�أ�����ǾͲ�������д��array[helper[l]] <= array[helper[r]
helper��¼����indexArray�ڴ�����ԭ����ֵ��������Ҫ����indexArray�����ֵ

countArray
��ͣ��indexArray����ֵ��curr++�� ��helper�����ֵ����ôhelper���汣����������index������ÿ��merge��ʼʱ������ͬ��Χ��indexArray�����ֵ������
�߼���r > rightʱ��l������ܻ��У�

	
*/
	
	private static void copyArray(int[] indexArray, int[] prevIndexArray, int start, int end) {
		for (int i = start; i <= end; i++) {
			prevIndexArray[i] = indexArray[i];
		}
	}

}
