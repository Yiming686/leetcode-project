package Lintcode.String;

public class LAI_649_String_Replace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "denmarkgermanyboliviaeritreadenmarkdenmark";
		String source = "denmark";
		String target = "guam";
		System.out.println("" + replace(input, source, target));
	}

	public static String replace(String input, String source, String target) {
		char[] arr = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length();) {//ËÑË÷·¶Î§
			int pos = input.indexOf(source, i);
			System.out.println("pos:"+pos);
			if (pos == i) {
				sb.append(target);
				 i = pos + source.length();
			} else if (pos > i) {
				// sb.append(String.valueOf(arr, i, pos - 1));
				sb.append(String.valueOf(arr, i, pos - i));
				sb.append(target);
				 i = pos + source.length();
			} else {
				sb.append(String.valueOf(arr, i, input.length() - i));
				i = input.length();
			}
		}
		return sb.toString();
	}

}
