package Leet.OA.Microsoft;



import static Utils.StringUtils.toStr;

import java.util.ArrayList;
import java.util.List;

import Utils.StringUtils;
import Utils.TreeNodeUtils.TP;

public class Leet_93_Restore_IP_Addresses {

	public static void main(String[] args) {
//		int digit = Character.getNumericValue(ch);
		System.out.println(""+Character.getNumericValue('a'));
		   for (int j = 0; j < 10; ++j) {
//			   char ch = (char)( j);
			   char ch = '3';
//			   System.out.println(""+ch);
//			      System.out.println(Character.forDigit(ch, 10));
//			      System.out.println(Character.forDigit(j, 10));
//			      System.out.println(Character.digit(ch, 10));
		   }
		   
//		String str = "25525511135";
//		String str = "2222";
		String str = "2345";
//		String str = "10002552551";
//		String str = "0000";
		
		System.out.println(""+restoreIpAddresses(str));
	}
	
    public static List<String> restoreIpAddresses(String str) {
//    	AAA();
//    	BBB();
    	List<String> result = new ArrayList<String>();
    	char[] arr = str.toCharArray();
    	int pos = 0;
    	int section = 0;
    	StringBuilder sb = new StringBuilder();
//        TP tp = TP.build("result:sb:arr:pos:section", "01011", "root", null, result, sb, toStr(arr), pos, section);
        TP tp = TP.build("result:sb:arr:pos:section", "01011", "root", null, result, sb, toStr(arr), pos, section);
    	restoreIpAddresses(result, sb, arr, pos, section, tp);
    	tp.print();
    	return result;
    }
//对于arr,从pos开始，试着找第一个section
	private static void restoreIpAddresses(List<String> result, StringBuilder sb, char[] arr, int pos, int section, TP tp) {
		if(section == 4) {
			if(pos == arr.length) {
				tp.setCollected(true);//Mark Right Base Case
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
				sb.append(".");
			}
			return;
		}
		//只取从pos开始的三个数字，每次取一个，范围为[0 to 255]。 因为下一个循环需要用到上一个循环里面的变量，所以前面必须有一个初始变量，
//		特例：0开头可以，但是只能是0；后面两个是0也可，但是第一个必须不是0
		int val = 0;
		for(int i = pos; i < arr.length && i < pos + 3; i++) { 
			char ch = arr[i];
			if(arr[pos] == '0' && i != pos) {
				continue;
			}
			if(Character.isDigit(ch)) {
//				int digit = Character.forDigit(ch, 10);
				int digit = Character.getNumericValue(ch);
				val = val * 10 + digit;
				if(val < 256) {
//					if(section != 3) {
						restoreIpAddresses(result, sb.append(val).append("."), arr, i + 1 , section + 1, TP.build(tp, result, sb, toStr(arr), i+1, section+1));
						sb.delete(sb.length() - (i - pos + 1 + 1), sb.length());
//					}else {
//						restoreIpAddresses(result, sb.append(val), arr, i + 1, section + 1);
//						sb.delete(sb.length() - (i - pos + 1), sb.length());
//					}
				}
			}
		}
	}

}
