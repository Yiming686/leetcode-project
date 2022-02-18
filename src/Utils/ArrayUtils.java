package Utils;

import static Utils.ArrayUtils.toStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.TransactionRequiredException;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;
import com.sun.javafx.sg.prism.web.NGWebView;

import sun.misc.CharacterEncoder;

/**
 * @author yiming
 *
 * @param <T>
 */
//public class ArrayUtils<T> {
public class ArrayUtils {
	public static void AAA() {
		
	}
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printIntArray(convertInt2IntArr(003));
//		int[] arr = generateIntArray(10, 3, 19);
//		int[] arr = generateIntArray(10, 3, 19, false);
//		int[] arr = generateIntArray(10, 3, 19, true);

//		int[] arr = generateIntArrayNoDup(10, 3, 19);
//		int[] arr = generateIntArrayNoDup(10, 3, 19, false);
//		int[] arr = generateIntArrayNoDup(10, 3, 19, true);

//		int[] arr = generateIntArrayNoDupSorted(10, 3, 19);
//		int[] arr = generateIntArrayNoDupSorted(10, 3, 19, false);
//		int[] arr = generateIntArrayNoDupSorted(10, 3, 19, true);

//		int[] arr = generateIntArrayWithDup(10, 3, 19);
//		int[] arr = generateIntArrayWithDup(10, 3, 19, false);
//		int[] arr = generateIntArrayWithDup(10, 3, 19, true);

//		int[] arr = generateIntArrayWithDupSorted(10, 3, 19);
//		int[] arr = generateIntArrayWithDupSorted(10, 3, 19, false);
//		int[] arr = generateIntArrayWithDupSorted(10, 3, 19, true);

//		int[] arr = generateIntArrayAllDup(9, 5);
//		int[] arr = generateIntArrayAllDup(9, 5, false);
//		int[] arr = generateIntArrayAllDup(9, 5, true);

//		Arrays.sort(arr);
//		print(arr);
//		printIntArray(arr);
//		int[] arr = generateIntArray(10, 3, 9);
//		System.out.println(""+Arrays.toString(arr));
//		char[] arr = generateCharArray(8, 'a', 'h');
//		System.out.println(""+Arrays.toString(arr));
//		swap(arr, 0, arr.length - 1);
//		System.out.println(""+Arrays.toString(arr));
//		System.out.println(""+);
	}

//--- Generate Int Array: Start ---------------------------------------------------------------------------------------------------------------

	public static int[] buildNewSortedIntArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] copy = new int[arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);
		Arrays.sort(copy);
		return copy;
	}

