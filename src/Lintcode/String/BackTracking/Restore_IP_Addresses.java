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
        if(list.size() == 4){//����Ѿ��ҵ��ĸ�ip��
            if(start != s.length())//����Ѿ��ҵ����ĸ�ip������startû�е���󣬷��ذ�
                return;
            StringBuffer sb = new StringBuffer();//������ɰ��ո�ʽ,����,����
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        //start��0�仯��start+2�仯�����˳�ѭ��ʱ����Ϊlen��
        //iһ��Ҫ��start��ʼ��������Ծ��������start+2���߸��󣬸���û������ΪisValid()
        for(int i=start; i<s.length() && i<= start+2; i++){
            String tmp = s.substring(start, i+1);//ȡǰ1��ǰ2��ǰ3�ַ�
            if(isValid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);//��һ�εݹ鿪ʼ��i+1
                list.remove(list.size()-1);
            }
        }

        //also worked, i is the next index of last character
        // for(int i=start+1; i<=s.length() && i<= start+3; i++){
        //     String tmp = s.substring(start, i);//ȡǰ1��ǰ2��ǰ3�ַ�
        //     if(isValid(tmp)){
        //         list.add(tmp);
        //         helper(result, list, s, i);
        //         list.remove(list.size()-1);
        //     }
        // }
    }
    
    //����ȥ������0�����,��0��Ч��������Ч��������0ֻҪ����С��255����
    private boolean isValid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 1 && digit <= 255;
    }
	
}
