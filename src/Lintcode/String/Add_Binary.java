package Lintcode.String;

public class Add_Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String addBinary(String str1, String str2) {
        // Write your code here
    	if(str1 == null || str2 == null) return null;
        if(str1.length() < str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        
        String result = "";
        int carry = 0;
        //pa ���ڵ��� pb
        int p1 = str1.length()-1;
        int p2 = str2.length()-1;
        //���ҵ��󣬰�λ�ã�������ӣ��������resultǰ��
        //ѭ������pa��pb��carries
        while(p2 >= 0){
            int sum = (int)(str1.charAt(p1) - '0') + (int)(str2.charAt(p2) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            p1 --;
            p2 --;
        }
        
        while(p1 >= 0){
            int sum = (int)(str1.charAt(p1) - '0') + carry;
            result = String.valueOf(sum % 2) + result;
            carry = sum / 2;
            p1 --;
        }       
        
        if (carry == 1)
            result = "1" + result;
        return result;
    }
}
