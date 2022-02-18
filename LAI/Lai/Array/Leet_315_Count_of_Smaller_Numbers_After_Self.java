package Lai.Array;

import static Utils.ArrayUtils.convertListToIntArr;
import static Utils.ArrayUtils.mergeIntArrays;
import static Utils.ArrayUtils.print;
import static Utils.ArrayUtils.printIntArray;

import java.util.ArrayList;
import java.util.List;

import Utils.ArrayUtils;

public class Leet_315_Count_of_Smaller_Numbers_After_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
//		result.add(8);
//		result.get(2);
//		result.set(2, 7);
//		result.set(0, 4);
//		result.set(1, 9);
		System.out.println(""+result);
//		int[] arr = ArrayUtils.generateIntArrayNoDup(8, 0, 40);
//		int[] arr = {34,  7, 33, 38,  6, 19, 40, 22};
//		int[] arr = {28,  8,  2, 26, 10, 32, 15, 27};
		int[] arr = {5,2,6,1,0};
//		int[] arr = new int[]{5,2,6,1};
//		print(arr);
		printIntArray(arr, 3, true);
		System.out.println("count: ");
		printIntArray(convertListToIntArr(sortAndCountSmaller(arr)), 3, true);
		
	}
	
	public static List<Integer> sortAndCountSmaller(int[] index2ValArr) {
		List<Integer> result = new ArrayList<Integer>();		
		int[] pos2IndexArr = new int[index2ValArr.length];
		int[] copyPos2IndexArr = new int[index2ValArr.length];
		for(int i = 0; i < index2ValArr.length; i++) {
			pos2IndexArr[i] = i;
			copyPos2IndexArr[i] = i;
			result.add(0);
		}
		sortAndCountSmaller(result, pos2IndexArr, copyPos2IndexArr, index2ValArr, 0, index2ValArr.length - 1);
		printIntArray(pos2IndexArr, 3 ,true);
		return result;
	}

	private static void sortAndCountSmaller(List<Integer> result, int[] pos2IndexArr, int[] copyPos2IndexArr, int[] index2ValArr, int startPos, 
			int endPos) {
		if(startPos >= endPos) {
			return;
		}
		int midPos = startPos + (endPos - startPos) / 2;
		sortAndCountSmaller(result, pos2IndexArr, copyPos2IndexArr, index2ValArr, startPos, midPos);
		sortAndCountSmaller(result, pos2IndexArr, copyPos2IndexArr, index2ValArr, midPos + 1, endPos);
		mergeIntArrays(result, pos2IndexArr, copyPos2IndexArr, index2ValArr, startPos, midPos, endPos);
	}

	//val, index, pos
	private static void mergeIntArrays(List<Integer> result, int[] pos2IndexArr, int[] copyPos2IndexArr, int[] index2ValArr, int startPos,
			int midPos, int endPos) {
		for(int i = startPos; i <= endPos; i++) {
			copyPos2IndexArr[i] = pos2IndexArr[i];
		}
		int leftPos = startPos;
		int rightPos = midPos + 1;
		int currPos = startPos;
		while(leftPos <= midPos && rightPos <= endPos) {
			if(index2ValArr[copyPos2IndexArr[leftPos]] <= index2ValArr[copyPos2IndexArr[rightPos]]) { // compare val, not index, not pos
//				System.out.println("index: "+prevIndexArr[left]);
				pos2IndexArr[currPos++] = copyPos2IndexArr[leftPos++];
				result.set(copyPos2IndexArr[leftPos], result.get(copyPos2IndexArr[leftPos]) + rightPos - midPos - 1);
			}else {
				pos2IndexArr[currPos++] = copyPos2IndexArr[rightPos++];
			}
		}
		while(leftPos <= midPos) {
			result.set(copyPos2IndexArr[leftPos], result.get(copyPos2IndexArr[leftPos]) + rightPos - midPos - 1);
			pos2IndexArr[currPos++] = copyPos2IndexArr[leftPos++];			
		}
		
	}
	
	

}