//	0.generateIntArray(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
//	Commonly used one which generate NO duplicate elements.
	/**
	 * @param size
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] buildIntArray(int size, int min, int max) {
		boolean toPrint = true;
		return buildIntArray(size, min, max, toPrint);
	}

	public static int[] buildIntArray(int size, int min, int max, boolean toPrint) {
		int[] arr = buildIntArrayNoDup(size, min, max, false);
		if (toPrint)
			printIntArray("No Dup Array: ", arr);
		return arr;
	}

//	1.generateIntArrayNoDup():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
//	Commonly used one which generate NO duplicate elements.
	public static int[] buildIntArrayNoDup(int size, int min, int max) {
		return buildIntArrayNoDup(size, min, max, true);
	}

	public static int[] buildIntArrayNoDup(int size, int min, int max, boolean toPrint) {
		int[] arr = new int[size];
		int range = max - min + 1;
		//required, mandatory, or infinite loop would be there in the next while loop
		if (range < size) {
			throw new IllegalArgumentException(
					"Illegal Arguments! When generating Int Array with No Dup, range is less than size!!");
		}
		int i = 0;
		Set<Integer> set = new HashSet<>();
		while (set.size() < size) {
			int val = min + (int) (Math.random() * range);
			if (set.add(val)) {
				arr[i++] = val;
			}
		}
		if (toPrint)
			printIntArray("No Dup Array: ", arr);
		return arr;

	}

//	2.generateIntArrayWithDup():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）	
//	Commonly used one which MUST generate duplicate elements.
	public static int[] buildIntArrayWithDup(int size, int min, int max) {
		return buildIntArrayWithDup(size, min, max, true);
	}

	private static int[] buildIntArrayWithDup(int size, int min, int max, boolean toPrint) {
		int[] arr = new int[size];
		int range = max - min + 1;
		for (int i = 0; i < arr.length; i++) {
			int val = min + (int) (Math.random() * range);
			arr[i] = val;
		}
		if (toPrint)
			printIntArray("With Dup Array: ", arr);
		return arr;

	}

	private static int[] buildIntArrayWithDup22(int size, int min, int max, boolean toPrint) {
		// TODO Auto-generated method stub
		int[] arr = buildIntArrayNoDup(size, min, max, false);
		arr = buildDup(arr, false);
		if (toPrint)
			printIntArray("With Dup Array: ", arr);
		return arr;
	}

	//其实，还没有百分百确保包含重复，万一每一个选定元素，对应的复制次数是0, 1，则另外复制了。极其特殊情况下，是没有重复元素的。
	private static int[] buildDup(int[] arr, boolean toPrint) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		//arr has no dup, also the one to be returned
		List<Point<Integer>> points = buildPointList(convertIntArr2IntegerArr(arr));
		TreeSet<Integer> treeSet = new TreeSet<>();
		while (points.size() > 1) {
			treeSet.clear();
			int range = points.size();//cacl range by index in dup
			int index = (int) (Math.random() * range);//the one to be duplicated
			Point<Integer> point0 = points.remove(index);
			treeSet.add(point0.index);
			int numOfDup = (int) (Math.random() * range) + 2;
			numOfDup /= 2;
			int times = numOfDup;
			while (--times > 0) {//loop times - 1 times
				range = points.size();
				index = (int) (Math.random() * range);//the one to be duplicated
				Point<Integer> point = points.remove(index);
				treeSet.add(point.index);
				arr[point.index] = arr[point0.index];
			}
			if (toPrint)
				System.out.printf("index: %2d, value: %3d, numOfDup: %3d, as in %s\n", point0.index, point0.value,
						numOfDup, treeSet);
		}
		if (toPrint)
			System.out.println();
		return arr;
	}

	private static <E> List<Point<E>> buildPointList(E[] arr) {
		List<Point<E>> result = new ArrayList<>();
		if (arr == null || arr.length < 1) {
			return result;
		}
		for (int i = 0; i < arr.length; i++) {
			result.add(new Point<E>(i, arr[i]));
		}
		return result;
	}

	private static class Point<E> {
		int index;
		E value;

		public Point(int index, E value) {
			super();
			this.index = index;
			this.value = value;
		}

	}

//	3.generateIntArrayAllDup():   在指定[start, end]范围内，生成大小为n的整数数组，全部都是重复元素：
	//返回整数数组，大小为size，其值全部为val
	public static int[] buildIntArrayAllDup(int size, int val) {
		boolean toPrint = true;
		return buildIntArrayAllDup(size, val, toPrint);
	}

	public static int[] buildIntArrayAllDup(int size, int val, boolean toPrint) {
		int[] arr = new int[size];
		Arrays.fill(arr, val);
		if (toPrint)
			printIntArray("All Dup Array: ", arr);
		return arr;
	}

//	4.generateIntArraySorted(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	public static int[] buildIntArraySorted(int size, int min, int max) {
		return buildIntArrayNoDupSorted(size, min, max);
	}

	public static int[] buildIntArraySorted(int size, int min, int max, boolean toPrint) {
		return buildIntArrayNoDupSorted(size, min, max, toPrint);
	}

//	5.generateIntArrayNoDupSorted():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	public static int[] buildIntArrayNoDupSorted(int size, int min, int max) {
		boolean toPrint = true;
		return buildIntArrayNoDupSorted(size, min, max, toPrint);
	}

	public static int[] buildIntArrayNoDupSorted(int size, int min, int max, boolean toPrint) {
		int[] arr = buildIntArrayNoDup(size, min, max, false);
		Arrays.sort(arr);
		if (toPrint)
			printIntArray("No Dup Array Sorted: ", arr);
		return arr;
	}

//	6.generateIntArrayWithDupSorted():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）, 同时排好序;
	//by default, less log
	public static int[] buildIntArrayWithDupSorted(int size, int min, int max) {
		boolean toPrint = true;
		return buildIntArrayWithDupSorted(size, min, max, toPrint);
	}

	public static int[] buildIntArrayWithDupSorted(int size, int min, int max, boolean toPrint) {
		int[] arr = buildIntArrayWithDup(size, min, max, false);
		Arrays.sort(arr);
		if (toPrint)
			printIntArray("With Dup Array Sorted: ", arr);
		return arr;
	}

	public static Integer[] buildIntegerArray(int size, int min, int max) {
		return convertIntArr2IntegerArr(buildIntArray(size, min, max));
	}

	public static Integer[] buildIntegerArray(int size, int min, int max, boolean toPrint) {
		return convertIntArr2IntegerArr(buildIntArray(size, min, max, toPrint));
	}

	public static Integer[] buildIntegerArrayNoDup(int size, int min, int max) {
		return convertIntArr2IntegerArr(buildIntArrayNoDup(size, min, max, true));
	}

	public static Integer[] buildIntegerArrayNoDup(int size, int min, int max, boolean toPrint) {
		return convertIntArr2IntegerArr(buildIntArrayNoDup(size, min, max, toPrint));
	}

	public static Integer[] buildIntegerArrayWithDup(int size, int min, int max) {
		return convertIntArr2IntegerArr(buildIntArrayWithDup(size, min, max, true));
	}

	public static Integer[] buildIntegerArrayWithDup(int size, int min, int max, boolean toPrint) {
		return convertIntArr2IntegerArr(buildIntArrayWithDup(size, min, max, toPrint));
	}

	public static Integer[] buildIntegerArrayAllDup(int size, int val) {
		boolean toPrint = true;
		return convertIntArr2IntegerArr(buildIntArrayAllDup(size, val, toPrint));
	}

	public static Integer[] buildIntegerArrayAllDup(int size, int val, boolean toPrint) {
		return convertIntArr2IntegerArr(buildIntArrayAllDup(size, val, toPrint));
	}

	public static Integer[] buildIntegerArrayNoDupSorted(int size, int min, int max) {
		boolean toPrint = true;
		return convertIntArr2IntegerArr(buildIntArrayNoDupSorted(size, min, max, toPrint));
	}

	public static Integer[] buildIntegerArrayWithDupSorted(int size, int min, int max) {
		boolean toPrint = true;
		return convertIntArr2IntegerArr(buildIntArrayWithDupSorted(size, min, max, toPrint));
	}

//	--- Generate Int Array: End ---------------------------------------------------------------------------------------------------------------

//	--- Generate Char Array: Start ---------------------------------------------------------------------------------------------------------------
//	0.generateIntArray(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
//	Commonly used one which generate NO duplicate elements.
	public static char[] buildCharArray(int size, char min, char max) {
		boolean toPrint = true;
		return buildCharArray(size, min, max, toPrint);
	}

	public static char[] buildCharArray(int size, char min, char max, boolean toPrint) {
		char[] arr = buildCharArrayNoDup(size, min, max, false);
		if (toPrint)
			printCharArray("No Dup Array: ", arr);
		return arr;
	}

//	1.generateIntArrayNoDup():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素：
//	Commonly used one which generate NO duplicate elements.
	public static char[] buildCharArrayNoDup(int size, char min, char max) {
		return buildCharArrayNoDup(size, min, max, true);
	}

	public static char[] buildCharArrayNoDup(int size, char min, char max, boolean toPrint) {
		char[] arr = new char[size];
		if (max - min + 1 < size) {
			throw new IllegalArgumentException("Illegal Arguments! Range is less than size");
		}
		int range = max - min + 1;
		int i = 0;
		Set<Character> set = new HashSet<>();
		while (set.size() < size) {
			char val = (char) (min + (int) (Math.random() * range));
			if (set.add(val)) {
				arr[i++] = val;
			}
		}
		if (toPrint)
			printCharArray("No Dup Array: ", arr);
		return arr;

	}
//	2.generateIntArrayWithDup():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）	
//	Commonly used one which MUST generate duplicate elements.
	public static char[] buildCharArrayWithDupHighly(char min, char max) {
		int size = 21;
		Random random = new Random();
		size = random.nextInt(size);
		return buildCharArrayWithDupHighly(size, min, max, true);
	}
	
	public static char[] buildCharArrayWithDupHighly(int size, char min, char max) {
		return buildCharArrayWithDupHighly(size, min, max, true);
	}

	public static char[] buildCharArrayWithDupHighly(int size, char min, char max, boolean toPrint) {
		char[] arr = new char[size];
		Random random = new Random();
		int width = max - min + 1;
		for(int i = 0; i < size; i ++) {
			arr[i] = (char)(min + random.nextInt(width));
		}
		if (toPrint) {
			printCharArray("With highly Dup Array: ", arr);
		}
		return arr;
	}
	
	public static char[] buildCharArrayWithDup(int size, Map<Character, Integer> char2ProbMap) {
		return buildCharArrayWithDup(size, char2ProbMap, true);
	}
	public static char[] buildCharArrayWithDup(int size, Map<Character, Integer> char2ProbMap, boolean toPrint) {
		List<Character> list = new ArrayList<>();
		for(Map.Entry<Character, Integer> entry : char2ProbMap.entrySet()) {
			for(int i = 0; i < entry.getValue(); i++) {
				list.add(entry.getKey());
			}
		}
		return buildCharArrayWithDup(size, list, toPrint);
	}
	
	public static char[] buildCharArrayWithDup(int size, List<Character> list) {
		return buildCharArrayWithDup(size, list, true);
	}
	
	public static char[] buildCharArrayWithDup(int size, List<Character> list, boolean toPrint) {
		char[] arr = new char[size];
		for(int i = 0; i < size; i++) {
			arr[i] = list.get((int)(Math.random() * list.size()));
		}
		if (toPrint)
			printCharArray("With Dup Array: ", arr);
		return arr;
		
	}
//	public static char[] buildCharArrayWithDup(int size, Map<Character, Integer> char2ProbMap, boolean toPrint) {
//		char[] arr = new char[size];
//		List<Character> list = new ArrayList<>();
//		for(Map.Entry<Character, Integer> entry : char2ProbMap.entrySet()) {
//			for(int i = 0; i < entry.getValue(); i++) {
//				list.add(entry.getKey());
//			}
//		}
//		for(int i = 0; i < size; i++) {
//			arr[i] = list.get((int)(Math.random() * list.size()));
//		}
//		if (toPrint)
//			printCharArray("With Dup Array: ", arr);
//		return arr;
//	}

//	public static char[] buildCharArrayWithDup(int size, Map<Character, Integer> char2ProbMap) {
//		return buildCharArrayWithDup(size, char2ProbMap, true);
//	}

	public static char[] buildCharArrayWithDup(int size, char min, char max) {
		return buildCharArrayWithDup(size, min, max, true);
	}
	public static char[] buildCharArrayWithDup(int size, char min, char max, boolean toPrint) {
		// TODO Auto-generated method stub
		char[] arr = new char[size];
		int range = max - min + 1;
		for(int i = 0; i < size; i++) {
			arr[i] = (char)(Math.random() * range + min);
		}
		if (toPrint)
			printCharArray("With Dup Array: ", arr);
		return arr;
	}
	
//	comment out 01/31/2020
//	public static char[] generateCharArrayWithDup(int size, char min, char max, boolean toPrint) {
//		// TODO Auto-generated method stub
//		char[] arr = generateCharArrayNoDup(size, min, max, false);
//		arr = generateDup(arr, false);
//		if (toPrint)
//			printCharArray("With Dup Array: ", arr);
//		return arr;
//	}

	//其实，还没有百分百确保包含重复，万一每一个选定元素，对应的复制次数是0, 1，则另外复制了。极其特殊情况下，是没有重复元素的。
	private static char[] generateDup(char[] arr, boolean toPrint) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		//arr has no dup, also the one to be returned
		List<Point<Character>> points = buildPointList(convertCharArr2CharacterArr(arr));
		TreeSet<Integer> treeSet = new TreeSet<>();
		while (points.size() > 1) {
			treeSet.clear();
			int range = points.size();//cacl range by index in dup
			int index = (int) (Math.random() * range);//the one to be duplicated
			Point<Character> point0 = points.remove(index);
			treeSet.add(point0.index);
			int numOfDup = (int) (Math.random() * range) + 2;
			numOfDup /= 2;
			int times = numOfDup;
			while (--times > 0) {//loop times - 1 times
				range = points.size();
				index = (int) (Math.random() * range);//the one to be duplicated
				Point<Character> point = points.remove(index);
				treeSet.add(point.index);
				arr[point.index] = arr[point0.index];
			}
			if (toPrint)
				System.out.printf("index: %2d, value: %3d, numOfDup: %3d, as in %s\n", point0.index, point0.value,
						numOfDup, treeSet);
		}
		if (toPrint)
			System.out.println();
		return arr;
	}

//	3.generateIntArrayAllDup():   在指定[start, end]范围内，生成大小为n的整数数组，全部都是重复元素：
	//返回整数数组，大小为size，其值全部为val
	public static char[] buildCharArrayAllDup(int size, char val) {
		boolean toPrint = true;
		return buildCharArrayAllDup(size, val, toPrint, true);
	}

	/**
	 * @param size
	 * @param val
	 * @param toPrint
	 * @return
	 */
	public static char[] buildCharArrayAllDup(int size, char val, boolean toPrint) {
		return buildCharArrayAllDup(size, val, toPrint, true);
//		char[] arr = new char[size]; 
//		Arrays.fill(arr, val);
//		if(toPrint) printCharArray("All Dup Array: ", arr);
//		return arr;
	}

	/**
	 * @param size
	 * @param val
	 * @param toPrint
	 * @param withIndex
	 * @return
	 */
	public static char[] buildCharArrayAllDup(int size, char val, boolean toPrint, boolean withIndex) {
		char[] arr = new char[size];
		Arrays.fill(arr, val);
		if (toPrint)
			printCharArray("All Dup Array: ", arr, withIndex);
		return arr;
	}

