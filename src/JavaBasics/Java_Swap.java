package JavaBasics;

import LeetCode.ArrayPrinter;

public class Java_Swap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = { 2, 7, 11, 15 ,68,89};

//		int a = nums[0];
//		char a = 'a';
//		char b = 'b';
		
//		System.out.printf("%d, %d \n", a, b);
		ArrayPrinter.printIntegerArray(nums);
		swap(nums, 4, 1);
		ArrayPrinter.printIntegerArray(nums);
//		System.out.printf("%d, %d \n", a, b);

		System.out.println();

	}

	public static void swap(Integer a, Integer b) {
		// TODO Auto-generated method stub
		System.out.printf("%d, %d \n", a, b);

		a = a ^ b;
		System.out.printf("%d, %d \n", a, b);

		b = a ^ b;
		System.out.printf("%d, %d \n", a, b);

		a = a ^ b;
		System.out.printf("%d, %d \n", a, b);

	}
	public static void swap(int a, int b) {
		// TODO Auto-generated method stub
		System.out.printf("%d, %d \n", a, b);

		a = a ^ b;
		System.out.printf("%d, %d \n", a, b);

		b = a ^ b;
		System.out.printf("%d, %d \n", a, b);

		a = a ^ b;
		System.out.printf("%d, %d \n", a, b);

	}

	public static void swap(char a, char b) {
		// TODO Auto-generated method stub
		System.out.printf("%c, %c \n", a, b);

		a = (char) (a ^ b);
		System.out.printf("%c, %c \n", a, b);

		b = (char) (a ^ b);
		System.out.printf("%c, %c \n", a, b);

		a = (char) (a ^ b);
		System.out.printf("%c, %c \n", a, b);

	}
	public static void swap(int[] nums, int i1, int i2) {
		// TODO Auto-generated method stub

		nums[i1] = nums[i1] ^ nums[i2];
		nums[i2] = nums[i1] ^ nums[i2];
		nums[i1] = nums[i1] ^ nums[i2];

	}
	
	public static void swap(Integer[] nums, int i1, int i2) {
		// TODO Auto-generated method stub

		nums[i1] = nums[i1] ^ nums[i2];
		nums[i2] = nums[i1] ^ nums[i2];
		nums[i1] = nums[i1] ^ nums[i2];

	}
	public static void swap(Integer[] nums, Integer i1, Integer i2) {
		// TODO Auto-generated method stub

		nums[i1] = nums[i1] ^ nums[i2];
		nums[i2] = nums[i1] ^ nums[i2];
		nums[i1] = nums[i1] ^ nums[i2];

	}
}
