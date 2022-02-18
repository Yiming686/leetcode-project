package Leet.String.Parenthesis;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_475_Different_Ways_to_Add_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "2-1-1";
		String input = "  22    *     3333 -  4444 *   5555 ";
		String input2 = "22*3333-4444*5555 ";
//		String input = "2*3-4*5*2+2*2";
//		List<String> list = split(input);
		List<String> list = splitWithSpaces(input);
		List<String> list2 = splitWithSpaces(input2);
		System.out.println("splitWithSpaces: "+list);
		System.out.println("list: "+split(input));
		System.out.println("list_old: "+split_old(input));
		
		System.out.println("splitWithSpaces: "+list2);
		System.out.println("list: "+split(input2));
		System.out.println("list_old: "+split_old(input2));

//		System.out.println(""+diffWaysToCompute(input));
	}

//	错误的分解：错误在哪里呢？错误在针对的数字的个数，每层减少一个，最后一层1个，
//	正确地分解：针对n个数，就有n-1对左右括号，就是求解n
//	题目理解：对添加()的含义的理解，把两个东西括起来，不能是三个东西，这个东西可以是数字，也可以是一定括号括起来的东西
//	也就是说每一个(),就会减少一个数字，有了这个限制，对于n个数字，就必须得有n-1个左右括号。
	public static List<Integer> diffWaysToCompute(String input) {
		// Write your solution here
		List<Integer> result = new LinkedList<>();
		List<String> list = split(input);
		System.out.println("list: "+list);
		int size = list.size();
		int left = size;
		int right = size;
//		findAll(result, list, left, right);
		findAll(result, list, 0);
		Collections.sort(result);
		return result;
	}
	
//	private static void findAll(List<Integer> result, List<String> list, int left, int right) {//thid para is the list size
	private static void findAll(List<Integer> result, List<String> list, int pos) {//thid para is the list size
		if (list.size() == 1) {
			result.add(Integer.valueOf(list.get(0)));
			return;
		}
		findAll(result, list, pos+2);
		Integer val1 = Integer.valueOf(list.get(pos));
		String op = list.get(pos+1);
		Integer val2 = Integer.valueOf(list.get(pos+2));
		Integer newVal = null;
		if ("+".equals(op)) {
			newVal = val1 + val2;
		} else if ("-".equals(op)) {
			newVal = val1 - val2;
		} else {
			newVal = val1 * val2;
		}
		list.remove(pos);
		list.remove(pos);
		list.remove(pos);
		list.add(pos, "" + newVal);
		findAll(result, list, pos);
		

	}
	
	private static void findAll_2(List<Integer> result, List<String> list) {//thid para is the list size
		if (list.size() == 1) {
			// insert(result, list);
			result.add(Integer.valueOf(list.get(0)));
			return;
		}
		int size = list.size();
		for (int i = 1; i < size; i += 2) {
			String op = list.get(i);
			Integer val1 = Integer.valueOf(list.get(i - 1));
			Integer val2 = Integer.valueOf(list.get(i + 1));
			Integer newVal = null;
			if ("+".equals(op)) {
				newVal = val1 + val2;
			} else if ("-".equals(op)) {
				newVal = val1 - val2;
			} else {
				newVal = val1 * val2;
			}
			list.remove(i - 1);
			list.remove(i - 1);
			list.remove(i - 1);
			list.add(i - 1, "" + newVal);
			//to subproblem
			findAll_2(result, list);
			list.remove(i - 1);
			list.add(i - 1, "" + val2);
			list.add(i - 1, op);
			list.add(i - 1, "" + val1);
		}
	}

	private static void findAll_wrong(List<Integer> result, List<String> list) {//thid para is the list size
		if (list.size() == 1) {
			// insert(result, list);
			result.add(Integer.valueOf(list.get(0)));
			return;
		}
		int size = list.size();
		for (int i = 1; i < size; i += 2) {
			String op = list.get(i);
			Integer val1 = Integer.valueOf(list.get(i - 1));
			Integer val2 = Integer.valueOf(list.get(i + 1));
			Integer newVal = null;
			if ("+".equals(op)) {
				newVal = val1 + val2;
			} else if ("-".equals(op)) {
				newVal = val1 - val2;
			} else {
				newVal = val1 * val2;
			}
			list.remove(i - 1);
			list.remove(i - 1);
			list.remove(i - 1);
			list.add(i - 1, "" + newVal);
			//to subproblem
			findAll_wrong(result, list);
			list.remove(i - 1);
			list.add(i - 1, "" + val2);
			list.add(i - 1, op);
			list.add(i - 1, "" + val1);
		}
	}
	// private void insert(List<Integer> result, List<String> list){
	//   int val = list.get(0);
	//   if(result.isEmpty()){
	//     result.add(val);
	//   }else if(val < result.get(0)){
	//     result.addFirst();
	//   }else if(val > result.get(result.size() - 1)){
	//     result.addLast(val);
	//   }else{

	//   }
	// }

//	Better
	private static List<String> split(String input) {
		List<String> list = new LinkedList<>();
		int len = input.length();
		int left = 0;
		for (int right = 1; right < len; right++) {
			char ch = input.charAt(right);
			if (ch == '+' || ch == '-' || ch == '*') {
				list.add(input.substring(left, right));
				list.add(""+ch);
				left = right + 1;
			} 
		}
		list.add(input.substring(left));
		return list;
	}
	
//	
	private static List<String> splitWithSpaces(String input) {
		List<String> list = new LinkedList<>();
		int len = input.length();
		int left = 0;
		int right = 0;
		boolean leftFound = false;
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if(ch == ' ') continue;
			if (ch == '+' || ch == '-' || ch == '*') {
				list.add(input.substring(left, right + 1));
				list.add(""+ch);
				leftFound = false;
			}else if(!leftFound) {
				left = i;
				right = i;
				leftFound = true;
			}else {
				right = i;
			}
		}
		list.add(input.substring(left, right + 1));
		return list;
	}

	//	Not good
	private static List<String> split_old(String input) {
		List<String> list = new LinkedList<>();
		int len = input.length();
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				list.add("" + ch);
			} else {
				int start = i;
				while (ch != '+' && ch != '-' && ch != '*') {
					i++;
					if(i < len) {
						ch = input.charAt(i);
					}else {
						break;
					}
				}
				list.add(input.substring(start, i));
				i--;
			}
		}
		return list;
	}
	

}
