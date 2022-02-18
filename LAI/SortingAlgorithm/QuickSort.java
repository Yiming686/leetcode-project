package SortingAlgorithm;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = ArrayGenerater.intArray(10, 1, 100);
		
//		int[] arr = ArrayGenerater.intArray(20, -100, 100);
		int[] arr = {15, 43, 95, 73, 48, 75, 22, 62, 31, -2};
//		int[] arr = {-29, -12, 22, 63, 41, 77, 1, -71, -21, -97, 90, -33, -58, 95, 44, 59, 65, -13, -28, -26};
//		int[] arr = {-29, -12, 22, 63, 41, -26, 1, -26, -21, -97, 90, -26, -58, 95, -26, 59, 65, -13, -26, -26};
//		int[] arr = {-29, -12, 22, 63, 41, -26, 1, -26, -21, -97, 90, -26, -58, 95, -26, 59, 65, -13, -26, -26};

		System.out.println(""+Arrays.toString(arr));
		System.out.println(""+Arrays.toString(quickSort(arr)));
	}
	
	 static public int[] quickSort(int[] array) {
		    // Write your solution here
		    if(array == null || array.length <= 1){
		      return array;
		    }
		    quickSort(array, 0, array.length - 1);
		    return array;  
		  }
		  
	 static  private void quickSort(int[] array, int start, int end){
		    if(start >= end){
		      return; 
		    }
		    int pivotIndex = partition(array, start, end);
		    System.out.println(" partition: "+Arrays.toString(array));
		    quickSort(array, start, pivotIndex - 1);
		    System.out.println(" quickLeft: "+Arrays.toString(array));
		    quickSort(array, pivotIndex + 1, end);
		    System.out.println("quickRight"+Arrays.toString(array));
		  }
		  
		  static private int partition00(int[] array, int start, int end){
		    int pivotIndex = start + new java.util.Random().nextInt(end - start + 1);
		    int pivot = array[pivotIndex];
		    swap(array, pivotIndex, end);
		    int left = start;
		    int right = end - 1;
		    while(left <= right){
		      if(array[left] <= array[pivot]){
		        left++;
		      } else {
		        swap(array, left, right);
		        right--;
		      }
		    }
		    swap(array, left, end);
		    return left;
		  }
		  
		  static  private int partition(int[] array, int start, int end){
			  int pivotIndex = end;
		    int pivot = array[end];
		    int left = start;
		    int right = end - 1;
		    //left, right为待检测区域，每次减少一个,左侧已经为小于等于区，右侧为大于区间，
//		    最后left指向第一个大于的元素或者也有一种可能是第一个等于的元素，最后交换left和pivot没问题，和第一个大的交换或者原地不变
		    while(left <= right){
		      if(array[left] <= pivot){
		        left++;
		        System.out.println("Pivoit:"+pivot +", Left++: "+ left +", Right  : "+ right  +", End: " + end );
		      }else{
		        swap(array, left, right);
		        right--;
				System.out.println("Pivoit:"+pivot +", Left  : "+ left +", Right--: "+ right  +", End: " + end );
		      }
		    }
		    System.out.println("Pivoit:"+pivot +", Left: "+ left +", Right: "+ right  +", End: " + end );
		    swap(array, left, end);
		    pivotIndex = left;
		    return pivotIndex;
		  }
		  
		  
		  static	   private int partitionOK(int[] array, int start, int end){
		    int pivot = array[end];
		    int left = start;
		    int right = end - 1;
		    while(left <= right){
		      if(array[left] < pivot){
		        left++;
		      }else{
		        swap(array, left, right);
		        right--;
		      }
		    }
		    swap(array, left, end);
		    return left;
		  }
		  
		  static  private void swap(int [] array, int left, int right){
		    int temp = array[left];
		    array[left] = array[right];
		    array[right] = temp;
		  }

		  
}
