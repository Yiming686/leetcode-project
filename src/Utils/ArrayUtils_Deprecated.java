package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;



public class ArrayUtils_Deprecated<T> {
	
	public static void main(String[] args) {
//		int[] arr = generateIntArrayNoDup(10, 3, 19);
		int[] arr = generateIntArrayWithDup(10, 3, 19);
		Arrays.sort(arr);
//		int[] arr = generateIntArray(10, 3, 9);
//		System.out.println(""+Arrays.toString(arr));
//		char[] arr = generateCharArray(8, 'a', 'h');
		System.out.println(""+Arrays.toString(arr));
//		swap(arr, 0, arr.length - 1);
//		System.out.println(""+Arrays.toString(arr));
//		System.out.println(""+);
	}

//---Generate Int Array---------------------------------------------------------------------------------------------------------------
	
	//not a good one which generaate duplicate elements.
	public static int[] generateIntArray_OLD(int size, int left, int right){
		int[] arr = new int[size];
		int range = right - left + 1;
		for(int i = 0; i < size; i++) {
			arr[i] = left + (int)(Math.random() * range );
			if(arr[i] == left || arr[i] == right || arr[i] == right - 1) {
//				System.out.println(""+arr[i]);
			}
		}
		System.out.println("Generated Char Array: "+Arrays.toString(arr));
		return arr;
	}
	
	public static int[] generateIntArray(int size, int left, int right){
		return generateIntArrayNoDup(size, left, right);
	}
	public static int[] generateIntArrayNoDup(int size, int left, int right){
		int[] arr = new int[size];
		if(right - left + 1 < size) {
			throw new IllegalArgumentException("Illegal Arguments! Range is less than size");
		}
		int range = right - left + 1;
		int i = 0;
		Set<Integer> set = new HashSet<>();
		while(set.size() < size) {
			int val = left + (int)(Math.random() * range );
			if(set.add(val)) {
				arr[i++] = val;				
			}
		}
		System.out.println("No Dup Array: "+Arrays.toString(arr));
		return arr;
	}
	
	public static int[] generateIntArrayWithDup(int size, int left, int right){
		int[] arr = generateIntArrayNoDup(size, left, right);
		return generateDup(arr);
	}
	
	private static int[] generateDup(int[] arr) {
		if(arr == null || arr.length < 2) {
			return arr;
		}
		//arr has no dup, also the one to be returned
		System.out.println("Generated Char Array: "+Arrays.toString(arr));
//		boolean[] visited = new boolean[arr.length]; // mark if visited

		List<Point> points = buildPointList(arr);
		while(points.size() > 1) {
			int range = points.size();//cacl range by index in dup
			int index = (int)(Math.random() * range );//the one to be duplicated
			Point point0 = points.remove(index);
			int times = (int)(Math.random() * range ) + 1;
			times /= 2;
			System.out.print("index: " + point0.index +", value: "+ point0.value + ", times: " + times);
			
			while(--times > 0) {//loop times - 1 times
				range = points.size();
				index = (int)(Math.random() * range );//the one to be duplicated
				System.out.print(", "+index );
				Point point = points.remove(index);
				arr[point.index] = arr[point0.index];
//				visited[point.index] = true;
			}
			System.out.println();
		}
		return arr;
	}
	
	private static List<Point> buildPointList(int[] arr) {
		List<Point> result  = new ArrayList<>(); 
		if(arr == null || arr.length < 1) {
			return result;
		}
		for(int i = 0; i < arr.length; i++) {
			result.add(new Point(i, arr[i]));
		}
		return result;
	}

	private static class Point{
		int index;
		int value;
		public Point(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
		
	}
	private static int[] generateDup00(int[] arr) {
		// TODO Auto-generated method stub
		if(arr == null || arr.length < 2) {
			return arr;
		}
		//arr has no dup, also the one to be returned
		System.out.println("Generated Char Array: "+Arrays.toString(arr));
		boolean[] visited = new boolean[arr.length]; // mark if visited
		//dup is not as arr,
		int[] dup = Arrays.copyOf(arr, arr.length);// one step to find next one to be duplicated
		//the ones next to leftIndex(exclusive) are all unique
		int leftIndex = 0;//index in dup
		while(leftIndex + 1 < arr.length) {
			//pick element: arr[index]
			int range = arr.length - leftIndex - 1;//cacl range by index in dup
			int index = leftIndex + (int)(Math.random() * range );//the one to be duplicated
			//determine how many duplicates
			int times = (int)(Math.random() * range ) + 1;
			//pick index times and copy arr[index] to position and mark visited
			visited[index] = true;
			System.out.println("index" + index +", value: "+ dup[index] + ", times: " + times);
			System.out.println("Generated Char Array:arr: "+Arrays.toString(arr));
			System.out.println("Generated Char Array:visited: "+Arrays.toString(visited));
			while(--times > 0) {
				int nextIndex = findNextIndex(visited);
				arr[nextIndex] = arr[index];
				swap(dup, nextIndex, leftIndex);
				visited[nextIndex] = true;
				leftIndex++;
			}
			
		}
		return arr;
	}

	private static int findNextIndex(boolean[] visited) {
		// TODO Auto-generated method stub
		if(visited == null || visited.length < 1) {
			return -1;
		}
		boolean allVisited = true;//assume all are visited
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {//find one is not visited, mark allvisited false;
				allVisited = false;
				break;
			}
		}
		if(allVisited) {
			return -1;
		}
		int range = visited.length;
		int index = (int)(Math.random() * range);
		while(visited[index]) {
			index = (int)(Math.random() * range );
		}
		return index;
	}


	
	public static char[] generateCharArray(int size, char left, char right){
		char[] arr = new char[size];
		int range = right - left + 1;
		for(int i = 0; i < size; i++) {
			arr[i] = (char)(left + (int)(Math.random() * range ));
			if(arr[i] == left || arr[i] == right || arr[i] == right - 1) {
//				System.out.println(""+arr[i]);
			}
		}
		System.out.println("Generated Char Array: "+Arrays.toString(arr));
		return arr;
	}

	public static char[] generateCharArrayNoDup(int size, char left, char right){
		char[] arr = new char[size];
		if(right - left + 1 < size) {
			return arr;
		}
		int range = right - left + 1;
		int i = 0;
		Set<Character> set = new HashSet<>();
		while(set.size() < size) {
			char val = (char)(left + (int)(Math.random() * range ));
			if(set.add(val)) {
				arr[i++] = val;				
			}
		}
		System.out.println("Generated Char Array: "+Arrays.toString(arr));
		return arr;
	}

	public static Integer[] generateIntegerArray(int size, int left, int right){
		Integer[] arr = new Integer[size];
		int range = right - left + 1;
		for(int i = 0; i < size; i++) {
			arr[i] = left + (int)(Math.random() * range );
			if(arr[i] == left || arr[i] == right || arr[i] == right - 1) {
//				System.out.println(""+arr[i]);
			}
		}
		System.out.println("Generated Int Array: "+Arrays.toString(arr));
		return arr;
	}

	public static <T> void swap(T[] arr, int left, int right){
		T temp = arr[left];		
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void swap(int[] arr, int left, int right){
		int temp = arr[left];		
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void swap(char[] arr, int left, int right){
		char temp = arr[left];		
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void print(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println(""+Arrays.toString(arr));
	}


}
