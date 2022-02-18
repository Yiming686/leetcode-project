package SortingAlgorithm;


import static Utils.ArrayUtils.*;

public class Merge_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = buildIntArrayNoDup(8, 2, 20);
		mergeSort(arr);
		print(arr);
	}
	
	  public static int[] mergeSort(int[] array) {
		   if(array == null || array.length <= 1){
		       return array;
		   }
	
		   int[] copy = new int[array.length];
		   mergeSort(array, copy, 0, array.length - 1);
		   return array;
	}

	  private static void mergeSort(int[] array, int[] copy, int left, int right){
		   if(left >= right){// base case£ºonly one element need sort
		       return;
		   }
		   //Åü³É2°ë
		   int mid = left + (right - left) / 2;
		   mergeSort(array, copy, left, mid);
		   mergeSort(array, copy, mid + 1, right);
		   merge(array, copy, left, mid, right);
	}

	//Ë­Ð¡ÒÆË­
	  private static void merge(int[] array, int[] copy, int leftBound, int mid, int rightBound){
	  //   for(int i = 0; i < array.length; i++){
//	         copy[i] = array[i];
	  //   }
	     for(int i = leftBound; i <= rightBound; i++){
	        copy[i] = array[i];
	     }
	     int leftIndex = leftBound;
	     int rightIndex = mid + 1;;
	     while(leftIndex <= mid && rightIndex <= rightBound){
	         if(copy[rightIndex] < copy[leftIndex]){
	             array[leftBound++] = copy[rightIndex++];
	         }else{
	             array[leftBound++] = copy[leftIndex++];
	         }
	     }
	     while(leftIndex <= mid){
	         array[leftBound++] = copy[leftIndex++];
	     }
	  }
	  
	

}
