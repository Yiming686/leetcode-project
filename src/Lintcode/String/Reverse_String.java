package Lintcode.String;

public class Reverse_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		str = "This is a book";
		System.out.println("" + reverse(str));
		str = "This";
		System.out.println("" + reverse(str));
		str = "a";
		System.out.println("" + reverse(str));
		str = " This is a book ";
		System.out.println("" + reverse(str));
		str = " This  is   a     book      ";
		System.out.println("" + reverse(str));
	}

	private static String reverse(String str) {
		// TODO Auto-generated method stub
		if(str == null || str.length() <=1) return str;
		int len = str.length();
		int mid = len/2;
		String left  = reverse(str.substring(0, mid));
		String right = reverse(str.substring(mid, len));
		return right + left;
//		worked as well
//		return reverse(str.substring(mid, len)) + reverse(str.substring(0, mid));
	}
//	private static String reverse2(String str) {
//		// TODO Auto-generated method stub
//		char[] arr = str.toCharArray();
//		reverse(arr, 0, arr.length-1);
//		return new String(arr);
//	}

	private static char[] reverse(char[] arr, int left, int right) {
		// TODO Auto-generated method stub
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return arr;
	}

}
