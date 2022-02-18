package Lai.XB.DFS.All_Path;

import static Utils.TreeNodeUtils.levelAndPrint;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;

/**
 * Given a string containing only digits, restore it by retiring all possible
 * valid IP address combinations.
 * 
 * Input: ¡±25525511135¡±
 * 
 * Output: [¡°255.255.11.135¡±, ¡°255.255.111.35¡±]
 *
 * 
 */
public class Restore_IP_Addresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(""+Restore01("25525511135"));
		System.out.println(""+Restore01("10809010"));
	}

	public static List<String> Restore00(String ip) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char[] arr = ip.toCharArray();
		TP root = TP.build("", "11011", null, result, sb, arr, 0, 0);
		helper00(result, sb, arr, 0, 0, root);
		root.print();
		return result;
	}

	private static void helper00(List<String> result, StringBuilder sb, char[] arr, int start, int section,TP root) {
		if (section == 4) {
			if(start == arr.length){
				sb.deleteCharAt(sb.length() - 1);
//				System.out.println("len-1: "+ (sb.length() - 1));
				result.add(sb.toString());
				TP.build(TP.IS_BASE_CASE, root, result, sb, arr, start, section);
				sb.append('.');
			}
//			TP.build(TP.IS_BASE_CASE, root, result, sb, arr, start, section);
			return;
		}
		
		for(int end = start; end < arr.length && end < start + 3; end++) {
			if(arr[start] == '0' && start < end) {
				continue;
			}
			String valStr = new String(arr, start, end - start + 1);
			int val = Integer.valueOf(valStr);
			if(val >= 0 && val <= 255) {
				sb.append(valStr);
				sb.append('.');
				helper00(result, sb, arr, end + 1, section + 1, TP.build(root, result, sb, arr, end + 1, section + 1));
				sb.deleteCharAt(sb.length() - 1);
				for(int i = 0; i < valStr.length(); i++) {
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}

	
	public static List<String> Restore01(String ip) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
//		char[] arr = ip.toCharArray();
		TP root = TP.build("", "11011", null, result, sb, ip, 0, 0);
		helper01(result, sb, ip, 0, 0, root);
		root.print();
		return result;
	}

	private static void helper01(List<String> result, StringBuilder sb, String str, int start, int section,TP root) {
		if (section == 4) {
			if(start == str.length()){
				sb.deleteCharAt(sb.length() - 1);
//				System.out.println("len-1: "+ (sb.length() - 1));
				result.add(sb.toString());
				TP.build(TP.IS_BASE_CASE, root, result, sb, str, start, section);
				sb.append('.');
			}
//			TP.build(TP.IS_BASE_CASE, root, result, sb, arr, start, section);
			return;
		}
		
		for(int end = start; end < str.length() && end < start + 3; end++) {
//			if(str.charAt(start) == '0' && start < end) {
//				continue;
//			}
//			String valStr = new String(arr, start, end - start + 1);
			String valStr = str.substring(start, end + 1);
            if(valStr.length() > 1 && valStr.startsWith("0")){
                continue;
            }

//			System.out.println("valStr: "+ valStr);
			int val = Integer.valueOf(valStr);
//			System.out.println("val: "+ val);
			
			if(val >= 0 && val <= 255) {
				sb.append(valStr);
				sb.append('.');
				helper01(result, sb, str, end + 1, section + 1, TP.build(root, result, sb, str, end + 1, section + 1));
				sb.deleteCharAt(sb.length() - 1);
				for(int i = 0; i < valStr.length(); i++) {
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}
	
}
