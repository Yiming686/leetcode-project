package LeetCode.JavaArray;

import java.util.HashMap;
import java.util.Map;


/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Hide Tags Math String

 */
public class LC_013_Roman_to_Integer {
	/**
	 * 本代码由九章算法编辑提供。没有版权欢迎转发。
	 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
	 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
	 * - 更多详情请见官方网站：http://www.jiuzhang.com/
	 */

	public class Solution {
	 	public int romanToInt(String s) {
		    if (s == null || s.length()==0) {
	 return 0;
		    }
		    Map<Character, Integer> m = new HashMap<Character, Integer>();
		    m.put('I', 1);
		    m.put('V', 5);
		    m.put('X', 10);
		    m.put('L', 50);
		    m.put('C', 100);
		    m.put('D', 500);
		    m.put('M', 1000);

		    int length = s.length();
		    int result = m.get(s.charAt(length - 1));
		    for (int i = length - 2; i >= 0; i--) {
		        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
		            result += m.get(s.charAt(i));
		        } else {
		            result -= m.get(s.charAt(i));
		        }
		    }
		    return result;
		}
	}
	
    public int romanToInt(String s) {
        char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] val = { 1, 5, 10, 50, 100, 500, 1000 };
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < symbol.length; i++)
            map.put(symbol[i], val[i]);
 
        int len = s.length();
        int res = 0;
 
        res += map.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int cur = map.get(s.charAt(i));
            int pre = map.get(s.charAt(i - 1));
            if (cur <= pre) {
                res += cur;
            } else {
                res = res + cur - 2 * pre;
            }
 
        }
        return res;
 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
