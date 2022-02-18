package Lai.Ace.Mountain_View;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNodeUtils.TP;
import apple.laf.JRSUIConstants.Size;
import jdk.internal.dynalink.beans.StaticClass;

public class LC_842_Split_Array_into_Fibonacci_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(""+splitIntoFibonacci("3847"));
		System.out.println(""+splitIntoFibonacci("123456579"));
//		System.out.println(""+splitIntoFibonacci("3847"));
//		System.out.println(""+splitIntoFibonacci("3847"));
	}
	
    public static List<String> splitIntoFibonacci(String str) {
    	List<String> result = new ArrayList<>();
		if(str == null || str.length() == 0) {
			return result;
		}
//		return splitIntoFibonacci(str, 0, -1, -1);
		TP tp = TP.build("", "10111", "root", null);
		splitIntoFibonacci(result, str, 0, "-1", "-1", tp); TP.build("root", null, result, str, 0, "-1", "-1");
		tp.print();
		return result;
}

//    index左边的已经处理完毕，每一步的第一刀的下刀的位置
private static void splitIntoFibonacci(List<String> result, String str, int index, String prev1, String prev2,TP tp) {
	if(index == str.length()) {
		if(result.size() > 2 && !prev1.equals("-1") && !prev1.equals("-1")) {
			System.out.println("result:"+result);			
			tp.mark();
		}
		return;
	}
	for(int i = index; i < str.length(); i++) {
//		int num = Integer.valueOf(str.substring(index, i+1));
		String num = str.substring(index, i+1);
		if(isOverFlow(num) || (result.size() >= 2 && !canFib(result, num))) {
			continue;
		}
//		System.out.println("num:"+num);
//		System.out.println("result:"+result);
		result.add(num);
//		splitIntoFibonacci(result, str, index + 1, num, prev1, TP.build("child", tp)); TP.build("child", tp, result, str, index + 1,num, prev1);
		splitIntoFibonacci(result, str, i + 1, num, prev1, TP.build(""+i, tp)); TP.build(""+i, tp, result, str, i + 1,num, prev1);
		result.remove(result.size() - 1);		
	}
////		int num = Integer.valueOf(str.substring(index, i+1));
////		String num = str.substring(index, i+1);
//		String num = str.substring(index, index+1);
////		System.out.println("num:"+num);
////		System.out.println("result:"+result);
//		result.add(num);
////		splitIntoFibonacci(result, str, index + 1, num, prev1, TP.build("child", tp)); TP.build("child", tp, result, str, index + 1,num, prev1);
//		splitIntoFibonacci(result, str, index + 1, num, prev1, TP.build("left", tp)); TP.build("left", tp, result, str, index + 1,num, prev1);
//		result.remove(result.size() - 1);		
//		splitIntoFibonacci(result, str, index + 1, num, prev1, TP.build("right", tp)); TP.build("right", tp, result, str, index + 1,num, prev1);
}

private static boolean canFib(List<String> result, String num) {
	// TODO Auto-generated method stub
	if(result.size() < 2) {
		return true;
	}	
	boolean canFib = Integer.valueOf(num) == Integer.valueOf(result.get(result.size() - 1)) + Integer.valueOf(result.get(result.size() - 2));
	return  canFib ;
}

static boolean isOverFlow(String num){
	int maxLen = String.valueOf(Integer.MAX_VALUE).length();
	if(num.length() > maxLen) {
		return true;
	}
	return  Long.valueOf(num) > Integer.MAX_VALUE;
}



}
