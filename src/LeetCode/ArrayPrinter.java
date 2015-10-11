package LeetCode;

public class ArrayPrinter {

	/**
	 * @param args
	 */
	public static void printIntegerArray(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null) {
			System.out.print("null");
			return;
		}

		int len = arr.length;
		System.out.print("[");

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i]);
			if (i != len - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	public static void printIntegerArray(Integer[] arr) {
		// TODO Auto-generated method stub
		if (arr == null) {
			System.out.print("null");
			return;
		}

		int len = arr.length;
		System.out.print("[");

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i]);
			if (i != len - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}
	public static String printIntegerArrayToStr(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < len; i++) {
			sb.append(arr[i]);
			if (i != len - 1)
				sb.append(", ");
			// System.out.print(", ");
		}
		sb.append("]");
		String str = sb.toString();
		// System.out.println(str);
		return str;
	}
	
	public static void printStringArray(String[] arr) {
		// TODO Auto-generated method stub
		if (arr == null) {
			System.out.print("null");
			return;
		}

		int len = arr.length;
		System.out.print("[");

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i]);
			if (i != len - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

}