//	4.generateIntArraySorted(): 最常见的，在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	public static char[] buildCharArraySorted(int size, char min, char max) {
		return buildCharArrayNoDupSorted(size, min, max);
	}

	public static char[] buildCharArraySorted(int size, char min, char max, boolean toPrint) {
		return buildCharArrayNoDupSorted(size, min, max, toPrint);
	}

//	5.generateIntArrayNoDupSorted():    在指定[start, end]范围内，生成大小为n的整数数组，没有重复元素, 同时排好序;
	public static char[] buildCharArrayNoDupSorted(int size, char min, char max) {
		boolean toPrint = true;
		return buildCharArrayNoDupSorted(size, min, max, toPrint);
	}

	public static char[] buildCharArrayNoDupSorted(int size, char min, char max, boolean toPrint) {
		char[] arr = buildCharArrayNoDup(size, min, max, false);
		Arrays.sort(arr);
		if (toPrint)
			printCharArray("No Dup Array Sorted: ", arr);
		return arr;
	}

//	6.generateIntArrayWithDupSorted():  在指定[start, end]范围内，生成大小为n的整数数组，必须有重复元素：（重复个数不超过n/2个）, 同时排好序;
	//by default, less log
	public static char[] buildCharArrayWithDupSorted(int size, char min, char max) {
		boolean toPrint = true;
		return buildCharArrayWithDupSorted(size, min, max, toPrint);
	}

	public static char[] buildCharArrayWithDupSorted(int size, char min, char max, boolean toPrint) {
		char[] arr = buildCharArrayWithDup(size, min, max, false);
		Arrays.sort(arr);
		if (toPrint)
			printCharArray("With Dup Array Sorted: ", arr);
		return arr;
	}

	public static Character[] buildCharacterArray(int size, char min, char max) {
		return convertCharArr2CharacterArr(buildCharArray(size, min, max));
	}

	public static Character[] buildCharacterArray(int size, char min, char max, boolean toPrint) {
		return convertCharArr2CharacterArr(buildCharArray(size, min, max, toPrint));
	}

	public static Character[] buildCharacterArrayNoDup(int size, char min, char max) {
		return convertCharArr2CharacterArr(buildCharArrayNoDup(size, min, max, true));
	}

	public static Character[] buildCharacterArrayNoDup(int size, char min, char max, boolean toPrint) {
		return convertCharArr2CharacterArr(buildCharArrayNoDup(size, min, max, toPrint));
	}

	public static Character[] buildCharacterArrayWithDup(int size, Map<Character, Integer> char2ProbMap) {
		return convertCharArr2CharacterArr(buildCharArrayWithDup(size, char2ProbMap, true));
	}

	public static Character[] buildCharacterArrayWithDup(int size, char min, char max) {
		boolean toPrint = true;
		return convertCharArr2CharacterArr(buildCharArrayWithDup(size, min, max, toPrint));
	}

	public static Character[] buildCharacterArrayWithDup(int size, char min, char max, boolean toPrint) {
		return convertCharArr2CharacterArr(buildCharArrayWithDup(size, min, max, toPrint));
	}

	public static Character[] buildCharacterArrayAllDup(int size, char val) {
		boolean toPrint = true;
		return convertCharArr2CharacterArr(buildCharArrayAllDup(size, val, toPrint));
	}

	public static Character[] buildCharacterArrayAllDup(int size, char val, boolean toPrint) {
		return convertCharArr2CharacterArr(buildCharArrayAllDup(size, val, toPrint));
	}

	public static Character[] buildCharacterArrayNoDupSorted(int size, char min, char max) {
		boolean toPrint = true;
		return convertCharArr2CharacterArr(buildCharArrayNoDupSorted(size, min, max, toPrint));
	}

	public static Character[] buildCharacterArrayWithDupSorted(int size, char min, char max) {
		boolean toPrint = true;
		return convertCharArr2CharacterArr(buildCharArrayWithDupSorted(size, min, max, toPrint));
	}

