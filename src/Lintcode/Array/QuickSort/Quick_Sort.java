package Lintcode.Array.QuickSort;

import java.util.Arrays;

import com.sun.jmx.snmp.internal.SnmpAccessControlSubSystem;

public class Quick_Sort {

		public static void main(String[] args) {
			int[] x = { 9, 2, 4, 7, 3, 7, 10};
//			int[] x = { 3,3,3,6,3,6,3,6,3,6,6,6,6};
//			int[] x = { 9, 2, 4, 7, 3, 7, 10, 2, 3};
			System.out.println(Arrays.toString(x));
	 
			int low = 0;
			int high = x.length - 1;
	 
			quickSort(x, low, high);
			System.out.println(Arrays.toString(x));
		}
	 
		public static void quickSort(int[] arr, int low, int high) {
			if (arr == null || arr.length == 0)
				return;
			if (low >= high)
				return;
			// pick the pivot��mid���ܵ���low
			int middle = low + (high - low) / 2;
//			int middle = low ;
//			int middle = high ;

			int pivot = arr[middle];
			// make left < pivot and right > pivot
			//��ô�ƹ�mid,i���ܵ���mid
			int i = low, j = high;
			while (i < j) {
				//���iλ�õ�Ԫ���Ѿ�С��pivot�������������,��Ϊ�ϸ����������ڶ��������
				while (arr[i] < pivot) {
					i++;
				}
				//���jλ�õ�Ԫ���Ѿ�����pivot��������ǰ��������Ϊ�ϸ����������ڶ�����ǰ��
				while (arr[j] > pivot) {
					j--;
				}
				//��ʱarr[i]���ܵ���pivot,����arr[j]���ܵ���pivot,����arr[i] == arr[j] == pivot
				if (i < j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				i++;
				j--;
				System.out.print("i: "+i);
				System.out.print("j: "+j);
			}
			System.out.println();
			// recursively sort two sub parts
			if (low < j)
				quickSort(arr, low, j);
	 
			if (high > i)
				quickSort(arr, i, high);

//			// recursively sort two sub parts
////			if (low < middle)
//				quickSort(arr, low, middle-1);
//	 
////			if (high > middle)
//				quickSort(arr, middle + 1, high);
		}

}
