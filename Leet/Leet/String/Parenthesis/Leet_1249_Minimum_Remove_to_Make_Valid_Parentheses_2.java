package Leet.String.Parenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * 
��Ŀ��Leet_1249_Minimum_Remove_to_Make_Valid_Parentheses_2
������ ( �� ) ���ַ���������㸴���ˡ�
���⣺û���κη� ( ���� ) ���ַ� 

 *
 */
public class Leet_1249_Minimum_Remove_to_Make_Valid_Parentheses_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "))((";
//		String str = "())()(((";
//		String str = "())()(((";
		String str = "((((())()";
//		String str = "(())())))))";
		String SPLITER = "_";
		System.out.println("    str: "+SPLITER+str+SPLITER);
		System.out.println("removed: "+SPLITER+minRemoveToMakeValid(str)+SPLITER);
	}
//	( )(() )
//	û���κη�(����)���ַ�
//  Time: O(N), Space: O(N), Great solution, very like minAddToMakeValid
	public static String minRemoveToMakeValid(String str) {
		// int minAdd = minAddToMakeValid(str);
		char[] arr = str.toCharArray();
		int left = 0;
        int right = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {//sliding window, for each arr[i]
			char ch = arr[i];
//			if (ch != '(' && ch != ')') {
//				continue;
//			}
			if (ch == '(') {
				left++;
				list.add(i);
			} else {
				right++;
				if (right > left) {//right == left + 1
					arr[i] = ' ';
					left = 0;
					right = 0;
				}
			}
			//here, make sure left >= right always
		}
		int count = left - right;
	    for(int i = 0; i < count ; i++){
			arr[list.get(list.size() - 1 - i)] = ' ';
            // arr[list.get(i)] = ' ';//Wrong, must delete ( from last to first
		}		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i < arr.length; i++) {
            if(arr[i] != ' ') {
                sb.append(arr[i]);
            }
		}
		return sb.toString();
	}
	
    //  Time: O(N), Space: O(1), Great solution, easy to explain
    public static int minAddToMakeValid(String str) {
    // public int minAddToMakeValid_(String s) {
        int sec = 0;
        int left = 0, right = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (right > left) {//��������Ч�㣺��������Ч���һ����Ҳ��������Ч���һ��    
                    sec++; //һ��sec����һ������
                    left = 0;
                    right = 0;
                }
            }
            //here, make sure left >= right always
        }
        return sec + left - right;
    }

}
