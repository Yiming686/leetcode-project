package Lintcode.String.BackTracking;

import java.util.ArrayList;

/**

Restore IP Addresses Show result 

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Have you met this question in a real interview? Yes
Example
Given "25525511135", return

[
  "255.255.11.135",
  "255.255.111.35"
]
Order does not matter.

Tags Expand 
String Backtracking Recursion


Related Problems Expand 
Medium Subsets

 *
 *
 */
public class Restore_IP_Addresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(s.length() <4 || s.length() > 12)
            return result;
        
        helper(result, list, s , 0);
        return result;
    }
    
    public void helper(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){//如果已经找到四个ip了
            if(start != s.length())//如果已经找到了四个ip，但是start没有到最后，返回吧
                return;
            StringBuffer sb = new StringBuffer();//否则，则可按照格式,加入,返回
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        //start从0变化到start+2变化，当退出循环时，变为len了
        //i一定要从start开始，不能跳跃，结束于start+2或者更大，更大没意义因为isValid()
        for(int i=start; i<s.length() && i<= start+2; i++){
            String tmp = s.substring(start, i+1);//取前1，前2，前3字符
            if(isValid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);//下一次递归开始于i+1
                list.remove(list.size()-1);
            }
        }

        //also worked, i is the next index of last character
        // for(int i=start+1; i<=s.length() && i<= start+3; i++){
        //     String tmp = s.substring(start, i);//取前1，前2，前3字符
        //     if(isValid(tmp)){
        //         list.add(tmp);
        //         helper(result, list, s, i);
        //         list.remove(list.size()-1);
        //     }
        // }
    }
    
    //巧妙去除连续0的情况,单0有效，多零无效，不等于0只要大于小于255即可
    private boolean isValid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 1 && digit <= 255;
    }
	
}
