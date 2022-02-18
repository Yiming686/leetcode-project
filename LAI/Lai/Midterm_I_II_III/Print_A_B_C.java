package Lai.Midterm_I_II_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Utils.TreeNodeUtils.TP;

public class Print_A_B_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("" + printABC("UHTY"));
	}

	private static List<String> printABC(String str) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		TP root = TP.build("", "1111", null, result, sb, Arrays.toString(arr), 0);
		helper(result, sb, arr, 0, root);
		root.print();
//		System.out.println("size: "+result.size());
		return result;

	}

	private static void helper(List<String> result, StringBuilder sb, char[] arr, int pos, TP root) {
		if (pos == arr.length ) {
//			sb.append(arr[pos]);
			// sb.append("_");
			// helper(result, sb, arr, pos + 1);
			result.add(sb.toString());
//			sb.deleteCharAt(sb.length() - 1);
			// sb.deleteCharAt(sb.length()-1);
			TP.build(TP.IS_BASE_CASE, root, result, sb, Arrays.toString(arr), pos);
			return;
		}
		for (int i = pos; i < arr.length; i++) {
		    swap(arr, pos, i);
		    sb.append(arr[pos]);
			if(i != arr.length - 1) {
				sb.append("_");
			}
			helper(result, sb, arr, pos + 1, TP.build(root, result, sb, Arrays.toString(arr), pos + 1));
			if(i != arr.length - 1) {
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.deleteCharAt(sb.length() - 1);
		    swap(arr, pos, i);
		}

	}
	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
}
