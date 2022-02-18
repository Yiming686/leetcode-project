package Lai.Recursion_I_Sorting_Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Lai.Utils.ArrayUtils99;


public class Rainbow_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,1,0,-1,0,1,-1};
//		int[] arr2 = ArrayUtils99.generateIntArray(6, -1, 1);
////		System.out.println(""+ Arrays.toString(arr));
//
////		System.out.println(""+ Arrays.toString(rainbowSort(arr)));
//		System.out.println(""+ Arrays.toString(rainbowSort3Colors(arr2)));
		
//		int[] arr41 = ArrayUtils99.generateIntArray(10, 1, 4);
//		arr41 = new int[]{3, 3, 4, 3, 1, 1, 2, 4, 2, 4};
//		
//		System.out.println(""+ Arrays.toString(rainbowSort4Colors(arr41)));
		
		List<Integer> list = new LinkedList<>();
		System.out.println(""+list.size());
		list.add(4);
		System.out.println(""+list.size());
		list.add(null);
		list.add(4);
		list.add(null);
		System.out.println(""+list.size());

		list.add(4);
		System.out.println(""+list.size());

		list.add(4);
		System.out.println(""+list.size());

		list.add(4);
		System.out.println(""+list.size());

		int[] arr71 = ArrayUtils99.generateIntArray(10, 1, 7);
//		arr41 = new int[]{3, 3, 4, 3, 1, 1, 2, 4, 2, 4};
//		arr71 = new int[]{4, 4, 7, 5, 7, 1, 4, 3, 7, 5};
		arr71 = new int[]{4};
		arr71 = new int[]{7,4,2};
		
		System.out.println(""+ Arrays.toString(rainbowSort7Colors(arr71)));

	}

	public static int[] rainbowSort3Colors(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int one = 0;
		int two = 0;
		int three = arr.length - 1;
		while (two <= three) {
			System.out.println(""+ Arrays.toString(arr));
			System.out.printf("minusOne: %d, zero: %d, plusOne: %d \n", one, two, three);
			if (arr[two] == -1) {
				swap(arr, one++, two++);
			} else if (arr[two] == 1) {
				swap(arr, two, three--);
			} else {
				two++;				
			}
		}
		return arr;
	}

	public static int[] rainbowSort4Colors(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int one = 0;
		int two = 0;
		int three = 0;
		int four = arr.length - 1;
		while (three <= four) {
//			System.out.printf("minusOne: %d, zero: %d, plusOne: %d \n", one, two, four);
			if (arr[three] == 1) {
				System.out.printf("1\n");
				swap(arr, one++, three);
				swap(arr, two++, three++);
//				two++;
			} else if (arr[three] == 2) {
				System.out.printf("2\n");
				swap(arr, two++, three++);
			} else if (arr[three] == 3) {
				System.out.printf("3\n");
				three++;
			} else {
				System.out.printf("4\n");
				swap(arr, three, four--);		
			}
			System.out.println(""+ Arrays.toString(arr));

		}
		return arr;
	}

	public static int[] rainbowSort5Colors(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int minusOne = 0;
		int zero = 0;
		int plusOne = arr.length - 1;
		while (zero <= plusOne) {
			System.out.println(""+ Arrays.toString(arr));
			System.out.printf("minusOne: %d, zero: %d, plusOne: %d \n", minusOne, zero, plusOne);
			if (arr[zero] == -1) {
				swap(arr, zero++, minusOne++);
			} else if (arr[zero] == 1) {
				swap(arr, zero, plusOne--);
			} else {
				zero++;				
			}
		}
		return arr;
	}

	public static int[] rainbowSort7Colors(int[] arr) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = arr.length - 1;
		while (six <= seven) {
//			System.out.printf("minusOne: %d, zero: %d, plusOne: %d \n", one, two, four);
			if (arr[six] == 1) {
				System.out.printf("1\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
				swap(arr, two++, three-1);
				swap(arr, one++, two-1);
			} else if (arr[six] == 2) {
				System.out.printf("2\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
				swap(arr, two++, three-1);
			} else if (arr[six] == 3) {
				System.out.printf("3\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
			} else if (arr[six] == 4) {
				System.out.printf("4\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
			} else if (arr[six] == 5) {
				System.out.printf("5\n");
				swap(arr, five++, six++);
			} else if (arr[six] == 6) {
				System.out.printf("6\n");
				six++;
			} else {
				System.out.printf("7\n");
				swap(arr, six, seven--);		
			}
			System.out.println(""+ Arrays.toString(arr));

		}
		return arr;
	}

	public static int[] rainbowSort7Colors(int[] arr, int min, int max) {
		// Write your solution here
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = arr.length - 1;
		while (six <= seven) {
//			System.out.printf("minusOne: %d, zero: %d, plusOne: %d \n", one, two, four);
			if (arr[six] == 1) {
				System.out.printf("1\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
				swap(arr, two++, three-1);
				swap(arr, one++, two-1);
			} else if (arr[six] == 2) {
				System.out.printf("2\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
				swap(arr, two++, three-1);
			} else if (arr[six] == 3) {
				System.out.printf("3\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
				swap(arr, three++, four-1);
			} else if (arr[six] == 4) {
				System.out.printf("4\n");
				swap(arr, five++, six++);
				swap(arr, four++, five-1);
			} else if (arr[six] == 5) {
				System.out.printf("5\n");
				swap(arr, five++, six++);
			} else if (arr[six] == 6) {
				System.out.printf("6\n");
				six++;
			} else {
				System.out.printf("7\n");
				swap(arr, six, seven--);		
			}
			System.out.println(""+ Arrays.toString(arr));

		}
		return arr;
	}

	
	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

}
