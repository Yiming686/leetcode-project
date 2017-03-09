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
    	s = s.trim();// 去掉leading or trailing white spaces "3 "
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
        boolean hasNum = false; //确认是否是number is a digit
        boolean hasDot = false; // is a '.'
        boolean hasExp = false; // is a 'e'
        while (i <= end) {
//        	取得c对c进行逐级检测，是否isDigit(), isDot?, isExp?,is + - ,这几个都不是就直接返回false
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasNum = true;//find digital number
            }else if (c == '.') {
                if(hasExp || hasDot) {//. 前面或者有e或者有. 则返回false。即点只能有一个，而且必须在e前面
                	return false;	
                }
                hasDot = true;//标记发现dot
            }else if (c == 'e') {
                if(hasExp || !hasNum){//e前面或者有e或者没有数字，则返回false。即点只能有一个，而且必须在e前面
                	return false;
                } 
                hasExp = true;//标记发现e
                hasNum = false;//reset 没有发现number
            }else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {//number里面的+-符号如果不在e后面，返回false
                	return false;
                }
            }else {
                return false;
            }
            i++;
        }
        return hasNum;
    }

    
//   not good, ignore it，
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
