package LeetCode.JavaString;

import java.util.ArrayList;
import java.util.List;

/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 Hide Tags Backtracking String

 */
public class LC_022_Generate_Parentheses {

	//jiuzhang solution, worked
    public static List<String> generateParenthesis3(int n) {
        List<String> result = new ArrayList<String>();
        if(n <= 0) {
            return result;
        }
        int[] count = new int[1];
        generateParenthesis(result,count, "", n, n);
        return result;
    }
    
	public static void generateParenthesis( List<String> result ,int[] count, String s, int left, int right) {
	    
		if(left == 0 && right == 0) {
			count[0] += 1;
			System.out.println(""+count[0]+": " + s);
//			System.out.println(charArr);

			result.add(s);
			return;
		}
		if(left < 0 || right < 0)return;
		//如果不判断，left和right是否小于0，则Runtime Error Message: java.lang.StackOverflowError
//		if(left > right || left < 0 || right < 0) {
//			return; 	
//		}
		//s去一个"(",left减一，s取一个")", right义减一
		//其实是先取"(", 再取")"
		generateParenthesis(result, count,s + "(", left - 1, right);
		generateParenthesis(result, count,s + ")", left, right - 1);
	}

	//jiuzhang solution, modified, worked
    public List<String> generateParenthesis2(int n) {
        List<String> rst = new ArrayList<String>();
        if(n <= 0) {
            return rst;
        }
        generateParenthesis(rst, "",n, 0, 0);
        return rst;
    }
    
	public void generateParenthesis( List<String> rst , String s,int n, int left, int right) {
	    
		if(left == n && right == n) {
			rst.add(s);
			return;
		}
		if(left < right || left > n || right > n) {
			return; 	
		}

		generateParenthesis(rst, s + "(", n,left + 1, right);
		generateParenthesis(rst, s + ")", n,left, right + 1);
	}

	
	// Accepted, 250ms
	// 如果直接简单循环，然后判断，难度低
	// 如果直接要给出，这个递归算法，难度还是有点大，
	// 简单认识：尽管要输出字符串String，但是必须要处理单个字符char
	// 无论如何变化，字符数组的长度不变
	// 递归中传递什么参数？

	// 主要是规律的总结，花费时间
	// 1.如果没有剩余的左右括号可用left==right==0，输出结果
	// 2.如果还有递归的左括号可用，则插入左括号，然后递归调用
	// 3.如果右括号剩余量大于左括号剩余量，
	public List<String> generateParenthesis(int n) {
		List<String> strList = new ArrayList<String>();
		char[] charArr = new char[2 * n];

		generateParenthesis(strList, charArr, n, n, 0);
		return strList;
	}

	private void generateParenthesis(List<String> strList, char[] charArr,
			int left, int right, int curr) {
		// TODO Auto-generated method stub
		if (left < 0 || right < left)
			return;
		if (left == 0 && right == 0)
			strList.add(new String(charArr));
		else {
			if (left > 0) {
				charArr[curr] = '(';
				generateParenthesis(strList, charArr, left - 1, right, curr + 1);
			}
			if (right > left) {
				charArr[curr] = ')';
				generateParenthesis(strList, charArr, left, right - 1, curr + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		createParenthsis(3);
		generateParenthesis3(3);
	}

	private static void createParenthsis(int n) {
		// TODO Auto-generated method stub
		char[] charArr = new char[2 * n];
		int[] i = new int[1];
		createParenthsis(charArr,i, n, n, 0);
	}

	private static void createParenthsis(char[] charArr,int[] i, int left, int right,
			int curr) {
		// TODO Auto-generated method stub
		// 这个条件就是说（即使没有了还要继续，）一旦没有了就终止
//		 System.out.printf("l=%s,r=%s,curr=%s   \n", left, right, curr);

//		if (left < 0 || right < left)
//			return;
		if (left == 0 && right == 0){
			i[0] += 1;
			System.out.print(""+i[0]+": ");
			System.out.println(charArr);
		}
		if (curr < charArr.length) {
			// if (left > 0) {
			charArr[curr] = '(';
			createParenthsis(charArr,i, left - 1, right, curr + 1);
			// }
			// if (right > left) {
			charArr[curr] = ')';
			createParenthsis(charArr,i, left, right - 1, curr + 1);
			// }
		}
	}
	/*
	思路

	针对一个长度为2n的合法排列，第1到2n个位置都满足如下规则

	1
	左括号的个数≥右括号的个数
	所以，我们就可以按照这个规则去打印括号

	假设在位置k我们还剩余left个左括号和right个右括号

	如果left和right均为零，则说明我们已经完成一个合法排列，可以将其打印出来
	如果left>0，打印左括号
	如果right>0 并且 right>left 打印右括号
	*/
	
//	best solution, using StringBuffer,worked
	static List<String> generate(int n) {
		List<String> list = new ArrayList<String>();
		genereate(n, n, new StringBuffer(), list);
		return list;
	}
	private static void genereate(int left, int right, StringBuffer sb, List<String> list) {
		// TODO Auto-generated method stub
		if (left == 0 && right == 0) {
			list.add(sb.toString());
			return;
		}
		if(left > 0){
			genereate(left - 1, right , sb.append("("), list);
			sb.deleteCharAt(sb.length() -1 );
		}
		if(right > 0 && right > left){
			genereate(left, right - 1 , sb.append(")"), list);
			sb.deleteCharAt(sb.length() - 1 );
		}
	}

//	best solution, using String, worked
	static List<String> generate2(int n) {
		List<String> list = new ArrayList<String>();
		genereate(n, n, "", list);
		return list;
	}
	private static void genereate(int left, int right, String str, List<String> list) {
		// TODO Auto-generated method stub
		if (left == 0 && right == 0) {
			list.add(str.toString());
			return;
		}
		if(left > 0){
			genereate(left - 1, right , str + "(", list);
		}
		if(right > 0 && right > left){
			genereate(left, right - 1 , str + ")", list);
		}
	}

}