//	--- Generate Char Array: End ---------------------------------------------------------------------------------------------------------------

//	--- Print Int Array or Char Array : Start ----------------------------------------------------------------------------------------------------------------

	public static void print(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}
	public static void print(String comment, String str) {
		// TODO Auto-generated method stub
		System.out.println(comment + str);
	}

	public static void printIntArray(String comment, String str) {
		System.out.println(comment+str);
	}


	public static void print(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("" + Arrays.toString(arr));
	}

	public static void print(int[] arr, boolean withIndex) {
		printIntArray(arr, withIndex);
	}

	public static void printIntArray(int[] arr) {
		printIntArrayWithIndex(arr);
	}

//	public static void printIntArray(int[] arr, boolean withIndex) {
//		if (withIndex) {
//			printIntArrayWithIndex(arr);
//		} else {
//			printIntArrayNoIndex(arr);
//		}
//	}
	
//	public static void printIntArray(int[] arr, int width) {
//		Integer[] exclusives = new Integer[0];
//		printIntArray(arr, width, exclusives);
//	}

	public static void printIntArray(int[] arr, int width) {
		boolean withIndex = false;
		Integer[] exclusives = new Integer[0];
		printIntArray(arr, width, withIndex, exclusives);
	}
	
	public static void printIntArray(int[] arr, boolean withIndex) {
		int width = 3;
		Integer[] exclusives = new Integer[0];
		printIntArray(arr, width, withIndex, exclusives);
	}
	
	public static void printIntArray(int[] arr, int width, boolean withIndex) {
		Integer[] exclusives = new Integer[0];
		printIntArray(arr, width, withIndex, exclusives);
	}
	
	public static void printIntArray(int[] arr, int width, boolean withIndex, Integer... exclusives) {
		if(arr == null) {
			System.out.println("Null Array!");
			return;
		}
		StringBuilder sbArr = new StringBuilder();
		StringBuilder sbIdx = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		if(exclusives != null) {
			set.addAll(Arrays.asList(exclusives));	
		}		
		sbArr.append("[");
		sbIdx.append(" ");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				sbArr.append(String.format("%s%" + width + "s", conn, ""));
			} else {
				sbArr.append(String.format("%s%" + width + "s", conn, arr[i]));
			}
			if(withIndex) {
				sbIdx.append(String.format("%s%" + width + "s", conn, i));
			}
			conn = ",";
		}
		sbArr.append("]");
		sbIdx.append(" ");
		System.out.println("" + sbArr.toString());
		if(withIndex) {
			System.out.println("" + sbIdx.toString());
		}
	}
	
	public static String toStr(int[] arr) {
		int width = 3;
		boolean withIndex = false;
		Integer[] exclusives = new Integer[0];
		return toStr(arr, width, withIndex, exclusives);
	}

	public static String toStr(int[] arr, int width) {
		boolean withIndex = false;
		Integer[] exclusives = new Integer[0];
		return toStr(arr, width, withIndex, exclusives);
	}

	public static String toStr(int[] arr,  boolean withIndex) {
		int width = 3;
		Integer[] exclusives = new Integer[0];
		return toStr(arr, width, withIndex, exclusives);
	}

	public static String toStr(int[] arr, int width, boolean withIndex) {
		Integer[] exclusives = new Integer[0];
		return toStr(arr, width, withIndex, exclusives);
	}
	public static String toStr(int[] arr, int width, boolean withIndex, Integer... exclusives) {
		if(arr == null) {
			return "null";
		}
		if(arr.length == 0) {
			return "[]";
		}
		StringBuilder sbArr = new StringBuilder();
		StringBuilder sbIdx = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		if(exclusives != null) {
			set.addAll(Arrays.asList(exclusives));	
		}		
		sbArr.append("[");
		sbIdx.append(" ");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				sbArr.append(String.format("%s%" + width + "s", conn, ""));
			} else {
				sbArr.append(String.format("%s%" + width + "s", conn, arr[i]));
			}
			if(withIndex) {
				sbIdx.append(String.format("%s%" + width + "s", conn, i));
			}
			conn = ",";
		}
		sbArr.append("]");
		sbIdx.append(" ");
		
		if(withIndex) {
			return sbArr.toString() + "\n" + sbIdx.toString();
		}else {
			return sbArr.toString();
		}
		
	}

	public static void printIntArray(String comment, int[] arr) {
		System.out.println(comment);
		printIntArrayWithIndex(arr);
	}

	public static void printIntArray(String comment, int[] arr, boolean withIndex) {
		System.out.println(comment);
		if (withIndex) {
			printIntArrayWithIndex(arr);
		} else {
			printIntArrayNoIndex(arr);
		}
	}

	public static void print(Integer[] arr) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		System.out.println("" + Arrays.toString(intArr));
	}

	public static void print(Integer[] arr, boolean withIndex) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		printIntArray(intArr, withIndex);
	}

	public static void printIntArray(Integer[] arr) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		printIntArrayWithIndex(intArr);
	}

	public static void printIntArray(Integer[] arr, boolean withIndex) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		if (withIndex) {
			printIntArrayWithIndex(intArr);
		} else {
			printIntArrayNoIndex(intArr);
		}
	}

	public static void printIntArray(String comment, Integer[] arr) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		System.out.println(comment);
		printIntArrayWithIndex(intArr);
	}

	public static void printIntArray(String comment, Integer[] arr, boolean withIndex) {
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		System.out.println(comment);
		if (withIndex) {
			printIntArrayWithIndex(intArr);
		} else {
			printIntArrayNoIndex(intArr);
		}
	}

	public static void printIntArrayNoIndex(int[] arr) {
		int width = 1;
		for (int i = 0; i < arr.length; i++) {
			width = Math.max(width, String.valueOf(arr[i]).length() + 1);
		}
		printIntArrayNoIndex(arr, width);
	}

	public static void printIntArrayNoIndex(int[] arr, int width) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			sb.append(String.format("%s%" + width + "s", conn, arr[i]));
			conn = ",";
		}
		sb.append("]");
		System.out.println("" + sb.toString());
		System.out.println();
	}

	public static void printIntArrayWithIndex(int[] arr) {
		int width = 1;
		for (int i = 0; i < arr.length; i++) {
			width = Math.max(width, String.valueOf(arr[i]).length() + 1);
		}
		width = width < 3 ? 3 : width;
		printIntArrayWithIndex(arr, width);
	}

	public static void printIntArrayWithIndex(int[] arr, int width) {
		StringBuilder sbArr = new StringBuilder();
		StringBuilder sbIdx = new StringBuilder();
		sbArr.append("[");
		sbIdx.append(" ");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			sbArr.append(String.format("%s%" + width + "s", conn, arr[i]));
			sbIdx.append(String.format("%s%" + width + "s", conn, i));
			conn = ",";
		}
		sbArr.append("]");
		sbIdx.append(" ");
		System.out.println("Array: " + sbArr.toString());
		System.out.println("Index: " + sbIdx.toString());
		System.out.println();
	}

