package Lintcode.String;

public class Valid_Number_ext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+isNumber("-3.21e-9"));
	}
	
//	Good solution
    public static boolean isNumber(String s) {
    	if(s == null || s.length() == 0){
    		return false;
    	}
    	s = s.trim();// ȥ��leading or trailing white spaces "3 "
        int len = s.length();
        int i = 0, end = len - 1;
        while (i <= end && Character.isWhitespace(s.charAt(i))) {
        	i++;	
        }
        if (i > end){
        	return false;
        } 
        while (i <= end && Character.isWhitespace(s.charAt(end))){
        	end--;
        } 
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-'){
        	i++;
        } 
        boolean hasNum = false; //ȷ���Ƿ���number is a digit
        boolean hasDot = false; // is a '.'
        boolean hasExp = false; // is a 'e'
        while (i <= end) {
//        	ȡ��c��c�����𼶼�⣬�Ƿ�isDigit(), isDot?, isExp?,is + - ,�⼸�������Ǿ�ֱ�ӷ���false
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;//find digital number
            }else if (c == '.') {
                if(hasExp || hasDot) {//. ǰ�������e������. �򷵻�false������ֻ����һ�������ұ�����eǰ��
                	return false;	
                }
                hasDot = true;//��Ƿ���dot
            }else if (c == 'e') {
                if(hasExp || !hasNum){//eǰ�������e����û�����֣��򷵻�false������ֻ����һ�������ұ�����eǰ��
                	return false;
                } 
                hasExp = true;//��Ƿ���e
                hasNum = false;//reset û�з���number
            }else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {//number�����+-�����������e���棬����false
                	return false;
                }
            }else {
                return false;
            }
            i++;
        }
        return hasNum;
    }

    
//   not good, ignore it��
    public static boolean isNumber2(String string) {
        if (string == null) {
            return false;
        }
        int size = string.length();
        if (size == 0) {
            return false;
        }
        char c;
        boolean dotFlag = false;
        for (int i = 0; i < size; i++) {
            c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c == '.') {
                if (dotFlag) {
                    return false;
                }
                dotFlag = true;
                continue;
            }
            if (i == 0 && c == '-') {
                continue;
            }
            return false;
        }
        return true;
    }

}
