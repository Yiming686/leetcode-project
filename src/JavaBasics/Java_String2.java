package JavaBasics;

public class Java_String2 {

    public static String shortestPalindrome(String s) {
        if(s == null) return null;
        int len = s.length();
        if(len == 0) return "";
        System.out.println("s:"+s);
        StringBuilder sb = new StringBuilder(s);
//        System.out.println("A:"+sb.reverse().toString());
//        System.out.println("B:"+sb.toString());
        if(sb.toString().equals(sb.reverse().toString())) return s;
        // if(isPalindrome(s)) return s;
        String pre = "";
        System.out.println("s2:"+s);
        for(int i = len; i > 0 ; i -- ){
            String sub = s.substring(0,i);
            System.out.println("sub:"+sub);
            if(isPalindrome(sub)) {
                break;
            }else{
                pre = pre+s.charAt(i-1) ;                
            }
        }
        return pre+s;
    }
    
    public static boolean isPalindrome(String s){

        if(s == null) return false;
        int len = s.length();
        if(len == 0) return true;
        for(int left = 0, right = len -1; left < right ; left++, right --){
            if(s.charAt(left)!= s.charAt(right)) return false;
        }
        return true;
    }
    public static String reverse999(String s){
    	System.out.println("s0:" + s);
    	if(s == null || s.length() == 0 || s.length() == 1) return s;
//    	if(s.length() == 2) return "" + s.charAt(1)+s.charAt(0) ;
    	String s1 = reverse999(s.substring(0, s.length()/2 ));
    	String s2 = reverse999(s.substring(s.length()/2));
    	System.out.println("s1:" + s1);
    	System.out.println("s2:" + s2);
    	return s2 + s1 ;
    }
    
	public static void main(String[] args) {
		String s3 = "";
		System.out.println(""+s3.length());
		System.out.println(""+s3.charAt(0));
    	String[] arr = new String[5];
    	System.out.println("arr3: "+arr[3]);
    	System.out.println("arr3: "+arr.length);
        if (arr == null || arr.length == 0) {
        	System.out.println("arr3: NULL or 0");
        }
        
        String prefix = arr[0];
        if(prefix == null)         	System.out.println("arr3: prefix == null");

        
        String s2 = "uldk";
        System.out.println("s2:"+s2.substring(0, 1));
        if( 1 == 1)return;
        
		// TODO Auto-generated method stub
		String s = "er";
//		String s1 = s.substring(-3, 2);
//		String s2 = s.substring(2);
//    	System.out.println("s1:" + s1);
//    	System.out.println("s2:" + s2);
		StringBuilder sb = new StringBuilder();
//		sb.append("12345");
//		System.out.println(sb.length());
//		sb.delete(4, sb.length() + 1);
//		System.out.println(sb);
//		System.out.println(shortestPalindrome("ba"));
//		
//		System.out.println(shortestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println("[Final Result999]:"+reverse999("syniverse"));
		System.out.println("[Final Result999]:"+reverse999("12345678"));
		System.out.println("[Final Result]:"+reverse666("syniverse"));
		System.out.println("[Final Result]:"+reverse666("12345678"));
		System.out.println("[Final Result]:"+reverse666(" "));
//		System.out.println("[Final Result]:"+reverse8("syniverse"));
	}
    public static String reverse8(String str) {
//        int localI = i++;
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
//        System.out.println("Step " + localI + ": " + str.substring(1) + " / " + str.charAt(0));
        String reversed = reverse8(str.substring(1)) + str.charAt(0);

//        System.out.println("Step " + localI + " returns: " + reversed);
        return reversed;
    }
public static String reverse666(String s){
	if(s==null) return null;
	int len = s.length();
	if(len == 0 || len == 1) return s;
	String s1 = s.substring(0,1);
	String s2 = reverse666(s.substring(1, len)); 
	return  s2+s1 ;
}
    
	public static String reverse(String s){
		if(s==null) return null;
		int len = s.length();
		if(len == 1) return s;
		return reverse(s, 0);
//		return reverse2(s, s.length()-1);
//		return reverse3(s, s.length()-1);
	}
	public static String reverse(String s, int i){
		System.out.printf("s:%s i:%s \n", s, i);
		if(s==null) return null;
		int len = s.length();
		if(len == 1) return s;
		if(i == len-1) return s.substring(len-1);
		String s1 = s.substring(i, i+ 1);
		System.out.printf("s:%s i:%s s1:%s\n", s, i, s1);
		String s2 = reverse(s, i+1);
		String s3 = s2+s1;
		System.out.printf("s:%s i:%s s1:%s s2:%s s3:%s \n", s, i,s1, s2, s3);
		return s3;
	}
	public static String reverse2(String s, int i){
		if(s==null) return null;
		int len = s.length();
		if(len == 1) return s;
		if(i == 0) return s.substring(0,1);
		String s1 = s.substring(i, i+1);
		String s2 = reverse2(s, i-1);
		String s3 = s1+s2;
		System.out.printf("s:%s i:%s  s1:%s s2:%s s3:%s \n", s, i,s1, s2, s3);
		return s3;
	}
	
	public static String reverse3(String s, int i){
		if(s==null) return null;
		int len = s.length();
		if(len == 1) return s;
		if(i == 0) return s.substring(0,1);
		String s1 = s.substring(i, i+1);
		String s2 = reverse3(s, i-1);
		String s3 = s1+s2;
		System.out.printf("s:%s i:%s  s1:%s s2:%s s3:%s \n", s, i,s1, s2, s3);
		return s3;
	}

	
	
	
}