// --- Above print Int Array,  Below print char Array --------------------------------------------------------
	public static void print(char[] arr) {
		// TODO Auto-generated method stub
		System.out.println("" + Arrays.toString(arr));
	}

	public static void printCharArray(char[] arr) {
		printCharArrayWithIndex(arr);
	}

	public static void printCharArray(char[] arr, boolean withIndex) {
		if (withIndex) {
			printCharArrayWithIndex(arr);
		} else {
			printCharArrayNoIndex(arr);
		}
	}

	public static void printCharArray(String comment, char[] arr) {
		System.out.println(comment);
		printCharArrayWithIndex(arr);
	}

	public static void printCharArray(String comment, char[] arr, boolean withIndex) {
		System.out.println(comment);
		if (withIndex) {
			printCharArrayWithIndex(arr);
		} else {
			printCharArrayNoIndex(arr);
		}
	}

	public static void printCharArrayNoIndex(char[] arr) {
		int width = 1;
		for (int i = 0; i < arr.length; i++) {
			width = Math.max(width, String.valueOf(arr[i]).length() + 1);
		}
		printCharArrayNoIndex(arr, width);
	}

	public static void printCharArrayNoIndex(char[] arr, int width) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			sb.append(String.format("%s%" + width + "s", conn, arr[i]));
			conn = ",";
		}
		sb.append("]");
		System.out.println("" + sb.toString());
		System.out.println();
	}

	public static void printCharArrayWithIndex(char[] arr) {
		int width = 1;
		for (int i = 0; i < arr.length; i++) {
			width = Math.max(width, String.valueOf(arr[i]).length() + 1);
		}
		printCharArrayWithIndex(arr, width);
	}

	public static void printCharArrayWithIndex(char[] arr, int width) {
		StringBuilder sbArr = new StringBuilder();
		StringBuilder sbIdx = new StringBuilder();
		sbArr.append("[");
		sbIdx.append(" ");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			sbArr.append(String.format("%s%" + width + "s", conn, arr[i]));
			sbIdx.append(String.format("%s%" + width + "s", conn, i));
			conn = ",";
		}
		sbArr.append("]");
		sbIdx.append(" ");
		System.out.println("Array: " + sbArr.toString());
		System.out.println("Index: " + sbIdx.toString());
		System.out.println();
	}

	public static void printCharArray(char[] arr, int width, Character... exclusives) {
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		set.addAll(Arrays.asList(exclusives));
		sb.append("[");
		String conn = "";
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				sb.append(String.format("%s%" + width + "s", conn, ""));
			} else {
				sb.append(String.format("%s%" + width + "s", conn, arr[i]));
			}
			conn = ",";
		}
		sb.append("]");
		System.out.println("" + sb.toString());

	}

