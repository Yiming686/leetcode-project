package Lai.Final;

import java.util.ArrayList;
import java.util.List;

public class Space_Subset_A_B_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "gtfd";
		System.out.println("" + subsetSpaces(str));
	}

	private static List<String> subsetSpaces(String str) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		subsetSpaces(result, sb, str, 0);
		return result;
	}

	private static void subsetSpaces(List<String> result, StringBuilder sb, String str, int pos) {
		if (pos == 2 * str.length() - 1) {
			result.add(sb.toString());
			return;
		}
		if (pos % 2 == 0) {
			sb.append(str.charAt(pos / 2));
			subsetSpaces(result, sb, str, pos + 1);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			subsetSpaces(result, sb, str, pos + 1);

			sb.append("_");
			subsetSpaces(result, sb, str, pos + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
