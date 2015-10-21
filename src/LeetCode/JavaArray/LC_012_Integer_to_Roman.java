package LeetCode.JavaArray;

/*
 Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Tags Math String

 */
public class LC_012_Integer_to_Roman {

    public String intToRoman(int num) {
        String[] str = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0; i++) {
             
            while (num >= val[i]) {
                num -= val[i];
                sb.append(str[i]);
            }
 
        }
        return sb.toString();
    }
    
	/**
	 * 本代码由九章算法编辑提供。没有版权欢迎转发。
	 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
	 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
	 * - 更多详情请见官方网站：http://www.jiuzhang.com/
	 */

	public class Solution {
		public String intToRoman(int num) {
			if(num <= 0) {
				return "";
			}
		    int[] nums =       {1000, 900, 500, 400, 100,   90,   50, 40,   10,   9,    5,   4,    1};
		    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		    StringBuilder res = new StringBuilder();
		    int digit=0;
		    while (num > 0) {
		        int times = num / nums[digit];
		        num -= nums[digit] * times;
		        for ( ; times > 0; times--) {
		            res.append(symbols[digit]);
		        }
		        digit++;
		    }
		    return res.toString();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
