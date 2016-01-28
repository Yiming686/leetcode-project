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
		//������жϣ�left��right�Ƿ�С��0����Runtime Error Message: java.lang.StackOverflowError
//		if(left > right || left < 0 || right < 0) {
//			return; 	
//		}
		//sȥһ��"(",left��һ��sȡһ��")", right���һ
		//��ʵ����ȡ"(", ��ȡ")"
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
	// ���ֱ�Ӽ�ѭ����Ȼ���жϣ��Ѷȵ�
	// ���ֱ��Ҫ����������ݹ��㷨���ѶȻ����е��
	// ����ʶ������Ҫ����ַ���String�����Ǳ���Ҫ�������ַ�char
	// ������α仯���ַ�����ĳ��Ȳ���
	// �ݹ��д���ʲô������

	// ��Ҫ�ǹ��ɵ��ܽᣬ����ʱ��
	// 1.���û��ʣ����������ſ���left==right==0��������
	// 2.������еݹ�������ſ��ã�����������ţ�Ȼ��ݹ����
	// 3.���������ʣ��������������ʣ������
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
		// �����������˵����ʹû���˻�Ҫ��������һ��û���˾���ֹ
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
	˼·

	���һ������Ϊ2n�ĺϷ����У���1��2n��λ�ö��������¹���

	1
	�����ŵĸ����������ŵĸ���
	���ԣ����ǾͿ��԰����������ȥ��ӡ����

	������λ��k���ǻ�ʣ��left�������ź�right��������

	���left��right��Ϊ�㣬��˵�������Ѿ����һ���Ϸ����У����Խ����ӡ����
	���left>0����ӡ������
	���right>0 ���� right>left ��ӡ������
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