//	--- Print Int Array or Char Array: End ----------------------------------------------------------------------------------------------------------------

//	--- Swap Array: Start ----------------------------------------------------------------------------------------------------------------	

	public static <T> void swap(T[] arr, int left, int right) {
		T temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public void swap(Integer[] arr, int start, int end) {
		Integer temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	public static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	public static void swap(Character[] arr, int left, int right) {
		Character temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}


//	--- Swap Array: End ----------------------------------------------------------------------------------------------------------------

//	--- Convert Array: Start ---------------------------------------------------------------------------------------------------------------	

	public static Integer[] convertIntArr2IntegerArr(int[] arr) {
		if (arr == null) {
			return null;
		}
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public static int[] convertIntegerArr2IntArr(Integer[] arr) {
		if (arr == null) {
			return null;
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public static Integer[] convertCharArr2IntegerArr(char[] arr) {
		if (arr == null) {
			return null;
		}
		Integer[] result = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				result[i] = Character.digit(arr[i], 10);
//				result[i] = Integer.valueOf(arr[i]);
			} else {
				//Exception
			}
		}
		return result;
	}

	public static Character[] convertCharArr2CharacterArr(char[] arr) {
		if (arr == null) {
			return null;
		}
		Character[] result = new Character[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public static char[] convertCharacterArr2CharArr(Character[] arr) {
		if (arr == null) {
			return null;
		}
		char[] result = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public static int[] convertInt2IntArr(int val) {
		String str = String.valueOf(val);
		int[] arr = new int[str.length()];
		for (int i = str.length() - 1; i >= 0; i--) {
			arr[i] = val % 10;
			val /= 10;
		}
		return arr;
	}

	public static String convertSquareBracketStr2IntArrCurlyBraceStr(String str) {
		// TODO Auto-generated method stub
		String result = null;
		if (str == null)
			return null;
		result = str.trim();
		result = result.replaceAll("\\[", "\\{");
		result = result.replaceAll("\\]", "\\}");
//		result = result.replaceAll("\\[", "y");
//		result = result.replaceAll("\\]", "b");

		System.out.println("" + result);
		return result;
	}

//	private Pattern patternSquareBrack = Pattern.compile(regex);
	public static int[][] convertStr2TwoDimensionIntArr(String str) {
		if (str == null)
			return null;
		str = str.trim();
//		Pattern patternSquareBrack = Pattern.compile("\\s*(\[\\s*+d\\s*,\s*+d\\s*\])");//0个或多个spaces，\s*
		Pattern pattern = Pattern.compile("\\[(\\[((\\d+,?)+)\\],?)+\\]");//0个或多个spaces，\s*
		int rows = 0;
		int cols = 0;
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
//			System.out.println("0:" + matcher.group(0));
//			System.out.println("1:" + matcher.group(1));
//			System.out.println("2:" + matcher.group(2));
//			System.out.println("3:" + matcher.group(3));
//			matcher.g
//			rows = matcher.groupCount();
//			cols = matcher.groupCount();
		}
		int[][] arr = new int[rows][cols];
		return arr;
	}
//	public static int[] convertStr2IntArr(String str) {
//		
//		if(str == null) return null;
//		Integer[] result = new Integer[str.length()];
//		char[] arr = str.toCharArray();
//		for(int i = str.length() - 1; i >= 0; i--){
////			result[i] = Integer.valueOf(arr[i]); //123 to 49,50,51; abc to 97,98,99
////						;
//			result[i] = Character.digit(arr[i], 10); //Integer.valueOf(arr[i]); 
//		}
//		return convertIntegerArr2IntArr(result);
//	}

//	public static Integer[] convertStr2IntegerArr(String str) {
//		if(str == null) return null;
//		Integer[] result = new Integer[str.length()];
//		
//		char[] arr = str.toCharArray();
//		for(int i = str.length() - 1; i >= 0; i--){
//			result[i] = Integer.valueOf(arr[i]); 
//		}
//		return result;
//	}

	public static int[] convertStr2IntArr(String str) {
		Integer[] arr = convertStr2IntegerArr(str);
		return convertIntegerArr2IntArr(arr);
	}

	public static Integer[] convertStr2IntegerArr(String str) {
		if (str == null)
			return null;
		Integer[] result = new Integer[str.length()];

		char[] arr = str.toCharArray();
		for (int i = str.length() - 1; i >= 0; i--) {
			result[i] = Integer.valueOf(arr[i]);
		}
		return result;
	}

	public static char[] convertStr2CharArr(String str) {
		if (str == null)
			return null;
		return str.toCharArray();
	}

	public static Character[] convertStr2CharacterArr(String str) {
		if (str == null)
			return null;
		char[] arr = str.toCharArray();
		return convertCharArr2CharacterArr(arr);
	}

	public static boolean verifyEqualTwoArray(Integer[] expected, Integer[] actural) {
		// TODO Auto-generated method stub
		if (expected == null && actural == null) {
			System.out.println("VerifyEqualTwoArray: " + " TRUE ! ");
			return true;
		}
		if (expected == null || actural == null) {
			System.out.println("VerifyEqualTwoArray: " + " FALSE !");
			return false;
		}
		if (expected.length != actural.length) {
			System.out.println("VerifyEqualTwoArray: " + " FALSE !");
			return false;
		}
		for (int i = 0; i < expected.length; i++) {
			if (!expected[i].equals(actural[i])) {
				System.out.println("VerifyEqualTwoArray: " + " FALSE !");
				return false;
			}
		}
		System.out.println("VerifyEqualTwoArray: " + " TRUE !");
		return true;
	}

	//	--- Convert Array: End ---------------------------------------------------------------------------------------------------------------

	//best partition ever
	public static int partitionA(int[] arr, int left, int right) {
		int pivotPos = right;
		int pivot = arr[pivotPos];
		right--;
		while (left <= right) {
			if (arr[left] < pivot) {
				left++;
			} else {
				ArrayUtils.swap(arr, left, right--);
			}
		}
		//right to last smaller; left to first larger, only return left
		ArrayUtils.swap(arr, left, pivotPos);
		return left;
	}

//	by LaiO
	public static int partitionB(int[] arr, int left, int right) {
		int pivotPos = right;
		int pivot = arr[pivotPos];
		int start = left;
		int end = right - 1;
		while (start <= end) {
			if (arr[start] < pivot) {
				start++;
			} else if (arr[end] >= pivot) {
				end--;
			} else {
				ArrayUtils.swap(arr, start++, end--);
			}
		}
		ArrayUtils.swap(arr, start, right);
		return start;
	}

	public static void print(String[] words) {
		// TODO Auto-generated method stub
		System.out.println("" + Arrays.toString(words));
	}

	public static void print(String[] words, int from, int to) {
		// TODO Auto-generated method stub
		words = Arrays.copyOfRange(words, from, to);
		System.out.println("" + Arrays.toString(words));
	}

	//	public static int[][] convertSquareBracketStr2IntArr(String arrStr) {
//		// TODO Auto-generated method stub
//		arrStr.replace("[", "{");
//		String str = arrStr.replace("]", "}");
//		int[][] arr = str; 
//		return null;
//	}
	public static String convertSquareBracketStr2CurlyBraceStr(String arrStr) {
		// TODO Auto-generated method stub
		String str = arrStr.replaceAll("\\[", "{").replaceAll("\\]", "}");
		System.out.println("" + str);
		return str;
	}

	public static void printConsecutiveChar(char ch, int count) {
		StringBuilder sBuilder = new StringBuilder();
		while (--count > 0) {
			sBuilder.append(ch);
		}
		System.out.println("" + sBuilder.toString());
	}

	public static void printIntegerArray(String comment, Integer[] arr) {
		System.out.println(comment);
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = arr[i];
		}
		printIntArrayWithIndex(intArr);
	}

	public static void printf(String format, Object... obs) {
		// TODO Auto-generated method stub
		System.out.printf(format + "\n", obs);
	}

	public static void ppprintf(String format, Object... obs) {
		// TODO Auto-generated method stub
		System.out.printf(format, obs);
	}

	public static int[] mergeIntArrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		if (arr1 == null || arr2 == null) {
			return null;
		}
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0;
		for (int val : arr1) {
			arr[i++] = val;
		}
		for (int val : arr2) {
			arr[i++] = val;
		}
		return arr;
	}

	public static int[] shuffle(int[] arr) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		Random random = new Random();
		int k = arr.length;
		for (int i = 0; i < arr.length; i++) {
			int pos = random.nextInt(k--);
			swap(arr, i, pos);
		}
		return arr;
	}

	public static List<Integer> convertIntArrToList(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return nums;
		}
		for (int val : arr) {
			nums.add(val);
		}
		return nums;
	}

	public static ArrayList<Integer> convertIntArrToArrayList(int[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return nums;
		}
		for (int val : arr) {
			nums.add(val);
		}
		return nums;
	}
	
	public static int[] convertListToIntArr(List<Integer> list) {
		// TODO Auto-generated method stub
//		List<Integer> nums = new ArrayList<>();
		if(list == null) {
			return null;
		}
		if(list.size() == 0) {
			return new int[0];
		}
		int[] arr = new int[list.size()];
		int i = 0;
		for(Integer ele : list) {
			arr[i++] = ele;
		}
		return arr;
	}

	public static Integer[] convertListToIntArr1(List<Integer> list) {
		// TODO Auto-generated method stub
//		List<Integer> nums = new ArrayList<>();
		if(list == null) {
			return null;
		}
		if(list.size() == 0) {
			return new Integer[0];
		}
		Integer[] arr = new Integer[list.size()];
		int i = 0;
		for(Integer ele : list) {
			arr[i++] = ele;
		}
		return arr;
	}

	public static int[] fromStringToArray(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.length() == 0) {
			return null;
		}
		str = str.trim();
//		str = str.substring(1, str.length() - 1);
		String[] arr = str.split(",");
		int[] intArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.valueOf((arr[i]));
		}
		return intArr;
	}

}
