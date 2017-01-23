package Lintcode.String;

import java.util.Arrays;

public class Space_Replacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "new york  k                  ";
		String str = "he she            ";
//		String str = "Mr John Smith                      ";
		int len = 6;
		System.out.println(""+replaceBlank55(str.toCharArray(), len));
//		System.out.println(""+replaceBlank33(str.toCharArray(), len));
	}
	
    //My solution, best, worked 
    public static int replaceBlank55(char[] str, int length) {
            if(str == null) return 0;
            int newLen = length;
            int index = str.length - 1;
            for(int i = length - 1; i >=0; i--){
            	System.out.println(""+Arrays.toString(str));
                char ch = str[i];
                // if(ch.equals(' ')){
                if(ch == ' '){
                    str[index--] = '0';
                    str[index--] = '2';
                    str[index--] = '%';
                    newLen += 2;
                }else{
                    str[index--] = ch;
                }
            }
            for(int i = 0; i < newLen; i++){
                str[i] = str[str.length - newLen + i];
            }
            System.out.println(""+Arrays.toString(str));
            return newLen;
        }
    
//    
    static int replaceBlank33(char str[], int length) {
        if(0==length) return 0;
        int num = 0;
        for(int i=0;i<length;i++){
            if(str[i] == ' ') num++;
        }
        
        int newLen = length + num*2;
        // str[newLen] = 0; 
            int j = newLen - 1;
        for(int i=length-1;i>=0;i--){
        	System.out.println(""+Arrays.toString(str));
            if(str[i] != ' '){
                str[j] = str[i];
                j--;
            }
            else{
                str[j-0] = '0';
                str[j-1] = '2';
                str[j-2] = '%';
                j = j-3;
            }
        }
        return newLen;
    }


}
