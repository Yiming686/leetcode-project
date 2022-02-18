package Lai.DB22.DFS_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Utils.ArrayUtils;

public class Plus_Minus_Multipy_Divide_To_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,5,7};
//		int[] arr = {2,5,1,12};
//		int[] arr = {4,4,4,4};
//		int[] arr = {1,2,2,4};
//		int[] arr = {5, 12, 3, 8};
//		int[] arr = { 7,  6, 13,  4};
		
//		int[] arr = {5,9,7,6};
//		int[] arr = { 6,9,13,5};//13,  5,  6,  9
//		int[] arr = { 10,11,12,5};//13,  5,  6,  9
//		int[] arr = {bbbdsggd};
//		int[] arr = {8,12,12,10};
//		int[] arr = {4,6,12,13}
//		int[] arr = {1,2,8,12};
//		int[] arr = {4,6,7,10};
		int[] arr = {3,4,2,1};
		System.out.println(""+ to24(arr));
		
//		int k = 3;
//		int numOfSol = 4;
//		findTo24(k, numOfSol);
		
//		int[] rangeOfSol = {0, 0};
//		findTo24(k, rangeOfSol);
	}
	
	private static void findTo24(int k, int numOfSol) {
		while(--k >= 0) {
			int[] arr2 = ArrayUtils.buildIntArray(4, 1, 13, false);
			List<String>list2 = to24(arr2);
			if(numOfSol == 0) {
				if(list2.size() == 0) {
					ArrayUtils.printIntArray(arr2);
					System.out.println("-NO-NO-NO-NO-NO-NO-NO-NO-: "+ list2);
					System.out.println("");
				}else {
					k++;
				}
			}else if(list2.size() == numOfSol) {
				ArrayUtils.printIntArray(arr2);
				System.out.println("========================> "+ list2);
				System.out.println("");
			}else {
				k++;
			}
		}
	}
	
	private static void findTo24(int k, int[] numOfSol) {
		while(--k >= 0) {
			int[] arr2 = ArrayUtils.buildIntArray(4, 1, 13, false);
			List<String>list2 = to24(arr2);
			if(numOfSol[0] == 0 && numOfSol[1] == 0) {
				if(list2.size() == 0) {
					ArrayUtils.printIntArray(arr2);
					System.out.println("-NO-NO-NO-NO-NO-NO-NO-NO-: "+ list2);
					System.out.println("");
				}else {
					k++;
				}
			}else if(list2.size() >= numOfSol[0] && list2.size() <= numOfSol[1]) {
				ArrayUtils.printIntArray(arr2);
//				System.out.println("-NO-NO-NO-NO-NO-NO-NO-NO-: "+ list2);
				System.out.println("========================> "+ list2);
				System.out.println("");
			}else {
				k++;
			}
		}

	}

	private static List<String> to24(int[] arr) {
		List<String>  result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder(); 
		 dfs(result, sb, arr, 0, 0);
		 return result;
	}

	private static void dfs(List<String> result, StringBuilder sb, int[] arr, int pos, int val) {
		// TODO Auto-generated method stub
		if(pos == arr.length) {
//			if(val == 24) {
//				result.add(Arrays.toString(arr));
				result.addAll(printTo24(arr));
//			}
			return;
		}
//		sb.append("(");
		Set<Integer> set = new HashSet<>();
		for (int i = pos; i < arr.length; i++) {
			if(set.add(arr[i])) {
				swap(arr, pos, i);
//			sb.append(arr[i]);
				dfs(result, sb, arr, pos + 1, val);
//			sb.deleteCharAt(sb.length() - 1);
				swap(arr, pos, i);
			}
		}
//		sb.append(")");
		
	}
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	private static List<String> printTo24(int[] arr) {
		List<String>  result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
//		System.out.println("arr:"+Arrays.toString(arr));
		sb.append("\n====> (((" + arr[0]);
		to24(result, sb, arr, 1, arr[0]);
//		System.out.println("result:"+result);
		return result;
	}

	private static void to24(List<String> result, StringBuilder sb, int[] arr, int i, int prevVal) {
		if(i == arr.length) {
			if(prevVal == 24) {
				result.add(sb.toString() );
			}
			return;
		}
//--- try next arr[i] ----------------------------------------------------------------
		int len = sb.length();
		sb.append("+" + arr[i] + ")");
		to24(result, sb, arr, i + 1, prevVal + arr[i]);
//		sb.deleteCharAt(sb.length() - 1);
		sb.setLength(len);
		
		sb.append("-" + arr[i] + ")");
		to24(result, sb, arr, i + 1, prevVal - arr[i]);
		sb.setLength(len);
		
		sb.append("*" + arr[i] + ")");
		to24(result, sb, arr, i + 1, prevVal * arr[i]);
		sb.setLength(len);
		
		if(prevVal % arr[i] == 0) {
			sb.append("/" + arr[i] + ")");
			to24(result, sb, arr, i + 1, prevVal / arr[i]);
			sb.setLength(len);
		}		
//-------------------------------------------------------------------
//		Set<Integer> set = new HashSet<>();
//		if(i+1 < arr.length) {
//			set.add(arr[i] + arr[i+1]); 
//			set.add(arr[i] - arr[i+1]);
//			set.add(arr[i] * arr[i+1]);
//			if(arr[i] % arr[i+1] == 0) {
//				set.add(arr[i] / arr[i+1]);
//			}
//		}
//		for(int val : set) {
//			sb.append("+" + val + ")");
//			to24(result, sb, arr, i + 1, prevVal + val);
////		sb.deleteCharAt(sb.length() - 1);
//			sb.setLength(len);
//			
//			sb.append("-" + val + ")");
//			to24(result, sb, arr, i + 1, prevVal - val);
//			sb.setLength(len);
//			
//			sb.append("*" + val + ")");
//			to24(result, sb, arr, i + 1, prevVal * val);
//			sb.setLength(len);
//			
//			if(prevVal % val == 0) {
//				sb.append("/" + val + ")");
//				to24(result, sb, arr, i + 1, prevVal / val);
//				sb.setLength(len);
//			}				
//		}

		
		
//		for(int i = pos; i < arr.length; i++) {
//			if(pos == 0) {
////				sb.append();
//				to24(result, sb, arr, pos + 1, val);
//				sb.deleteCharAt(sb.length() - 1);
//			}else {
//			}
//		}
		
	}


}
